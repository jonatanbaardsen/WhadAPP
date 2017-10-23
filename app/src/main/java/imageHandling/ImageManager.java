package imageHandling;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import com.example.windows10.app.R;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

/**
 * By idea from Codehenge.
 * See <a href="http://www.codehenge.net/2011/06/android-development-tutorial-asynchronous-lazy-loading-and-caching-of-listview-images/">http://www.codehenge.net</a>
 */

public class ImageManager
{

    // TODO: 10/16/2017 Moved to other class


    private HashMap<String, Bitmap> imageMap = new HashMap<String, Bitmap>();
    private Context context;
    private File cacheDir;

    public ImageManager(Context context)
    {
        this.context = context;
        createOrGetCacheDirectory();
    }

    private void createOrGetCacheDirectory()
    {
        try
        {
            // Find the dir to save cached images
            String sdState = android.os.Environment.getExternalStorageState();

            if (sdState.equals(android.os.Environment.MEDIA_MOUNTED))
            {
                File sdDir = android.os.Environment.getExternalStorageDirectory();
                cacheDir = new File(sdDir, "data/" + context.getString(R.string.app_name));
            }
            else
                cacheDir = context.getCacheDir();
            if (!cacheDir.exists())
            {
                final boolean directoryCreated;
                directoryCreated = cacheDir.mkdirs();

                //Should never end up here
                if (!directoryCreated)
                    throw new SecurityException("Directories not created, unknown cause");


            }
        } catch (Exception e)
        {
            Log.d(context.getString(R.string.imageManager), e.getMessage());
        }
    }

    private void queueImage(String url, ImageView imageView)
    {


    }

    /**
     * By idea from Codehenge.
     * See <a href="http://www.codehenge.net/2011/06/android-development-tutorial-asynchronous-lazy-loading-and-caching-of-listview-images/">http://www.codehenge.net</a>
     */

    private class ImageQueueManager implements Runnable
    {
        private ImageQueue imageQueue = new ImageQueue();

        @Override
        public void run()
        {

            try
            {
                while (true)
                {
                    if (imageQueue.getImageReferences().size() > 1)
                        synchronized (imageQueue.getImageReferences())
                        {
                            imageQueue.getImageReferences().wait();
                        }

                    if (imageQueue.getImageReferences().size() > 0)
                    {
                        ImageReference imageToLoad;
                        synchronized (imageQueue.getImageReferences())
                        {
                            imageToLoad = imageQueue.getImageReferences().pop();
                        }
                        Bitmap bitmap = getBitmap(imageToLoad.getUrl());
                        imageMap.put(imageToLoad.getUrl(), bitmap);
                    }
                    if (Thread.interrupted())
                    {
                        break;
                    }


                }

            } catch (InterruptedException e)
            {
                Log.d(context.getString(R.string.imageManager), e.getMessage());
            }
        }


        private Bitmap getBitmap(String url)
        {

            String filename = String.valueOf(url.hashCode());
            File file = new File(cacheDir, filename);

            Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
            if (bitmap != null)
                return bitmap;

            try
            {
                bitmap = getBitmapFromDB(url);
                writeFile(bitmap, file);
                return bitmap;
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return bitmap;
        }


    }

    private Bitmap getBitmapFromDB(String url)
    {
        try
        {
            // TODO: 10/17/2017 Get bitmap form DB
        } catch (Exception e)
        {

        }


        return null;

    }

    private void writeFile(Bitmap bitmap, File file)
    {
        FileOutputStream out = null;
        try
        {
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 80, out);
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (out != null) out.close();
            } catch (Exception ex)
            {
                Log.d(context.getString(R.string.imageManager),ex.getMessage());
            }
        }
    }


}

