package com.rtnslider

import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.runtime.collectAsState

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event

@Composable
fun JetpackComposeView(
    viewModel: JetpackComposeViewModel,
    onValueChange: (value: Float) -> Unit = {}
) {
    val minimumValue by viewModel.minimumValue.collectAsState()
    val maximumValue by viewModel.maximumValue.collectAsState()
    val thumbTintColor by viewModel.thumbTintColor.collectAsState()
    val minimumTrackTintColor by viewModel.minimumTrackTintColor.collectAsState()
    val value by viewModel.value.collectAsState()

    val thumbColor = parseColor(thumbTintColor)
    val activeTrackColor = parseColor(minimumTrackTintColor)

    var sliderPosition by remember { mutableFloatStateOf(value.coerceIn(minimumValue, maximumValue)) }
    Column {
        Slider(
            value = sliderPosition,
            valueRange = minimumValue..maximumValue,
            onValueChange = {
                sliderPosition = it
                onValueChange(it)
            },
            colors = SliderDefaults.colors(
                thumbColor = thumbColor,
                activeTrackColor = activeTrackColor,
            )
        )
        Text(text = sliderPosition.toString())
    }
}

// Função auxiliar para converter uma cor em hexadecimal para Color, com fallback para uma cor padrão.
private fun parseColor(hexColor: String, defaultColor: Color = Color.Cyan): Color {
    return try {
        Color(android.graphics.Color.parseColor(hexColor))
    } catch (e: IllegalArgumentException) {
        defaultColor
    }
}

class JetpackComposeViewModel : ViewModel() {
    private val _minimumValue = MutableStateFlow(0f)
    private val _maximumValue = MutableStateFlow(100f)
    private val _thumbTintColor = MutableStateFlow("#9ccfb8")
    private val _minimumTrackTintColor = MutableStateFlow("#9ccfb8")
    private val _value = MutableStateFlow(0f)

    val minimumValue: StateFlow<Float> get() = _minimumValue
    val maximumValue: StateFlow<Float> get() = _maximumValue
    val thumbTintColor: StateFlow<String> get() = _thumbTintColor
    val minimumTrackTintColor: StateFlow<String> get() = _minimumTrackTintColor
    val value: StateFlow<Float> get() = _value

    fun updateMinimumValue(newValue: Float) {
        _minimumValue.value = newValue
    }

    fun updateMaximumValue(newValue: Float) {
        _maximumValue.value = newValue
    }

    fun updateThumbTintColor(newValue: String) {
        _thumbTintColor.value = newValue
    }

    fun updateMinimumTrackTintColor(newValue: String) {
        _minimumTrackTintColor.value = newValue
    }

    fun updateValue(newValue: Float) {
        _value.value = newValue
    }
}

class OnValueChangeEvent(surfaceId: Int, viewId: Int, val value: Float) : Event<OnValueChangeEvent>(surfaceId, viewId) {
    override fun getEventName() = EVENT_NAME

    // All events for a given view can be coalesced.
    override fun getCoalescingKey(): Short = 0

    override fun getEventData(): WritableMap? = Arguments.createMap().also {
        it.putDouble("value", value.toDouble())
    }

    companion object {
        const val EVENT_NAME = "onValueChange"
    }
}