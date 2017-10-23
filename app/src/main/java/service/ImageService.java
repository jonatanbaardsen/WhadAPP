package service;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.SparseArray;

import imageHandling.*;

/**
 * Created by Windows10 on 10/16/2017.
 */

public class ImageService extends Service
{
    private Context context;
    private ImageManager imageManager;
    private SparseArray<Uri> imageUriArray;

    public ImageService(Context context)
    {
        imageManager = new ImageManager(context);
        imageUriArray = new SparseArray<Uri>();
    }

    public Context getContext()
    {
        return context;
    }

    public void setContext(Context context)
    {
        this.context = context;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
