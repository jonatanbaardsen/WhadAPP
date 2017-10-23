package adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import model.Chat;
import model.Contact;

/**
 * Created by Windows10 on 10/16/2017.
 */

public class ContactAdapter extends ArrayAdapter
{

    public ContactAdapter(@NonNull Context context, @NonNull ArrayList<Contact> contacts)
    {
        super(context, 0, contacts);
    }
}
