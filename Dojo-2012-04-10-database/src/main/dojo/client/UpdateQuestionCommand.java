package dojo.client;

import dojo.dao.DaoFactory;
import dojo.model.Question;

public class UpdateQuestionCommand extends Command {

    private final Question question;

    public UpdateQuestionCommand(Question question) {
        this.question = question;
    }

    @Override
    public boolean run() {

        question.question = readLine("Type question: ");
        question.answer = readLine("Type answer:   ");

        DaoFactory.getQuestionDao().saveQuestion(question);

        printLine("Question with id %s updated successfully!", question.getId());
        printLine("");

        return false;
    }

    @Override
    public String getName() {
        return question.question;
    }
}