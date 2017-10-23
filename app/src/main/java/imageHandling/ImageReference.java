package imageHandling;

import android.widget.ImageView;

/**
 *  By idea from Codehenge.
 * See <a href="http://www.codehenge.net/2011/06/android-development-tutorial-asynchronous-lazy-loading-and-caching-of-listview-images/">http://www.codehenge.net</a>
 */

public class ImageReference
{
    private String url;
    private ImageView imageView;
    public ImageReference(String url, ImageView imageView)
    {
        this.url = url;
        this.imageView = imageView;
    }

    public String getUrl()
    {
        return url;
    }

    public ImageView getImageView()
    {
        return imageView;
    }
}
