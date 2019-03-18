package io.jochimsen.collo.protocol;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.NonFinal;

/**
 * This io.jochimsen.cahframework.protocol object shall never be changed because it is used to signal errors to the communication partner.
 * It'players defined to be compatible across all io.jochimsen.cahframework.protocol versions.
 */
@Value
@NonFinal
@EqualsAndHashCode(callSuper = false)
public class ErrorMessage extends ProtocolMessage {
    private final int errorCode;
    private final String message;

    @Override
    public int getMessageId() {
        return MessageCode.ERROR;
    }
}
