package controller.commands;

import util.MyLogger;

public class Unknow extends FrontCommand {

    @Override
    public void process() {
        MyLogger.writeLogSevere("Error en el comando");
        forward("/Unknow.jsp");
    }

}
