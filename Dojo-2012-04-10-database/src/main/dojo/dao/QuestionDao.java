package dojo.dao;

import dojo.model.Question;

import java.util.Collection;

public interface QuestionDao {

    /**
     * Inserts a new or updates an existing question.
     *
     * A question is considered new if its id is null,
     * otherwise its existing. A unique id is assigned
     * automatically to new questions.
     */
    Question saveQuestion(Question question);

    /**
     * List all questions ordered ascending by id.
     */
    Collection<Question> listQuestions();

    /**
     * Delete question by id.
     */
    void deleteQuestionById(Long id);
}
