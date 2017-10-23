package adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

/**
 * Created by Windows10 on 10/16/2017.
 */

public class MessageAdapter extends ArrayAdapter
{
    public MessageAdapter(@NonNull Context context, @LayoutRes int resource)
    {
        super(context, resource);
    }
}
