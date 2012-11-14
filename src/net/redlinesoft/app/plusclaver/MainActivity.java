package net.redlinesoft.app.plusclaver;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	// type facce
	Typeface face;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        
        // set typeface for text all game
        face=Typeface.createFromAsset(getAssets(),"fonts/Arabica.ttf");
        
        TextView textTitle = (TextView) findViewById(R.id.textTitle);
        textTitle.setTypeface(face); 
        
        Button buttPlay = (Button) findViewById(R.id.buttonStart);
        buttPlay.setTypeface(face);
        buttPlay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,GameActivity.class);
		        startActivity(intent);
			}
        	
        }); 
        
        Button buttCredit = (Button) findViewById(R.id.buttonCredit);
        buttCredit.setTypeface(face);
        buttCredit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,AboutActivity.class);
		        startActivity(intent);
				
			}
		});
        
        Button buttScore = (Button) findViewById(R.id.buttonScore);        
        buttScore.setTypeface(face);
        buttScore.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
