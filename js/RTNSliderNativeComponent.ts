import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import type { ViewProps } from 'react-native';
import type { 
  BubblingEventHandler,
  Float 
} from 'react-native/Libraries/Types/CodegenTypes';

interface OnValueChangeEvent {
  value: Float;
};

interface NativeProps extends ViewProps {
  maximumValue?: Float;
  minimumValue?: Float;
  thumbTintColor?: string;
  minimumTrackTintColor?: string;
  value?: Float;
  onValueChange?: BubblingEventHandler<Readonly<OnValueChangeEvent>>;
}

export default codegenNativeComponent<NativeProps>('RTNSlider');
