package org.example;

import org.example.exceptions.ArgsException;

import java.text.ParseException;
import java.util.*;

public class Args {
    private final String schema;
    String[] args;
    private boolean valid = true;
    private Set<Character> unexpectedArguments = new TreeSet<Character>() ;
    private Map<Character, ArgumentMarshaller> marshallers = new HashMap<> ();
    private Set<Character> argsFound = new HashSet<Character>() ;
    private int currentArgument;
    private char errorArgumentId = '\0';
    private String errorParameter = "TILT";
    private ErrorCode errorCode = ErrorCode.OK;
    private enum ErrorCode {OK, MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER, UNEXPECTED_ARGUMENT }

    public Args (String schema, String[] args) throws ParseException {
        this.schema = schema;
        this.args = args;
        valid = parse();
    }
    private boolean parse() throws ParseException {
        if (schema.length() == 0 && args.length == 0){
            return true;
        }
        parseSchema() ;
        try {
            parseArguments();
        }catch (ArgsException e){
        }
        return valid;
    }

    private boolean parseSchema() throws ParseException {
        for (String element : schema.split(",")) {
            if (element.length() > 0) {
                String trimmedElement = element.trim();
                parseSchemaElement(trimmedElement) ;
            }
        }
         return true;
    }

    private void parseSchemaElement(String element) throws ParseException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);
        if (isBooleanElement(elementTail)) {
            marshallers.put(elementId, new BooleanArgumentMarshaller());
        } else if(isStringSchemaElement(elementTail)) {
            marshallers.put(elementId, new StringArgumentMarshaller());
        } else if(isIntegerSchemaElement(elementTail)) {
            marshallers.put(elementId, new IntegerArgumentMarshaller());
        } else {
            throw new ParseException("Argument: %c has invalid format: %s.".formatted(elementId, elementTail), 0);
        }


    }

    private void validateSchemaElementId(char elementId) throws ParseException {
        if(!Character.isLetter(elementId)) {
            throw new ParseException("Bad character: " + elementId + "in Args format: " + schema, 0);
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
        for (currentArgument = 0; currentArgument < args.length; currentArgument++) {
            String arg = args[currentArgument];
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
            errorCode = ErrorCode.UNEXPECTED_ARGUMENT;
            valid = false;
        }
    }

    private boolean setArgument (char argChar) throws ArgsException {
        final var marshaller = marshallers.get(argChar);
        try {
            if(marshaller instanceof BooleanArgumentMarshaller) {
                setBooleanArg(marshaller);
            } else if(marshaller instanceof StringArgumentMarshaller) {
                setStringArg(marshaller);
            } else if (marshaller instanceof IntegerArgumentMarshaller) {
                setIntArg(marshaller);
            } else {
                return false;
            }
        } catch (ArgsException e) {
            valid = false;
            errorArgumentId = argChar;
            throw e;
        }
        return true;
    }

    private void setIntArg(ArgumentMarshaller marshaller) throws ArgsException {
        currentArgument++;
        String parameter = null;
        try {
            parameter = args[currentArgument];
            marshaller.set(parameter);
        } catch (ArrayIndexOutOfBoundsException e) {
            errorCode = ErrorCode.MISSING_INTEGER;
            throw new ArgsException();
        } catch (ArgsException e) {
            errorParameter = parameter;
            errorCode = ErrorCode.INVALID_INTEGER;
            throw e;
        }
    }

    private void setStringArg(ArgumentMarshaller marshaller) throws ArgsException {
        currentArgument++;
        try {
            marshaller.set(args[currentArgument]);
        } catch (ArrayIndexOutOfBoundsException e) {
            errorCode = ErrorCode.MISSING_STRING;
            throw new ArgsException();
        }
    }

    private void setBooleanArg(ArgumentMarshaller marshaller) {
        try {
            marshaller.set("true");
        } catch (ArgsException e) {
        }

    }

    public int cardinality() {
        return argsFound.size();
    }

    public String usage() {
        if (schema.length() > 0) {
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

    private abstract class ArgumentMarshaller {

        public abstract void set(String s);
        public abstract Object get();
    }

    private class BooleanArgumentMarshaller extends ArgumentMarshaller {
        private boolean booleanValue = false;
        public void set(String s) {
            booleanValue = true;
        }

        public Object get() {
            return booleanValue;
        }
    }

    private class StringArgumentMarshaller extends ArgumentMarshaller {
        private String stringValue = "";
        public void set(String s) {
            stringValue = s;
        }

        public Object get() {
            return stringValue;
        }
    }

    private class IntegerArgumentMarshaller extends ArgumentMarshaller {
        private int integerValue = 0;

        public void set(String s) throws ArgsException {
            try {
                integerValue = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new ArgsException();
            }

        }

        public Object get() {
            return integerValue;
        }
    }

}

