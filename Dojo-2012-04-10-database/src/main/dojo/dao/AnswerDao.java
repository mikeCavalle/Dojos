package dojo.dao;

import dojo.model.Answer;

import java.util.Collection;

public interface AnswerDao {

    /**
     * Inserts a new or updates an existing answer.
     *
     * An answer is considered new if its id is null,
     * otherwise its existing. A unique id is assigned
     * automatically to new answers.
     */
    Answer save(Answer answer);

    /**
     * List all answers ordered descending by answer date.
     */
    Collection<Answer> listAnswers();

    /**
     * Delete all answers.
     */
    void deleteAll();
}
