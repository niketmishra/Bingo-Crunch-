package com.snicket.premsourav.bingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        iv1=(ImageView)findViewById(R.id.iv1);

        Thread t=new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch (Exception e)
                {

                }

                Intent i=new Intent(Splash.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        };
        t.start();
    }
}
