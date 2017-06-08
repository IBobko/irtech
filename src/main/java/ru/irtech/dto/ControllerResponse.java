package ru.irtech.dto;

/**
 * Created by Iggytoto on 29.04.2017.
 */
public class ControllerResponse {

    /**
     * Ok message tag.
     */
    protected static final String OK_MESSAGE = "OK";

    /**
     * Message.
     */
    private final String message;

    /**
     * Main c-tor.
     *
     * @param message message to return.
     */
    public ControllerResponse(final String message) {
        this.message = message;
    }

    /**
     * Message getter.
     *
     * @return message.
     */
    public String getMessage() {
        return this.message;
    }
}
