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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
    THINGS TO ADD:
        - DONE: change the ImageClass to store the filepath instead of storing the images so it saves on memory
        - DONE: automatically set to next picture after a certain time.
        - DONE: set time limit before changing to next picture.
        - DONE: change directory in app to display all pictures in that directory.
        - add animation to simulate swiping to next picture.
        - clean up code(last)
        - Add(create in photoshop) a default image that tells the user to choose a directory to start viewing
 */


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ImageClass images = new ImageClass("C:\\Users\\Evan\\Desktop\\images.txt");
        PictureChangeClass nextPictureButton = new PictureChangeClass("Next Picture",images, 'n');
        PictureChangeClass previousPictureButton = new PictureChangeClass("Previous Picture", images, 'p');

        TimeIntervalClass sliderTime = new TimeIntervalClass();

        //Setting title to the Stage
        primaryStage.setTitle("Loading an image");

        DirectoryChooser imgDirectory = new DirectoryChooser();
        Button directButton = new Button("Select Directory");

        Group testGroup = new Group(images.getNextImage('n'));

        testGroup.getChildren().add(sliderTime.getTextField());
        testGroup.getChildren().add(sliderTime.getText());
        testGroup.getChildren().add(nextPictureButton.getButton());
        testGroup.getChildren().add(previousPictureButton.getButton());

        directButton.setOnAction(value ->
        {
            File directory = imgDirectory.showDialog(primaryStage);
            try
            {
                //returns null if the DirectoryChooser was cancelled
                if(directory != null)
                {
                    images.changeImageDirectory(directory);
                }
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
                int timeInMillis = sliderTime.getSliderTime();
                if(elapsedMillis > timeInMillis && timeInMillis > 0)
                {
                    images.getNextImage('n');
                    images.resetStartTime();
                }
            }
        }.start();
    }


    public static void main(String[] args) {
        launch(args);
    }

}

