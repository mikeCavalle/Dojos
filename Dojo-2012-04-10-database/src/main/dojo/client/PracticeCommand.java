package dojo.client;

import dojo.dao.DaoFactory;
import dojo.model.Answer;
import dojo.model.Question;

import java.util.*;

public class PracticeCommand extends Command {

    @Override
    public boolean run() {

        List<Question> questions = new ArrayList<Question>(DaoFactory.getQuestionDao().listQuestions());
        Collections.shuffle(questions);

        int questionCount = questions.size();
        int index = 1;
        int correctCount = 0;

        for (Question question : questions) {
            printLine("Question %s / %s", index++, questionCount);
            String answerValue = readLine(question.question);

            boolean correct = question.answer.equals(answerValue);
            if (correct) {
                correctCount++;
                printLine("CORRECT!");
            } else {
                printLine("INCORRECT, you should have answered '%s'", question.answer);
            }

            Answer answer = new Answer();
            answer.questionId = question.getId();
            answer.date = new Date();
            answer.correct = correct;

            DaoFactory.getAnswerDao().save(answer);
            printLine("");
        }

        printLine("");
        printLine("Practice completed!");
        printLine("You answered correctly to %s out of %s", correctCount, questionCount);
        printLine("");

        return false;
    }

    @Override
    public String getName() {
        return "Practice";
    }
}