package org.example;

import org.example.exceptions.ArgsException;
import org.junit.Test;

import static org.junit.Assert.*;


public class ArgsTest {

    @Test
    public void shouldReturnloggingTrue() throws ArgsException {
        final var stringArgs = new String[]{"-l"};
        final var args = new Args("l", stringArgs);
        assertTrue(args.getBoolean('l'));
    }

    @Test
    public void shouldReturnFalseWhenEmptySchema() throws ArgsException {
        final var stringArgs = new String[]{};
        final var args = new Args("", stringArgs);
        assertFalse(args.getBoolean('l'));
    }

    @Test
    public void shouldReturnPort() throws ArgsException {
        final var stringArgs = new String[]{"-p", "8080"};
        final var args = new Args("p#", stringArgs);
        assertEquals(8080, args.getInt('p'));
    }

    @Test
    public void shouldReturnDirectory() throws ArgsException {
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
        final var exception = assertThrows(ArgsException.class, () -> new Args("d%", stringArgs));

        final var expectedMessage = "Argument: d has invalid format: %.";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void whenBadCharacterThenThrowParseException() throws ArgsException {
        final var directory = "/home/user/process";
        final var stringArgs = new String[]{"-d", directory};
        final var exception = assertThrows(ArgsException.class, () -> new Args("12", stringArgs));

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
    public void whenMoreArgumentsThanExpectedThenReturnErrorMessage() throws ArgsException {
        final var stringArgs = new String[]{"-l", "-p", "8080", "otherParameter"};
        final var args = new Args("l,p#", stringArgs);
        final var exception = assertThrows(Exception.class, args::errorMessage);

        final var expectedMessage = "TILT: Should not get here.";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void whenStringArgumentSentByIntegerThenReturnErrorMessage() throws Exception {
        final var stringArgs = new String[]{"-p", "a"};
        final var exception = assertThrows(NumberFormatException.class, () -> new Args("p#", stringArgs));
        final var expectedMessage = "For input string: \"a\"";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void whenStringArgumentWasRequestedButNoOneExistsThenReturnErrorMessage() throws Exception {
        final var stringArgs = new String[]{"-d"};
        final var args = new Args("d*", stringArgs);
        final var expectedMessage = "Could not find string parameter for -d.";
        assertEquals(expectedMessage, args.errorMessage());
    }

    @Test
    public void shouldReturnNumberOfParameters() throws ArgsException {
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
    public void shouldReturnEmptyUsage() throws ArgsException {
        final var stringArgs = new String[]{};
        final var arg = new Args("", stringArgs);
        final var usage = arg.usage();

        assertTrue(usage.isEmpty());
    }

    @Test
    public void testSimpleDoublePresent() throws ArgsException {
        Args args = new Args("x##", new String[] {"-x", "42.3"});
        assertTrue(args.isValid());
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));
        assertEquals(42.3, args.getDouble('x'), .001);
    }

    @Test
    public void testMissingDouble() throws Exception {
        Args args = new Args("x##", new String[] {"-x"});
        assertFalse(args.isValid());
        assertEquals(0, args.cardinality());
        assertFalse(args.has('x'));
        assertEquals(0.0, args.getDouble('x'), 0.01);
        assertEquals("Could not find double parameter for -x.", args.errorMessage());
    }

}