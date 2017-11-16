package adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import model.Chat;

/**
 * Created by Windows10 on 10/16/2017.
 */

public class ChatAdapter extends BaseAdapter
{
    List<Chat> chats = new ArrayList<Chat>();
    public ChatAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Object[] objects)
    {
        super();
        for (Object o: objects)
        {
            chats.add((Chat) o);
        }
    }


    @Override
    public int getCount()
    {
        return chats.size();
    }

    @Override
    public Object getItem(int i)
    {
        return chats.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View gridView = view;


        if(gridView != null)
        return gridView;


        return null;
    }

    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }
}
