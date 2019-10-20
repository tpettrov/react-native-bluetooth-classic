package kjd.reactnative.bluetooth;

import android.bluetooth.BluetoothDevice;

import java.io.UnsupportedEncodingException;

/**
 * Manages listening on the Bluetooth data received.
 */
@SuppressWarnings({"unused"})
public interface BluetoothEventListener {

    /**
     * Data has been received from the BluetoothDevice.
     *
     * @param device the device which sent the data
     * @param data the byte array received from the device
     * @param size the size of the byte array
     * @throws UnsupportedEncodingException
     */
    void onDataReceived(BluetoothDevice device, byte[] data, int size) throws UnsupportedEncodingException;

    /**
     * An error occurred while communicating or connecting to the device.
     *
     * @param device the device on which the error occurred
     */
    void onError(BluetoothDevice device, Exception e);

    /**
     * BluetoothDevice was successfully connected.
     *
     * @param device device to which we connected
     */
    void onConnectionSuccess(BluetoothDevice device);

    /**
     * BluetoothDevice connection attempt failed.
     *
     * @param device device for which the failure occurred
     * @param e optional reason for the failure
     */
    void onConnectionFailed(BluetoothDevice device, Exception e);

    /**
     * BluetoothDevice connection was lost.
     *
     * @param device device for which the failure occurred
     * @param e optional reason for the failure
     */
    void onConnectionLost(BluetoothDevice device, Exception e);

}
