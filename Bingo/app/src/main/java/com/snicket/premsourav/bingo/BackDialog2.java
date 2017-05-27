package com.snicket.premsourav.bingo;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BackDialog2 extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_back_dialog);

        db=openOrCreateDatabase("playertwo",MODE_PRIVATE,null);
        String q="create table if not exists playtwo(user varchar)";
        db.execSQL(q);

        Dialog t= new Dialog(BackDialog2.this);
        t.setTitle("Player 2");
        t.setContentView(R.layout.play2);
        t.setCancelable(false);
        final EditText et1=(EditText)t.findViewById(R.id.et1);
        Button b1=(Button)t.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m=et1.getText().toString();
                if(m.matches(""))
                {
                    Toast.makeText(BackDialog2.this,"Please enter a name",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String v1="insert into playtwo values('"+m+"')";
                    db.execSQL(v1);
                    Intent i=new Intent(BackDialog2.this,Fill2.class);
                    startActivity(i);
                    finish();
                }
            }
        });
        t.show();
        Window window = t.getWindow();
        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
    }
}
