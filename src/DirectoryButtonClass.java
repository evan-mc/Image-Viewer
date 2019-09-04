package sample;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.DirectoryChooser;
import java.io.File;
import java.io.IOException;

public class DirectoryButtonClass
{
    private DirectoryChooser directory;
    private Button directoryButton;

    public DirectoryButtonClass(String buttonText, ImageClass images, Stage primaryStage)
    {
        directory = new DirectoryChooser();
        directoryButton = new Button(buttonText);

        directoryButton.setOnAction(value ->
        {
            File directoryFile = directory.showDialog(primaryStage);
            try
            {
                //returns null if the DirectoryChooser was cancelled
                if(directoryFile != null)
                {
                    images.changeImageDirectory(directoryFile);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });
    }

    public Button getDirectoryButton()
    {
        return directoryButton;
    }
}
