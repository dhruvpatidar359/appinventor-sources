//
//  Image.swift
//  AIComponentKit
//
//  Created by Evan Patton on 10/20/16.
//  Copyright © 2016 MIT Center for Mobile Learning. All rights reserved.
//

import Foundation

open class Image: ViewComponent, AbstractMethodsForViewComponent {
  fileprivate let _view = UIImageView()
  fileprivate var _image: UIImage? = nil
  fileprivate var _picturePath = ""
  fileprivate var _rotationAngle = 0.0
  
  public override init(_ parent: ComponentContainer) {
    _view.isUserInteractionEnabled = true
    super.init(parent)
  }

  open override var view: UIView {
    get {
      return _view
    }
  }
  
  open var Picture: String {
    get {
      return _picturePath
    }
    set(path) {
      _picturePath = path
      if path.isEmpty {
        _image = nil
        _view.image = nil
        _view.frame.size = CGSize(width: 0, height: 0)
        _view.setNeedsUpdateConstraints()
        _view.setNeedsLayout()
      } else if let image = UIImage(named: path) {
        _image = image
        _view.image = image
        _view.sizeToFit()
        _view.setNeedsUpdateConstraints()
        _view.setNeedsLayout()
      }
      NSLog("Image size: \(_view.frame)")
    }
  }
  
  open var RotationAngle: Double {
    get {
      return _rotationAngle
    }
    set(rotationAngle) {
      if (_rotationAngle == rotationAngle) {
        return  // Don't waste cycles
      }
    }
  }
}
