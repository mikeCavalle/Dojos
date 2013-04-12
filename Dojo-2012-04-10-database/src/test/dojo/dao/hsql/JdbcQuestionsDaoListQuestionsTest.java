package dojo.dao.hsql;

import dojo.AbstractDbTest;
import dojo.dao.QuestionDao;
import dojo.model.Question;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class JdbcQuestionsDaoListQuestionsTest extends AbstractDbTest{

    private QuestionDao dao;

    @Before
    public void setup(){
        dao = new JdbcQuestionDao(jdbcOperations);
    }

    @Override
    protected String[] fixtures() {
        return new String[] {"dojo/questionListFixture.sql"};
    }

    @Test
    public void shouldReturnCorrectNumberOfQuestions() {
        Collection<Question> questions = dao.listQuestions();

        assertEquals(2, questions.size());
    }

    @Test
    public void shouldReturnCorrectQuestions() {
        Question[] questions = dao.listQuestions().toArray(new Question[]{});

        assertEquals("Paljonko on 2 + 6", questions[0].question);
        assertEquals("8", questions[0].answer);
        assertEquals(new Long(3), questions[0].getId());

        assertEquals("Paljonko on 3 + 3", questions[1].question);
        assertEquals("6", questions[1].answer);
        assertEquals(new Long(5), questions[1].getId());
    }

}
