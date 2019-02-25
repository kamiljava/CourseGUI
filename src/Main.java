import animatefx.animation.Pulse;
import animatefx.animation.RubberBand;
import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/courseView.fxml"));
        primaryStage.setTitle("CourseGUI");
        primaryStage.setScene(new Scene(root));


        primaryStage.getScene().getStylesheets().add("Style.css");

        Image image = new Image("/view/img/logo.png");
        primaryStage.getIcons().add(image);

        primaryStage.setResizable(false);
        primaryStage.show();
        new Pulse(root).play();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
