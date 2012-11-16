package net.redlinesoft.app.plusclaver;

import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	// type facce
	Typeface face;
	
	private MediaPlayer mMediaPlayer = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main); 
      
        // set typeface for text all game
        face=Typeface.createFromAsset(getAssets(),"fonts/Arabica.ttf");
        
        // initial database
        final DatabaseHandler myDb = new DatabaseHandler(this);
		myDb.getWritableDatabase();
        
        // check config for username
		if (myDb.getConfigRow()==0) {
			// if config equal zero shoud prompt user to enter a name to record score
			Log.d("APP","No config data let user enter a name");
			
			final Context context = this;			 
			final Dialog dialog = new Dialog(context);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setCancelable(false);
			dialog.setContentView(R.layout.config_layout);
			
			TextView textConfigTitle = (TextView) dialog.findViewById(R.id.textConfigTitle);
			textConfigTitle.setTypeface(face);
			
			final EditText textName = (EditText) dialog.findViewById(R.id.editTextName);
			textName.setTypeface(face);
			
			Button buttonSave = (Button) dialog.findViewById(R.id.buttonSave);
			buttonSave.setTypeface(face);
			
			buttonSave.setOnClickListener(new OnClickListener() {				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.d("APP","Save config");
					String strName = textName.getText().toString();
					myDb.InsterConfig(1,strName);
					dialog.dismiss();
				}
			});
			dialog.show(); 
		}
		
		// check internet connection to update leaderboard from redmobi score services
		if (checkNetworkStatus()) {
			// TODO update leaderboard data
			Log.d("APP","Upadte leaderboard score form redmobi services");
		}
        
        
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
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		//stopSound();
		finish();
	}

	/*
	 * Play Sound
	 */
	private void playSound(int resources) {
		// TODO Auto-generated method stub
		if (mMediaPlayer != null) {
			mMediaPlayer.stop();
			mMediaPlayer.release();
		}
		mMediaPlayer = MediaPlayer.create(this,resources);
		mMediaPlayer.setLooping(true);
		mMediaPlayer.start(); 
	}
	

	private void stopSound() {
		if (mMediaPlayer != null) {
			mMediaPlayer.stop();
			mMediaPlayer.release();
		}
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("APP","On Pause");
		pauseSound();
	}

	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
		Log.d("APP","On Post Pause");
		playSound(R.raw.song);
	}
 
	private void pauseSound() {
		if (mMediaPlayer != null) {
			mMediaPlayer.pause();
		}
	}


	public boolean checkNetworkStatus() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager
				.getActiveNetworkInfo();
		return activeNetworkInfo != null;
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
