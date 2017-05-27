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


public class SPlay1 extends AppCompatActivity {


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
        Cursor ca=db.rawQuery(h,null);
        ca.moveToLast();
        final String n1=ca.getString(ca.getColumnIndex("user"));
        tv1.setText(n1);
        db.close();

        db=openOrCreateDatabase("playertwo",MODE_PRIVATE,null);
        String wa="select *from playtwo";
        Cursor cq=db.rawQuery(wa,null);
        cq.moveToLast();
        String jk=cq.getString(cq.getColumnIndex("user"));
        tv3.setText(jk);
        db.close();

        db=openOrCreateDatabase("fillfirst",MODE_PRIVATE,null);
        String y="select *from fillone";
        Cursor cr=db.rawQuery(y,null);
        cr.moveToLast();
        final String k1 = cr.getString(cr.getColumnIndex("a1"));
        final String k2 = cr.getString(cr.getColumnIndex("a2"));
        final String k3 = cr.getString(cr.getColumnIndex("a3"));
        final String k4 = cr.getString(cr.getColumnIndex("a4"));
        final String k5 = cr.getString(cr.getColumnIndex("a5"));
        final String k6 = cr.getString(cr.getColumnIndex("a6"));
        final String k7 = cr.getString(cr.getColumnIndex("a7"));
        final String k8 = cr.getString(cr.getColumnIndex("a8"));
        final String k9 = cr.getString(cr.getColumnIndex("a9"));
        final String k10 = cr.getString(cr.getColumnIndex("a10"));
        final String k11 = cr.getString(cr.getColumnIndex("a11"));
        final String k12 = cr.getString(cr.getColumnIndex("a12"));
        final String k13 = cr.getString(cr.getColumnIndex("a13"));
        final String k14 = cr.getString(cr.getColumnIndex("a14"));
        final String k15 = cr.getString(cr.getColumnIndex("a15"));
        final String k16 = cr.getString(cr.getColumnIndex("a16"));
        final String k17 = cr.getString(cr.getColumnIndex("a17"));
        final String k18 = cr.getString(cr.getColumnIndex("a18"));
        final String k19 = cr.getString(cr.getColumnIndex("a19"));
        final String k20 = cr.getString(cr.getColumnIndex("a20"));
        final String k21 = cr.getString(cr.getColumnIndex("a21"));
        final String k22 = cr.getString(cr.getColumnIndex("a22"));
        final String k23 = cr.getString(cr.getColumnIndex("a23"));
        final String k24 = cr.getString(cr.getColumnIndex("a24"));
        final String k25 = cr.getString(cr.getColumnIndex("a25"));

        b1.setText(k1);
        b2.setText(k2);
        b3.setText(k3);
        b4.setText(k4);
        b5.setText(k5);
        b6.setText(k6);
        b7.setText(k7);
        b8.setText(k8);
        b9.setText(k9);
        b10.setText(k10);
        b11.setText(k11);
        b12.setText(k12);
        b13.setText(k13);
        b14.setText(k14);
        b15.setText(k15);
        b16.setText(k16);
        b17.setText(k17);
        b18.setText(k18);
        b19.setText(k19);
        b20.setText(k20);
        b21.setText(k21);
        b22.setText(k22);
        b23.setText(k23);
        b24.setText(k24);
        b25.setText(k25);
        db.close();

        int a1=Integer.parseInt(k1);
        int a2=Integer.parseInt(k2);
        int a3=Integer.parseInt(k3);
        int a4=Integer.parseInt(k4);
        int a5=Integer.parseInt(k5);
        int a6=Integer.parseInt(k6);
        int a7=Integer.parseInt(k7);
        int a8=Integer.parseInt(k8);
        int a9=Integer.parseInt(k9);
        int a10=Integer.parseInt(k10);
        int a11=Integer.parseInt(k11);
        int a12=Integer.parseInt(k12);
        int a13=Integer.parseInt(k13);
        int a14=Integer.parseInt(k14);
        int a15=Integer.parseInt(k15);
        int a16=Integer.parseInt(k16);
        int a17=Integer.parseInt(k17);
        int a18=Integer.parseInt(k18);
        int a19=Integer.parseInt(k19);
        int a20=Integer.parseInt(k20);
        int a21=Integer.parseInt(k21);
        int a22=Integer.parseInt(k22);
        int a23=Integer.parseInt(k23);
        int a24=Integer.parseInt(k24);
        int a25=Integer.parseInt(k25);

