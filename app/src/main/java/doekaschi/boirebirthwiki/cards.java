package doekaschi.boirebirthwiki;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.*;

import static android.app.PendingIntent.getActivity;


public class cards extends ActionBarActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        setTitle("Cards");
        int currentApi= Build.VERSION.SDK_INT;
        if(currentApi>=21) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_background));
        }
        final ListView lv=(ListView) findViewById(R.id.listCards);
        final String cards[]=new String[]{"0 - The Fool", "I - The Magician", "II - The High Priestess", "III - The Empress",
                "IV - The Emperor", "V - The Hierophant", "VI - The Lovers", "VII - The Chariot", "VIII - Justice",
                "IX - The Hermit", "X - Wheel of Fortune", "XI - Strength", "XII - The Hanged Man", "XIII - Death",
                "XIV - Temperance", "XV - The Devil", "XVI - The Tower", "XVII - The Stars", "XVIII - The Moon",
                "XIX - The Sun", "XX - Judgement", "XXI - The World"};
        final String effects[]=new String[]
                {"Teleports you back to the starting room of a floor.",
                "Grants homing tears for the current room.",
                "Mom's dismembered leg is called down to deal massive damage to anything it stomps. It will always stomp on the enemy with the most health. If used in an empty room or during the fight with Mom, it will stomp Isaac instead.",
                "Triggers the Whore Of Babylon effect.",
                "Teleports you into the Boss Room of a floor.",
                "Spawns 2 Soul Hearts.",
                "Drops 2 full red hearts. If used in a Black Heart or Eternal Heart-containing Super Secret Room, it will spawn those types of hearts instead.",
                "Grants the temporary invulnerability effect of My Little Unicorn.",
                "Spawns one of each consumable drop (a heart, a key, a bomb, and a coin).",
                "Teleports you to the shop. If there is no shop, this will act as a random teleport. If the shop has not yet been accessed, this card will unlock the door without requiring a key (as long as the player exits through the main entrance).",
                "Spawns an arcade machine (Slot Machine or Fortune Teller).",
                "Upon use, increases all of Isaac's stats except tears and adds one (temporary) heart container for the current room. If Isaac has 12 heart containers, one will be lost upon exiting a room.",
                "Removes Isaac's body, allowing him to fly around similar to Transcendence.",
                "Does significant damage to all enemies in the room (damage deal: 40).",
                "Spawns a Blood Donation Machine.",
                "Increases your damage by 2 until you leave the room (same effect as the Book of Belial).",
                "Spawns 6 troll bombs randomly around the room.",
                "Teleports the player to the Treasure Room. If there is no Treasure Room, this will act as a random teleport. Randomly chooses a Treasure Room on Curse of the Labyrinth. If the Treasure Room has not yet been accessed, this card will unlock the door without requiring a key (as long as the player exits through the main entrance).",
                "Teleports the player to the Secret Room. This card will open one random wall once inside the Secret Room, so you can leave even if you don't have any bombs available.",
                "Restores full health, damages any enemies in the room, and reveals the map for the current floor, except the Super Secret Room.",
                "Spawns a Beggar.",
                "Reveals the entire floor, except for the Super Secret Room. Has no effect if under the effect of Curse of the Lost or Amnesia."};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cards);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(getApplicationContext(), "Item "+position+", "+lv.getItemAtPosition(position),
                        Toast.LENGTH_SHORT).show();*/
                AlertDialog.Builder builder=new AlertDialog.Builder(cards.this);
                builder.setTitle(cards[position]);
                builder.setMessage(effects[position]);
                builder.setCancelable(true);
                builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert=builder.create();
                alert.show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cards, menu);
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

    public void startSettings() {
        Intent i=new Intent(this, settings.class);
        startActivity(i);
    }
}
