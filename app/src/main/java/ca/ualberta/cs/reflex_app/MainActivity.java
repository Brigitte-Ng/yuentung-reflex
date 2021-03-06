package ca.ualberta.cs.reflex_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //allows users to jump to activity_single_user.xml
    public void goSingleUser(View v){
        Intent intent = new Intent(this, SingleUserActivity.class);
        startActivity(intent);
    }

    //allows users to jump to activity_game_show.xml
    public void goGameShowBuzzer(View v){
        Intent intent = new Intent(this, GameShowActivity.class);
        startActivity(intent);
    }

    //allows users to jump to activity_view_stats.xml
    public void goViewStats(View v){
        Intent intent = new Intent(this, ViewStatsActivity.class);
        startActivity(intent);
    }
}
