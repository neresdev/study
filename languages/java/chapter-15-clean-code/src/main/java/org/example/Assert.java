package org.example;

public class Assert {

    public static String format(String message, String expected, String actual) {
        String formatted = "";
        if (message != null)
            formatted = message + " ";
        return formatted + "expected:<" + expected + "> but was:<" + actual + ">";
    }
}
