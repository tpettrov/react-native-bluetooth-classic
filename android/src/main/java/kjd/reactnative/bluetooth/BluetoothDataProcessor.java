package kjd.reactnative.bluetooth;

import android.bluetooth.BluetoothDevice;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/**
 * Processes Bluetooth buffer data (String) into the appropriate data type used when sending
 * events to React Native.  Originally the data was assumed to be String in all instances, but
 * there have been some comments stating that the data format needs to be customized.  For example
 * there may be: String, Byte[], Integer[], etc.
 * <p>
 * Instead of modifying the RNBluetoothClassicModule, a BluetoothDataProcessor should be created
 * and passed into the RNBluetoothClassicPackage.
 */
@SuppressWarnings({"unused"})
public interface BluetoothDataProcessor<T> {

    /**
     * Writes the processed data to map to use as an event parameter.
     *
     * @param device
     * @param data
     * @return
     */
    WritableMap write(BluetoothDevice device, String data);

    /**
     * Converts the device and message to an appropriate WritableMap.
     *
     * @param device the device from which the message was sent
     * @param data the String contents of the message
     * @return WritableMap which will be sent to React Native
     */
    T processData(BluetoothDevice device, String data);

    /**
     * Converts String into BluetoothMessage and exports to WritableMap.
     */
    BluetoothDataProcessor BluetoothMessageProcessor = new BluetoothDataProcessor<BluetoothMessage>() {
        @Override
        public WritableMap write(BluetoothDevice device, String data) {
            return processData(device, data).asMap();
        }

        @Override
        public BluetoothMessage processData(BluetoothDevice device, String data) {
            return new BluetoothMessage<>(device, processData(device, data));
        }
    };

    /**
     * Converts String into Integer Array and exports as WritableArray.  This was pulled from
     * a comment made on https://github.com/kenjdavidson/react-native-bluetooth-classic/issues/1
     * stating that the format returned to React Native was an Intege Array.
     */
    BluetoothDataProcessor BluetoothByteArraypProcessor = new BluetoothDataProcessor<WritableArray>() {
        @Override
        public WritableMap write(BluetoothDevice device, String data) {
            WritableMap params = Arguments.createMap();
            params.putMap("device", RNUtils.deviceToWritableMap(device));
            params.putString("originalData", data);
            params.putArray("data", processData(device, data));
            return params;
        }

        @Override
        public WritableArray processData(BluetoothDevice device, String data) {
            WritableArray writableArray = Arguments.createArray();
            byte[] bytes = data.getBytes();

            for(int i=0;i<bytes.length;i++){
                writableArray.pushInt((int)bytes[i]);
            }

            return writableArray;
        }
    };
}
