package dojo.dao.hsql;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class HsqlDataSourceFactory {

    /**
     * Create file based HSQL database and create tables if they do not
     * already exist.
     */
    public static DataSource create(String file) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        dataSource.setUrl("jdbc:hsqldb:file:/Users/henrim/Documents/workspaces/dojo/db/" + file);
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        createTables(dataSource);

        return dataSource;
    }

    private static void createTables(DriverManagerDataSource dataSource) {

        JdbcOperations jdbcOperations = new JdbcTemplate(dataSource);

        try {
            jdbcOperations.update("create table question (\n" +
                    "  id bigint generated by default as identity not null primary key,\n" +
                    "  question varchar(255) not null,\n" +
                    "  answer varchar(255) not null\n" +
                    ")");
        } catch (Exception e) {}

        try {
            jdbcOperations.update("create table answer (\n" +
                    "  id bigint generated by default as identity not null primary key,\n" +
                    "  correct boolean not null,\n" +
                    "  answer_date timestamp default now,\n" +
                    "  question_id bigint not null,\n" +
                    "  constraint answer_question_id foreign key (question_id) references question (id)\n" +
                    ")");
        } catch (Exception e) {}
    }
}