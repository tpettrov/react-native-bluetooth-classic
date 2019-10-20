//
//  StringEncodingUtils.swift
//  RNBluetoothClassic
//
//  Created by Ken Davidson on 2019-10-13.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation

class StringEncodingUtils {
    static func parseEncoding(_ str:String) -> String.Encoding? {
        switch (str) {
            case "ascii": return .ascii
            case "utf8": return .utf8
            case "utf16": return .utf16
            case "utf32": return .utf32
            case "symbol": return .symbol
            case "unicode": return .unicode
            default: return nil;
        }
    }
}
