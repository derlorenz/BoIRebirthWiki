package doekaschi.boirebirthwiki;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Lorenz on 22.03.2015.
 */
public class imageRetriever extends AsyncTask< intStringContainer,Void, Drawable> {

    @Override
    protected Drawable doInBackground(intStringContainer... var) {
        InputStream is=null;
        URL u= null;

        try {
            u = new URL(var[0].strings[var[0].numbers]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            is=(InputStream) u.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Drawable d=Drawable.createFromStream(is, null);
        return d;
    }

    protected void onPostExecute(Drawable result) {
        returnDrawable(result);
    }

    private Drawable returnDrawable(Drawable d) {
        return d;
    }

}
