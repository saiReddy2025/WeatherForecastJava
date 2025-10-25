import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import com.google.gson.*;

public class WeatherApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Enter City:");
        TextField cityField = new TextField();
        Button fetchBtn = new Button("Get Weather");
        Label resultLabel = new Label();

        fetchBtn.setOnAction(e -> {
            String city = cityField.getText().trim();
            if(city.isEmpty()) {
                resultLabel.setText("Please enter a city name!");
                return;
            }

            String apiKey = "27964fabbdd19daf5dcd57429670ebb4"; // Your API key
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" 
                         + city + "&appid=" + apiKey + "&units=metric";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if(response.statusCode() != 200) {
                    resultLabel.setText("City not found or API error!");
                    return;
                }

                JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
                double temp = json.getAsJsonObject("main").get("temp").getAsDouble();
                String desc = json.getAsJsonArray("weather")
                                .get(0).getAsJsonObject()
                                .get("description").getAsString();

                resultLabel.setText("City: " + city + "\nTemperature: " + temp + "°C\nCondition: " + desc);

            } catch (IOException | InterruptedException ex) {
                resultLabel.setText("Error fetching data!");
            }
        });

        VBox root = new VBox(10, label, cityField, fetchBtn, resultLabel);
        root.setStyle("-fx-padding: 20; -fx-font-size: 14;");
        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("Weather Forecast App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
