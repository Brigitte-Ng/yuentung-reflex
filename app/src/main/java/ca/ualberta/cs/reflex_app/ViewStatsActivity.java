package ca.ualberta.cs.reflex_app;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ViewStatsActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats);

        TextView singleStats = (TextView)findViewById(R.id.singleStats);
        singleStats.setText("Single User Mode:\n"+TimingActivity.LoadData());

        TextView buzzerStats = (TextView)findViewById(R.id.buzzerStats);
        buzzerStats.setText("Gameshow Buzzer Mode:\n" +
                            "Two Players:\n"+TwoPlayersBuzzerActivity.LoadData() +
                            "Three Players:\n"+ThreePlayersBuzzerActivity.LoadData() +
                            "Four Players:\n"+FourPlayersBuzzerActivity.LoadData()
                            );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_stats, menu);
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
}
