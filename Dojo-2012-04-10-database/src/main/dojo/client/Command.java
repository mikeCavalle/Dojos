package dojo.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Command {

    public abstract boolean run();
    public abstract String getName();

    protected final String readLine(String message) {
        try {
            System.out.print(message + ' ');
            return new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected final void printLine(String message, Object... args) {
        System.out.println(String.format(message, args));
    }
}
