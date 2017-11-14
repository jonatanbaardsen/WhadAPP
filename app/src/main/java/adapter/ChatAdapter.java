package adapter;

import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.windows10.app.R;

import java.util.ArrayList;
import java.util.List;

import activity.MainActivity;
import model.Chat;

/**
 * Created by Windows10 on 10/16/2017.
 */

public class ChatAdapter extends BaseAdapter
{
    private final Context context;
    private List<Chat> chats;
    private LayoutInflater inflater;

    public ChatAdapter(Activity context, ArrayList<Chat> chats)
    {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.chats = chats;
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
        return (long) i;
    }

    /*
    * General structure and logic in this method is from <a href="https://www.caveofprogramming.com/guest-posts/custom-gridview-with-imageview-and-textview-in-android.html">https://www.caveofprogramming.com/</a>
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        Holder holder = new Holder();
        View gridView = view;
        if(gridView == null)
        {
         gridView = inflater.inflate(R.layout.grid_chat, viewGroup);
         holder.chatImage = (ImageView) gridView.findViewById(R.id.image_chat);
         holder.chatTitle = (TextView) gridView.findViewById(R.id.text_chat_title);

         holder.chatTitle.setText(chats.get(i).getChatId());
         gridView.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View view)
             {
                 Toast.makeText(context, "You Clicked "+ view.getId(), Toast.LENGTH_LONG).show();
             }
         });
        }

        return gridView;
    }

    public class Holder
    {
        TextView chatTitle;
        ImageView chatImage;
    }
}
