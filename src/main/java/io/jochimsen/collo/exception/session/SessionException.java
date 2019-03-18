package io.jochimsen.collo.exception.session;

public abstract class SessionException extends RuntimeException {
    public SessionException(final String message) {
        super(message);
    }

    public SessionException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
