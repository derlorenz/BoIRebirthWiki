package doekaschi.boirebirthwiki;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.ImageReader;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Lorenz on 22.03.2015.
 */
public class listAdapterImage extends ArrayAdapter<String>{

    String[] var;

    public listAdapterImage(Context context, String[] images) {
        super(context, R.layout.image_listview, images);
        var=images;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;

        if(v==null) {
            LayoutInflater vi;
            vi=LayoutInflater.from(getContext());
            v=vi.inflate(R.layout.image_listview, null);
        }

        String p=getItem(position);

        if(p!=null) {
                ImageView iv = (ImageView) v.findViewById(R.id.imageTest);
                Picasso.with(getContext()).setIndicatorsEnabled(true);
                if(var!=null&&var[position]!=null) {
                    Picasso.with(getContext()).load(var[position]).into(iv);
                }
                else {
                    Picasso.with(getContext()).load("@drawable/transparent").into(iv);
                }

        }
        return v;
    }
}
