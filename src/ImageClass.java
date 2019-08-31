package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.Arrays;

public class ImageClass
{
    public ImageClass(String PathToImgSrc) throws IOException
    {
        images = new ArrayList<>();
        i = 0;
        startTime = System.currentTimeMillis();

        Scanner scan = new Scanner(new File(PathToImgSrc));
        while(scan.hasNextLine())
        {
            File file = new File(scan.nextLine());

            //checks to make sure that the current file is an image.
            if(Files.probeContentType(file.toPath()).substring(0, 5).equals("image"))
            {
                System.out.println(file.toURI().toString());
                images.add(file.toURI().toString());
            }

        }

        currentImage = new ImageView(new Image(images.get(i)));

        //positions and re-sizes the images to fit properly.
        currentImage.setFitHeight(450);
        currentImage.setFitWidth(450);
        currentImage.setX(75);
        currentImage.setY(50);
        currentImage.setPreserveRatio(true);
    }

    public void changeImageDirectory(File directory) throws IOException
    {
        images = new ArrayList<>(Arrays.asList(directory.list()));
        for(int i = 0, listSize = images.size(); i < listSize; ++i)
        {
            File file = new File(directory.getAbsolutePath() + "/" + images.get(i));
            images.set(i, file.toURI().toString());
        }

        i = 0;
        startTime = System.currentTimeMillis();

        currentImage.setImage(new Image(images.get(i)));

    }

    public ImageView showImage()
    {
        changeImage();
        return currentImage;
    }

    public long getStartTime()
    {
        return startTime;
    }

    public void resetStartTime()
    {
        startTime = System.currentTimeMillis();
    }

    private void changeImage()
    {
        //updates the idx of the list containing all the images.
        ++i;
        if(i == images.size())
        {
            i = 0;
        }

        currentImage.setImage(new Image(images.get(i)));
    }

    private List<String> images;
    private int i;
    private ImageView currentImage;

    private long startTime;
}
