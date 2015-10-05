package ca.ualberta.cs.reflex_app;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ViewStatsActivity extends MainActivity {

    String buzzerStat;
    String singleStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats);

        TextView singleStats = (TextView)findViewById(R.id.singleStats);
        ArrayList timerRecord = TimingActivity.LoadData();
        Collections.sort(timerRecord);
        List last10min;
        List last100min;
        List last10max;
        List last100max;

        if (timerRecord.size() > 10){
            last10min = timerRecord.subList(0, 10);
            last10max = timerRecord.subList((timerRecord.size()-10), timerRecord.size());
        }
        else{
            last10min = timerRecord;
            last10max = timerRecord;
        }

        if (timerRecord.size() > 100){
            last100min = timerRecord.subList(0, 100);
            last100max = timerRecord.subList((timerRecord.size()-100), timerRecord.size());
        }
        else{
            last100min = timerRecord;
            last100max = timerRecord;
        }
        singleStat = ("Single User Mode:"+
                "\nMinimum time of last 10 times:\n" + last10min +
                "\nMinimum time of last 100 times:\n" + last100min +
                "\nMaximum time of last 10 times:\n" + last10max +
                "\nMaximum time of last 100 times:\n" + last100max);
        singleStats.setText(singleStat);

        TextView buzzerStats = (TextView)findViewById(R.id.buzzerStats);
        buzzerStat = ("Gameshow Buzzer Mode:" +
                "\nTwo Players:\n" + TwoPlayersBuzzerActivity.LoadData() +
                "\nThree Players:\n" + ThreePlayersBuzzerActivity.LoadData() +
                "\nFour Players:\n" + FourPlayersBuzzerActivity.LoadData()
        );
        buzzerStats.setText(buzzerStat);
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
