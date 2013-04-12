package dojo.client;

public class Option {

    public final String key;
    public final Command command;

    public Option(String key, Command command) {
        this.key = key;
        this.command = command;
    }
}
