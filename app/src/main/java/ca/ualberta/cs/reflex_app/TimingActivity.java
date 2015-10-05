package ca.ualberta.cs.reflex_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;

import java.util.Random;


public class TimingActivity extends SingleUserActivity {

    long startTime = 0;
    long millis = 0;
    JSONArray singleTimeRecords = new JSONArray();
    Random rand = new Random();
    long randomTime = 0;


    public void SaveData(){

    }

    public void LoadData(){

    }
    //runs without a timer by reposting this handler at the end of the runnable
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            //set the hi button visible
            Button stop = (Button)findViewById(R.id.stopTimer);
            stop.setVisibility(View.VISIBLE);

            //set the area button invisible
            Button area = (Button)findViewById(R.id.area);
            area.setVisibility(View.INVISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing);

        //start the timer and set the hi button invisible
        startTime = System.currentTimeMillis();
        Button stop = (Button)findViewById(R.id.stopTimer);
        stop.setVisibility(View.INVISIBLE);

        //set area button visible
        Button area = (Button)findViewById(R.id.area);
        area.setVisibility(View.VISIBLE);

        //generate a random time for 10ms to 2000ms
        randomTime = rand.nextInt(1991)+ 10;
        timerHandler.postDelayed(timerRunnable, randomTime);

        //when user click on the hi button, the timer stops and the reaction time will show
        stop.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View arg0) {

                millis = System.currentTimeMillis() - startTime;
                Long record = new Long(millis);
                singleTimeRecords.put(record);

                AlertDialog resultPop = new AlertDialog.Builder(TimingActivity.this).create();
                resultPop.setTitle("Your Reaction Time");
                resultPop.setMessage(record.toString() + " Millisecond");
                resultPop.setButton(AlertDialog.BUTTON_NEGATIVE, "Restart", new DialogInterface.OnClickListener() {
                    //Restart single user mode (current activity)
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                        dialog.dismiss();
                        }
                    }
                );
                resultPop.setButton(AlertDialog.BUTTON_POSITIVE, "Exit", new DialogInterface.OnClickListener() {
                    //Go back to main page
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent= new Intent(TimingActivity.this, MainActivity.class);
                        finish();
                        startActivity(intent);
                        dialog.dismiss();
                        }
                    }
                );
                resultPop.show();
            }
        });

        //when the user clicks before the hi button shows, an warning message will show
        area.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog warningPop = new AlertDialog.Builder(TimingActivity.this).create();
                warningPop.setTitle("WARNING!!");
                warningPop.setMessage("Don't hit too early");
                warningPop.setButton(AlertDialog.BUTTON_NEUTRAL, "Restart", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        //Restart single user mode (current activity)
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                warningPop.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timing, menu);
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
