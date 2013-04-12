package dojo.client;

import dojo.dao.DaoFactory;
import dojo.model.Answer;

import java.util.Collection;

public class ShowStatisticsCommand extends Command {

    @Override
    public boolean run() {

        Collection<Answer> allAnswers = DaoFactory.getAnswerDao().listAnswers();

        int correctAnswers = 0;
        for (Answer answer : allAnswers) {
            if (answer.correct) {
                correctAnswers++;
            }
        }

        printLine("");
        printLine(getName());
        printLine("Total answers      %s", allAnswers.size());
        printLine("Correct answers    %s", correctAnswers);
        printLine("Incorrect answers  %s", allAnswers.size() - correctAnswers);
        printLine("");

        return false;
    }

    @Override
    public String getName() {
        return "Show statistics";
    }
}
