package AutoClicker;


import AutoClicker.Model.Clicker.Advanced_Auto_Clicker;
import AutoClicker.Model.Clicker.Auto_Clicker;
import AutoClicker.Model.Clicker.Intermediate_Auto_Clicker;

import AutoClicker.Model.CoordinateLocator.coordinateLocator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws AWTException {
        Auto_Clicker test=new Intermediate_Auto_Clicker(2,0,4,0);
        coordinateLocator locator=new coordinateLocator(3129,3398,540,848);
        Auto_Clicker advTest=new Advanced_Auto_Clicker(test,locator);
        advTest.Start();
        //    launch(args);
    }
}
