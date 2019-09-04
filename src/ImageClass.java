package sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageClass
{
    private List<String> images;
    private int currentImgIdx;
    private ImageView currentImage;

    public ImageClass(File pathToImgSrc) throws IOException
    {
        images = new ArrayList<>();
        images.add(pathToImgSrc.toURI().toString());
        currentImgIdx = 0;

        currentImage = new ImageView(new Image(images.get(currentImgIdx)));

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

        for (int i = 0, listSize = images.size(); i < listSize; ++i)
        {
            File file = new File(directory.getAbsolutePath() + "/" + images.get(i));
            images.set(i, file.toURI().toString());
        }
        currentImgIdx = 0;

        currentImage.setImage(new Image(images.get(currentImgIdx)));
    }

    public ImageView getNextImage(char nextOrPrevious)
    {
        if (nextOrPrevious == 'n')
        {
            loadNextImage();
        }
        else if(nextOrPrevious == 'p')
        {
            loadPreviousImage();
        }
        return currentImage;
    }

    private void loadNextImage()
    {
        if(currentImgIdx < images.size()-1)
        {
            ++currentImgIdx;
        }
        else
        {
            currentImgIdx = 0;
        }

        currentImage.setImage(new Image(images.get(currentImgIdx)));
    }

    private void loadPreviousImage()
    {
        if(currentImgIdx > 0)
        {
            --currentImgIdx;
        }
        else
        {
            currentImgIdx = images.size()-1;
        }
        currentImage.setImage(new Image(images.get(currentImgIdx)));
    }
}
