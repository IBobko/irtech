package ru.irtech.dto;

/**
 * Created by Iggytoto on 30.04.2017.
 * Class that represents generic advice response
 */
public class AdviceResponse extends ControllerResponse {
    /**
     * advice message.
     */
    private final String adviceMessage;

    /**
     * image url.
     */
    private final String imageResource;

    /**
     * adviceId.
     */
    private final int adviceId;

    /**
     * Main c-tor.
     *
     * @param adviceMessage advice text.
     * @param imageResource image static url.
     * @param id            advice id.
     */
    public AdviceResponse(final String adviceMessage, final String imageResource, final int id) {
        super("OK");
        this.adviceMessage = adviceMessage;
        this.imageResource = imageResource;
        this.adviceId = id;
    }

    /**
     * get advice id.
     *
     * @return id.
     */
    public int getAdviceId() {
        return adviceId;
    }

    /**
     * get image url.
     *
     * @return url.
     */
    public String getImageResource() {
        return imageResource;
    }

    /**
     * get advice.
     *
     * @return advice string.
     */
    public String getAdviceMessage() {
        return adviceMessage;
    }
}
