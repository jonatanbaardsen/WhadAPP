package adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

/**
 * Created by Windows10 on 10/16/2017.
 */

public class ChatAdapter extends ArrayAdapter
{
    public ChatAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Object[] objects)
    {
        super(context, resource, objects);
    }
}
