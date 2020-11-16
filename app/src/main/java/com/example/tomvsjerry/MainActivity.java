package com.example.tomvsjerry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //tom = 0
    //jerry = 1
    // blank = 2
    int activeplayer = 0;
    int[] gamestate= {2,2,2,2,2,2,2,2,2};

    int[][] winpos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void PlayerTap(View view)
    {
        ImageView img = (ImageView) view;

        int tappedimg = Integer.parseInt(img.getTag().toString());

        if(gamestate[tappedimg] == 2) {
            gamestate[tappedimg] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.tom);
                activeplayer = 1;
               TextView status = findViewById(R.id.status);
               status.setText("Jerrys Turn");
            } else {

                img.setImageResource(R.drawable.jerry);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("Toms Turn");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }

        // check if anyplayer has win
        for(int[] winpos: winpos)
        {
            if(gamestate[winpos[0]] == gamestate[winpos[1]] && gamestate[winpos[1]] == gamestate[winpos[2]] && gamestate[winpos[0]]!=2)
            {
                // somebody has won
                String winner = "jj";
                if(gamestate[winpos[0]] == 0)
                {
                    winner = "Tom has won";
                    for (int i=0;i<gamestate.length;i++)
                    {
                        gamestate[i] =0;
                    }
                }
                else
                {
                    winner = "Jerry has Won";
                    for (int i=0;i<gamestate.length;i++)
                    {
                        gamestate[i] =1;
                    }

                }
                //winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winner);
            }

        }

    }
    public void reset(View view)
    {
        activeplayer = 0;
        for (int i=0;i<gamestate.length;i++)
        {
            gamestate[i] =2;
        }
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);

        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);

        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("Toms Turn");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}