package kjd.reactnative.bluetooth;

import com.facebook.react.bridge.WritableMap;

/**
 * Provide an interface for all objects that can be output as a
 * {@link com.facebook.react.bridge.WritableMap}.
 */
public interface WritableMapper {

    WritableMap toMap();

}