        int[] arr={a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25};

        SharedPreferences gsp= PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor edit = gsp.edit();
        String bt1=gsp.getString("bt1","");
        String bt2=gsp.getString("bt2","");
        String bt3=gsp.getString("bt3","");
        String bt4=gsp.getString("bt4","");
        String bt5=gsp.getString("bt5","");
        String bt6=gsp.getString("bt6","");
        String bt7=gsp.getString("bt7","");
        String bt8=gsp.getString("bt8","");
        String bt9=gsp.getString("bt9","");
        String bt10=gsp.getString("bt10","");
        String bt11=gsp.getString("bt11","");
        String bt12=gsp.getString("bt12","");
        String bt13=gsp.getString("bt13","");
        String bt14=gsp.getString("bt14","");
        String bt15=gsp.getString("bt15","");
        String bt16=gsp.getString("bt16","");
        String bt17=gsp.getString("bt17","");
        String bt18=gsp.getString("bt18","");
        String bt19=gsp.getString("bt19","");
        String bt20=gsp.getString("bt20","");
        String bt21=gsp.getString("bt21","");
        String bt22=gsp.getString("bt22","");
        String bt23=gsp.getString("bt23","");
        String bt24=gsp.getString("bt24","");
        String bt25=gsp.getString("bt25","");


        String btt1=gsp.getString("btt1","");
        String btt2=gsp.getString("btt2","");
        String btt3=gsp.getString("btt3","");
        String btt4=gsp.getString("btt4","");
        String btt5=gsp.getString("btt5","");
        String btt6=gsp.getString("btt6","");
        String btt7=gsp.getString("btt7","");
        String btt8=gsp.getString("btt8","");
        String btt9=gsp.getString("btt9","");
        String btt10=gsp.getString("btt10","");
        String btt11=gsp.getString("btt11","");
        String btt12=gsp.getString("btt12","");
        String btt13=gsp.getString("btt13","");
        String btt14=gsp.getString("btt14","");
        String btt15=gsp.getString("btt15","");
        String btt16=gsp.getString("btt16","");
        String btt17=gsp.getString("btt17","");
        String btt18=gsp.getString("btt18","");
        String btt19=gsp.getString("btt19","");
        String btt20=gsp.getString("btt20","");
        String btt21=gsp.getString("btt21","");
        String btt22=gsp.getString("btt22","");
        String btt23=gsp.getString("btt23","");
        String btt24=gsp.getString("btt24","");
        String btt25=gsp.getString("btt25","");

