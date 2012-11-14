package net.redlinesoft.app.plusclaver;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class AboutActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_about);
        
     // type facce
    	Typeface face;
    	
    	face=Typeface.createFromAsset(getAssets(),"fonts/Arabica.ttf");
    	
    	TextView textHelpTitle = (TextView) findViewById(R.id.textHelpTitle);
    	textHelpTitle.setTypeface(face);
    	
    	TextView textHelp = (TextView) findViewById(R.id.textHelp);
    	textHelp.setTypeface(face);
    	
    	TextView textCreditTitle = (TextView) findViewById(R.id.textCreditTitle);
    	textCreditTitle.setTypeface(face);
    	
    	TextView textCredit = (TextView) findViewById(R.id.textCredit);
    	textCredit.setTypeface(face);
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_about, menu);
        return true;
    }
}
