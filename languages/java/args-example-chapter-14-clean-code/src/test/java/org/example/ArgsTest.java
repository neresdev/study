package org.example;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;


public class ArgsTest {

    @Test
    public void shouldReturnloggingTrue() throws ParseException {
        final var stringArgs = new String[]{"-l"};
        final var args = new Args("l", stringArgs);
        assertTrue(args.getBoolean('l'));
    }

    @Test
    public void shouldReturnFalseWhenEmptySchema() throws ParseException {
        final var stringArgs = new String[]{};
        final var args = new Args("", stringArgs);
        assertFalse(args.getBoolean('l'));
    }

    @Test
    public void shouldReturnPort() throws ParseException {
        final var stringArgs = new String[]{"-p", "8080"};
        final var args = new Args("p#", stringArgs);
        assertEquals(8080, args.getInt('p'));
    }

    @Test
    public void shouldReturnDirectory() throws ParseException {
        final var directory = "/home/user/process";
        final var stringArgs = new String[]{"-d", directory};
        final var args = new Args("d*", stringArgs);
        final var actualDirectory = args.getString('d');

        assertEquals(directory, actualDirectory);
    }

    @Test
    public void whenInvalidArgumentFormatThenThrowParseException() {
        final var directory = "/home/user/process";
        final var stringArgs = new String[]{"-d", directory};
        final var exception = assertThrows(ParseException.class, () -> new Args("d%", stringArgs));

        final var expectedMessage = "Argument: d has invalid format: %.";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void whenBadCharacterThenThrowParseException() throws ParseException {
        final var directory = "/home/user/process";
        final var stringArgs = new String[]{"-d", directory};
        final var exception = assertThrows(ParseException.class, () -> new Args("12", stringArgs));

        final var expectedMessage = "Bad character: 1in Args format: 12";

        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    public void whenUnexpectedAgumentThenReturnErrorMessage() throws Exception{
        final var directory = "/home/user/process";
        final var otherParameter = "test";
        final var stringArgs = new String[]{"-1", directory, otherParameter};
        final var args = new Args("d#", stringArgs);
        final var argsErrorMessage = args.errorMessage();
        final var expectedMessage = "Argument (s) - 1 unexpected.";
        assertFalse(argsErrorMessage.isEmpty());
        assertEquals(expectedMessage, argsErrorMessage);
    }

    @Test
    public void whenLessArgumentsThanExpectedThenReturnErrorMessage() throws Exception {
        final var stringArgs = new String[]{"-l", "-p"};
        final var args = new Args("l,p#", stringArgs);
        final var expectedMessage = "Could not find integer parameter for -p.";
        assertEquals(expectedMessage, args.errorMessage());
    }

    @Test
    public void whenMoreArgumentsThanExpectedThenReturnErrorMessage() throws ParseException {
        final var stringArgs = new String[]{"-l", "-p", "8080", "otherParameter"};
        final var args = new Args("l,p#", stringArgs);
        final var exception = assertThrows(Exception.class, args::errorMessage);

        final var expectedMessage = "TILT: Should not get here.";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void whenStringArgumentSentByIntegerThenReturnErrorMessage() throws Exception {
        final var stringArgs = new String[]{"-p", "a"};
        final var args = new Args("p#", stringArgs);
        final var expectedMessage = "Argument -p expects an integer but was 'a'.";
        assertEquals(expectedMessage, args.errorMessage());
    }

    @Test
    public void whenStringArgumentWasRequestedButNoOneExistsThenReturnErrorMessage() throws Exception {
        final var stringArgs = new String[]{"-d"};
        final var args = new Args("d*", stringArgs);
        final var expectedMessage = "Could not find string parameter for -d.";
        assertEquals(expectedMessage, args.errorMessage());
    }

    @Test
    public void shouldReturnNumberOfParameters() throws ParseException {
        final var stringArgs = new String[]{"-l", "-p", "8080", "-d", "/processor"};
        final var arg = new Args("l,p#,d*", stringArgs);

        assertEquals(3, arg.cardinality());
    }

    @Test
    public void shouldReturnUsage() throws Exception {
        final var stringArgs = new String[]{"-l", "-p", "8080", "-d", "/processor"};
        final var arg = new Args("l,p#,d*", stringArgs);
        final var usage = arg.usage();

        final var expectedUsage = "-[l,p#,d*]";

        assertEquals(expectedUsage, usage);
        assertTrue(arg.has('p'));
        assertTrue(arg.isValid());
    }

    @Test
    public void shouldReturnEmptyUsage() throws ParseException {
        final var stringArgs = new String[]{};
        final var arg = new Args("", stringArgs);
        final var usage = arg.usage();

        assertTrue(usage.isEmpty());
    }



}