        Intent ri=getIntent();
        Bundle b=ri.getExtras();
        if(ri.hasExtra("but1"))
        {
            String q1=b.getString("but1");
            int j1=Integer.parseInt(q1);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j1)
                    break;
            }

            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but2"))
        {
            String q2=b.getString("but2");
            int j2=Integer.parseInt(q2);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j2)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but3"))
        {
            String q3=b.getString("but3");
            int j3=Integer.parseInt(q3);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j3)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but4"))
        {
            String q4=b.getString("but4");
            int j4=Integer.parseInt(q4);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j4)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but5"))
        {
            String q5=b.getString("but5");
            int j5=Integer.parseInt(q5);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j5)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but6"))
        {
            String q6=b.getString("but6");
            int j6=Integer.parseInt(q6);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j6)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but7"))
        {
            String q7=b.getString("but7");
            int j7=Integer.parseInt(q7);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j7)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but8"))
        {
            String q8=b.getString("but8");
            int j8=Integer.parseInt(q8);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j8)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but9"))
        {
            String q9=b.getString("but9");
            int j9=Integer.parseInt(q9);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j9)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but10"))
        {
            String q10=b.getString("but10");
            int j10=Integer.parseInt(q10);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j10)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but11"))
        {
            String q11=b.getString("but11");
            int j11=Integer.parseInt(q11);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j11)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but12"))
        {
            String q12=b.getString("but12");
            int j12=Integer.parseInt(q12);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j12)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but13"))
        {
            String q13=b.getString("but13");
            int j13=Integer.parseInt(q13);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j13)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but14"))
        {
            String q14=b.getString("but14");
            int j14=Integer.parseInt(q14);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j14)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but15"))
        {
            String q15=b.getString("but15");
            int j15=Integer.parseInt(q15);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j15)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but16"))
        {
            String q16=b.getString("but16");
            int j16=Integer.parseInt(q16);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j16)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but17"))
        {
            String q17=b.getString("but17");
            int j17=Integer.parseInt(q17);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j17)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but18"))
        {
            String q18=b.getString("but18");
            int j18=Integer.parseInt(q18);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j18)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but19"))
        {
            String q19=b.getString("but19");
            int j19=Integer.parseInt(q19);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j19)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but20"))
        {
            String q20=b.getString("but20");
            int j20=Integer.parseInt(q20);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j20)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but21"))
        {
            String q21=b.getString("but21");
            int j21=Integer.parseInt(q21);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j21)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but22"))
        {
            String q22=b.getString("but22");
            int j22=Integer.parseInt(q22);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j22)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but23"))
        {
            String q23=b.getString("but23");
            int j23=Integer.parseInt(q23);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j23)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but24"))
        {
            String q24=b.getString("but24");
            int j24=Integer.parseInt(q24);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j24)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
                edit.commit();
            }
            clickedb[i]=1;
            color(i);
        }
        if(ri.hasExtra("but25"))
        {
            String q25=b.getString("but25");
            int j25=Integer.parseInt(q25);
            for(i=0;i<25;i++)
            {
                if(arr[i]==j25)
                    break;
            }
            if(i==0)
            {
                edit.putString("btt1","1");
                edit.commit();
            }
            if(i==1)
            {
                edit.putString("btt2","1");
                edit.commit();
            }
            if(i==2)
            {
                edit.putString("btt3","1");
                edit.commit();
            }
            if(i==3)
            {
                edit.putString("btt4","1");
                edit.commit();
            }
            if(i==4)
            {
                edit.putString("btt5","1");
                edit.commit();
            }
            if(i==5)
            {
                edit.putString("btt6","1");
                edit.commit();
            }
            if(i==6)
            {
                edit.putString("btt7","1");
                edit.commit();
            }
            if(i==7)
            {
                edit.putString("btt8","1");
                edit.commit();
            }
            if(i==8)
            {
                edit.putString("btt9","1");
                edit.commit();
            }
            if(i==9)
            {
                edit.putString("btt10","1");
                edit.commit();
            }
            if(i==10)
            {
                edit.putString("btt11","1");
                edit.commit();
            }
            if(i==11)
            {
                edit.putString("btt12","1");
                edit.commit();
            }
            if(i==12)
            {
                edit.putString("btt13","1");
                edit.commit();
            }
            if(i==13)
            {
                edit.putString("btt14","1");
                edit.commit();
            }
            if(i==14)
            {
                edit.putString("btt15","1");
                edit.commit();
            }
            if(i==15)
            {
                edit.putString("btt16","1");
                edit.commit();
            }
            if(i==16)
            {
                edit.putString("btt17","1");
                edit.commit();
            }
            if(i==17)
            {
                edit.putString("btt18","1");
                edit.commit();
            }
            if(i==18)
            {
                edit.putString("btt19","1");
                edit.commit();
            }
            if(i==19)
            {
                edit.putString("btt20","1");
                edit.commit();
            }
            if(i==20)
            {
                edit.putString("btt21","1");
                edit.commit();
            }
            if(i==21)
            {
                edit.putString("btt22","1");
                edit.commit();
            }
            if(i==22)
            {
                edit.putString("btt23","1");
                edit.commit();
            }
            if(i==23)
            {
                edit.putString("btt24","1");
                edit.commit();
            }
            if(i==24)
            {
                edit.putString("btt25","1");
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

        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(Color.parseColor("#88C3FA"));
                Toast.makeText(SPlay1.this,"here!!",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(SPlay1.this,SPlay2.class);
                startActivity(i);
            }
        });*/
        db=openOrCreateDatabase("playertwo",MODE_PRIVATE,null);
        String waa="select *from playtwo";
        Cursor qcd=db.rawQuery(waa,null);
        qcd.moveToLast();
        final String jkk=qcd.getString(qcd.getColumnIndex("user"));
        db.close();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clickedb[0] != 1) {
                    if(playerr==null)
                    {
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[0] = 1;
                    edit.putString("bt1","1");
                    edit.commit();
                    b1.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        //are you sure
                        //if yes then execute below code
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setContentView(R.layout.pass);
                        a.setCancelable(false);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu1",k1);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[1] = 1;
                    edit.putString("bt2","1");
                    edit.commit();
                    b2.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setContentView(R.layout.pass);
                        a.setCancelable(false);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu2",k2);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[2] = 1;
                    edit.putString("bt3","1");
                    edit.commit();
                    b3.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setContentView(R.layout.pass);
                        a.setCancelable(false);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu3",k3);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[3] = 1;
                    edit.putString("bt4","1");
                    edit.commit();
                    b4.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setContentView(R.layout.pass);
                        a.setCancelable(false);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu4",k4);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[4] = 1;
                    edit.putString("bt5","1");
                    edit.commit();
                    b5.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu5",k5);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[5] = 1;
                    edit.putString("bt6","1");
                    edit.commit();
                    b6.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu6",k6);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[6] = 1;
                    edit.putString("bt7","1");
                    edit.commit();
                    b7.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu7",k7);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[7] = 1;
                    edit.putString("bt8","1");
                    edit.commit();
                    b8.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu8",k8);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[8] = 1;
                    edit.putString("bt9","1");
                    edit.commit();
                    b9.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu9",k9);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[9] = 1;
                    edit.putString("bt10","1");
                    edit.commit();
                    b10.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu10",k10);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[10] = 1;
                    edit.putString("bt11","1");
                    edit.commit();
                    b11.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu11",k11);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[11] = 1;
                    edit.putString("bt12","1");
                    edit.commit();
                    b12.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu12",k12);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[12] = 1;
                    edit.putString("bt13","1");
                    edit.commit();
                    b13.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu13",k13);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[13] = 1;
                    edit.putString("bt14","1");
                    edit.commit();
                    b14.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu14",k14);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[14] = 1;
                    edit.putString("bt15","1");
                    edit.commit();
                    b15.setBackgroundColor(Color.parseColor("#88C3FA"));

                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu15",k15);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[15] = 1;
                    edit.putString("bt16","1");
                    edit.commit();
                    b16.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu16",k16);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[16] = 1;
                    edit.putString("bt17","1");
                    edit.commit();
                    b17.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu17",k17);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[17] = 1;
                    edit.putString("bt18","1");
                    edit.commit();
                    b18.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu18",k18);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[18] = 1;
                    edit.putString("bt19","1");
                    edit.commit();
                    b19.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu19",k19);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[19] = 1;
                    edit.putString("bt20","1");
                    edit.commit();
                    b20.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu20",k20);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[20] = 1;
                    edit.putString("bt21","1");
                    edit.commit();
                    b21.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu21",k21);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[21] = 1;
                    edit.putString("bt22","1");
                    edit.commit();
                    b22.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu22",k22);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[22] = 1;
                    edit.putString("bt23","1");
                    edit.commit();
                    b23.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu23",k23);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[23] = 1;
                    edit.putString("bt24","1");
                    edit.commit();
                    b24.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu24",k24);
                                startActivityForResult(h,56);
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
                        playerr=MediaPlayer.create(SPlay1.this,R.raw.beep);
                    }
                    playerr.start();
                    clickedb[24] = 1;
                    edit.putString("bt25","1");
                    edit.commit();
                    b25.setBackgroundColor(Color.parseColor("#88C3FA"));
                    disa();
                    comp(clickedb[0], clickedb[1], clickedb[2], clickedb[3], clickedb[4], clickedb[5], clickedb[6], clickedb[7], clickedb[8], clickedb[9], clickedb[10], clickedb[11], clickedb[12], clickedb[13], clickedb[14], clickedb[15], clickedb[16], clickedb[17], clickedb[18], clickedb[19], clickedb[20], clickedb[21], clickedb[22], clickedb[23], clickedb[24]);
                    if (sum < 5) {
                        Dialog a=new Dialog(SPlay1.this);
                        a.setTitle("Pass");
                        a.setCancelable(false);
                        a.setContentView(R.layout.pass);
                        TextView tv1=(TextView)a.findViewById(R.id.tv1);
                        tv1.setText("Pass the phone to \n "+jkk);
                        Button b1=(Button)a.findViewById(R.id.b1);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent h=new Intent(SPlay1.this,SPlay2.class);
                                h.putExtra("bu25",k25);
                                startActivityForResult(h,56);
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


        if(btt1.equals("1"))
        {
            clickedb[0] = 1;
            b1.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt2.equals("1"))
        {
            clickedb[1] = 1;
            b2.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt3.equals("1"))
        {
            clickedb[2] = 1;
            b3.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt4.equals("1"))
        {
            clickedb[3] = 1;
            b4.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt5.equals("1"))
        {
            clickedb[4] = 1;
            b5.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt6.equals("1"))
        {
            clickedb[5] = 1;
            b6.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt7.equals("1"))
        {
            clickedb[6] = 1;
            b7.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt8.equals("1"))
        {
            clickedb[7] = 1;
            b8.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt9.equals("1"))
        {
            clickedb[8] = 1;
            b9.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt10.equals("1"))
        {
            clickedb[9] = 1;
            b10.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt11.equals("1"))
        {
            clickedb[10] = 1;
            b11.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt12.equals("1"))
        {
            clickedb[11] = 1;
            b12.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt13.equals("1"))
        {
            clickedb[12] = 1;
            b13.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt14.equals("1"))
        {
            clickedb[13] = 1;
            b14.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt15.equals("1"))
        {
            clickedb[14] = 1;
            b15.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt16.equals("1"))
        {
            clickedb[15] = 1;
            b16.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt17.equals("1"))
        {
            clickedb[16] = 1;
            b17.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt18.equals("1"))
        {
            clickedb[17] = 1;
            b18.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt19.equals("1"))
        {
            clickedb[18] = 1;
            b19.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt20.equals("1"))
        {
            clickedb[19] = 1;
            b20.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt21.equals("1"))
        {
            clickedb[20] = 1;
            b21.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt22.equals("1"))
        {
            clickedb[21] = 1;
            b22.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt23.equals("1"))
        {
            clickedb[22] = 1;
            b23.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt24.equals("1"))
        {
            clickedb[23] = 1;
            b24.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(btt25.equals("1"))
        {
            clickedb[24] = 1;
            b25.setBackgroundColor(Color.parseColor("#F17C67"));
        }



        if(bt1.equals("1"))
        {
            clickedb[0] = 1;
            b1.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt2.equals("1"))
        {
            clickedb[1] = 1;
            b2.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt3.equals("1"))
        {
            clickedb[2] = 1;
            b3.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt4.equals("1"))
        {
            clickedb[3] = 1;
            b4.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt5.equals("1"))
        {
            clickedb[4] = 1;
            b5.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt6.equals("1"))
        {
            clickedb[5] = 1;
            b6.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt7.equals("1"))
        {
            clickedb[6] = 1;
            b7.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt8.equals("1"))
        {
            clickedb[7] = 1;
            b8.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt9.equals("1"))
        {
            clickedb[8] = 1;
            b9.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt10.equals("1"))
        {
            clickedb[9] = 1;
            b10.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt11.equals("1"))
        {
            clickedb[10] = 1;
            b11.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt12.equals("1"))
        {
            clickedb[11] = 1;
            b12.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt13.equals("1"))
        {
            clickedb[12] = 1;
            b13.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt14.equals("1"))
        {
            clickedb[13] = 1;
            b14.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt15.equals("1"))
        {
            clickedb[14] = 1;
            b15.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt16.equals("1"))
        {
            clickedb[15] = 1;
            b16.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt17.equals("1"))
        {
            clickedb[16] = 1;
            b17.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt18.equals("1"))
        {
            clickedb[17] = 1;
            b18.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt19.equals("1"))
        {
            clickedb[18] = 1;
            b19.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt20.equals("1"))
        {
            clickedb[19] = 1;
            b20.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt21.equals("1"))
        {
            clickedb[20] = 1;
            b21.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt22.equals("1"))
        {
            clickedb[21] = 1;
            b22.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt23.equals("1"))
        {
            clickedb[22] = 1;
            b23.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt24.equals("1"))
        {
            clickedb[23] = 1;
            b24.setBackgroundColor(Color.parseColor("#88C3FA"));
        }
        if(bt25.equals("1"))
        {
            clickedb[24] = 1;
            b25.setBackgroundColor(Color.parseColor("#88C3FA"));
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
            interstitial = new InterstitialAd(SPlay1.this);
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

            final Dialog d1=new Dialog(SPlay1.this);
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
                        usr++;
                        String q=""+usr;
                        String z=""+opp;
                        String v1="insert into mulco values('"+q+"','"+z+"')";
                        db.execSQL(v1);
                        db.close();
                    }
                    else
                    {
                        Toast.makeText(SPlay1.this,"some error!!",Toast.LENGTH_SHORT).show();
                    }
                    if(playerr.isPlaying())
                    {
                        playerr.stop();
                    }

                    Intent i=new Intent(SPlay1.this,BackDialog.class);
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
                    Intent i=new Intent(SPlay1.this,MainActivity.class);
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
        final Dialog d1=new Dialog(SPlay1.this);
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
                    Toast.makeText(SPlay1.this,"some error!!",Toast.LENGTH_SHORT).show();
                }


                Intent i = new Intent(SPlay1.this, SinglePlay.class);
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

                Intent i = new Intent(SPlay1.this, MainActivity.class);
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
                        Toast.makeText(SPlay1.this,"some error!!",Toast.LENGTH_SHORT).show();
                    }

                    Intent i = new Intent(SPlay1.this, SinglePlay.class);
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

                    Intent i = new Intent(SPlay1.this, MainActivity.class);
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
        final Dialog d= new Dialog(SPlay1.this);
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
                Intent i=new Intent(SPlay1.this,MainActivity.class);
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
            b1.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==1)
        {
            b2.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==2)
        {
            b3.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==3)
        {
            b4.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==4)
        {
            b5.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==5)
        {
            b6.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==6)
        {
            b7.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==7)
        {
            b8.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==8)
        {
            b9.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==9)
        {
            b10.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==10)
        {
            b11.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==11)
        {
            b12.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==12)
        {
            b13.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==13)
        {
            b14.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==14)
        {
            b15.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==15)
        {
            b16.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==16)
        {
            b17.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==17)
        {
            b18.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==18)
        {
            b19.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==19)
        {
            b20.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==20)
        {
            b21.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==21)
        {
            b22.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==22)
        {
            b23.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==23)
        {
            b24.setBackgroundColor(Color.parseColor("#F17C67"));
        }
        if(i==24)
        {
            b25.setBackgroundColor(Color.parseColor("#F17C67"));
        }
    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}
