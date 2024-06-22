package com.rtnslider

import android.graphics.Color
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RTNSliderManagerInterface
import com.facebook.react.viewmanagers.RTNSliderManagerDelegate
import com.facebook.react.common.MapBuilder

@ReactModule(name = SliderManager.NAME)
class SliderManager : SimpleViewManager<RTNSlider>(),
    RTNSliderManagerInterface<RTNSlider> {
  private val mDelegate: ViewManagerDelegate<RTNSlider>

  init {
    mDelegate = RTNSliderManagerDelegate(this)
  }

  override fun getDelegate(): ViewManagerDelegate<RTNSlider>? {
    return mDelegate
  }

  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): RTNSlider {
    return RTNSlider(context)
  }

  @ReactProp(name = "minimumValue")
  override fun setMinimumValue(view: RTNSlider?, minimumValue: Float) {
    view?.viewModel?.updateMinimumValue(minimumValue ?: 0f)
  }

  @ReactProp(name = "maximumValue")
  override fun setMaximumValue(view: RTNSlider?, maximumValue: Float) {
    view?.viewModel?.updateMaximumValue(maximumValue ?: 100f)
  }

  @ReactProp(name = "thumbTintColor")
  override fun setThumbTintColor(view: RTNSlider?, thumbTintColor: String?) {
    view?.viewModel?.updateThumbTintColor(thumbTintColor ?: "#9ccfb8")
  }

  @ReactProp(name = "minimumTrackTintColor")
  override fun setMinimumTrackTintColor(view: RTNSlider?, minimumTrackTintColor: String?) {
    view?.viewModel?.updateMinimumTrackTintColor(minimumTrackTintColor ?: "#9ccfb8")
  }

  @ReactProp(name = "value")
  override fun setValue(view: RTNSlider?, value: Float) {
    view?.viewModel?.updateValue(value ?: 0f)
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any> = mutableMapOf(
    OnValueChangeEvent.EVENT_NAME to MapBuilder.of("registrationName", "onValueChange")
  )

  companion object {
    const val NAME = "RTNSlider"
  }
}
