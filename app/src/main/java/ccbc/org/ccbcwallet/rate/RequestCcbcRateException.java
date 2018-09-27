package ccbc.org.ccbcwallet.rate;

/**
 * Created by furszy on 7/5/17.
 */
public class RequestCcbcRateException extends Exception {
    public RequestCcbcRateException(String message) {
        super(message);
    }

    public RequestCcbcRateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestCcbcRateException(Exception e) {
        super(e);
    }
}
