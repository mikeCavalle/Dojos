package dojo.dao.mem;

import dojo.dao.QuestionDao;
import dojo.model.Question;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryQuestionDao implements QuestionDao {

    private final SortedMap<Long, Question> questions = new TreeMap<Long, Question>();
    private final AtomicLong idSequence = new AtomicLong(0);

    @Override
    public Question saveQuestion(Question question) {

        if (question.getId() == null) {
            question = new Question(idSequence.incrementAndGet(), question.question, question.answer);
        }

        questions.put(question.getId(), question);

        return question;
    }

    @Override
    public Collection<Question> listQuestions() {
        return questions.values();
    }

    @Override
    public void deleteQuestionById(Long id) {
        questions.remove(id);
    }
}
