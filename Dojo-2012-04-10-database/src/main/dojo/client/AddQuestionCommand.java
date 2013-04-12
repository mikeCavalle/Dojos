package dojo.client;

import dojo.dao.DaoFactory;
import dojo.model.Question;

public class AddQuestionCommand extends Command {

    @Override
    public boolean run() {

        printLine("");
        printLine(getName());
        Question question = new Question();

        question.question = readLine("Type question: ");
        question.answer = readLine("Type answer:   ");

        Question insertedQuestion = DaoFactory.getQuestionDao().saveQuestion(question);

        printLine("Question with id %s added successfully!", insertedQuestion.getId());
        printLine("");

        return false;
    }

    @Override
    public String getName() {
        return "Add question";
    }
}