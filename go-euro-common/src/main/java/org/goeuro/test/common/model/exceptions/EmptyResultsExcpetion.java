package org.goeuro.test.common.model.exceptions;

/**
 * Created by Nikola.Ivanov on 2/7/14.
 */
public class EmptyResultsExcpetion extends RuntimeException {
    public EmptyResultsExcpetion() {
    }

    public EmptyResultsExcpetion(String message) {
        super(message);
    }

    public EmptyResultsExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyResultsExcpetion(Throwable cause) {
        super(cause);
    }

    public EmptyResultsExcpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
