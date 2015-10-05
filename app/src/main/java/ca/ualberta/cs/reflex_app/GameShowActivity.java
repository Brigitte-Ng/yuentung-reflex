package ca.ualberta.cs.reflex_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class GameShowActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_show);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_show, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //allows users to jump to activity_two_players_buzzer.xml
    public void goTwoBuzzers(View v){
        Intent intent = new Intent(this, TwoPlayersBuzzerActivity.class);
        startActivity(intent);
    }

    //allows users to jump to activity_three_players_buzzer.xml
    public void goThreeBuzzers(View v){
        Intent intent = new Intent(this, ThreePlayersBuzzerActivity.class);
        startActivity(intent);
    }

    //allows users to jump to activity_four_players_buzzer.xml
    public void goFourBuzzers(View v){
        Intent intent = new Intent(this, FourPlayersBuzzerActivity.class);
        startActivity(intent);
    }
}
