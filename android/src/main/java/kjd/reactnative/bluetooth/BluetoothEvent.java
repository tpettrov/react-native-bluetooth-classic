package kjd.reactnative.bluetooth;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

/**
 * Bluetooth events (and their code values) which are available to the Android and React Native
 * application.
 */
@SuppressWarnings({"unused"})
public enum BluetoothEvent {
    BLUETOOTH_ENABLED("bluetoothEnabled"),
    BLUETOOTH_DISABLED("bluetoothDisabled"),
    BLUETOOTH_CONNECTED("bluetoothConnected"),
    BLUETOOTH_DISCONNECTED("bluetoothDisconnected"),
    CONNECTION_SUCCESS("connectionSuccess"),        // Promise only
    CONNECTION_FAILED("connectionFailed"),          // Promise only
    CONNECTION_LOST("connectionLost"),
    READ("read"),
    ERROR("error");

    public final String code;
    BluetoothEvent(String code) {
        this.code = code;
    }

    public static WritableMap eventNames() {
        WritableMap events = Arguments.createMap();
        for(BluetoothEvent event : BluetoothEvent.values()) {
            events.putString(event.name(), event.code);
        }
        return events;
    }
}
