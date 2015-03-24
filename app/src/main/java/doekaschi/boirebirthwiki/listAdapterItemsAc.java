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
 * Created by Lorenz on 18.03.2015.
 */
public class listAdapterItemsAc extends ArrayAdapter<String>{

    int[] times;
    String[] images;

    public listAdapterItemsAc(Context context, String[] resource, int[] time, String[] images_n) {
        super(context, R.layout.items_listview_ac, resource);
        times=time;
        images=images_n;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;

        if(v==null) {
            LayoutInflater vi;
            vi=LayoutInflater.from(getContext());
            v=vi.inflate(R.layout.items_listview_ac, null);
        }

        String p=getItem(position);

        if(p!=null) {
            TextView name=(TextView) v.findViewById(R.id.itemsNameAc);
            TextView time=(TextView) v.findViewById(R.id.itemsRech);
            ImageView icon=(ImageView) v.findViewById(R.id.imageAc);

            if(name!=null) {
                name.setText(p);
            }
            if(time!=null) {
                time.setText("[Recharge: "+times[position]+"]");
            }
            if(icon!=null) {
                //Picasso.with(getContext()).setIndicatorsEnabled(true);
                if(images!=null&&images[position]!=null) {
                    Picasso.with(getContext()).load(images[position]).into(icon);
                }
                else {
                    Picasso.with(getContext()).load("@drawable/transparent");
                }
            }
        }
        return v;
    }

}
