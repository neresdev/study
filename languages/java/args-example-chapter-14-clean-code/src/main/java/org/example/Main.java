package org.example;

import org.example.exceptions.ArgsException;

import java.text.ParseException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ArgsException {
        final var arg = new Args("l,p#,d*", args);
        final var logging = arg.getBoolean('l');
    }
}