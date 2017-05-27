package com.snicket.premsourav.bingo;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Fill2 extends AppCompatActivity{

    int id = 0;
    final String arr[] = new String[25];
    String s;
    TextView tv1;
    SQLiteDatabase db;
    ImageButton ib1,ib2,bb1;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_single_play);

        tv1=(TextView)findViewById(R.id.tv1);
        ib1=(ImageButton)findViewById(R.id.ib1);
        ib2=(ImageButton)findViewById(R.id.ib2);

        bb1 = (ImageButton) findViewById(R.id.bb1);

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

        if(player==null)
        {
            player=MediaPlayer.create(this,R.raw.binbeat);
        }
        player.start();
        player.setLooping(true);

        db=openOrCreateDatabase("playertwo",MODE_PRIVATE,null);
        String wa="select *from playtwo";
        Cursor cq=db.rawQuery(wa,null);
        cq.moveToLast();
        String n1=cq.getString(cq.getColumnIndex("user"));
        tv1.setText(n1);
        db.close();

        db=openOrCreateDatabase("fillsecond",MODE_PRIVATE,null);
        String pd="create table if not exists filltwo(a1 varchar,a2 varchar,a3 varchar,a4 varchar,a5 varchar,a6 varchar,a7 varchar,a8 varchar,a9 varchar,a10 varchar,a11 varchar,a12 varchar,a13 varchar,a14 varchar,a15 varchar,a16 varchar,a17 varchar,a18 varchar,a19 varchar,a20 varchar,a21 varchar,a22 varchar,a23 varchar,a24 varchar,a25 varchar)";
        db.execSQL(pd);


        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=0;
                b1.setText("a");
                b2.setText("a");
                b3.setText("a");
                b4.setText("a");
                b5.setText("a");
                b6.setText("a");
                b7.setText("a");
                b8.setText("a");
                b9.setText("a");
                b10.setText("a");
                b11.setText("a");
                b12.setText("a");
                b13.setText("a");
                b14.setText("a");
                b15.setText("a");
                b16.setText("a");
                b17.setText("a");
                b18.setText("a");
                b19.setText("a");
                b20.setText("a");
                b21.setText("a");
                b22.setText("a");
                b23.setText("a");
                b24.setText("a");
                b25.setText("a");
                b1.setTextColor(Color.TRANSPARENT);
                b2.setTextColor(Color.TRANSPARENT);
                b3.setTextColor(Color.TRANSPARENT);
                b4.setTextColor(Color.TRANSPARENT);
                b5.setTextColor(Color.TRANSPARENT);
                b6.setTextColor(Color.TRANSPARENT);
                b7.setTextColor(Color.TRANSPARENT);
                b8.setTextColor(Color.TRANSPARENT);
                b9.setTextColor(Color.TRANSPARENT);
                b10.setTextColor(Color.TRANSPARENT);
                b11.setTextColor(Color.TRANSPARENT);
                b12.setTextColor(Color.TRANSPARENT);
                b13.setTextColor(Color.TRANSPARENT);
                b14.setTextColor(Color.TRANSPARENT);
                b15.setTextColor(Color.TRANSPARENT);
                b16.setTextColor(Color.TRANSPARENT);
                b17.setTextColor(Color.TRANSPARENT);
                b18.setTextColor(Color.TRANSPARENT);
                b19.setTextColor(Color.TRANSPARENT);
                b20.setTextColor(Color.TRANSPARENT);
                b21.setTextColor(Color.TRANSPARENT);
                b22.setTextColor(Color.TRANSPARENT);
                b23.setTextColor(Color.TRANSPARENT);
                b24.setTextColor(Color.TRANSPARENT);
                b25.setTextColor(Color.TRANSPARENT);
            }
        });

        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerTwo();

                /*String s1=b1.getText().toString();
                String s2=b2.getText().toString();
                String s3=b3.getText().toString();
                String s4=b4.getText().toString();
                String s5=b5.getText().toString();
                String s6=b6.getText().toString();
                String s7=b7.getText().toString();
                String s8=b8.getText().toString();
                String s9=b9.getText().toString();
                String s10=b10.getText().toString();
                String s11=b11.getText().toString();
                String s12=b12.getText().toString();
                String s13=b13.getText().toString();
                String s14=b14.getText().toString();
                String s15=b15.getText().toString();
                String s16=b16.getText().toString();
                String s17=b17.getText().toString();
                String s18=b18.getText().toString();
                String s19=b19.getText().toString();
                String s20=b20.getText().toString();
                String s21=b21.getText().toString();
                String s22=b22.getText().toString();
                String s23=b23.getText().toString();
                String s24=b24.getText().toString();
                String s25=b25.getText().toString();

                if(s1.equals("a") || s2.equals("a") || s3.equals("a") || s4.equals("a") || s5.equals("a") || s6.equals("a") || s7.equals("a") || s8.equals("a") || s9.equals("a") || s10.equals("a") || s11.equals("a") || s12.equals("a") || s13.equals("a") || s14.equals("a") || s15.equals("a") || s16.equals("a") || s17.equals("a") || s18.equals("a") || s19.equals("a") || s20.equals("a") || s21.equals("a") || s22.equals("a") || s23.equals("a") || s24.equals("a") || s25.equals("a"))
                {
                    Toast.makeText(Fill1.this, "FILL ALL THE BOXES!!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(Fill1.this, PlayGame.class);
                    i.putExtra("n1",s1);
                    i.putExtra("n2",s2);
                    i.putExtra("n3",s3);
                    i.putExtra("n4",s4);
                    i.putExtra("n5",s5);
                    i.putExtra("n6",s6);
                    i.putExtra("n7",s7);
                    i.putExtra("n8",s8);
                    i.putExtra("n9",s9);
                    i.putExtra("n10",s10);
                    i.putExtra("n11",s11);
                    i.putExtra("n12",s12);
                    i.putExtra("n13",s13);
                    i.putExtra("n14",s14);
                    i.putExtra("n15",s15);
                    i.putExtra("n16",s16);
                    i.putExtra("n17",s17);
                    i.putExtra("n18",s18);
                    i.putExtra("n19",s19);
                    i.putExtra("n20",s20);
                    i.putExtra("n21",s21);
                    i.putExtra("n22",s22);
                    i.putExtra("n23",s23);
                    i.putExtra("n24",s24);
                    i.putExtra("n25",s25);

                    startActivityForResult(i,97);
                    finish();
                }*/
            }
        });

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] a = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"};
                final String arr[] = new String[25];
                int i, n = 25;
                for (i = 0; i < n; i++) {
                    int s = i + (int) (Math.random() * (n - i));
                    String temp = a[s];
                    a[s] = a[i];
                    a[i] = temp;
                }

                for (i = 0; i < 25; i++) {
                    arr[i] = a[i];
                }

                b1.setText(arr[0]);
                b1.setTextColor(Color.parseColor("#000000"));
                b2.setText(arr[1]);
                b2.setTextColor(Color.parseColor("#000000"));
                b3.setText(arr[2]);
                b3.setTextColor(Color.parseColor("#000000"));
                b4.setText(arr[3]);
                b4.setTextColor(Color.parseColor("#000000"));
                b5.setText(arr[4]);
                b5.setTextColor(Color.parseColor("#000000"));
                b6.setText(arr[5]);
                b6.setTextColor(Color.parseColor("#000000"));
                b7.setText(arr[6]);
                b7.setTextColor(Color.parseColor("#000000"));
                b8.setText(arr[7]);
                b8.setTextColor(Color.parseColor("#000000"));
                b9.setText(arr[8]);
                b9.setTextColor(Color.parseColor("#000000"));
                b10.setText(arr[9]);
                b10.setTextColor(Color.parseColor("#000000"));
                b11.setText(arr[10]);
                b11.setTextColor(Color.parseColor("#000000"));
                b12.setText(arr[11]);
                b12.setTextColor(Color.parseColor("#000000"));
                b13.setText(arr[12]);
                b13.setTextColor(Color.parseColor("#000000"));
                b14.setText(arr[13]);
                b14.setTextColor(Color.parseColor("#000000"));
                b15.setText(arr[14]);
                b15.setTextColor(Color.parseColor("#000000"));
                b16.setText(arr[15]);
                b16.setTextColor(Color.parseColor("#000000"));
                b17.setText(arr[16]);
                b17.setTextColor(Color.parseColor("#000000"));
                b18.setText(arr[17]);
                b18.setTextColor(Color.parseColor("#000000"));
                b19.setText(arr[18]);
                b19.setTextColor(Color.parseColor("#000000"));
                b20.setText(arr[19]);
                b20.setTextColor(Color.parseColor("#000000"));
                b21.setText(arr[20]);
                b21.setTextColor(Color.parseColor("#000000"));
                b22.setText(arr[21]);
                b22.setTextColor(Color.parseColor("#000000"));
                b23.setText(arr[22]);
                b23.setTextColor(Color.parseColor("#000000"));
                b24.setText(arr[23]);
                b24.setTextColor(Color.parseColor("#000000"));
                b25.setText(arr[24]);
                b25.setTextColor(Color.parseColor("#000000"));
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b1.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b1.setText("" + id);
                    b1.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b2.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b2.setText("" + id);
                    b2.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b3.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b3.setText("" + id);
                    b3.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b4.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b4.setText("" + id);
                    b4.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b5.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b5.setText("" + id);
                    b5.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b6.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b6.setText("" + id);
                    b6.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b7.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b7.setText("" + id);
                    b7.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b8.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b8.setText("" + id);
                    b8.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b9.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b9.setText("" + id);
                    b9.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b10.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b10.setText("" + id);
                    b10.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b11.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b11.setText("" + id);
                    b11.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b12.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b12.setText("" + id);
                    b12.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b13.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b13.setText("" + id);
                    b13.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b14.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b14.setText("" + id);
                    b14.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b15.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b15.setText("" + id);
                    b15.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b16.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b16.setText("" + id);
                    b16.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b17.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b17.setText("" + id);
                    b17.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b18.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b18.setText("" + id);
                    b18.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b19.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b19.setText("" + id);
                    b19.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b20.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b20.setText("" + id);
                    b20.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b21.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b21.setText("" + id);
                    b21.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b22.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b22.setText("" + id);
                    b22.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b23.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b23.setText("" + id);
                    b23.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b24.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b24.setText("" + id);
                    b24.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = b25.getText().toString();
                if (s.equals("a")) {
                    id++;
                    b25.setText("" + id);
                    b25.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        final Dialog d= new Dialog(Fill2.this);
        d.setTitle("Return?");
        d.setContentView(R.layout.returnmain);
        Button b1=(Button)d.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.isPlaying())
                {
                    player.stop();
                }
                Intent i=new Intent(Fill2.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        d.show();
    }

    void playerTwo()
    {
        String s1=b1.getText().toString();
        String s2=b2.getText().toString();
        String s3=b3.getText().toString();
        String s4=b4.getText().toString();
        String s5=b5.getText().toString();
        String s6=b6.getText().toString();
        String s7=b7.getText().toString();
        String s8=b8.getText().toString();
        String s9=b9.getText().toString();
        String s10=b10.getText().toString();
        String s11=b11.getText().toString();
        String s12=b12.getText().toString();
        String s13=b13.getText().toString();
        String s14=b14.getText().toString();
        String s15=b15.getText().toString();
        String s16=b16.getText().toString();
        String s17=b17.getText().toString();
        String s18=b18.getText().toString();
        String s19=b19.getText().toString();
        String s20=b20.getText().toString();
        String s21=b21.getText().toString();
        String s22=b22.getText().toString();
        String s23=b23.getText().toString();
        String s24=b24.getText().toString();
        String s25=b25.getText().toString();

        if(s1.equals("a") || s2.equals("a") || s3.equals("a") || s4.equals("a") || s5.equals("a") || s6.equals("a") || s7.equals("a") || s8.equals("a") || s9.equals("a") || s10.equals("a") || s11.equals("a") || s12.equals("a") || s13.equals("a") || s14.equals("a") || s15.equals("a") || s16.equals("a") || s17.equals("a") || s18.equals("a") || s19.equals("a") || s20.equals("a") || s21.equals("a") || s22.equals("a") || s23.equals("a") || s24.equals("a") || s25.equals("a"))
        {
            Toast.makeText(Fill2.this, "FILL ALL THE BOXES!!!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(player.isPlaying())
            {
                player.stop();
            }
            String v1="insert into filltwo values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"','"+s11+"','"+s12+"','"+s13+"','"+s14+"','"+s15+"','"+s16+"','"+s17+"','"+s18+"','"+s19+"','"+s20+"','"+s21+"','"+s22+"','"+s23+"','"+s24+"','"+s25+"')";
            db.execSQL(v1);
            db.close();
            Intent i = new Intent(Fill2.this, SPlay1.class);
            startActivity(i);
            finish();
        }
    }
}