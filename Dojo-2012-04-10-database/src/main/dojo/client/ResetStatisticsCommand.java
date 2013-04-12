package dojo.client;

import dojo.dao.DaoFactory;

public class ResetStatisticsCommand extends Command {

    @Override
    public boolean run() {

        DaoFactory.getAnswerDao().deleteAll();

        printLine("");
        printLine("Statistics reseted successfully! ");
        printLine("");

        return false;
    }

    @Override
    public String getName() {
        return "Reset statistics";
    }
}
