package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.stage.DirectoryChooser;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
    THINGS TO ADD:
        - DONE: change the ImageClass to store the filepath instead of storing the images so it saves on memory
        - DONE: automatically set to next picture after a certain time.
        - set time limit before changing to next picture.
        - DONE: change directory in app to display all pictures in that directory.
        - add animation to simulate swiping to next picture.
        - clean up code(last)
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ImageClass images = new ImageClass("C:\\Users\\Evan\\Desktop\\images.txt");

        //Setting title to the Stage
        primaryStage.setTitle("Loading an image");

        //change pic button
        Button button = new Button("Change picture");
        button.setLayoutY(500);
        button.setOnAction(value ->
                images.showImage());

        DirectoryChooser imgDirectory = new DirectoryChooser();
        Button directButton = new Button("Select Directory");

        Group testGroup = new Group(images.showImage(), button);

        directButton.setOnAction(value ->
        {
            File directory = imgDirectory.showDialog(primaryStage);
            try
            {
                images.changeImageDirectory(directory);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });

        testGroup.getChildren().add(directButton);

        Scene buttonScene = new Scene(testGroup, 600, 600);
        primaryStage.setScene(buttonScene);

        //Displaying the contents of the stage
        primaryStage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                long elapsedMillis = System.currentTimeMillis() - images.getStartTime() ;
                if(elapsedMillis > 5000)
                {
                    images.showImage();
                    images.resetStartTime();
                }
            }
        }.start();
        System.out.println("you");
    }


    public static void main(String[] args) {
        launch(args);
    }

}

