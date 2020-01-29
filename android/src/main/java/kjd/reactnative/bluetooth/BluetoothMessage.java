package kjd.reactnative.bluetooth;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

import java.util.Calendar;
import java.util.Date;

public class BluetoothMessage<T> {

    private WritableMap device;
    private Date timestamp;
    private T data;
    private String base64string;

    public BluetoothMessage(WritableMap device, T data) {
        this.device = device;
        this.data = data;
        this.timestamp = Calendar.getInstance().getTime();
    }

    public BluetoothMessage(WritableMap device, T data, String base64string) {
        this(device, data);
        this.base64string = base64string;
    }

    public WritableMap asMap() {
        WritableMap map = Arguments.createMap();
        map.putString("data", String.valueOf(data));
        map.putString("base64string", base64string);
        map.putString("timestamp", RNUtils.parseDate(timestamp));
        return map;
    }
}
