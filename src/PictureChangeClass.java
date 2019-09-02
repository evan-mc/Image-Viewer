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

public class PictureChangeClass
{
    PictureChangeClass(String buttonText, ImageClass images, char choice)
    {
        changePictureButton = new Button(buttonText);

        if(choice == 'n')
        {
            changePictureButton.setOnAction(value ->
            {
                images.resetStartTime();
                images.getNextImage('n');
            });

            changePictureButton.setLayoutX(500);
        }
        else if(choice =='p')
        {
            changePictureButton.setOnAction(value ->
            {
                images.resetStartTime();
                images.getNextImage('p');
            });
        }

        changePictureButton.setLayoutY(500);
    }

    public Button getButton()
    {
        return changePictureButton;
    }

    private Button changePictureButton;
}
