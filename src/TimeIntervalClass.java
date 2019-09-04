package sample;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TimeIntervalClass
{
    private TextField sliderTime;
    private Text sliderText;
    private long timeInMillis;
    private long timeLimit;

    TimeIntervalClass()
    {
        sliderTime = new TextField();
        sliderTime.setText("5");
        sliderTime.setLayoutX(450);

        timeLimit = 5000;
        timeInMillis = System.currentTimeMillis();
        sliderText = new Text("Enter time to switch to next picture");

        sliderTime.setOnAction(value ->
        {
            timeLimit = changeTime(sliderTime.getText());
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

    public long getTimeInMillis()
    {
        return timeInMillis;
    }

    public long getTimeLimit()
    {
        return timeLimit;
    }

    public void resetSliderTime()
    {
        timeInMillis = System.currentTimeMillis();
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
}
