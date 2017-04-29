package ru.irtech.dto;

/**
 * Created by Iggytoto on 29.04.2017.
 */
public class ControllerResponse {
    /**
     * Message
     */
    protected final String message;

    /**
     * Main c-tor
     *
     * @param message message to return
     */
    public ControllerResponse(String message) {
        this.message = message;
    }

    /**
     * Message getter
     *
     * @return message
     */
    public String getMessage() {
        return this.message;
    }
}
