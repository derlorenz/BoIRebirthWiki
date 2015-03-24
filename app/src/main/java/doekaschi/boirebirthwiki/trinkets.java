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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class trinkets extends ActionBarActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trinkets);
        setTitle("Trinkets");
        int currentApi= Build.VERSION.SDK_INT;
        if(currentApi>=21) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_background));
        }
        ListView lv=(ListView) findViewById(R.id.listTrinkets);
        final String[] trinkets=new String[] {
                "???'s Soul",
                "AAA Battery",
                "Ace of Spades",
                "Bible Tract",
                "Black Lipstick",
                "Bloody Penny",
                "Broken Ankh",
                "Broken Magnet",
                "Broken Remote",
                "Burnt Penny",
                "Butt Penny",
                "Cain's Eye",
                "Callus",
                "Cancer (Trinket)",
                "Cartridge",
                "Child's Heart",
                "Counterfeit Penny",
                "Cursed Skull",
                "Curved Horn",
                "Daemon's Tail",
                "Eve's Bird Foot",
                "Fish Head",
                "Flat Penny",
                "Flat Worm",
                "Goat Hoof",
                "Hook Worm",
                "Isaac's Fork",
                "Isaac's Head",
                "Judas' Tongue",
                "The Left Hand",
                "Liberty Cap",
                "Lucky Toe",
                "Lucky Rock",
                "Maggy's Faith",
                "Match Stick",
                "A Missing Page",
                "Missing Poster",
                "Mom's Pearl",
                "Mom's Toenail",
                "Monkey Paw",
                "Mysterious Paper",
                "Petrified Poop",
                "Paper Clip",
                "Pinky Eye",
                "Purple Heart",
                "Push Pin",
                "Pulse Worm",
                "Red Patch",
                "Ring Worm",
                "Rosary Bead",
                "Rusted Key",
                "Safety Cap",
                "Samson's Lock",
                "Store Credit",
                "Swallowed Penny",
                "The Tick",
                "Umbilical Cord",
                "Wiggle Worm",
                "Whip Worm"
        };

        final String[] effects=new String[] {
                "Spawns a familiar that floats slowly around the room on a pattern similar to The Peeper and fires spectral and homing tears.",
                "Automatically recharges the last energy slot of an activated item, effectively reducing recharge rates by one.",
                "Increases the chance of tarot cards or playing cards dropping after clearing a room, and the chance of finding cards when opening a chest.",
                "Increases chance for Eternal Hearts to spawn.",
                "Increases the chance of Black Hearts appearing.",
                "Gives a 50% chance to drop a half heart when money is collected.",
                "When held, Isaac has a chance to be revived as ???. Can occur multiple times in the same run.",
                "Pulls coins towards Isaac, but ignores other pickups.",
                "Triggers the Teleport effect whenever an activated item is used.",
                "Gives a 50% chance to drop a bomb when money is collected.",
                "Isaac will fart when he picks up a coin.",
                "When starting a floor, 25% chance to get the The Compass effect for the duration of a floor.",
                "Prevents damage from creep and spikes.",
                "-2 Tear Delay (effectively increases firerate of tears)",
                "Chance to trigger The Gamekid effect upon taking damage.",
                "Increases the chance of a Heart dropping after clearing a room, and the chance of finding a Heart when opening a Chest.",
                "Gives a 50% chance of increasing the value of every coin pickup by one.",
                "If Isaac has less than one full red heart after taking damage, he will be immediately teleported to the last cleared room he was in.",
                "Increases damage by 2.",
                "Grants a huge chance of any non-specific Heart drop turning into a Black Heart.",
                "5% chance to spawn a Dead Bird familiar for the current room each time an enemy dies.",
                "Spawns a Blue Fly every time Isaac takes damage.",
                "Gives a 50% chance of spawning a key upon collecting a penny.",
                "Isaac's tears take on an oblong appearance. They also push enemies back.",
                "Increases speed by 0.15.",
                "Tears move shifting left to right forming a path of right angles. +10 to Range (effective range remains about the same).",
                "A chance to heal Isaac for 1/2 a red heart upon clearing a room.",
                "Gives the player Isaac's severed head as a tear-firing familiar. Fires piercing tears.",
                "Items in the Devil Room only cost 1 heart. Soul heart trades still cost 3 Soul hearts.",
                "Replaces Brown Chests and Golden Chests with Red Chests.",
                "Grants a chance of triggering Mini Mush, Odd Mushroom (Large), Odd Mushroom (Thin) or The Compass effects for the current room upon entering it.",
                "Increases Luck by 1.",
                "Each obstacle destroyed drops one coin.",
                "Gives an eternal heart at the start of every floor.",
                "Increases the chance of Bombs dropping after clearing a room, and the chance of finding Bombs when opening a Chest.",
                "5% chance to induce The Necronomicon's effect upon taking damage.",
                "If Isaac dies in a Sacrifice Room, a puzzle piece will appear on his last will.",
                "Grants a secondary 10% chance of any non-specific Heart drop turning into a Soul Heart.",
                "Mom's foot randomly stomps down somewhere in the room. 1 minute intervals.",
                "If the character has half a red heart or no red hearts after taking damage, it grants a Black Heart. The effect can trigger up to three times, after which the trinket will disappear.",
                "Isaac farts or poops at random intervals. Getting hit can also trigger the effect.",
                "Chance to trigger the effect of The Polaroid or The Negative every time damage is taken if the character has only half a red heart or no red hearts.",
                "Greatly increases the chances of a pickup dropping when destroying poop.",
                "Golden Chests can be opened without using a key.",
                "Adds a 10% chance to shoot a poison tear, dealing damage over time when inflicted.",
                "Shots pulse in size.",
                "Increases chance for challenge rooms to be boss challenge rooms / Causes more enemy champions to spawn.",
                "Adds a 10% chance to shoot a piercing and spectral tear.",
                "Shots pulse in size.",
                "Grants a chance of increasing damage by 1.8 for the current room upon taking damage.",
                "Gives Isaac spinning shots.",
                "\"Faith up\". Increases the chance of Angel Rooms and Eternal Hearts appearing.",
                "Improves the chance of keys and golden chests dropping after clearing a room, and chance of finding a key when opening a chest.",
                "Improves the chance of Pills dropping after clearing a room, and chance of finding a Pill when opening a Chest.",
                "1/15 chance to increase damage by 0.5 for the current room each time an enemy dies.",
                "The next store purchase is free. The trinket disappears on purchase.",
                "Upon taking damage, Isaac drops a penny.",
                "Drain 15% health of each enemy with more than 60 HP (ie. most bosses). Also restores one red heart of Isaac whenever he enters an uncleared boss room. The Tick cannot be swapped out for another trinket.",
                "When Isaac's health is brought to half a red heart and no soul hearts, a Little Steven familiar spawns for the current room.",
                "Gives Isaac's shots a wave-like trajectory.",
                "Increases shot speed by 1 and increases range."
        };

        ArrayAdapter<String> aa=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, trinkets);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(trinkets.this);
                builder.setTitle(trinkets[position]);
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
        getMenuInflater().inflate(R.menu.menu_trinkets, menu);
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
