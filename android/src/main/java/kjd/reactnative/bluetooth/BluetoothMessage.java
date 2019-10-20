package kjd.reactnative.bluetooth;

import android.bluetooth.BluetoothDevice;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

import java.util.Calendar;
import java.util.Date;

/**
 * Wrapper for Bluetooth message contents.  By default BluetoothMessage(s) consist of: the related
 * BluetoothDevice, the Timestamp of the message and data to be provided (in String form).  The
 * message is immutable.
 *
 * @param <T> type for which this BluetoothMessage provides wrapping
 */
public class BluetoothMessage<T> {

    private BluetoothDevice device;
    private Date timestamp;
    private T data;

    public BluetoothMessage(BluetoothDevice device, T data) {
        this.device = device;
        this.data = data;
        this.timestamp = Calendar.getInstance().getTime();
    }

    public WritableMap asMap() {
        WritableMap map = Arguments.createMap();
        map.putMap("device", RNUtils.deviceToWritableMap(device));
        map.putString("data", String.valueOf(data));
        map.putString("timestamp", RNUtils.parseDate(timestamp));
        return map;
    }

}
