package life.plank.controller.exception;

/**
 * Created by Praneeth on 9/8/2015.
 */
public class PlankResourceNotFoundException extends RuntimeException {
    public PlankResourceNotFoundException() {
        super();
    }

    public PlankResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PlankResourceNotFoundException(final String message) {
        super(message);
    }

    public PlankResourceNotFoundException(final Throwable cause) {
        super(cause);
    }

}
