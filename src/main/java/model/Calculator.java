package model;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    private final static String EMPTY = "0";

    private String result = EMPTY;

    private String first = EMPTY;
    private String second = EMPTY;
    private String command = "";
    private String symbol = "";

    private boolean status = false;



    private final List<String> commands = Arrays.asList("+", "-", "*", "/", "=");
    private final List<String> numbers = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "-");


    public void add(final String s) throws CalculatorException {
        execute(s);
    }

    private void execute(final String s) throws CalculatorException {
        if (s.equals("c")) {
            first = EMPTY;
            second = EMPTY;
            command = EMPTY;
            status = false;
            result = EMPTY;

            return;
        } else if (s.equals("=")) {
            first = executeCommand(Float.valueOf(first), command, Float.valueOf(second));
            second = EMPTY;
            result = first;
            command = EMPTY;
            status = false;

            return;
        }

        if (status) {
            if (numbers.contains(s)) {
                second = makeNumber(second, s);
                result = second;
                return;
            }

            if (commands.contains(command)) {
                first = executeCommand(Float.valueOf(first), command, Float.valueOf(second));
                second = EMPTY;
                result = EMPTY;
            }

        } else {
            if (numbers.contains(s)) {
                first = makeNumber(first, s);
                result = first;
                return;
            }

            if (commands.contains(s)) {
                command = s;
                status = true;
                result = EMPTY;
            }
        }
    }

    private String executeCommand(Float first, String cmd, Float second) throws CalculatorException {
        Float result = 0.f;
        if (cmd.equals("+")) {
            result = first + second;
        } else if (cmd.equals("*")) {
            result = first * second;
        } else if (cmd.equals("-")) {
            result = first - second;
        } else if (cmd.equals("/")) {
            if (first.equals(0.f)) {
                throw new CalculatorException("Division zero");
            }
            result = first / second;
        }

        return String.valueOf(result);
    }

    private String makeNumber(String string, String s) {
        if (string.equals(EMPTY)) {
            string = s;
        } else {
            string += s;
        }

        return string;
    }

    public Float getNumber() {

        return Float.valueOf(result);
    }
}
