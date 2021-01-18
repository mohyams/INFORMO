package com.example.mohit.fb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.darwindeveloper.horizontalscrollmenulibrary.custom_views.HorizontalScrollMenuView;
import com.darwindeveloper.horizontalscrollmenulibrary.extras.MenuItem;

public class club extends AppCompatActivity {

    private Button button;
    private Button butabout;
    HorizontalScrollMenuView menu;
    TextView textview;
    ImageButton imgbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        butabout=(Button)findViewById(R.id.btnabout);
        butabout.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(club.this, AboutUs.class);
                                            startActivity(intent);
                                        }
                                    });
        button=(Button)findViewById(R.id.btnlogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(club.this,login.class);
                startActivity(intent);
            }
        });

        menu = (HorizontalScrollMenuView) findViewById(R.id.menu);

        initMenu();

    }

    private void initMenu() {

        menu.addItem("ACM",R.drawable.acm );
        menu.addItem("ACSES",R.drawable.acses );
        menu.addItem("ARTCIRCLE",R.drawable.art );
        menu.addItem("CESA",R.drawable.cesa );
        menu.addItem("EESA",R.drawable.eesa );
        menu.addItem("ELESA",R.drawable.elesa );
        menu.addItem("MESA",R.drawable.mesa );
        menu.addItem("PACE",R.drawable.logo );
        menu.addItem("ROTARACT",R.drawable.rotaract);
        menu.addItem("SAIT",R.drawable.sait );
        menu.addItem("VISION",R.drawable.vision );
        menu.addItem("WLUG",R.drawable.wlug );

        menu.setOnHSMenuClickListener(new HorizontalScrollMenuView.OnHSMenuClickListener() {
            @Override
            public void onHSMClick(MenuItem menuItem, int position) {
                if(position==0) {
                    Intent intent = new Intent(club.this, acmdisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to ACM",Toast.LENGTH_SHORT).show();
                }
                else if(position == 1){
                    Intent intent = new Intent(club.this,acsesdisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to ACSES",Toast.LENGTH_SHORT).show();
                }
                else if(position == 2)
                {
                    Intent intent = new Intent(club.this, artdisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to ARTCIRCLE",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3)
                {
                    Intent intent = new Intent(club.this, cesadisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to CESA",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4)
                {
                    Intent intent = new Intent(club.this, eesadisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to EESA",Toast.LENGTH_SHORT).show();
                }
                else if(position == 5)
                {
                    Intent intent = new Intent(club.this, elesadisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to ELESA",Toast.LENGTH_SHORT).show();
                }
                else if(position == 6)
                {
                    Intent intent = new Intent(club.this, mesadisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to MESA",Toast.LENGTH_SHORT).show();
                }
                else if(position == 7)
                {
                    Intent intent = new Intent(club.this, pacedisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to PACE",Toast.LENGTH_SHORT).show();
                }
                else if(position == 8)
                {
                    Intent intent = new Intent(club.this, rotaractdisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to ROTARACT",Toast.LENGTH_SHORT).show();
                }
                else if(position == 9)
                {
                    Intent intent = new Intent(club.this, saitdisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to SAIT",Toast.LENGTH_SHORT).show();
                }
                else if(position == 10)
                {
                    Intent intent = new Intent(club.this, visiondisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to VISION",Toast.LENGTH_SHORT).show();
                }
                else if(position == 11)
                {
                    Intent intent = new Intent(club.this, wlugdisplay.class);
                    startActivity(intent);
                    Toast.makeText(club.this,"Welcome to WLUG",Toast.LENGTH_SHORT).show();
                }
                }

        });





    }
}
