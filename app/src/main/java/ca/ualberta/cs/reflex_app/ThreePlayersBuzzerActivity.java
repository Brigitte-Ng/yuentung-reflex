package ca.ualberta.cs.reflex_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;


public class ThreePlayersBuzzerActivity extends GameShowActivity {

    int playerOneCount = 0;
    int playerTwoCount = 0;
    int playerThreeCount = 0;
    static JSONObject threePlayers = new JSONObject();

    public void SaveData(String player, String count){
        try {
            threePlayers.put(player, count);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject LoadData(){
        return threePlayers;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_players_buzzer);

        Button playerOne = (Button)findViewById(R.id.playerOne3);
        Button playerTwo = (Button)findViewById(R.id.playerTwo3);
        Button playerThree = (Button)findViewById(R.id.playerThree3);

        //when user click on the Player 1 button, a pop up window will show
        playerOne.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View arg0) {

                playerOneCount = playerOneCount + 1;

                AlertDialog playerOne = new AlertDialog.Builder(ThreePlayersBuzzerActivity.this).create();
                playerOne.setTitle("");
                playerOne.setMessage("Player 1");
                playerOne.setButton(AlertDialog.BUTTON_NEGATIVE, "Continue", new DialogInterface.OnClickListener() {
                            
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }
                );
                playerOne.setButton(AlertDialog.BUTTON_POSITIVE, "Exit", new DialogInterface.OnClickListener() {
                            //Go back to main page
                            public void onClick(DialogInterface dialog, int which) {
                                SaveData("Player 1", Integer.toString(playerOneCount));
                                SaveData("Player 2", Integer.toString(playerTwoCount));
                                SaveData("Player 3", Integer.toString(playerThreeCount));
                                Intent intent= new Intent(ThreePlayersBuzzerActivity.this, MainActivity.class);
                                finish();
                                startActivity(intent);
                                dialog.dismiss();
                            }
                        }
                );
                playerOne.show();
            }
        });

        //when user click on the Player 2 button, a pop up window will show
        playerTwo.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View arg0) {

                playerTwoCount = playerTwoCount + 1;

                AlertDialog playerTwo = new AlertDialog.Builder(ThreePlayersBuzzerActivity.this).create();
                playerTwo.setTitle("");
                playerTwo.setMessage("Player 2");
                playerTwo.setButton(AlertDialog.BUTTON_NEGATIVE, "Continue", new DialogInterface.OnClickListener() {
                            
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }
                );
                playerTwo.setButton(AlertDialog.BUTTON_POSITIVE, "Exit", new DialogInterface.OnClickListener() {
                            //Go back to main page
                            public void onClick(DialogInterface dialog, int which) {
                                SaveData("Player 1", Integer.toString(playerOneCount));
                                SaveData("Player 2", Integer.toString(playerTwoCount));
                                SaveData("Player 3", Integer.toString(playerThreeCount));
                                Intent intent= new Intent(ThreePlayersBuzzerActivity.this, MainActivity.class);
                                finish();
                                startActivity(intent);
                                dialog.dismiss();
                            }
                        }
                );
                playerTwo.show();
            }
        });

        //when user click on the Player 3 button, a pop up window will show
        playerThree.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View arg0) {

                playerThreeCount = playerThreeCount + 1;

                AlertDialog playerThree = new AlertDialog.Builder(ThreePlayersBuzzerActivity.this).create();
                playerThree.setTitle("");
                playerThree.setMessage("Player 3");
                playerThree.setButton(AlertDialog.BUTTON_NEGATIVE, "Continue", new DialogInterface.OnClickListener() {
                            
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }
                );
                playerThree.setButton(AlertDialog.BUTTON_POSITIVE, "Exit", new DialogInterface.OnClickListener() {
                            //Go back to main page
                            public void onClick(DialogInterface dialog, int which) {
                                SaveData("Player 1", Integer.toString(playerOneCount));
                                SaveData("Player 2", Integer.toString(playerTwoCount));
                                SaveData("Player 3", Integer.toString(playerThreeCount));
                                Intent intent= new Intent(ThreePlayersBuzzerActivity.this, MainActivity.class);
                                finish();
                                startActivity(intent);
                                dialog.dismiss();
                            }
                        }
                );
                playerThree.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_three_players_buzzer, menu);
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
