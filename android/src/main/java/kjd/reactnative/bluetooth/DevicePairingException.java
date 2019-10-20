package kjd.reactnative.bluetooth;

@SuppressWarnings({"unused"})
public class DevicePairingException extends IllegalStateException {

    public DevicePairingException() {
    }

    public DevicePairingException(String message) {
        super(message);
    }

    public DevicePairingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DevicePairingException(Throwable cause) {
        super(cause);
    }

}
