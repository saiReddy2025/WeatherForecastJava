Steps to add README.md:

Open Notepad (or any editor) and paste the following content:

# Weather Forecast Java App

A simple **JavaFX-based Weather Forecast Application** that fetches real-time weather information for any city using the **OpenWeatherMap API**.

## Features
- Enter a city name to get current weather.
- Displays temperature (°C) and weather condition.
- Simple and clean JavaFX user interface.

## Requirements
- Java JDK 25+
- JavaFX SDK 25+
- Gson library for JSON parsing
- OpenWeatherMap API key

## How to Run
1. Clone the repository:  
   ```bash
   git clone https://github.com/saiReddy2025/WeatherForecastJava.git


Navigate to the project folder:

cd WeatherApp


Compile the code:

javac --module-path "PATH_TO_FX" --add-modules javafx.controls -cp "lib\gson-2.10.1.jar" -d bin src\WeatherApp.java


Run the application:

java --module-path "PATH_TO_FX" --add-modules javafx.controls -cp "bin;lib\gson-2.10.1.jar" WeatherApp

