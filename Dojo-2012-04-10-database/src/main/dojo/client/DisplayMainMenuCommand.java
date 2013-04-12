package dojo.client;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DisplayMainMenuCommand extends DisplayOptionsCommand {

    private static final List<String> prompts = Arrays.asList(
            "Your command, Sir?",
            "What thou wilt?",
            "Whaddaya want?",
            "Give me a command",
            "What's your wish?",
            "Your orders?",
            "Milord?",
            "Say the word",
            "Yes, my liege?",
            "Aye, Sir?",
            "I await your command",
            "Sire?",
            "How may I serve?",
            "What would you ask of me?",
            "At your call",
            "What is it now?",
            "What's the plan?"
    );

    @Override
    public String getName() {
        return "MAIN MENU";
    }

    @Override
    public List<Option> getCommands() {
        return Arrays.asList(
            new Option("1", new AddQuestionCommand()),
            new Option("2", new ListQuestionsCommand()),
            new Option("3", new UpdateQuestionsCommand()),
            new Option("4", new DeleteQuestionsCommand()),
            new Option("5", new PracticeCommand()),
            new Option("6", new ShowStatisticsCommand()),
            new Option("7", new ResetStatisticsCommand()),
            new Option("0", new ExitCommand("EXIT"))
        );
    }

    @Override
    protected String getPrompt() {
        return prompts.get(new Random().nextInt(prompts.size()));
    }
}