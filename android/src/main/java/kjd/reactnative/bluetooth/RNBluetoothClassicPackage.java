
package kjd.reactnative.bluetooth;

import android.bluetooth.BluetoothDevice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptModule;

/**
 * Instantiates the {@link RNBluetoothClassicModule}.  The {@link RNBluetoothClassicPackage} is
 * provided to the MainApplication through the #getPackages method.  The package allows for
 * customization of the delimiter and encoding upon creation - allowing it to be skipped
 * during JavaScript configuration.
 *
 * @author kenjdavidson
 *
 */
public class RNBluetoothClassicPackage implements ReactPackage {

    public static final String DELIMITER = "\n";
    public static final String ENCODING = "UTF-8";

    private String mEncoding;
    private String mDelimiter;
    private BluetoothDataProcessor mParamWriter;

    public RNBluetoothClassicPackage() {
        this(DELIMITER, ENCODING);
    }

    public RNBluetoothClassicPackage(String delimiter, String encoding) {
        this(delimiter, encoding, BluetoothDataProcessor.BluetoothMessageProcessor);
    }

    public RNBluetoothClassicPackage(String delimiter, String encoding, BluetoothDataProcessor writer) {
        this.mDelimiter = delimiter;
        this.mEncoding = encoding;
        this.mParamWriter = writer;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
      return Arrays.<NativeModule>asList(new RNBluetoothClassicModule(reactContext, mDelimiter, mEncoding, mParamWriter));
    }

    // Deprecated from RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
      return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
      return Collections.emptyList();
    }

}