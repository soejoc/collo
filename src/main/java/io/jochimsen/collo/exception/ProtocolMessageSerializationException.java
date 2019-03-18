package io.jochimsen.collo.exception;

public class ProtocolMessageSerializationException extends RuntimeException {
    private static final String MESSAGE = "The protocol message could not be serialized";

    public ProtocolMessageSerializationException(final Throwable cause) {
        super(MESSAGE, cause);
    }
}
