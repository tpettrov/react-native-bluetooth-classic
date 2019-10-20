package kjd.reactnative.bluetooth;

import android.bluetooth.BluetoothDevice;

import com.facebook.react.bridge.WritableMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RNUtilsTest {

    @Mock
    BluetoothDevice device;

    @Test
    public void test_parseDate() {
    }

    @Test
    public void test_parseCalendar() {
    }

    @Test
    public void test_deviceToWritableMap_noClass_mapped() {
        when(device.getName()).thenReturn("TestDevice");
        when(device.getAddress()).thenReturn("1:1:1:1");
        when(device.getBluetoothClass()).thenReturn(null);

        WritableMap result = RNUtils.deviceToWritableMap(device);
        assertEquals(result.getString("name"), "TestDevice");
        assertEquals(result.getString("id"), "1:1:1:1");
        assertEquals(result.getString("address"), "1:1:1:1");
        assertEquals(result.getInt("class"), -1);
    }
}