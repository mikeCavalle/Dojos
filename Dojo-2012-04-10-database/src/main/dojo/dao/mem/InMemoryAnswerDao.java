package dojo.dao.mem;

import dojo.dao.AnswerDao;
import dojo.model.Answer;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryAnswerDao implements AnswerDao {

    private final SortedMap<Long, Answer> answers = new TreeMap<Long, Answer>();
    private final AtomicLong idSequence = new AtomicLong(0);

    @Override
    public Answer save(Answer answer) {
        if (answer.id == null) {
            answer.id = idSequence.incrementAndGet();
        }

        answers.put(answer.id, answer);

        return answer;
    }

    @Override
    public Collection<Answer> listAnswers() {
        return answers.values();
    }

    @Override
    public void deleteAll() {
        answers.clear();
    }
}