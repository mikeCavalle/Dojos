package dojo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example test.
 */
public class MyTest extends AbstractDbTest {

    @Override
    protected String[] fixtures() {
        return new String[] {"dojo/jee.sql"};
    }

 //   @Test
    public void fixtureSqlAddsOneQuestionToDatabase() {
        assertEquals(2, jdbcOperations.queryForInt("select count(*) from question"));
    }
}
