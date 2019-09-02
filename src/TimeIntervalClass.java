package sample;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;


/*

    probably need to reformat this class strructure as well as
    the class name(shouldnt be called buttonclass). do that later
    try making this class inherit from TextField
 */
public class TimeIntervalClass
{
    TimeIntervalClass()
    {
        sliderTime = new TextField();
        sliderTime.setText("5");
        sliderTime.setLayoutX(450);

        timeInMillis = 5000;

        sliderText = new Text("Enter time to switch to next picture");

        sliderTime.setOnAction(value ->
        {
            timeInMillis = changeTime(sliderTime.getText());
        });

        sliderText.setLayoutX(263);
        sliderText.setLayoutY(17);

    }

    public TextField getTextField()
    {
        return sliderTime;
    }

    public Text getText()
    {
        return sliderText;
    }

    public int getSliderTime()
    {
        return timeInMillis;
    }

    private int changeTime(String newTime)
    {
        int returnInt;
        try
        {
            returnInt = Integer.parseInt(newTime) * 1000;
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Couldn't convert " + newTime + " to an int. stopping slideshow.");
            returnInt = 0;
        }

        return returnInt;
    }

        private TextField sliderTime;
        private Text sliderText;
        private int timeInMillis;
}
