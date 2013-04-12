package dojo.client;

import dojo.dao.DaoFactory;
import dojo.model.Question;

import java.util.Collection;

public class ListQuestionsCommand extends Command {

    @Override
    public boolean run() {

        printLine("");
        printLine(getName());

        Collection<Question> questions = DaoFactory.getQuestionDao().listQuestions();
        if (questions.isEmpty()) {
            printLine("No questions");
        }

        for (Question question : questions) {
            printLine("[%s] %s", question.getId(), question.question);
        }

        printLine("");

        return false;
    }

    @Override
    public String getName() {
        return "List questions";
    }
}
