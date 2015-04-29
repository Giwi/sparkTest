package org.giwi.spark.application.model;

/**
 * Created by b3605 on 29/04/15.
 */
public class Message {
    private String mess;

    /**
     * Gets mess.
     *
     * @return mess
     */
    public String getMess() {
        return mess;
    }

    /**
     * Sets mess.
     *
     * @param mess the mess
     */
    public void setMess(String mess) {
        this.mess = mess;
    }

    /**
     * Instantiates a new Message.
     *
     * @param mess the mess
     */
    public Message(String mess) {
        this.mess = mess;
    }

}
