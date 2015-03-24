package doekaschi.boirebirthwiki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Lorenz on 22.03.2015.
 */
public class listAdapterItemsPassive extends ArrayAdapter<String>{

    String[] images;

    public listAdapterItemsPassive(Context context, String[] resource, String[] images_n) {
        super(context, R.layout.items_listview_passive, resource);
        images=images_n;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;

        if(v==null) {
            LayoutInflater vi;
            vi=LayoutInflater.from(getContext());
            v=vi.inflate(R.layout.items_listview_passive, null);
        }

        String p=getItem(position);

        if(p!=null) {
            TextView name=(TextView) v.findViewById(R.id.itemsNamePassive);
            ImageView icon=(ImageView) v.findViewById(R.id.imagePassiveItems);

            if(name!=null) {
                name.setText(p);
            }
            if(icon!=null) {
                if(images!=null&&images[position]!=null) {
                    //Picasso.with(getContext()).setIndicatorsEnabled(true);
                    Picasso.with(getContext()).load(images[position]).into(icon);
                }
                else {
                    Picasso.with(getContext()).load("@drawable/transparent").into(icon);
                }
            }
        }
        return v;
    }
}
