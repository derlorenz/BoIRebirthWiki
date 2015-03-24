package doekaschi.boirebirthwiki;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class activatedItems extends ActionBarActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activated_items);
        setTitle("Activated Collectibles");
        int currentApi= Build.VERSION.SDK_INT;
        if(currentApi>=21) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_background));
        }
        ListView lv=(ListView) findViewById(R.id.listAcitems);
        final String[] items=new String[] {
                "Anarchist Cookbook",
                "The Bean",
                "Best Friend",
                "The Bible",
                "Blank Card",
                "Blood Rights",
                "Bob's Rotten Head",
                "The Book Of Belial",
                "Book Of Revelations",
                "Book Of Secrets",
                "Book Of Shadows",
                "The Book Of Sin",
                "The Boomerang",
                "Box Of Spiders",
                "Breath Of Life",
                "Butter Bean",
                "The Candle",
                "Converter",
                "Crack The Sky",
                "Crystal Ball",
                "D4",
                "The D6",
                "D10",
                "D20",
                "D100",
                "Dad's Key",
                "Dead Sea Scrolls",
                "Deck Of Cards",
                "Doctor's Remote",
                "Flush!",
                "Forget Me Now",
                "The Gamekid",
                "Guppy's Head",
                "Guppy's Paw",
                "Head Of Krampus",
                "How To Jump",
                "The Hourglass",
                "Isaac's Tears",
                "IV Bag",
                "The Jar",
                "Kamikaze!",
                "Lemon Mishap",
                "Magic Fingers",
                "Mom's Bottle Of Pills",
                "Mom's Bra",
                "Mom's Pad",
                "Monster Manual",
                "Monstro's Tooth",
                "Mr. Boom",
                "My Little Unicorn",
                "The Nail",
                "The Necronomicon",
                "Notched Axe",
                "Pandora's Box",
                "The Pinking Shears",
                "The Pony",
                "The Poop",
                "Portable Slot",
                "Prayer Card",
                "Razor Blade",
                "Red Candle",
                "Remote Detonator",
                "Satanic Bible",
                "Scissors",
                "Shoop Da Whoop!",
                "Spider Butt",
                "Tammy's Head",
                "Telepathy For Dummies",
                "Teleport",
                "Undefined",
                "Unicorn Stump",
                "We Need To Go Deeper!",
                "White Pony",
                "Yum Heart"
        };

        final int[] rechTimes=new int[] {3, 1, 3, 6, 4, 0, 3, 3, 6, 6, 3, 4, 0, 2, 0, 0, 0, 0, 4, 6, 6, 6, 1, 6, 6, 2, 2, 6,
            3, 6, 0, 6, 1, 0, 6, 0, 2, 6, 0, 0, 0, 2, 0, 6, 3, 3, 3, 3, 2, 6, 6, 6, 3, 0, 6, 6, 1, 0, 6, 0, 0, 0, 6 ,6,
            2, 2, 1, 2, 2, 6, 1, 6, 6, 4};

        final String[] effects=new String[] {
                "Spawns six troll bombs around the room.",
                "Isaac releases bad gas, poisoning any enemy in close vicinity.",
                "Deploys a decoy Isaac that eventually explodes with an increased blast radius.",
                "Upon activation, Isaac gains Flight, allowing him to pass over all obstacles in the current room. Instantly kills Mom, Mom's Heart, and It Lives when activated, but will kill Isaac when activated while fighting Satan, Isaac, or ??? unless he has The Wafer.",
                "Has the same effect as the card or rune currently held by Isaac.",
                "Damages all enemies in the room, but deals a half-heart of damage to Isaac with each use.",
                "Upon use, Isaac holds a poison bomb which can be thrown towards any of the four cardinal points and explodes on impact.",
                "Guarantees a Devil Room or Angel Room will be open after beating a boss while holding it. Upon use increases damage by 2 for the current room and by a further +50% if the character also has the Blood Of The Martyr.",
                "Adds 1 Soul Heart and makes the next boss a Horseman (except on XL floors and floors with fixed bosses such as Mom).",
                "Upon being activated for the first time on a given floor, grants the effect of the Treasure Map. Upon being activated for the second time, grants the effects of The Compass. Upon the third activation, grants the effects of the Blue Map. All effects wear off upon moving to the next floor.",
                "Upon use, creates a protective shield nullifying all types of damage for a short duration.",
                "Spawns a random Pick Up, Pill, Card, or Trinket.",
                "Throws a short-range boomerang which does a bit of damage and has a high chance to stun the enemy for 2 seconds. Can also be used to grab pickups.",
                "Summons 2-4 Blue Spiders.",
                "Grants a brief moment of invincibility when the charge bar hits zero. If spacebar is held for an additional second after hitting zero, Isaac will take damage.",
                "Isaac farts and pushes back nearby enemies.",
                "Throws out a blue flame that can pass over gaps (but not through rocks). The flame damages anything in its path.",
                "When used, converts two soul hearts into a heart container.",
                "Summons multiple beams of light in random locations around the room, dealing a large amount of damage to any enemy that touches them.",
                "Reveals the map (except the Super Secret Room) and drops a random Tarot Card or Soul Heart.",
                "Rerolls all upgrades on the player. (Does not reroll Azazel's brimstone).",
                "Allows Isaac to re-roll collectible items in the current room into other items, depending on the current room's Item Pool.",
                "Rerolls the enemies in a room. Only rerolls enemies that are still alive (does not spawn new enemies).",
                "Rerolls all pickups in the current room.",
                "Upon use, rerolls all passive items on Isaac like the D4, every pedestal item on the room like the D6 and every pickup like the D20.",
                "Opens all doors in the current room when activated, including doors which require a Key to open and entrances to secret rooms. Opens the big doors in the first room of both The Chest and The Dark Room.",
                "Triggers the effect of a random activated item from a list of possible options (not every activated item is included).",
                "Gives Isaac a random Tarot Card.",
                "Sets a big red target on the ground (similar to the Epic Fetus item) which can be controlled with tear controls. After 6 seconds or by pressing space again, a huge explosive missile hits it, which damages all enemies caught in its blast radius.",
                "Changes all enemies in the room into poop. Does not work on all enemies (Knights and bosses are immune).",
                "When activated, the level ends and is freshly regenerated with new rooms, monsters, and items. Disappears after use.",
                "Upon use, turns the character into a into a Pac-Man-like creature for 5 seconds, granting invulnerability and increased speed, inflicting fear on all enemies, and replenishing half a red heart container for every two enemies killed.",
                "Spawns 2-4 Blue Flies to damage enemies.",
                "Removes one Heart Container in exchange for gaining 3 Soul Hearts.",
                "Fires a cross-patterned brimstone shot, just like the Fallen and Krampus shoot.",
                "Gives Isaac the ability to jump (over gaps, spikes, etc.).",
                "Upon activation, enemies and their projectiles are slowed down for a short duration.",
                "Shoots 8 tears around Isaac, which retain the damage, shot speed, and special effects of his tears. Each tear shot by Isaac increases item charge by one.",
                "Upon activation, Isaac loses a half-heart (one whole heart in The Womb onwards) for a random amount of coins, similar to the Blood Donation Machine.",
                "When at full health, up to 4 extra hearts can be stored in the jar.",
                "Creates an explosion in the same area as Isaac, dealing half a heart of damage to him and also damaging all enemies caught in the blast radius.",
                "Creates a small yellow pool of Creep, which damages enemies that cross it.",
                "For 1 Coin, damages all enemies in the room.",
                "Gives Isaac a random Pill, and will cause him to drop any held Q-slot item (If any). The player will only receive six different pill types in one playthrough.",
                "Upon use petrifies all enemies in the current room for approximately 4 seconds.",
                "Upon use inflicts fear to all enemies in the room for 5 seconds.",
                "Summons a random familiar for the current room. Can summon familiars not yet unlocked.",
                "Monstro jumps onto a random enemy, doing area damage. Can damage/kill the player if summoned in an room without enemies.",
                "Drops a large bomb.",
                "Upon use, grants invulnerability and increased speed for five seconds, removing the ability to shoot tears and instead dealing contact damage to enemies.",
                "Adds one Soul Heart and allows the breaking of Rocks and damaging enemies by simply walking over them. Increases Damage and decreases Speed. All effects except for the Soul Heart wear off upon leaving the room.",
                "Damages all enemies in the room significantly.",
                "Isaac holds the axe above his head for as long as the spacebar button is held (or until he leaves the room). While holding the axe, Isaac can break any rock he touches, but cannot attack or pick up other items.",
                "Upon use, spawns certain Pickups or Items depending on the floor it is used on. Single-use.",
                "Separates Isaac's head and body for the current room. Isaac's head, which now has flight, will be under the player's control, while his body will seek out enemies to attack by contact damage.",
                "Passively grants flight and increased speed. Upon use, Isaac charges in the direction the pony is facing, becoming invulnerable during the charge and damaging enemies.",
                "Spawns a pile of poop where the character is standing and knocks nearby monsters back. May yield pickups like regular poop.",
                "Upon activation, 1 coin will be consumed, and a random Pick Up may drop, similar to the Slot Machine.",
                "Grants an Eternal Heart per use.",
                "Upon use deals one heart damage and grants +1.2 damage for the current room.",
                "Throws a persistent flame that deals high damage and diminishes as it damages enemies or blocks shots.",
                "Bombs you place explode only when you use this item. Gives 5 bombs.",
                "Upon activation, Isaac gains a black heart.",
                "Upon use, turns Isaac's head into a stationary familiar which fire the same tears as the headless body for the current room.",
                "Fires a laser from Isaac's mouth.",
                "Damages all enemies in the room and slows them and their projectiles down.",
                "Shoots 10 tears in a circle around Isaac, which retain the damage, shot speed, and special effects (such as Poison) of Isaac's tears.",
                "Upon activation, grants homing tears for the current room.",
                "Teleports you to a random room on the level.",
                "Teleports Isaac to either the Secret Room, Super Secret Room, Treasure Room, or I AM ERROR.",
                "Upon use, grants invulnerability and increased speed for five seconds, but removes the ability to shoot tears.",
                "Creates a trapdoor to go to the next floor. If used in The Womb, it will create a trapdoor to Sheol, even if the player hasn't unlocked it.",
                "Passively grants flight and increased speed. Upon use, Isaac charges in the direction the pony is facing, becoming invulnerable during the charge and damaging enemies while also casting the effect of Crack The Sky.",
                "Restores 1 whole Red heart."

        };

        String[] images= new String[] {
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/6/68/Anarchist_Cookbook_Icon.png?version=95a493fd12ad2afee74202f9b212f449",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/b/b2/The_Bean_Icon.png?version=652549daaf1e81034e6384a0b901f830",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/4/41/Best_Friend_Icon.png?version=f698ddb09af8c3eb6390cfda029eb5ca",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/4/4c/The_Bible_Icon.png?version=4e3aafe2ec727cef3354766559358273",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/8/82/Blank_Card_Icon.png?version=d720c11f20763b3cc6af44f49df7aeac",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/9/9d/Blood_Rights_Icon.png?version=2114cecf1534d87caf9739ccc9a9b5da",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/a/ad/Bob%27s_Rotten_Head_Icon.png?version=5ab31b847ea4e9b784a7ba0b49199418",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/0/07/The_Book_Of_Belial_Icon.png?version=577526b832809856011cca5e17e3f076",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/8/88/Book_Of_Revelations_Icon.png?version=8e5d4273b0babaa7d8c0dca0189b7474",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/8/88/Book_Of_Secrets_Icon.png?version=462eecc136b400f872ebf331f7aa72db",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/c/c8/Book_Of_Shadows_Icon.png?version=de4bbfcd030811f0c129783d3a4adaa1",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/7/79/The_Book_Of_Sin_Icon.png?version=74e2abe0310728cd95bf0c1aef11ab46",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/a/a5/The_Boomerang_Icon.png?version=fe8365f7970c254b452af2f3b5b72c15",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/c/c1/Box_Of_Spiders_Icon.png?version=cd2e1ddc8a2565c90c72c3a09f530456",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/7/77/Breath_Of_Life_Icon.png?version=6f7e1f09062638c76bb748b85edd6d80",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/7/70/Butter_Bean_Icon.png?version=136eae2b65ed39eff70a8973f090d80e",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/9/9a/The_Candle_Icon.png?version=ffa57ff8a31460fdef8d6e735ed494f1",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/a/ab/Converter_Icon.png?version=c1fd31996ecd815fbb615b69083f030b",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/9/98/Crack_The_Sky_Icon.png?version=a34ed24ff7b3be96df9fc16f3be27f79",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/9/97/Crystal_Ball_Icon.png?version=1b3beb6a4d1bfa9ad146a84b0790cae6",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/3/34/D4_Icon.png?version=0aa426bb29cede49e6ea64fe4ac27a07",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/f/fa/The_D6_Icon.png?version=b5985281793295b5acb8eecbe43fbf65",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/6/6e/D10_Icon.png?version=439523b1b3715d9e4c802d273559fbb7",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/7/7a/D20_Icon.png?version=5f924572ac40250a5677579375aa4c4e",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/2/2a/D100_Icon.png?version=022681b09483edfe398c039a7737aa61",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/0/04/Dad%27s_Key_Icon.png?version=12d3cff3fa1994e9ba044449f7b5a277",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/4/42/Dead_Sea_Scrolls_Icon.png?version=4f0fc063f05ca32bd009246a9bbf9c7f",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/f/f8/Deck_Of_Cards_Icon.png?version=5d319c9962a5e35e0435e6114fa79216",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/2/26/Doctor%27s_Remote_Icon.png?version=3744bd84a6bfed123a7be0b38b9839a3",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/5/57/Flush%21_Icon.png?version=9907a63aa347d632e704e9e64908e0b3",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/5/56/Forget_Me_Now_Icon.png?version=8cdc74d760eeb7329bfdedd69b23ed88",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/5/5e/The_Gamekid_Icon.png?version=b900ee8935989f16f7d8a7b27759bf53",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/5/5a/Guppy%27s_Head_Icon.png?version=b48d422c6ecf802b467b05dafe12099d",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/4/4c/Guppy%27s_Paw_Icon.png?version=aaaf09a8f16f6f5cd25c4eabbd76754d",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/7/76/Head_Of_Krampus_Icon.png?version=0d7cff2122bfac60c311c8c7c2f53a3f",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/1/1f/How_To_Jump_Icon.png?version=233bdf566581d017fc4c6258ab18d794",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/2/20/The_Hourglass_Icon.png?version=e7cb62afac57fcaf1eb3ac1e0c6d0f1d",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/b/b6/Isaac%27s_Tears_Icon.png?version=a1bd6f5234c81eea6282090946fe412f",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/c/c0/IV_Bag_Icon.png?version=a7cb7d63949274e9808da0c75aad8e20",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/d/db/The_Jar_Icon.png?version=e3a651d03abae061946b1a5629e9285e",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/d/db/Kamikaze%21_Icon.png?version=0210505b93fca6c4a8c690e5f26e6d9b",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/1/19/Lemon_Mishap_Icon.png?version=830d83e3b608b55b96700e67f9d36573",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/4/4b/Magic_Fingers_Icon.png?version=812c49da1bc1c5934dc8e16b592e129d",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/5/55/Mom%27s_Bottle_Of_Pills_Icon.png?version=876691bee497a8e81bf8c50721bc694c",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/c/c4/Mom%27s_Bra_Icon.png?version=05d493a111f4d5057a2464e527ac2268",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/b/b7/Mom%27s_Pad_Icon.png?version=dbc2053e65ef84ee06098fc3ddbaa7eb",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/9/9c/Monster_Manual_Icon.png?version=78e1e70c2497635d42e15135836239c1",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/7/76/Monstro%27s_Tooth_Icon.png?version=7e8d632fec6f65046c2ff539e0e81ee2",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/a/ae/Mr._Boom_Icon.png?version=ad812471ae6931e6808f05af25a6f2a9",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/c/cb/My_Little_Unicorn_Icon.png?version=a8501bd648723d21b29407729f5260e0",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/e/e0/The_Nail_Icon.png?version=7c9272d71346794dcb2f0fc4f3ca10c6",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/7/77/The_Necronomicon_Icon.png?version=13f5dcc3d26a646dec777b88cfaf3ed1",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/5/5c/Notched_Axe_Icon.png?version=40456bd76e50be87829c49081390bdc4",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/2/2d/Pandora%27s_Box_Icon.png?version=c9183ccf100a6102fa662d3d630ea864",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/4/4b/The_Pinking_Shears_Icon.png?version=c4c628d91d46ef10f5232ec9ea81ab9b",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/8/87/The_Pony_Icon.png?version=345958a07bee382b80aa6bdd8c0fa176",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/7/72/The_Poop_Icon.png?version=2017be75d81ee1b7397647ec4fb6eef5",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/9/9c/Portable_Slot_Icon.png?version=cbf71bee1af85cd1a0ff31626285092a",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/1/17/Prayer_Card_Icon.png?version=2e5355884a7d5297a4dcc373afda6957",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/b/b4/Razor_Blade_Icon.png?version=a7ea39affa3b55319052383a702f75d8",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/a/ab/Red_Candle_Icon.png?version=5c5281ac2cdcc0b371840dc05ec985c9",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/2/2f/Remote_Detonator_Icon.png?version=18da6456d6234b1bce0804750fbec70c",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/5/5b/Satanic_Bible_Icon.png?version=7bd6b1184c70151c1dab51fb3c3138f0",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/8/83/Scissors_Icon.png?version=ba350bf569087706a024ac67334b52ee",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/2/2c/Shoop_Da_Whoop%21_Icon.png?version=8fe8e1590d5675ec911aa2cda0bf0648",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/7/7f/Spider_Butt_Icon.png?version=40077a39b1f6f133820f2bb0dc4b874d",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/2/2f/Tammy%27s_Head_Icon.png?version=c6fa7e6a4dff1b3ed66662a9b9a66775",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/1/12/Telepathy_For_Dummies_Icon.png?version=7cad0f4f1165b90634e5501c59e7d853",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/b/b0/Teleport_Icon.png?version=93a5b3246a69d8fe0ff26fb20fea589b",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/5/5b/Undefined_Icon.png?version=32fa513ec2abe469a4bf4ab10b984f91",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/3/3c/Unicorn_Stump_Icon.png?version=b45b428bb806ba0e33bd9d0868fcd23a",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/6/69/We_Need_To_Go_Deeper%21_Icon.png?version=4f4a66eb3f7cf83c8cf443a0323ba560",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/2/2e/White_Pony_Icon.png?version=dfdf49b31e855fe699cf284c5c1a99dd",
                "http://hydra-media.cursecdn.com/bindingofisaacrebirth.gamepedia.com/e/e0/Yum_Heart_Icon.png?version=c4ebe5030a6ca48f8fa2da08c9092911"
        };
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(activatedItems.this);
        if(sp.getBoolean("pref_img_key", false)) {
            //Toast.makeText(getApplicationContext(), Boolean.toString(sp.getBoolean("pref_img", true)), Toast.LENGTH_SHORT).show();
            listAdapterItemsAc adapter=new listAdapterItemsAc(this, items, rechTimes, images);
            lv.setAdapter(adapter);
        }
        else {
            listAdapterItemsAc adapter=new listAdapterItemsAc(this, items, rechTimes, null);
            lv.setAdapter(adapter);
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(activatedItems.this);
                builder.setTitle(items[position]);
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
        getMenuInflater().inflate(R.menu.menu_activated_items, menu);
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
