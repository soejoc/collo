package io.jochimsen.collo.misc.error.error_message;

import io.jochimsen.collo.misc.error.ErrorCode;
import io.jochimsen.collo.misc.error.ErrorMessageException;

public class InvalidProtocolVersionException extends ErrorMessageException {
    public InvalidProtocolVersionException(final int version, final int currentVersion) {
        super(String.format("Invalid io.jochimsen.cahframework.protocol version found! Expected version %d but found version %d", currentVersion, version));
    }

    @Override
    public int getErrorCode() {
        return ErrorCode.INVALID_PROTOCOL_VERSION;
    }
}
