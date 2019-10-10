# coding: utf-8
# Copyright (c) Facebook, Inc. and its affiliates.
#
# This source code is licensed under the MIT license found in the
# LICENSE file in the root directory of this source tree.

require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.swift_version = '5.0'

  s.name                    = package["name"]
  s.version                 = package["version"]
  s.summary                 = "RNBluetoothClassic"
  s.description             = <<-DESC
                                Provides Bluetooth Adapter (Android) and External Accessory (IOS) Bluetooth
                                support to React Native applications.
                             DESC
  s.homepage                = "https://kenjdavidson.github.io/react-native-bluetooth-classic"
  s.license                 = package["license"]
  s.author                  = "Kenneth Davidson <ken.j.davidson@live.ca>"
  s.platforms               = { :ios => '9.0' }
  s.source                  = { :git => 'https://github.com/kenjdavidson/react-native-bluetooth-classic.git' }
  s.source_files            = 'ios/**/*.{h,m,swift}'
  s.preserve_paths          = 'ios/**/*.{h,m,swift}'
  s.requires_arc            = true

  s.dependency "React"
end
