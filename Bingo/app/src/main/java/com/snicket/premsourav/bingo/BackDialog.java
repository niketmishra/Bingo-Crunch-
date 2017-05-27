package com.snicket.premsourav.bingo;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BackDialog extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_back_dialog);

        db=openOrCreateDatabase("playerone",MODE_PRIVATE,null);
        String q="create table if not exists playone(user varchar)";
        db.execSQL(q);

        Dialog t= new Dialog(BackDialog.this);
        t.setTitle("Player 1");
        t.setContentView(R.layout.play1);
        t.setCancelable(false);
        final EditText et1=(EditText)t.findViewById(R.id.et1);
        Button b1=(Button)t.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m=et1.getText().toString();
                if(m.matches(""))
                {
                    Toast.makeText(BackDialog.this,"Please enter a name",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SharedPreferences gsp= PreferenceManager.getDefaultSharedPreferences(BackDialog.this);
                    SharedPreferences.Editor edit = gsp.edit();
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


                    String v1="insert into playone values('"+m+"')";
                    db.execSQL(v1);
                    Intent i=new Intent(BackDialog.this,Fill1.class);
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
