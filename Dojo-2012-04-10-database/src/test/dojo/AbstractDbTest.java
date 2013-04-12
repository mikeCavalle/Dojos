package dojo;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Abstract base class for database tests.
 */
public abstract class AbstractDbTest {

    protected final Logger logger = LoggerFactory.getLogger(AbstractDbTest.class);

    private EmbeddedDatabase database;
    protected JdbcOperations jdbcOperations;

    /**
     * Initializes in-memory database and JdbcOperations.
     *
     * Execute scripts schema.sql and data.sql.
     */
    @Before
    public final void baseSetUp() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addDefaultScripts();

        for (String script : fixtures()) {
            logger.debug("Add fixture script {}", script);
            builder.addScript(script);
        }

        database = builder.build();
        jdbcOperations = new JdbcTemplate(database);
    }

    /**
     * Shutdowns database.
     */
    @After
    public final void baseTearDown() {
        database.shutdown();
    }

    /**
     * @return Paths of database scripts to execute before each test, e.g. dojo/mytest.sql
     */
    protected String[] fixtures() {
        return new String[0];
    }
}
