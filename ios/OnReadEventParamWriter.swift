//
//  OnReadEventParamWriter.swift
//  RNBluetoothClassic
//
//  Created by Ken Davidson on 2019-10-13.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation

/**
  Builds the appropriate Dictionary<String,Any> which is then sent to the React Native.  This came around due to a request/
  comment where someone was expecting the onRead Object in a different format.
 */
protocol OnReadEventParamWriter {
    
    /**
     Converts the device and content to a passable Dictionary<String,Any>
     - parameter device: the device which sent the data
     - parameter data: the data which was received from the device
     */
    func write(device:BluetoothDevice, data:String) -> Dictionary<String,Any>
    
}
