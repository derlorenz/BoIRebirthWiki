package doekaschi.boirebirthwiki;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ProgressDialog;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import java.net.URL;


public class search extends ActionBarActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater=getMenuInflater();
        //inflater.inflate(R.menu.menu_search, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void search(View view) {
        WebView wv=(WebView) findViewById(R.id.webViewSearch);
        EditText et=(EditText) findViewById(R.id.editTextSearch);
        String searchContent=et.getText().toString();

        if(searchContent!=null) {
            for(int i=0; i<searchContent.length(); i++) {
                if(searchContent.charAt(i)==' ') {
                    searchContent=searchContent.substring(0, i-1)+"+"+searchContent.substring(i+1);
                }
            }
            //Toast.makeText(getApplicationContext(), searchContent, Toast.LENGTH_SHORT).show();
            final ProgressDialog dialog = new ProgressDialog(search.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Loading. Please wait...");
            dialog.setIndeterminate(true);
            dialog.setCanceledOnTouchOutside(false);
            wv.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView view, String url) {
                    Toast.makeText(getApplicationContext(), "finished", Toast.LENGTH_SHORT);
                    dialog.cancel();
                }
            });
            dialog.show();
            wv.loadUrl("http://bindingofisaacrebirth.gamepedia.com/index.php?title=Special%3ASearch&profile=default&search="
                    +searchContent+"&fulltext=Search");

        }
    }
}
