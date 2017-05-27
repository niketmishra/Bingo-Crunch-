package com.snicket.premsourav.bingo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton b1, b2, b3, b4;

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        b1 = (ImageButton) findViewById(R.id.b1);
        b2 = (ImageButton) findViewById(R.id.b2);
        b3 = (ImageButton) findViewById(R.id.b3);
        b4 = (ImageButton) findViewById(R.id.b4);

        db = openOrCreateDatabase("countdb", MODE_PRIVATE, null);
        String q = "create table if not exists cou(user varchar,cpu varchar)";
        db.execSQL(q);
        String v1 = "insert into cou values('00','00')";
        db.execSQL(v1);
        db.close();


        ImageButton b1 = (ImageButton) findViewById(R.id.b1);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.4, 20);
        myAnim.setInterpolator(interpolator);
        b3.startAnimation(myAnim);
        b4.startAnimation(myAnim);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelDialog();
            }
        });

        db = openOrCreateDatabase("multidb", MODE_PRIVATE, null);
        String qr = "create table if not exists mulco(user varchar,userr varchar)";
        db.execSQL(qr);
        String vr = "insert into mulco values('00','00')";
        db.execSQL(vr);
        db.close();


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Multi.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                help();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleDialog();
            }
        });
    }

    void help() {
        Dialog j = new Dialog(this);
        j.setTitle("Instructions");
        j.setContentView(R.layout.help);
        j.show();
        Window window = j.getWindow();
        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
    }

    void simpleDialog() {
        final Dialog d = new Dialog(MainActivity.this);
        d.setTitle("About");
        d.setContentView(R.layout.mydialog);
        Button ok = (Button) d.findViewById(R.id.b1);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();
        Window window = d.getWindow();
        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

    }


    void levelDialog() {
        final Dialog a = new Dialog(MainActivity.this);

        a.setTitle("Level");
        a.setContentView(R.layout.leveldialog);
        Button b1 = (Button) a.findViewById(R.id.b1);
        Button b2 = (Button) a.findViewById(R.id.b2);
        Button b3 = (Button) a.findViewById(R.id.b3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SinglePlayEasy.class);
                startActivity(i);
                a.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SinglePlayMed.class);
                startActivity(i);
                a.dismiss();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SinglePlay.class);
                startActivity(i);
                a.dismiss();
            }
        });
        a.show();
        Window window = a.getWindow();
        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

    }

        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                exitByBackKey();

                //moveTaskToBack(false);

                return true;
            }
            return super.onKeyDown(keyCode, event);
        }

        protected void exitByBackKey() {

            AlertDialog alertbox = new AlertDialog.Builder(this)
                    .setMessage("Do you want to exit ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        // do something when the button is clicked
                        public void onClick(DialogInterface arg0, int arg1) {

                            finishAffinity(); //CLOSE ALL ACTIVITIES AT ONCE (API 16+)
                            //close();


                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {

                        // do something when the button is clicked
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    })

                    .show();

        }
            /*

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }*/

}
