package kjd.reactnative.bluetooth;

import com.facebook.react.bridge.ReactApplicationContext;

public interface IRNBluetoothClassicMiddleware {
  void setReactContext(ReactApplicationContext reactContext);

  void onData(byte[] bytesArray, int bytes);
}
