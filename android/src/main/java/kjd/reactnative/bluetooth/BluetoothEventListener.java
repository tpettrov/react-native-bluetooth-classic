package kjd.reactnative.bluetooth;

import java.io.UnsupportedEncodingException;

/**
 * Manages listening on the Bluetooth data received.
 */
public interface BluetoothDataReceivedListener {

    /**
     * Called when data is received from a RNBluetoothClassicService
     * @param data the received data
     * @param size the size of the received data
     * @throws UnsupportedEncodingException
     */
    void onDataReceived (byte[] data, int size) throws UnsupportedEncodingException;

}
