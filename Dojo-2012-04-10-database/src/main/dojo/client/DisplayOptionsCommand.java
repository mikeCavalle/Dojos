package dojo.client;

import java.util.List;

public abstract class DisplayOptionsCommand extends Command {

    protected abstract List<Option> getCommands();

    protected abstract String getPrompt();

    @Override
    public final boolean run() {
        for (boolean exitRequested = false; !exitRequested; ) {
            printHeader();
            printOptions();
            exitRequested = readAndRunCommand();
        }

        return false;
    }

    private boolean readAndRunCommand() {
        String key = readLine(getPrompt());
        for (Option option : getCommands()) {
            if (key.equals(option.key)) {
                if (option.command.run()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void printHeader() {
        printLine("");
        printLine(getName());
    }

    private void printOptions() {
        for (Option option : getCommands()) {
            printLine("%s = %s", option.key, option.command.getName());
        }
        printLine("");
    }
}