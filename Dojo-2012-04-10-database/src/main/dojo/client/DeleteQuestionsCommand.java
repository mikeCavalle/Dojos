package dojo.client;

import dojo.dao.DaoFactory;
import dojo.model.Question;

import java.util.ArrayList;
import java.util.List;

public class DeleteQuestionsCommand extends DisplayOptionsCommand {

    @Override
    public String getName() {
        return "Delete questions";
    }

    @Override
    protected List<Option> getCommands() {

        printLine("");
        printLine(getName());

        List<Option> options = new ArrayList<Option>();
        for (Question question : DaoFactory.getQuestionDao().listQuestions()) {
            options.add(new Option(String.valueOf(question.getId()), new DeleteQuestionCommand(question)));
        }

        options.add(new Option("0", new ExitCommand("BACK TO PREVIOUS VIEW")));

        return options;
    }

    @Override
    protected String getPrompt() {
        return "Enter the id of question to delete (0 to previous view)";
    }
}