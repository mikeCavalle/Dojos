package dojo.client;

import dojo.dao.DaoFactory;
import dojo.dao.mem.InMemoryAnswerDao;
import dojo.dao.mem.InMemoryQuestionDao;

public class Main {

    public static void main(String[] args) {

        DaoFactory.setQuestionDao(new InMemoryQuestionDao());
        DaoFactory.setAnswerDao(new InMemoryAnswerDao());

        new DisplayMainMenuCommand().run();

        System.out.println("Bye!");
    }
}