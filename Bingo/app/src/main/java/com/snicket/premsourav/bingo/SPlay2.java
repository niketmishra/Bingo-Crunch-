package com.snicket.premsourav.bingo;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
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

//parseColor("#F17C67")             ===cpu
//parseColor("#88C3FA")             ===user


public class SPlay2 extends AppCompatActivity {


    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25;
    TextView tv2, tv4, tv5, tv1, tv3;
    Vibrator vib;
    SQLiteDatabase db;

    int clickedb[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int sum = 0;
    int c = 0;
    int i;
    String s;
    int res1 = 0, res2 = 0, res3 = 0, res4 = 0, res5 = 0, res6 = 0, res7 = 0, res8 = 0, res9 = 0, res10 = 0, res11 = 0, res12 = 0;
    MediaPlayer playerr;

    //ADVERTISEMENT
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

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
        /*AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

// Prepare the Interstitial Ad
        interstitial = new InterstitialAd(SPlay2.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });*/
        //db=openOrCreateDatabase("countdb",MODE_WORLD_WRITEABLE,null);
        /*db=openOrCreateDatabase("countdb",MODE_PRIVATE,null);
        String q="create table if not exists cou(user varchar,cpu varchar)";
        db.execSQL(q);*/
        //String q1="insert into cou values(00,00)";
        //db.execSQL(q1);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv3 = (TextView) findViewById(R.id.tv3);
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

        db=openOrCreateDatabase("multidb",MODE_PRIVATE,null);
        String w1="select *from mulco";
        Cursor cu1=db.rawQuery(w1,null);
        cu1.moveToLast();
        String us1=cu1.getString(cu1.getColumnIndex("user"));
        String uss1=cu1.getString(cu1.getColumnIndex("userr"));
        tv4.setText(us1);
        tv5.setText(uss1);
        db.close();

        db=openOrCreateDatabase("playerone",MODE_PRIVATE,null);
        String h="select *from playone";
        Cursor ac=db.rawQuery(h,null);
        ac.moveToLast();
        String n1=ac.getString(ac.getColumnIndex("user"));
        tv1.setText(n1);
        db.close();

        db=openOrCreateDatabase("playertwo",MODE_PRIVATE,null);
        String wa="select *from playtwo";
        Cursor qc=db.rawQuery(wa,null);
        qc.moveToLast();
        String jk=qc.getString(qc.getColumnIndex("user"));
        tv3.setText(jk);
        db.close();

        db=openOrCreateDatabase("fillsecond",MODE_PRIVATE,null);
        String y="select *from filltwo";
        Cursor rc=db.rawQuery(y,null);
        rc.moveToLast();
        final String r1 = rc.getString(rc.getColumnIndex("a1"));
        final String r2 = rc.getString(rc.getColumnIndex("a2"));
        final String r3 = rc.getString(rc.getColumnIndex("a3"));
        final String r4 = rc.getString(rc.getColumnIndex("a4"));
        final String r5 = rc.getString(rc.getColumnIndex("a5"));
        final String r6 = rc.getString(rc.getColumnIndex("a6"));
        final String r7 = rc.getString(rc.getColumnIndex("a7"));
        final String r8 = rc.getString(rc.getColumnIndex("a8"));
        final String r9 = rc.getString(rc.getColumnIndex("a9"));
        final String r10 = rc.getString(rc.getColumnIndex("a10"));
        final String r11 = rc.getString(rc.getColumnIndex("a11"));
        final String r12 = rc.getString(rc.getColumnIndex("a12"));
        final String r13 = rc.getString(rc.getColumnIndex("a13"));
        final String r14 = rc.getString(rc.getColumnIndex("a14"));
        final String r15 = rc.getString(rc.getColumnIndex("a15"));
        final String r16 = rc.getString(rc.getColumnIndex("a16"));
        final String r17 = rc.getString(rc.getColumnIndex("a17"));
        final String r18 = rc.getString(rc.getColumnIndex("a18"));
        final String r19 = rc.getString(rc.getColumnIndex("a19"));
        final String r20 = rc.getString(rc.getColumnIndex("a20"));
        final String r21 = rc.getString(rc.getColumnIndex("a21"));
        final String r22 = rc.getString(rc.getColumnIndex("a22"));
        final String r23 = rc.getString(rc.getColumnIndex("a23"));
        final String r24 = rc.getString(rc.getColumnIndex("a24"));
        final String r25 = rc.getString(rc.getColumnIndex("a25"));

        b1.setText(r1);
        b2.setText(r2);
        b3.setText(r3);
        b4.setText(r4);
        b5.setText(r5);
        b6.setText(r6);
        b7.setText(r7);
        b8.setText(r8);
        b9.setText(r9);
        b10.setText(r10);
        b11.setText(r11);
        b12.setText(r12);
        b13.setText(r13);
        b14.setText(r14);
        b15.setText(r15);
        b16.setText(r16);
        b17.setText(r17);
        b18.setText(r18);
        b19.setText(r19);
        b20.setText(r20);
        b21.setText(r21);
        b22.setText(r22);
        b23.setText(r23);
        b24.setText(r24);
        b25.setText(r25);
        db.close();

        int v1=Integer.parseInt(r1);
        int v2=Integer.parseInt(r2);
        int v3=Integer.parseInt(r3);
        int v4=Integer.parseInt(r4);
        int v5=Integer.parseInt(r5);
        int v6=Integer.parseInt(r6);
        int v7=Integer.parseInt(r7);
        int v8=Integer.parseInt(r8);
        int v9=Integer.parseInt(r9);
        int v10=Integer.parseInt(r10);
        int v11=Integer.parseInt(r11);
        int v12=Integer.parseInt(r12);
        int v13=Integer.parseInt(r13);
        int v14=Integer.parseInt(r14);
        int v15=Integer.parseInt(r15);
        int v16=Integer.parseInt(r16);
        int v17=Integer.parseInt(r17);
        int v18=Integer.parseInt(r18);
        int v19=Integer.parseInt(r19);
        int v20=Integer.parseInt(r20);
        int v21=Integer.parseInt(r21);
        int v22=Integer.parseInt(r22);
        int v23=Integer.parseInt(r23);
        int v24=Integer.parseInt(r24);
        int v25=Integer.parseInt(r25);

        int[] ar={v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22,v23,v24,v25};

        SharedPreferences gsp= PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor edit = gsp.edit();
        String bn1=gsp.getString("bn1","");
        String bn2=gsp.getString("bn2","");
        String bn3=gsp.getString("bn3","");
        String bn4=gsp.getString("bn4","");
        String bn5=gsp.getString("bn5","");
        String bn6=gsp.getString("bn6","");
        String bn7=gsp.getString("bn7","");
        String bn8=gsp.getString("bn8","");
        String bn9=gsp.getString("bn9","");
        String bn10=gsp.getString("bn10","");
        String bn11=gsp.getString("bn11","");
        String bn12=gsp.getString("bn12","");
        String bn13=gsp.getString("bn13","");
        String bn14=gsp.getString("bn14","");
        String bn15=gsp.getString("bn15","");
        String bn16=gsp.getString("bn16","");
        String bn17=gsp.getString("bn17","");
        String bn18=gsp.getString("bn18","");
        String bn19=gsp.getString("bn19","");
        String bn20=gsp.getString("bn20","");
        String bn21=gsp.getString("bn21","");
        String bn22=gsp.getString("bn22","");
        String bn23=gsp.getString("bn23","");
        String bn24=gsp.getString("bn24","");
        String bn25=gsp.getString("bn25","");

        String bnn1=gsp.getString("bnn1","");
        String bnn2=gsp.getString("bnn2","");
        String bnn3=gsp.getString("bnn3","");
        String bnn4=gsp.getString("bnn4","");
        String bnn5=gsp.getString("bnn5","");
        String bnn6=gsp.getString("bnn6","");
        String bnn7=gsp.getString("bnn7","");
        String bnn8=gsp.getString("bnn8","");
        String bnn9=gsp.getString("bnn9","");
        String bnn10=gsp.getString("bnn10","");
        String bnn11=gsp.getString("bnn11","");
        String bnn12=gsp.getString("bnn12","");
        String bnn13=gsp.getString("bnn13","");
        String bnn14=gsp.getString("bnn14","");
        String bnn15=gsp.getString("bnn15","");
        String bnn16=gsp.getString("bnn16","");
        String bnn17=gsp.getString("bnn17","");
        String bnn18=gsp.getString("bnn18","");
        String bnn19=gsp.getString("bnn19","");
        String bnn20=gsp.getString("bnn20","");
        String bnn21=gsp.getString("bnn21","");
        String bnn22=gsp.getString("bnn22","");
        String bnn23=gsp.getString("bnn23","");
        String bnn24=gsp.getString("bnn24","");
        String bnn25=gsp.getString("bnn25","");



        Intent rih=getIntent();
        Bundle bu=rih.getExtras();
        if(rih.hasExtra("bu1"))
        {
            String j1=bu.getString("bu1");
            int t1=Integer.parseInt(j1);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t1)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu2"))
        {
            String j2=bu.getString("bu2");
            int t2=Integer.parseInt(j2);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t2)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu3"))
        {
            String j3=bu.getString("bu3");
            int t3=Integer.parseInt(j3);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t3)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu4"))
        {
            String j4=bu.getString("bu4");
            int t4=Integer.parseInt(j4);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t4)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu5"))
        {
            String j5=bu.getString("bu5");
            int t5=Integer.parseInt(j5);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t5)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu6"))
        {
            String j6=bu.getString("bu6");
            int t6=Integer.parseInt(j6);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t6)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu7"))
        {
            String j7=bu.getString("bu7");
            int t7=Integer.parseInt(j7);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t7)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu8"))
        {
            String j8=bu.getString("bu8");
            int t8=Integer.parseInt(j8);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t8)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu9"))
        {
            String j9=bu.getString("bu9");
            int t9=Integer.parseInt(j9);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t9)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu10"))
        {
            String j10=bu.getString("bu10");
            int t10=Integer.parseInt(j10);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t10)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu11"))
        {
            String j11=bu.getString("bu11");
            int t11=Integer.parseInt(j11);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t11)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu12"))
        {
            String j12=bu.getString("bu12");
            int t12=Integer.parseInt(j12);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t12)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu13"))
        {
            String j13=bu.getString("bu13");
            int t13=Integer.parseInt(j13);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t13)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu14"))
        {
            String j14=bu.getString("bu14");
            int t14=Integer.parseInt(j14);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t14)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu15"))
        {
            String j15=bu.getString("bu15");
            int t15=Integer.parseInt(j15);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t15)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu16"))
        {
            String j16=bu.getString("bu16");
            int t16=Integer.parseInt(j16);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t16)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu17"))
        {
            String j17=bu.getString("bu17");
            int t17=Integer.parseInt(j17);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t17)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu18"))
        {
            String j18=bu.getString("bu18");
            int t18=Integer.parseInt(j18);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t18)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu19"))
        {
            String j19=bu.getString("bu19");
            int t19=Integer.parseInt(j19);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t19)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu20"))
        {
            String j20=bu.getString("bu20");
            int t20=Integer.parseInt(j20);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t20)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu21"))
        {
            String j21=bu.getString("bu21");
            int t21=Integer.parseInt(j21);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t21)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu22"))
        {
            String j22=bu.getString("bu22");
            int t22=Integer.parseInt(j22);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t22)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu23"))
        {
            String j23=bu.getString("bu23");
            int t23=Integer.parseInt(j23);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t23)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu24"))
        {
            String j24=bu.getString("bu24");
            int t24=Integer.parseInt(j24);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t24)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(rih.hasExtra("bu25"))
        {
            String j25=bu.getString("bu25");
            int t25=Integer.parseInt(j25);
            for(i=0;i<25;i++)
            {
                if(ar[i]==t25)
                    break;
            }
            if(i==0)
            {
                edit.putString("bnn1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("bnn2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("bnn3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("bnn4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("bnn5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("bnn6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("bnn7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("bnn8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("bnn9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("bnn10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("bnn11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("bnn12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("bnn13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("bnn14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("bnn15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("bnn16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("bnn17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("bnn18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("bnn19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("bnn20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("bnn21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("bnn22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("bnn23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("bnn24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("bnn25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }

        /*db=openOrCreateDatabase("countdb",MODE_PRIVATE,null);
        String w="select *from cou";
        Cursor cu=db.rawQuery(w,null);
        cu.moveToLast();
        String us=cu.getString(cu.getColumnIndex("user"));
        String cp=cu.getString(cu.getColumnIndex("cpu"));
        tv4.setText(us);
        tv5.setText(cp);*/

        db=openOrCreateDatabase("playerone",MODE_PRIVATE,null);
        String hn="select *from playone";
        Cursor cka=db.rawQuery(hn,null);
        cka.moveToLast();
        final String np=cka.getString(cka.getColumnIndex("user"));
        db.close();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[0] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[0] = 1;
                    edit.putString("bn1","1");
                    edit.commit();
                    b1.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but1",r1);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[1] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[1] = 1;
                    edit.putString("bn2","1");
                    edit.commit();
                    b2.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but2",r2);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[2] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[2] = 1;
                    edit.putString("bn3","1");
                    edit.commit();
                    b3.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but3",r3);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[3] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[3] = 1;
                    edit.putString("bn4","1");
                    edit.commit();
                    b4.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but4",r4);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[4] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[4] = 1;
                    edit.putString("bn5","1");
                    edit.commit();
                    b5.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but5",r5);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[5] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[5] = 1;
                    edit.putString("bn6","1");
                    edit.commit();
                    b6.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but6",r6);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[6] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[6] = 1;
                    edit.putString("bn7","1");
                    edit.commit();
                    b7.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but7",r7);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[7] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[7] = 1;
                    edit.putString("bn8","1");
                    edit.commit();
                    b8.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but",r8);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[8] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[8] = 1;
                    edit.putString("bn9","1");
                    edit.commit();
                    b9.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but9",r9);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[9] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[9] = 1;
                    edit.putString("bn10","1");
                    edit.commit();
                    b10.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but10",r10);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[10] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[10] = 1;
                    edit.putString("bn11","1");
                    edit.commit();
                    b11.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but11",r11);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[11] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[11] = 1;
                    edit.putString("bn12","1");
                    edit.commit();
                    b12.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but12",r12);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[12] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[12] = 1;
                    edit.putString("bn13","1");
                    edit.commit();
                    b13.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but13",r13);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[13] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[13] = 1;
                    edit.putString("bn14","1");
                    edit.commit();
                    b14.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but14",r14);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[14] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[14] = 1;
                    edit.putString("bn15","1");
                    edit.commit();
                    b15.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but15",r15);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[15] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[15] = 1;
                    edit.putString("bn16","1");
                    edit.commit();
                    b16.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but16",r16);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[16] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[16] = 1;
                    edit.putString("bn17","1");
                    edit.commit();
                    b17.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but17",r17);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[17] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[17] = 1;
                    edit.putString("bn18","1");
                    edit.commit();
                    b18.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but18",r18);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[18] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[18] = 1;
                    edit.putString("bn19","1");
                    edit.commit();
                    b19.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but19",r19);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[19] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[19] = 1;
                    edit.putString("bn20","1");
                    edit.commit();
                    b20.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but20",r20);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[20] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[20] = 1;
                    edit.putString("bn21","1");
                    edit.commit();
                    b21.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but21",r21);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[21] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[21] = 1;
                    edit.putString("bn22","1");
                    edit.commit();
                    b22.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but22",r22);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[22] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[22] = 1;
                    edit.putString("bn23","1");
                    edit.commit();
                    b23.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but23",r23);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[23] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[23] = 1;
                    edit.putString("bn24","1");
                    edit.commit();
                    b24.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but24",r24);
                                startActivityForResult(p,56);
                                finish();

                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });
        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[24] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay2.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[24] = 1;
                    edit.putString("bn25","1");
                    edit.commit();
                    b25.setBackgroundColor(Color.parseColor("#F17C67"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay2.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+np);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p=new Intent(SPlay2.this,SPlay1.class);
                                p.putExtra("but25",r25);
                                startActivityForResult(p,56);
                                finish();
                            }
                        });
                        a.show();
                        Window window = a.getWindow();
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                    }
                }
            }
        });


        if(bnn1.equals("1"))
        {
            clickedb[0] = 1;
            b1.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn2.equals("1"))
        {
            clickedb[1] = 1;
            b2.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn3.equals("1"))
        {
            clickedb[2] = 1;
            b3.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn4.equals("1"))
        {
            clickedb[3] = 1;
            b4.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn5.equals("1"))
        {
            clickedb[4] = 1;
            b5.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn6.equals("1"))
        {
            clickedb[5] = 1;
            b6.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn7.equals("1"))
        {
            clickedb[6] = 1;
            b7.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn8.equals("1"))
        {
            clickedb[7] = 1;
            b8.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn9.equals("1"))
        {
            clickedb[8] = 1;
            b9.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn10.equals("1"))
        {
            clickedb[9] = 1;
            b10.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn11.equals("1"))
        {
            clickedb[10] = 1;
            b11.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn12.equals("1"))
        {
            clickedb[11] = 1;
            b12.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn13.equals("1"))
        {
            clickedb[12] = 1;
            b13.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn14.equals("1"))
        {
            clickedb[13] = 1;
            b14.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn15.equals("1"))
        {
            clickedb[14] = 1;
            b15.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn16.equals("1"))
        {
            clickedb[15] = 1;
            b16.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn17.equals("1"))
        {
            clickedb[16] = 1;
            b17.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn18.equals("1"))
        {
            clickedb[17] = 1;
            b18.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn19.equals("1"))
        {
            clickedb[18] = 1;
            b19.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn20.equals("1"))
        {
            clickedb[19] = 1;
            b20.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn21.equals("1"))
        {
            clickedb[20] = 1;
            b21.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn22.equals("1"))
        {
            clickedb[21] = 1;
            b22.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn23.equals("1"))
        {
            clickedb[22] = 1;
            b23.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn24.equals("1"))
        {
            clickedb[23] = 1;
            b24.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bnn25.equals("1"))
        {
            clickedb[24] = 1;
            b25.setBackgroundColor(Color.parseColor("#88C3FA"));
        }


        if(bn1.equals("1"))
        {
            clickedb[0] = 1;
            b1.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn2.equals("1"))
        {
            clickedb[1] = 1;
            b2.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn3.equals("1"))
        {
            clickedb[2] = 1;
            b3.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn4.equals("1"))
        {
            clickedb[3] = 1;
            b4.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn5.equals("1"))
        {
            clickedb[4] = 1;
            b5.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn6.equals("1"))
        {
            clickedb[5] = 1;
            b6.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn7.equals("1"))
        {
            clickedb[6] = 1;
            b7.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn8.equals("1"))
        {
            clickedb[7] = 1;
            b8.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn9.equals("1"))
        {
            clickedb[8] = 1;
            b9.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn10.equals("1"))
        {
            clickedb[9] = 1;
            b10.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn11.equals("1"))
        {
            clickedb[10] = 1;
            b11.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn12.equals("1"))
        {
            clickedb[11] = 1;
            b12.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn13.equals("1"))
        {
            clickedb[12] = 1;
            b13.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn14.equals("1"))
        {
            clickedb[13] = 1;
            b14.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn15.equals("1"))
        {
            clickedb[14] = 1;
            b15.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn16.equals("1"))
        {
            clickedb[15] = 1;
            b16.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn17.equals("1"))
        {
            clickedb[16] = 1;
            b17.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn18.equals("1"))
        {
            clickedb[17] = 1;
            b18.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn19.equals("1"))
        {
            clickedb[18] = 1;
            b19.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn20.equals("1"))
        {
            clickedb[19] = 1;
            b20.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn21.equals("1"))
        {
            clickedb[20] = 1;
            b21.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn22.equals("1"))
        {
            clickedb[21] = 1;
            b22.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn23.equals("1"))
        {
            clickedb[22] = 1;
            b23.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn24.equals("1"))
        {
            clickedb[23] = 1;
            b24.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(bn25.equals("1"))
        {
            clickedb[24] = 1;
            b25.setBackgroundColor(Color.parseColor("#F17C67"));
        }

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
        if (sum == 5|| sum>5) {
            tv2.setText("BINGO!!!");
            /*String s1 = "YOU WON!!!";
            Intent i = new Intent(PlayGame.this, ResultScreen.class);
            i.putExtra("Res1", s1);
            startActivityForResult(i, 101);*/
            //ADVERTISEMENT
            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

// Prepare the Interstitial Ad
            interstitial = new InterstitialAd(SPlay2.this);
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
            //a();

            //finish();

            SharedPreferences gsp= PreferenceManager.getDefaultSharedPreferences(this);
            final SharedPreferences.Editor edit = gsp.edit();

            Dialog d1=new Dialog(SPlay2.this);
            d1.setTitle("Result");
            d1.setContentView(R.layout.resu);
            d1.setCancelable(false);
            Button b1=(Button)d1.findViewById(R.id.b1);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db=openOrCreateDatabase("multidb",MODE_PRIVATE,null);
                    String w1="select *from mulco";
                    Cursor ca1=db.rawQuery(w1,null);
                    if(ca1.moveToFirst())
                    {
                        ca1.moveToLast();
                        String us=ca1.getString(ca1.getColumnIndex("user"));
                        String cp=ca1.getString(ca1.getColumnIndex("userr"));
                        int usr=Integer.parseInt(us);
                        int opp=Integer.parseInt(cp);
                        opp++;
                        String q=""+usr;
                        String z=""+opp;
                        String v1="insert into mulco values('"+q+"','"+z+"')";
                        db.execSQL(v1);
                        db.close();
                    }
                    else
                    {
                        Toast.makeText(SPlay2.this,"some error!!",Toast.LENGTH_SHORT).show();
                    }

                    if(playerr.isPlaying())
                    {
                        playerr.stop();
                    }

                    Intent i=new Intent(SPlay2.this,BackDialog.class);
                    startActivity(i);
                    edit.remove("bt1");
                    edit.remove("bt2");
                    edit.remove("bt3");
                    edit.remove("bt4");
                    edit.remove("bt5");
                    edit.remove("bt6");
                    edit.remove("bt7");
                    edit.remove("bt8");
                    edit.remove("bt9");
                    edit.remove("bt10");
                    edit.remove("bt11");
                    edit.remove("bt12");
                    edit.remove("bt13");
                    edit.remove("bt14");
                    edit.remove("bt15");
                    edit.remove("bt16");
                    edit.remove("bt17");
                    edit.remove("bt18");
                    edit.remove("bt19");
                    edit.remove("bt20");
                    edit.remove("bt21");
                    edit.remove("bt22");
                    edit.remove("bt23");
                    edit.remove("bt24");
                    edit.remove("bt25");
                    edit.remove("btt1");
                    edit.remove("btt2");
                    edit.remove("btt3");
                    edit.remove("btt4");
                    edit.remove("btt5");
                    edit.remove("btt6");
                    edit.remove("btt7");
                    edit.remove("btt8");
                    edit.remove("btt9");
                    edit.remove("btt10");
                    edit.remove("btt11");
                    edit.remove("btt12");
                    edit.remove("btt13");
                    edit.remove("btt14");
                    edit.remove("btt15");
                    edit.remove("btt16");
                    edit.remove("btt17");
                    edit.remove("btt18");
                    edit.remove("btt19");
                    edit.remove("btt20");
                    edit.remove("btt21");
                    edit.remove("btt22");
                    edit.remove("btt23");
                    edit.remove("btt24");
                    edit.remove("btt25");

                    edit.remove("bn1");
                    edit.remove("bn2");
                    edit.remove("bn3");
                    edit.remove("bn4");
                    edit.remove("bn5");
                    edit.remove("bn6");
                    edit.remove("bn7");
                    edit.remove("bn8");
                    edit.remove("bn9");
                    edit.remove("bn10");
                    edit.remove("bn11");
                    edit.remove("bn12");
                    edit.remove("bn13");
                    edit.remove("bn14");
                    edit.remove("bn15");
                    edit.remove("bn16");
                    edit.remove("bn17");
                    edit.remove("bn18");
                    edit.remove("bn19");
                    edit.remove("bn20");
                    edit.remove("bn21");
                    edit.remove("bn22");
                    edit.remove("bn23");
                    edit.remove("bn24");
                    edit.remove("bn25");
                    edit.remove("bnn1");
                    edit.remove("bnn2");
                    edit.remove("bnn3");
                    edit.remove("bnn4");
                    edit.remove("bnn5");
                    edit.remove("bnn6");
                    edit.remove("bnn7");
                    edit.remove("bnn8");
                    edit.remove("bnn9");
                    edit.remove("bnn10");
                    edit.remove("bnn11");
                    edit.remove("bnn12");
                    edit.remove("bnn13");
                    edit.remove("bnn14");
                    edit.remove("bnn15");
                    edit.remove("bnn16");
                    edit.remove("bnn17");
                    edit.remove("bnn18");
                    edit.remove("bnn19");
                    edit.remove("bnn20");
                    edit.remove("bnn21");
                    edit.remove("bnn22");
                    edit.remove("bnn23");
                    edit.remove("bnn24");
                    edit.remove("bnn25");
                    edit.commit();
                    finish();
                }
            });

            Button b2=(Button)d1.findViewById(R.id.b2);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(playerr.isPlaying())
                    {
                        playerr.stop();
                    }
                    Intent i=new Intent(SPlay2.this,MainActivity.class);
                    startActivity(i);
                    edit.remove("bt1");
                    edit.remove("bt2");
                    edit.remove("bt3");
                    edit.remove("bt4");
                    edit.remove("bt5");
                    edit.remove("bt6");
                    edit.remove("bt7");
                    edit.remove("bt8");
                    edit.remove("bt9");
                    edit.remove("bt10");
                    edit.remove("bt11");
                    edit.remove("bt12");
                    edit.remove("bt13");
                    edit.remove("bt14");
                    edit.remove("bt15");
                    edit.remove("bt16");
                    edit.remove("bt17");
                    edit.remove("bt18");
                    edit.remove("bt19");
                    edit.remove("bt20");
                    edit.remove("bt21");
                    edit.remove("bt22");
                    edit.remove("bt23");
                    edit.remove("bt24");
                    edit.remove("bt25");
                    edit.remove("btt1");
                    edit.remove("btt2");
                    edit.remove("btt3");
                    edit.remove("btt4");
                    edit.remove("btt5");
                    edit.remove("btt6");
                    edit.remove("btt7");
                    edit.remove("btt8");
                    edit.remove("btt9");
                    edit.remove("btt10");
                    edit.remove("btt11");
                    edit.remove("btt12");
                    edit.remove("btt13");
                    edit.remove("btt14");
                    edit.remove("btt15");
                    edit.remove("btt16");
                    edit.remove("btt17");
                    edit.remove("btt18");
                    edit.remove("btt19");
                    edit.remove("btt20");
                    edit.remove("btt21");
                    edit.remove("btt22");
                    edit.remove("btt23");
                    edit.remove("btt24");
                    edit.remove("btt25");

                    edit.remove("bn1");
                    edit.remove("bn2");
                    edit.remove("bn3");
                    edit.remove("bn4");
                    edit.remove("bn5");
                    edit.remove("bn6");
                    edit.remove("bn7");
                    edit.remove("bn8");
                    edit.remove("bn9");
                    edit.remove("bn10");
                    edit.remove("bn11");
                    edit.remove("bn12");
                    edit.remove("bn13");
                    edit.remove("bn14");
                    edit.remove("bn15");
                    edit.remove("bn16");
                    edit.remove("bn17");
                    edit.remove("bn18");
                    edit.remove("bn19");
                    edit.remove("bn20");
                    edit.remove("bn21");
                    edit.remove("bn22");
                    edit.remove("bn23");
                    edit.remove("bn24");
                    edit.remove("bn25");
                    edit.remove("bnn1");
                    edit.remove("bnn2");
                    edit.remove("bnn3");
                    edit.remove("bnn4");
                    edit.remove("bnn5");
                    edit.remove("bnn6");
                    edit.remove("bnn7");
                    edit.remove("bnn8");
                    edit.remove("bnn9");
                    edit.remove("bnn10");
                    edit.remove("bnn11");
                    edit.remove("bnn12");
                    edit.remove("bnn13");
                    edit.remove("bnn14");
                    edit.remove("bnn15");
                    edit.remove("bnn16");
                    edit.remove("bnn17");
                    edit.remove("bnn18");
                    edit.remove("bnn19");
                    edit.remove("bnn20");
                    edit.remove("bnn21");
                    edit.remove("bnn22");
                    edit.remove("bnn23");
                    edit.remove("bnn24");
                    edit.remove("bnn25");
                    edit.commit();
                    finish();
                }
            });
            d1.show();
        }
    }

    public void a()
    {
        final Dialog d1=new Dialog(SPlay2.this);
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
                    Toast.makeText(SPlay2.this,"some error!!",Toast.LENGTH_SHORT).show();
                }


                Intent i = new Intent(SPlay2.this, SinglePlay.class);
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

                Intent i = new Intent(SPlay2.this, MainActivity.class);
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
        int[] arr = {8,9};
        int rand = (int) (Math.random() * 2);
        int w = arr[rand];

        if (c == w) {
            /*String s2 = "YOU LOST!!!";
            Intent i = new Intent(PlayGame.this, ResultScreenLost.class);
            i.putExtra("Res2", s2);
            startActivityForResult(i, 102);*/

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
                        Toast.makeText(SPlay2.this,"some error!!",Toast.LENGTH_SHORT).show();
                    }

                    Intent i = new Intent(SPlay2.this, SinglePlay.class);
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

                    Intent i = new Intent(SPlay2.this, MainActivity.class);
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
        SharedPreferences gsp= PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor edit = gsp.edit();

        final Dialog d= new Dialog(SPlay2.this);
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
                Intent i=new Intent(SPlay2.this,MainActivity.class);
                startActivity(i);
                edit.remove("bt1");
                edit.remove("bt2");
                edit.remove("bt3");
                edit.remove("bt4");
                edit.remove("bt5");
                edit.remove("bt6");
                edit.remove("bt7");
                edit.remove("bt8");
                edit.remove("bt9");
                edit.remove("bt10");
                edit.remove("bt11");
                edit.remove("bt12");
                edit.remove("bt13");
                edit.remove("bt14");
                edit.remove("bt15");
                edit.remove("bt16");
                edit.remove("bt17");
                edit.remove("bt18");
                edit.remove("bt19");
                edit.remove("bt20");
                edit.remove("bt21");
                edit.remove("bt22");
                edit.remove("bt23");
                edit.remove("bt24");
                edit.remove("bt25");
                edit.remove("btt1");
                edit.remove("btt2");
                edit.remove("btt3");
                edit.remove("btt4");
                edit.remove("btt5");
                edit.remove("btt6");
                edit.remove("btt7");
                edit.remove("btt8");
                edit.remove("btt9");
                edit.remove("btt10");
                edit.remove("btt11");
                edit.remove("btt12");
                edit.remove("btt13");
                edit.remove("btt14");
                edit.remove("btt15");
                edit.remove("btt16");
                edit.remove("btt17");
                edit.remove("btt18");
                edit.remove("btt19");
                edit.remove("btt20");
                edit.remove("btt21");
                edit.remove("btt22");
                edit.remove("btt23");
                edit.remove("btt24");
                edit.remove("btt25");

                edit.remove("bn1");
                edit.remove("bn2");
                edit.remove("bn3");
                edit.remove("bn4");
                edit.remove("bn5");
                edit.remove("bn6");
                edit.remove("bn7");
                edit.remove("bn8");
                edit.remove("bn9");
                edit.remove("bn10");
                edit.remove("bn11");
                edit.remove("bn12");
                edit.remove("bn13");
                edit.remove("bn14");
                edit.remove("bn15");
                edit.remove("bn16");
                edit.remove("bn17");
                edit.remove("bn18");
                edit.remove("bn19");
                edit.remove("bn20");
                edit.remove("bn21");
                edit.remove("bn22");
                edit.remove("bn23");
                edit.remove("bn24");
                edit.remove("bn25");
                edit.remove("bnn1");
                edit.remove("bnn2");
                edit.remove("bnn3");
                edit.remove("bnn4");
                edit.remove("bnn5");
                edit.remove("bnn6");
                edit.remove("bnn7");
                edit.remove("bnn8");
                edit.remove("bnn9");
                edit.remove("bnn10");
                edit.remove("bnn11");
                edit.remove("bnn12");
                edit.remove("bnn13");
                edit.remove("bnn14");
                edit.remove("bnn15");
                edit.remove("bnn16");
                edit.remove("bnn17");
                edit.remove("bnn18");
                edit.remove("bnn19");
                edit.remove("bnn20");
                edit.remove("bnn21");
                edit.remove("bnn22");
                edit.remove("bnn23");
                edit.remove("bnn24");
                edit.remove("bnn25");
                edit.commit();
                finish();
            }
        });
        d.show();
    }

    public void color(int i)
    {
        if(i==0)
        {
            b1.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==1)
        {
            b2.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==2)
        {
            b3.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==3)
        {
            b4.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==4)
        {
            b5.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==5)
        {
            b6.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==6)
        {
            b7.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==7)
        {
            b8.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==8)
        {
            b9.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==9)
        {
            b10.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==10)
        {
            b11.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==11)
        {
            b12.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==12)
        {
            b13.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==13)
        {
            b14.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==14)
        {
            b15.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==15)
        {
            b16.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==16)
        {
            b17.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==17)
        {
            b18.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==18)
        {
            b19.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==19)
        {
            b20.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==20)
        {
            b21.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==21)
        {
            b22.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==22)
        {
            b23.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==23)
        {
            b24.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(i==24)
        {
            b25.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}
