package com.example.mohit.fb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private TextView Loginpage;
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Loginpage = (TextView)findViewById(R.id.tvloginpage);
        username = (EditText) findViewById(R.id.etusername);
        password=(EditText)findViewById(R.id.etpassword);
        login = (Button)findViewById(R.id.btn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(),password.getText().toString());
            }
        });
    }



    private void validate(String userName,String passWord )
    {
        if((userName.equals("acm")) && (passWord.equals("acm123")))
        {
            Intent intent = new Intent(login.this,acmlogin.class);
            startActivity(intent);
        }
        else if(userName.equals("acses")&&(passWord.equals("acses123")))
        {
            Intent intent = new Intent(login.this,acseslogin.class);
            startActivity(intent);
        }
        else if(userName.equals("artcircle")&&(passWord.equals("artcircle123")))
        {
            Intent intent = new Intent(login.this,artlogin.class);
            startActivity(intent);
        }
        else if(userName.equals("cesa")&&(passWord.equals("cesa123")))
        {
            Intent intent = new Intent(login.this,cesalogin.class);
            startActivity(intent);
        }
        else if(userName.equals("eesa")&&(passWord.equals("eesa123")))
        {
            Intent intent = new Intent(login.this,eesalogin.class);
            startActivity(intent);
        }
        else if(userName.equals("elesa")&&(passWord.equals("elesa123")))
        {
            Intent intent = new Intent(login.this,elesalogin.class);
            startActivity(intent);
        }
        else if(userName.equals("mesa")&&(passWord.equals("mesa123")))
        {
            Intent intent = new Intent(login.this,MainActivity.class);
            startActivity(intent);
        }
        else if(userName.equals("pace")&&(passWord.equals("pace123")))
        {
            Intent intent = new Intent(login.this,pacelogin.class);
            startActivity(intent);
        }
        else if(userName.equals("rotaract")&&(passWord.equals("rotaract123")))
        {
            Intent intent = new Intent(login.this,rotaractlogin.class);
            startActivity(intent);
        }
        else if(userName.equals("sait")&&(passWord.equals("sait123")))
        {
            Intent intent = new Intent(login.this,saitlogin.class);
            startActivity(intent);
        }
        else if(userName.equals("vision")&&(passWord.equals("vision123")))
        {
            Intent intent = new Intent(login.this,visionlogin.class);
            startActivity(intent);
        }
        else if(userName.equals("wlug")&&(passWord.equals("wlug123")))
        {
            Intent intent = new Intent(login.this,wluglogin.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(login.this,"Please Enter correct Crediantials",Toast.LENGTH_LONG).show();
        }

    }
}
