package com.rtnslider

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout 
import androidx.compose.ui.platform.ComposeView
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.UIManagerHelper

class RTNSlider : LinearLayout {
  constructor(context: Context) : super(context) {
    configureComponent(context)
  }
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    configureComponent(context)
  }
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  ) {
    configureComponent(context)
  }

  internal lateinit var viewModel: JetpackComposeViewModel

  private fun configureComponent(context: Context) {

    layoutParams = LayoutParams(
      LayoutParams.WRAP_CONTENT,
      LayoutParams.WRAP_CONTENT
    )

    ComposeView(context).also {
      it.layoutParams = LayoutParams(
        LayoutParams.WRAP_CONTENT,
        LayoutParams.WRAP_CONTENT
      )

      viewModel = JetpackComposeViewModel()

      it.setContent {
        JetpackComposeView(
          viewModel = viewModel,
          onValueChange = {
            value -> 
            val surfaceId = UIManagerHelper.getSurfaceId(context)
            val viewId = this.id

            UIManagerHelper
              .getEventDispatcherForReactTag(context as ReactContext, viewId)
              ?.dispatchEvent(
                OnValueChangeEvent(surfaceId, viewId, value.toFloat())
              )
          }
          )
      }                                

      addView(it)                      
    }

  }
}
