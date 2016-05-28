package org.nerdboy.chatbot;

import org.nerdboy.chatbot.brain.Brain;
import org.nerdboy.chatbot.server.HttpServer;
import org.nerdboy.chatbot.utils.DataUtil;

import java.util.Properties;

/**
 * Created by xsank.mz on 2016/5/18.
 */
public class Shour {
    private Brain brain;
    private HttpServer server;

    public Shour(String property) {
        Properties properties = DataUtil.loadProperty(property);
        initBrain(properties);
    }

    public Shour(Properties properties) {
        initBrain(properties);
    }

    private void initBrain(Properties properties) {
        brain = new Brain();
        String strAbility = properties.getProperty("ability");
        String strHandler = properties.getProperty("handler");
        brain.initAbilities(strAbility);
        brain.initHandler(strHandler);
    }

    public void play() {

    }

    public String response(String request) {
        return brain.response(request);
    }

    public void die() {
        this.brain.die();
        this.server.destroy();
    }
}