import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View, Button, NativeModules } from "react-native";

const { AlarmModule } = NativeModules;

export default function App() {
  function onPress() {
    AlarmModule.createAlarm("myAlarmName");
  }

  return (
    <View style={styles.container}>
      <Text>Open up App.tsx to start working on your app!</Text>
      <Button
        title="Click to invoke your native module!"
        color="#841584"
        onPress={onPress}
      />

      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
