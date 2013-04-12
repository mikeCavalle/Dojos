package dojo.dao;

public class DaoFactory {

    private static QuestionDao questionDao;
    private static AnswerDao answerDao;

    public static void setQuestionDao(QuestionDao dao) {
        questionDao = dao;
    }

    public static QuestionDao getQuestionDao() {
        return questionDao;
    }

    public static void setAnswerDao(AnswerDao answerDao) {
        DaoFactory.answerDao = answerDao;
    }

    public static AnswerDao getAnswerDao() {
        return answerDao;
    }
}
