package org.example;

import org.example.exceptions.ArgsException;

import java.util.*;

public class Args {
    private final String schema;
    private boolean valid = true;
    private final Set<Character> unexpectedArguments = new TreeSet<Character>() ;
    private final Map<Character, ArgumentMarshaller> marshallers = new HashMap<> ();
    private final Set<Character> argsFound = new HashSet<Character>() ;
    private Iterator<String> currentArgument;
    private char errorArgumentId = '\0';
    private String errorParameter = "TILT";
    private ArgsException.ErrorCode errorCode = ArgsException.ErrorCode.OK;
    private List<String> argsList;


    public Args (String schema, String[] args) throws ArgsException {
        this.schema = schema;
        argsList = Arrays.asList(args);
        valid = parse();
    }
    private boolean parse() throws ArgsException {
        if (schema.isEmpty() && argsList.isEmpty()){
            return true;
        }
        parseSchema() ;
        try {
            parseArguments();
        }catch (ArgsException e){
        }
        return valid;
    }

    private boolean parseSchema() throws ArgsException {
        for (String element : schema.split(",")) {
            if (!element.isEmpty()) {
                String trimmedElement = element.trim();
                parseSchemaElement(trimmedElement) ;
            }
        }
         return true;
    }

    private void parseSchemaElement(String element) throws ArgsException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);
        if (elementTail.length() == 0) {
            marshallers.put(elementId, new BooleanArgumentMarshaller());
        } else if(isStringSchemaElement(elementTail)) {
            marshallers.put(elementId, new StringArgumentMarshaller());
        } else if(isIntegerSchemaElement(elementTail)) {
            marshallers.put(elementId, new IntegerArgumentMarshaller());
        } else if (elementTail.equals("##")){
            marshallers.put(elementId, new DoubleArgumentMarshaller());
        } else {
            throw new ArgsException("Argument: %c has invalid format: %s.".formatted(elementId, elementTail));
        }


    }

    private void validateSchemaElementId(char elementId) throws ArgsException {
        if(!Character.isLetter(elementId)) {
            throw new ArgsException("Bad character: " + elementId + "in Args format: " + schema);
        }
    }


    private boolean isStringSchemaElement(String elementTail) {
        return elementTail.equals("*");
    }

    private boolean isBooleanElement(String elementTail) {
        return elementTail.isEmpty();
    }

    private boolean isIntegerSchemaElement(String elementTail) {
        return elementTail.equals("#");
    }

    private void parseArguments() throws ArgsException {
        for (currentArgument = argsList.listIterator(); currentArgument.hasNext();) {
            String arg = currentArgument.next();
            parseArgument(arg);
        }
    }

    private void parseArgument(String arg) throws ArgsException {
        if (arg.startsWith("-")) {
            parseElements(arg);
        }
    }

    private void parseElements(String arg) throws ArgsException {
        for (int i = 1; i < arg.length(); i++) {
            parseElement(arg.charAt(i));
        }
    }

    private void parseElement(char argChar) throws ArgsException {
        if (setArgument(argChar)) {
            argsFound.add(argChar);
        } else {
            unexpectedArguments.add(argChar);
            errorCode = ArgsException.ErrorCode.UNEXPECTED_ARGUMENT;
            valid = false;
        }
    }

    private boolean setArgument (char argChar) throws ArgsException {
        final var marshaller = marshallers.get(argChar);
        if (marshaller == null) {
            return false;
        }
        try {
            marshaller.set(currentArgument);
            return true;
        } catch (ArgsException e) {
            valid = false;
            errorArgumentId = argChar;
            throw e;
        }
    }

    public int cardinality() {
        return argsFound.size();
    }

    public String usage() {
        if (!schema.isEmpty()) {
            return "-[" + schema + "]";
        }
        return "";
    }

    public String errorMessage() throws Exception {
        return switch (errorCode) {
            case UNEXPECTED_ARGUMENT -> unexpectedArgumentMessage();
            case MISSING_STRING -> "Could not find string parameter for -%c.".formatted(errorArgumentId);
            case INVALID_INTEGER -> "Argument -%c expects an integer but was '%s'.".formatted(errorArgumentId, errorParameter);
            case MISSING_INTEGER -> "Could not find integer parameter for -%c.".formatted(errorArgumentId);
            case INVALID_DOUBLE -> "Argument -%c expects an double but was '%s'".formatted(errorArgumentId, errorParameter);
            case MISSING_DOUBLE -> "Could not find double parameter for -%c.".formatted(errorArgumentId);
            default -> throw new Exception("TILT: Should not get here.");
        };
    }

    private String unexpectedArgumentMessage() {
        StringBuffer message = new StringBuffer("Argument (s) - ");
        for (char c : unexpectedArguments) {
            message.append(c);
        }
        message.append(" unexpected.");
        return message.toString();
    }

    public String getString(char arg) {
        ArgumentMarshaller am = marshallers.get(arg);
        try {
            return am == null ? "" : (String) am.get();
        } catch (ClassCastException e) {
            return "";
        }
    }

    public int getInt(char arg) {
        ArgumentMarshaller am = marshallers.get(arg);
        try {
            return am == null ? 0 : (Integer) am.get();
        } catch (Exception e) {
            return 0;
        }
    }

    public double getDouble(char arg) {
        ArgumentMarshaller am = marshallers.get(arg);
        try {
            return am == null ? 0 : (Double) am.get();
        } catch (Exception e) {
            return 0.0;
        }
    }

    public boolean getBoolean(char arg) {
        ArgumentMarshaller am = marshallers.get(arg);
        boolean b = false;
        try {
            b = am != null && (Boolean) am.get();
        } catch (ClassCastException e) {
            b = false;
        }
        return b;
    }

    public boolean has(char arg) {
        return argsFound.contains(arg);
    }

    public boolean isValid() {
        return valid;
    }

    private interface ArgumentMarshaller {
        void set(Iterator<String> currentArgument) throws ArgsException;
        Object get();
    }

    private class BooleanArgumentMarshaller implements ArgumentMarshaller {
        private boolean booleanValue = false;

        public void set(Iterator<String> currentArgument) throws ArgsException {
            booleanValue = true;
        }

        public Object get() {
            return booleanValue;
        }
    }

    private class StringArgumentMarshaller implements ArgumentMarshaller {
        private String stringValue = "";

        public void set(Iterator<String> currentArgument) throws ArgsException {
            try {
                stringValue = currentArgument.next();
            } catch (NoSuchElementException e) {
                errorCode = ArgsException.ErrorCode.MISSING_STRING;
                throw new ArgsException();
            }
        }

        public Object get() {
            return stringValue;
        }
    }

    private class IntegerArgumentMarshaller implements ArgumentMarshaller {
        private int intValue = 0;

        public void set(Iterator<String> currentArgument) throws ArgsException {
            String parameter = null;
            try {
                parameter = currentArgument.next();
                intValue = Integer.parseInt(parameter) ;
            } catch (NoSuchElementException e) {
                errorCode = ArgsException.ErrorCode.MISSING_INTEGER;
                throw new ArgsException();
            } catch (NumberFormatException e) {
                errorParameter = parameter;
                errorCode = ArgsException.ErrorCode.INVALID_INTEGER;
                throw e;
            }
        }

        public Object get() {
            return intValue;
        }
    }

    private class DoubleArgumentMarshaller implements ArgumentMarshaller {
        private double doubleValue = 0;

        public void set(Iterator<String> currentArgument) throws ArgsException {
            String parameter = null;
            try {
                parameter = currentArgument.next();
                doubleValue = Double.parseDouble(parameter);
            } catch (NoSuchElementException e) {
                errorCode = ArgsException.ErrorCode.MISSING_DOUBLE;
                throw new ArgsException();
            } catch (NumberFormatException e) {
                errorParameter = parameter;
                errorCode = ArgsException.ErrorCode.INVALID_DOUBLE;
                throw new ArgsException();
            }
        }

        public Object get() {
            return doubleValue;
        }
    }

}

