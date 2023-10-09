package com.myfirstgame.tictactoe;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class TicTacToe extends AppCompatActivity {
    boolean gameactive=true;
    int active_player = 0;
    int [] state = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int [][] winning_positions = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void gameReset(View view){
        gameactive=true;
        active_player = 0;
        Arrays.fill(state, 2);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        TextView statusText = findViewById(R.id.statusText);
        statusText.setText("X's Turn-Tap to Play");
    }
    public void clicked(View v){
        ImageView view = (ImageView) v;
        int positionClicked = ((Integer.parseInt(v.getTag().toString()))-1);
        if (!gameactive){
            gameReset(v);
        }
        if (state[positionClicked]==2){
            state[positionClicked]=active_player;
            v.setTranslationY(-1000F);
            if (active_player == 0){
                view.setImageResource(R.drawable.x);
                active_player=1;
                TextView statusText = findViewById(R.id.statusText);
                statusText.setText("O's Turn- Tap to play");
            }else {
                view.setImageResource(R.drawable.zero);
                active_player=0;
                TextView statusText = findViewById(R.id.statusText);
                statusText.setText("X's Turn- Tap to play");
            }
            v.animate().translationYBy(1000f).setDuration(250);
        }
        for (int [] win : winning_positions){
            if (state[win[0]-1]==state[win[1]-1]&&state[win[1]-1]==state[win[2]-1] && state[win[0]-1]!=2){
                String winner="";

                if (state[win[0]-1]==0){
                    winner="X has won!!";
                } else{
                    winner="O has won!!";
                }
                gameactive=false;
                TextView statusText = findViewById(R.id.statusText);
                statusText.setText(winner);
            }
        }
    }
}