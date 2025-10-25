
@echo off
cd /d "C:\Users\gvsai\WeatherApp"
java --enable-native-access=javafx.graphics --module-path "C:\Users\gvsai\Downloads\openjfx-25.0.1_windows-x64_bin-sdk\javafx-sdk-25.0.1\lib;lib\gson-2.10.1.jar" --add-modules javafx.controls,com.google.gson -cp bin WeatherApp
pause
