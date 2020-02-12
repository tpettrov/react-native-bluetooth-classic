package kjd.reactnative.bluetooth;

import java.util.List;

public class BluetoothClassicMiddlewareService {
  private static BluetoothClassicMiddlewareService instance = null;
  private List<IRNBluetoothClassicMiddleware> mMiddlewares;

  private BluetoothClassicMiddlewareService() {}

  public static BluetoothClassicMiddlewareService getInstance() {
    if (instance == null) {
      synchronized(BluetoothClassicMiddlewareService.class) {
        instance = new BluetoothClassicMiddlewareService();
      }
    }
    return instance;
  }

  public List<IRNBluetoothClassicMiddleware> getMiddlewares() {
    return this.mMiddlewares;
  }

  public void setMiddleware(List<IRNBluetoothClassicMiddleware> middlewares) {
    this.mMiddlewares = middlewares;
  }
}
