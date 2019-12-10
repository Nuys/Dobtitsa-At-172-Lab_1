package sample.classes;

import sample.controllers.Authorization;

import java.util.TimerTask;

public class TimerTaskCheck extends TimerTask {

    private Proxys proxys;

    public TimerTaskCheck(Proxys proxys){
        this.proxys = proxys;
    }

    @Override
    public void run() {
        CheckProxy checkProxy = new CheckProxy(proxys);
        checkProxy.run();
    }
}
