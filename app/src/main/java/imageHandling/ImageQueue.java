package imageHandling;

import android.widget.ImageView;

import java.util.Stack;

/**
 *  By idea from Codehenge.
 * See <a href="http://www.codehenge.net/2011/06/android-development-tutorial-asynchronous-lazy-loading-and-caching-of-listview-images/">http://www.codehenge.net</a>
 */

public class ImageQueue
{
    private Stack<ImageReference> imageReferences = new Stack<>();

    //If a reference to the ImageView (see @link ImageView) already exists, remove it
    public void Clean(ImageView imageView)
    {
        for (int i = 0; i < imageReferences.size(); i++)
        {
            if(imageReferences.get(i).getImageView() == imageView)
                imageReferences.remove(i);
        }
    }

    public Stack<ImageReference> getImageReferences()
    {
        return imageReferences;
    }

}
