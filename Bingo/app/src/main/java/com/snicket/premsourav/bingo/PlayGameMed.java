package com.snicket.premsourav.bingo;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class PlayGameMed extends AppCompatActivity{
//parseColor("#F17C67")    === cpu
//parseColor("#88C3FA")    === user
//#F17C67 new cpu
// #88C3FA new user

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25;
    TextView tv2, tv4, tv5;
    Vibrator vib;
    SQLiteDatabase db;

    int clickedb[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int sum = 0;
    int c = 0;
    String s;
    int res1 = 0, res2 = 0, res3 = 0, res4 = 0, res5 = 0, res6 = 0, res7 = 0, res8 = 0, res9 = 0, res10 = 0, res11 = 0, res12 = 0;
    MediaPlayer playerr;

    //ADVERTISEMENT
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    int[] arr = {9,10};
    int rand = (int) (Math.random() * 2);
    int w = arr[rand];
    int f = 0;


    /*void runn()
    {
        final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
        int rand = (int) (Math.random()*25);
        Button rb = (buttons[rand]);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play_game);


        //ADVERTISEMENT
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

// Prepare the Interstitial Ad
        interstitial = new InterstitialAd(PlayGameMed.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
        //db=openOrCreateDatabase("countdb",MODE_WORLD_WRITEABLE,null);
        /*db=openOrCreateDatabase("countdb",MODE_PRIVATE,null);
        String q="create table if not exists cou(user varchar,cpu varchar)";
        db.execSQL(q);*/
        //String q1="insert into cou values(00,00)";
        //db.execSQL(q1);

        tv2 = (TextView) findViewById(R.id.tv2);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b13 = (Button) findViewById(R.id.b13);
        b14 = (Button) findViewById(R.id.b14);
        b15 = (Button) findViewById(R.id.b15);
        b16 = (Button) findViewById(R.id.b16);
        b17 = (Button) findViewById(R.id.b17);
        b18 = (Button) findViewById(R.id.b18);
        b19 = (Button) findViewById(R.id.b19);
        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);
        b23 = (Button) findViewById(R.id.b23);
        b24 = (Button) findViewById(R.id.b24);
        b25 = (Button) findViewById(R.id.b25);

        String vibrator_sn = Context.VIBRATOR_SERVICE;
        vib = (Vibrator) getSystemService(vibrator_sn);

        Intent ri = getIntent();
        Bundle b = ri.getExtras();
        String a1 = b.getString("n1");
        String a2 = b.getString("n2");
        String a3 = b.getString("n3");
        String a4 = b.getString("n4");
        String a5 = b.getString("n5");
        String a6 = b.getString("n6");
        String a7 = b.getString("n7");
        String a8 = b.getString("n8");
        String a9 = b.getString("n9");
        String a10 = b.getString("n10");
        String a11 = b.getString("n11");
        String a12 = b.getString("n12");
        String a13 = b.getString("n13");
        String a14 = b.getString("n14");
        String a15 = b.getString("n15");
        String a16 = b.getString("n16");
        String a17 = b.getString("n17");
        String a18 = b.getString("n18");
        String a19 = b.getString("n19");
        String a20 = b.getString("n20");
        String a21 = b.getString("n21");
        String a22 = b.getString("n22");
        String a23 = b.getString("n23");
        String a24 = b.getString("n24");
        String a25 = b.getString("n25");

        b1.setText(a1);
        b2.setText(a2);
        b3.setText(a3);
        b4.setText(a4);
        b5.setText(a5);
        b6.setText(a6);
        b7.setText(a7);
        b8.setText(a8);
        b9.setText(a9);
        b10.setText(a10);
        b11.setText(a11);
        b12.setText(a12);
        b13.setText(a13);
        b14.setText(a14);
        b15.setText(a15);
        b16.setText(a16);
        b17.setText(a17);
        b18.setText(a18);
        b19.setText(a19);
        b20.setText(a20);
        b21.setText(a21);
        b22.setText(a22);
        b23.setText(a23);
        b24.setText(a24);
        b25.setText(a25);

        db=openOrCreateDatabase("countdb",MODE_PRIVATE,null);
        String w="select *from cou";
        Cursor cu=db.rawQuery(w,null);
        cu.moveToLast();
        String us=cu.getString(cu.getColumnIndex("user"));
        String cp=cu.getString(cu.getColumnIndex("cpu"));
        tv4.setText(us);
        tv5.setText(cp);

        if(playerr==null)
        {
            playerr=MediaPlayer.create(this,R.raw.sangbeat);
        }
        playerr.start();
        playerr.setLooping(true);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[0] != 1) {

                    clickedb[0] = 1;
                    b1.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b1.getBackground();
                        int val1 = 0;
                        while (val1 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val1 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[1] != 1) {
                    clickedb[1] = 1;
                    b2.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b2.getBackground();
                        int val2 = 0;
                        while (val2 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val2 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[2] != 1) {
                    clickedb[2] = 1;
                    b3.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b3.getBackground();
                        int val3 = 0;
                        while (val3 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val3 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[3] != 1) {
                    clickedb[3] = 1;
                    b4.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b4.getBackground();
                        int val4 = 0;
                        while (val4 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val4 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[4] != 1) {
                    clickedb[4] = 1;
                    b5.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b5.getBackground();
                        int val5 = 0;
                        while (val5 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val5 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[5] != 1) {
                    clickedb[5] = 1;
                    b6.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b6.getBackground();
                        int val6 = 0;
                        while (val6 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val6 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[6] != 1) {
                    clickedb[6] = 1;
                    b7.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b7.getBackground();
                        int val7 = 0;
                        while (val7 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val7 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[7] != 1) {
                    clickedb[7] = 1;
                    b8.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b8.getBackground();
                        int val8 = 0;
                        while (val8 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val8 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[8] != 1) {
                    clickedb[8] = 1;
                    b9.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b9.getBackground();
                        int val9 = 0;
                        while (val9 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val9 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[9] != 1) {
                    clickedb[9] = 1;
                    b10.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b10.getBackground();
                        int val10 = 0;
                        while (val10 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val10 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[10] != 1) {
                    clickedb[10] = 1;
                    b11.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b11.getBackground();
                        int val11 = 0;
                        while (val11 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val11 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[11] != 1) {
                    clickedb[11] = 1;
                    b12.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b12.getBackground();
                        int val12 = 0;
                        while (val12 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val12 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[12] != 1) {
                    clickedb[12] = 1;
                    b13.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b13.getBackground();
                        int val13 = 0;
                        while (val13 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val13 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[13] != 1) {
                    clickedb[13] = 1;
                    b14.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b14.getBackground();
                        int val14 = 0;
                        while (val14 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val14 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[14] != 1) {
                    clickedb[14] = 1;
                    b15.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b15.getBackground();
                        int val15 = 0;
                        while (val15 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val15 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[15] != 1) {
                    clickedb[15] = 1;
                    b16.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b16.getBackground();
                        int val16 = 0;
                        while (val16 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val16 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[16] != 1) {
                    clickedb[16] = 1;
                    b17.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b17.getBackground();
                        int val17 = 0;
                        while (val17 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val17 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[17] != 1) {
                    clickedb[17] = 1;
                    b18.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b18.getBackground();
                        int val18 = 0;
                        while (val18 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val18 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[18] != 1) {
                    clickedb[18] = 1;
                    b19.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b19.getBackground();
                        int val19 = 0;
                        while (val19 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val19 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[19] != 1) {
                    clickedb[19] = 1;
                    b20.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b20.getBackground();
                        int val20 = 0;
                        while (val20 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val20 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[20] != 1) {
                    clickedb[20] = 1;
                    b21.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b21.getBackground();
                        int val21 = 0;
                        while (val21 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val21 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[21] != 1) {
                    clickedb[21] = 1;
                    b22.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b22.getBackground();
                        int val22 = 0;
                        while (val22 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val22 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[22] != 1) {
                    clickedb[22] = 1;
                    b23.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b23.getBackground();
                        int val23 = 0;
                        while (val23 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val23 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[23] != 1) {
                    clickedb[23] = 1;
                    b24.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b24.getBackground();
                        int val24 = 0;
                        while (val24 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                clickedb[rand] = 1;
                                val24 = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[24] != 1) {
                    clickedb[24] = 1;
                    b25.setBackgroundColor(Color.parseColor("#88C3FA"));
                    c++;
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        ColorDrawable buttonColor = (ColorDrawable) b25.getBackground();
                        int val25 = 0;
                        while (val25 != 1) {
                            final Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25};
                            int rand = (int) (Math.random() * 25);
                            final Button rb = (buttons[rand]);

                            if (clickedb[rand] == 0) {
                                val25 = 1;
                                clickedb[rand] = 1;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        rb.setBackgroundColor(Color.parseColor("#F17C67"));
                                        vib.vibrate(100);
                                        ena();
                                    }
                                }, 1500);
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                            }
                        }, 1502);
                        win();
                    }
                }
            }
        });
    }

    void disa() {
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        b10.setEnabled(false);
        b11.setEnabled(false);
        b12.setEnabled(false);
        b13.setEnabled(false);
        b14.setEnabled(false);
        b15.setEnabled(false);
        b16.setEnabled(false);
        b17.setEnabled(false);
        b18.setEnabled(false);
        b19.setEnabled(false);
        b20.setEnabled(false);
        b21.setEnabled(false);
        b22.setEnabled(false);
        b23.setEnabled(false);
        b24.setEnabled(false);
        b25.setEnabled(false);
    }

    void ena() {
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        b10.setEnabled(true);
        b11.setEnabled(true);
        b12.setEnabled(true);
        b13.setEnabled(true);
        b14.setEnabled(true);
        b15.setEnabled(true);
        b16.setEnabled(true);
        b17.setEnabled(true);
        b18.setEnabled(true);
        b19.setEnabled(true);
        b20.setEnabled(true);
        b21.setEnabled(true);
        b22.setEnabled(true);
        b23.setEnabled(true);
        b24.setEnabled(true);
        b25.setEnabled(true);
    }

    public void comp(int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, int a17, int a18, int a19, int a20, int a21, int a22, int a23, int a24, int a25) {
        if (a1 == 1 && a2 == 1 && a3 == 1 && a4 == 1 && a5 == 1) {
            res1 = 1;
        }
        if (a6 == 1 && a7 == 1 && a8 == 1 && a9 == 1 && a10 == 1) {
            res2 = 1;
        }
        if (a11 == 1 && a12 == 1 && a13 == 1 && a14 == 1 && a15 == 1) {
            res3 = 1;
        }
        if (a16 == 1 && a17 == 1 && a18 == 1 && a19 == 1 && a20 == 1) {
            res4 = 1;
        }
        if (a21 == 1 && a22 == 1 && a23 == 1 && a24 == 1 && a25 == 1) {
            res5 = 1;
        }
        if (a1 == 1 && a6 == 1 && a11 == 1 && a16 == 1 && a21 == 1) {
            res6 = 1;
        }
        if (a2 == 1 && a7 == 1 && a12 == 1 && a17 == 1 && a22 == 1) {
            res7 = 1;
        }
        if (a3 == 1 && a8 == 1 && a13 == 1 && a18 == 1 && a23 == 1) {
            res8 = 1;
        }
        if (a4 == 1 && a9 == 1 && a14 == 1 && a19 == 1 && a24 == 1) {
            res9 = 1;
        }
        if (a5 == 1 && a10 == 1 && a15 == 1 && a20 == 1 && a25 == 1) {
            res10 = 1;
        }
        if (a21 == 1 && a17 == 1 && a13 == 1 && a9 == 1 && a5 == 1) {
            res11 = 1;
        }
        if (a1 == 1 && a7 == 1 && a13 == 1 && a19 == 1 && a25 == 1) {
            res12 = 1;
        }

        sum = res1 + res2 + res3 + res4 + res5 + res6 + res7 + res8 + res9 + res10 + res11 + res12;

        if (sum == 0) {
            tv2.setText("GOOD LUCK!!");
        }
        if (sum == 1) {
            tv2.setText("B");
        }
        if (sum == 2) {
            tv2.setText("BI");
        }
        if (sum == 3) {
            tv2.setText("BIN");
        }
        if (sum == 4) {
            tv2.setText("BING");
        }
        if ((sum == 5|| sum>5) && f == 0) {
            tv2.setText("BINGO!!!");
            /*String s1 = "YOU WON!!!";
            Intent i = new Intent(PlayGame.this, ResultScreen.class);
            i.putExtra("Res1", s1);
            startActivityForResult(i, 101);*/

            //Toast.makeText(this,"won!!",Toast.LENGTH_SHORT).show();

            a();

            //finish();

        }
    }

    public void a()
    {
        final Dialog d1=new Dialog(PlayGameMed.this);
        d1.setTitle("Result");
        d1.setContentView(R.layout.resu);
        d1.setCancelable(false);
        Button b1=(Button)d1.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w="select *from cou";
                Cursor ca=db.rawQuery(w,null);
                if(ca.moveToFirst())
                {
                    ca.moveToLast();
                    String us=ca.getString(ca.getColumnIndex("user"));
                    String cp=ca.getString(ca.getColumnIndex("cpu"));
                    int usr=Integer.parseInt(us);
                    int opp=Integer.parseInt(cp);
                    usr++;
                    String q=""+usr;
                    String z=""+opp;
                    String v1="insert into cou values('"+q+"','"+z+"')";
                    db.execSQL(v1);
                }
                else
                {
                        /*String q1="insert into cou values('01','00')";
                        db.execSQL(q1);
                        tv4.setText("01");
                        tv5.setText("00");*/
                    Toast.makeText(PlayGameMed.this,"some error!!",Toast.LENGTH_SHORT).show();
                }
                if(playerr.isPlaying())
                {
                    playerr.stop();
                }


                Intent i = new Intent(PlayGameMed.this, SinglePlayMed.class);
                startActivity(i);
                d1.dismiss();
                finish();
            }
        });

        Button b2=(Button)d1.findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    /*String v1="insert into cou values(00,00)";
                    db.execSQL(v1);
                    tv4.setText("00");
                    tv5.setText("00");*/
                if(playerr.isPlaying())
                {
                    playerr.stop();
                }

                Intent i = new Intent(PlayGameMed.this, MainActivity.class);
                startActivity(i);
                d1.dismiss();
                finish();
            }
        });
        d1.show();
        //Window window = d1.getWindow();
        //window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
    }

    public void win() {

        if (c == w) {
            /*String s2 = "YOU LOST!!!";
            Intent i = new Intent(PlayGame.this, ResultScreenLost.class);
            i.putExtra("Res2", s2);
            startActivityForResult(i, 102);*/
            f=1;
            final Dialog d2=new Dialog(this);
            d2.setTitle("Result");
            d2.setContentView(R.layout.resul);
            d2.setCancelable(false);
            Button b1=(Button)d2.findViewById(R.id.b1);
            Button b2=(Button)d2.findViewById(R.id.b2);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String w="select *from cou";
                    Cursor ca=db.rawQuery(w,null);
                    if(ca.moveToFirst())
                    {
                        ca.moveToLast();
                        String us=ca.getString(ca.getColumnIndex("user"));
                        String cp=ca.getString(ca.getColumnIndex("cpu"));
                        int usr=Integer.parseInt(us);
                        int opp=Integer.parseInt(cp);
                        opp++;
                        String q=""+usr;
                        String z=""+opp;
                        String v1="insert into cou values('"+q+"','"+z+"')";
                        db.execSQL(v1);
                    }
                    else
                    {
                        /*String q1="insert into cou values('01','00')";
                        db.execSQL(q1);
                        tv4.setText("01");
                        tv5.setText("00");*/
                        Toast.makeText(PlayGameMed.this,"some error!!",Toast.LENGTH_SHORT).show();
                    }
                    if(playerr.isPlaying())
                    {
                        playerr.stop();
                    }

                    Intent i = new Intent(PlayGameMed.this, SinglePlayMed.class);
                    startActivity(i);
                    d2.dismiss();
                    finish();
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*String v1="insert into cou values(00,00)";
                    db.execSQL(v1);
                    tv4.setText("00");
                    tv5.setText("00");*/
                    if(playerr.isPlaying())
                    {
                        playerr.stop();
                    }

                    Intent i = new Intent(PlayGameMed.this, MainActivity.class);
                    startActivity(i);
                    d2.dismiss();
                    finish();
                }
            });
            d2.show();
            Window window = d2.getWindow();
            window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);


            //finish();
            //return;
        }
    }
    @Override
    public void onBackPressed() {
        final Dialog d= new Dialog(PlayGameMed.this);
        d.setTitle("Return?");
        d.setContentView(R.layout.returnmain);
        Button b1=(Button)d.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playerr.isPlaying())
                {
                    playerr.stop();
                }
                Intent i=new Intent(PlayGameMed.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        d.show();
    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}
