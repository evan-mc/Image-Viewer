package sample;

import javafx.scene.control.Button;

public class PictureChangeClass
{
    private Button changePictureButton;

    PictureChangeClass(String buttonText, ImageClass images, TimeIntervalClass time, char choice)
    {
        changePictureButton = new Button(buttonText);

        if(choice == 'n')
        {
            changePictureButton.setOnAction(value ->
            {
                images.getNextImage('n');
                time.resetSliderTime();
            });

            changePictureButton.setLayoutX(500);
        }
        else if(choice =='p')
        {
            changePictureButton.setOnAction(value ->
            {
                images.getNextImage('p');
                time.resetSliderTime();
            });
        }

        changePictureButton.setLayoutY(500);
    }

    public Button getButton()
    {
        return changePictureButton;
    }
}
