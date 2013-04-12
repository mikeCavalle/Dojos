package dojo.client;

import dojo.dao.DaoFactory;
import dojo.model.Question;

public class DeleteQuestionCommand extends Command {

    private final Long id;
    private final String name;

    public DeleteQuestionCommand(Question question) {
        id = question.getId();
        name = question.question;
    }

    @Override
    public boolean run() {
        DaoFactory.getQuestionDao().deleteQuestionById(id);

        printLine("");
        printLine("Question with id %s deleted successfully!", id);
        printLine("");

        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
