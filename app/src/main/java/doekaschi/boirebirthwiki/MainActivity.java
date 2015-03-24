package doekaschi.boirebirthwiki;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        setTitle("BoI Rebirth Wiki");

        int currentApi= Build.VERSION.SDK_INT;
        if(currentApi>=21) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_background));
        }
        //ActionBar ab=getActionBar();
        //ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFC400")));

        //SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        //TextView tx=(TextView) findViewById(R.id.textSettings);
        //tx.setText(Boolean.toString(sp.getBoolean("pref_img_key", true)));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startSettings();
        }

        return super.onOptionsItemSelected(item);
    }

    public void openCards(View view) {
        Intent i=new Intent(this, cards.class);
        startActivity(i);
    }

    public void openItems(View view) {
        Intent i=new Intent(this, items.class);
        startActivity(i);
    }

    public void openTrinkets(View view) {
        Intent i=new Intent(this, trinkets.class);
        startActivity(i);
    }

    public void openTest(View view) {
        Intent i=new Intent(this, test.class);
        startActivity(i);
    }

    public void openSearch(View view) {
        Intent i=new Intent(this, search.class);
        startActivity(i);
    }

    public void startSettings() {
        Intent i=new Intent(this, settings.class);
        startActivity(i);
    }
}
