package kjd.reactnative.bluetooth;

import android.bluetooth.BluetoothDevice;

import com.facebook.react.bridge.WritableMap;

/**
 * Builds the appropriate WritableMap which is then sent to the React Native Javascript using the
 * {@link com.facebook.react.uimanager.events.RCTEventEmitter}.  This came around due to a request/
 * comment where someone was expecting the onRead Object in a different format.
 */
public interface OnReadEventParamWriter {

    /**
     * Converts the device and message to an appropriate WritableMap.
     *
     * @param device the device from which the message was sent
     * @param contents the String contents of the message
     * @return WritableMap which will be sent to React Native
     */
    public WritableMap write(BluetoothDevice device, String contents);

}
