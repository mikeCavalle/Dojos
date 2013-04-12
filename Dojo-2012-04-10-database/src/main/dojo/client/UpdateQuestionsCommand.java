package dojo.client;

import dojo.dao.DaoFactory;
import dojo.model.Question;

import java.util.ArrayList;
import java.util.List;

public class UpdateQuestionsCommand extends DisplayOptionsCommand {

    @Override
    protected List<Option> getCommands() {
        List<Option> options = new ArrayList<Option>();
        for (Question question : DaoFactory.getQuestionDao().listQuestions()) {
            options.add(new Option(String.valueOf(question.getId()), new UpdateQuestionCommand(question)));
        }

        options.add(new Option("0", new ExitCommand("BACK TO PREVIOUS VIEW")));

        return options;
    }

    @Override
    public String getName() {
        return "Update questions";
    }

    @Override
    protected String getPrompt() {
        return "Enter the id of question to update (0 to previous view)";
    }
}