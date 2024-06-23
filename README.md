---
 RTNSlider (Working in Progress) (Working only new Arch)
---



A component used to select a single value from a range of values.
This [component](https://developer.android.com/develop/ui/compose/components/slider) integrates a slider implemented with [Jetpack Compose](https://developer.android.com/develop/ui/compose). 

---


 How to use?
---

1 - Clone the project to the same folder as your React Native project 
2 - Using the terminal, access the root of your React Native project and type the following command: 
```console
yarn add ../RTNSlider 
```
3 - Using the terminal, access the android folder of your React Native project and type the following command: 
```console
./gradlew generateCodegenArtifactsFromSchema
```
4 - Run your project

---
 Example Usage
---
```js
<RTNSlider
  value={value}
  minimumTrackTintColor="#07407B"
  thumbTintColor="#07407B"
  minimumValue={minimumValue}
  maximumValue={maximumValue}
  style={styles.box}
  onValueChange={handleValueChange}
/>
```





# Reference

## Props



### `style`

Used to style and layout the `Slider`. See `StyleSheet.js` and `ViewStylePropTypes.js` for more info.

| Type       | Required |
| ---------- | -------- |
| View.style | No       |

---

### `maximumValue`

Initial maximum value of the slider. Default value is 100.

| Type   | Required |
| ------ | -------- |
| number | No       |

---

### `minimumTrackTintColor`

The color used for the track to the left of the button. Overrides the default blue gradient image on iOS.

| Type               | Required | Default
| ------------------ | -------- | -------- |
| color | No       | #9ccfb8

---

### `minimumValue`

Initial minimum value of the slider. Default value is 0.

| Type   | Required |
| ------ | -------- |
| number | No       |

---

### `onValueChange`

Callback continuously called while the user is dragging the slider.

| Type     | Required |
| -------- | -------- |
| function | No       |

---

### `value`

Initial value of the slider. The value should be between minimumValue and maximumValue, which default to 0 and 1 respectively. Default value is 0.

_This is not a controlled component_, you don't need to update the value during dragging.

| Type   | Required |
| ------ | -------- |
| number | No       |

---

### `thumbTintColor`

The color used to tint the default thumb images on iOS, or the color of the foreground switch grip on Android.

| Type               | Required | Default
| ------------------ | -------- | -------- |
| color | No       | #9ccfb8

---

![Screenshot Component](https://github.com/mensonones/RTNSlider/blob/main/prints/rtn-slider.jpg)
