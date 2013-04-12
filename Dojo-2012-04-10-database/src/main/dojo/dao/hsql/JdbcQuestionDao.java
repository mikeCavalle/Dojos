package dojo.dao.hsql;

import dojo.dao.QuestionDao;
import dojo.model.Question;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JdbcQuestionDao implements QuestionDao {

    private final JdbcOperations jdbcOperations;

    public JdbcQuestionDao(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Question saveQuestion(Question question) {
        Question updatedQuestion = question;
        if (question.getId() == null) {
            this.jdbcOperations.update("insert into question (question, answer) values (?, ?)", question.question, question.answer);
            updatedQuestion = new Question(jdbcOperations.queryForLong("select max(id) from question"), question.question, question.answer);
        } else {
            this.jdbcOperations.update("update question set question=?, answer=? where id=?", question.question, question.answer, question.getId());
        }

        return updatedQuestion;
    }

    @Override
    public Collection<Question> listQuestions() {
        List<Question> questions = jdbcOperations.query("SELECT * FROM question ORDER BY id ASC", new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Question(rs.getLong("id"), rs.getString("question"), rs.getString("answer"));
            }
        });
        return questions;
    }

    @Override
    public void deleteQuestionById(Long id) {
        throw new RuntimeException("Not implemented");
    }
}
