package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import java.io.File;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ImageClass images = new ImageClass(new File("img/defaultimg.png"));
        TimeIntervalClass sliderTime = new TimeIntervalClass();
        PictureChangeClass nextPictureButton = new PictureChangeClass("Next Picture",images, sliderTime, 'n');
        PictureChangeClass previousPictureButton = new PictureChangeClass("Previous Picture", images, sliderTime, 'p');
        DirectoryButtonClass directory = new DirectoryButtonClass("Select Directory", images, primaryStage);

        primaryStage.setTitle("Image Viewer");

        Group testGroup = new Group(images.getNextImage('n'));

        testGroup.getChildren().add(sliderTime.getTextField());
        testGroup.getChildren().add(sliderTime.getText());
        testGroup.getChildren().add(nextPictureButton.getButton());
        testGroup.getChildren().add(previousPictureButton.getButton());
        testGroup.getChildren().add(directory.getDirectoryButton());

        Scene buttonScene = new Scene(testGroup, 600, 600);
        primaryStage.setScene(buttonScene);

        //Displaying the contents of the stage
        primaryStage.show();

        new AnimationTimer()
        {
            @Override
            public void handle(long now) {
                long elapsedMillis = System.currentTimeMillis() - sliderTime.getTimeInMillis();
                long timeLimit = sliderTime.getTimeLimit();
                if(elapsedMillis > timeLimit && timeLimit > 0)
                {
                    images.getNextImage('n');
                    sliderTime.resetSliderTime();
                }
            }
        }.start();
    }


    public static void main(String[] args)
    {
        launch(args);
    }

}

