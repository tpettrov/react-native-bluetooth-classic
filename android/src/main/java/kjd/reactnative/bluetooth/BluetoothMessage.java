package kjd.reactnative.bluetooth;

import android.bluetooth.BluetoothDevice;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

import java.util.Calendar;
import java.util.Date;

/**
 * Wrapper for Bluetooth message contents.
 *
 * @param <T>
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
