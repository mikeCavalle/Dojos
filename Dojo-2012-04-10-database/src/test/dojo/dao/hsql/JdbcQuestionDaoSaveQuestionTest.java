package dojo.dao.hsql;

import dojo.AbstractDbTest;
import dojo.dao.QuestionDao;
import dojo.model.Question;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class JdbcQuestionDaoSaveQuestionTest extends AbstractDbTest {

    private QuestionDao dao;

    @Before
    public void setup(){
        dao = new JdbcQuestionDao(jdbcOperations);
    }

    @Test
    public void shouldSaveNewQuestionToDb() {
        Question question = new Question();
        dao.saveQuestion(question);

        int count = jdbcOperations.queryForInt("select count(*) from question");
        assertEquals(2, count);
    }

    @Test
    public void shouldReturnQuestionWithId() {
        int initialId = getMaxId();

        Question question = new Question();
        Question updatedQuestion = dao.saveQuestion(question);

        assertEquals(new Long(initialId + 1), updatedQuestion.getId());
    }

    @Test
    public void shouldAddProperIdForInserts() {
        int initialId = getMaxId();
        dao.saveQuestion(new Question());
        dao.saveQuestion(new Question());
        dao.saveQuestion(new Question());

        int maxId = getMaxId();
        assertEquals(initialId + 3, maxId);
    }

    @Test
    public void shouldReturnCorrectIdForTheThirdInsert() {
        int initialId = getMaxId();
        dao.saveQuestion(new Question());
        dao.saveQuestion(new Question());
        Question savedQuestion = dao.saveQuestion(new Question());

        assertEquals(new Long(initialId + 3), savedQuestion.getId());
    }

    @Test
    public void shouldSaveCorrectQuestionText() {
        Question question = new Question("1+1", "whatever");

        Question savedQuestion = dao.saveQuestion(question);
        String questionText = jdbcOperations.queryForObject(
                "select question from question where id="+savedQuestion.getId(), String.class);
        assertEquals("1+1", questionText);
    }

    @Test
    public void shouldUpdateCorrectQuestion() {
        Question question = new Question("1+1", "2");

        Question savedQuestion  = dao.saveQuestion(question);
        long savedQuestionId = savedQuestion.getId();
        savedQuestion.question = "Jotain muuta";
        dao.saveQuestion(savedQuestion);

        String answerText = jdbcOperations.queryForObject(
                "select question from question where id="+savedQuestionId, String.class);
        assertEquals("Jotain muuta", answerText);
    }

    @Test
    public void shouldSaveCorrectAnswer() {
        Question question = new Question("1+1", "2");

        Question savedQuestion = dao.saveQuestion(question);
        String answerText = jdbcOperations.queryForObject(
                "select answer from question where id="+savedQuestion.getId(), String.class);
        assertEquals("2", answerText);
    }

    @Test
    public void shouldUpdateCorrectAnswer() {
        Question question = new Question("1+1", "2");

        Question savedQuestion  = dao.saveQuestion(question);
        long savedQuestionId = savedQuestion.getId();
        savedQuestion.answer = "Jotain muuta";
        dao.saveQuestion(savedQuestion);

        String answerText = jdbcOperations.queryForObject(
                "select answer from question where id="+savedQuestionId, String.class);
        assertEquals("Jotain muuta", answerText);
    }

    @Override
    protected String[] fixtures() {
        return new String[] {"dojo/jee.sql"};
    }

    private int getMaxId() {
        return jdbcOperations.queryForInt("select max(id) from question");
    }
}
