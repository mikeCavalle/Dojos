package dojo.client;

public class ExitCommand extends Command {

    private final String name;

    public ExitCommand(String name) {
        this.name = name;
    }

    @Override
    public boolean run() {
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
