package net.redlinesoft.app.plusclaver;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

	// game lavel
	private Integer GAME_LEVEL = 1;
	
	// game score
	private Integer GAME_SCORE = 0;
	
	// overall correct answer
	private Integer GAME_ANSWER = 0;
	
	// overall have answer
	private Integer GAME_GETANSWER = 0;
	
	// overall time out
	public Integer GAME_TIMEOUT = 5;
	
	// result for puls score
	public Integer GAME_RESULT = 1;
	
	// question string
	private String GAME_QUESTION = "";
	
	// ratio for change level
	public Integer GAME_RATIO = 10;
	
	// ratio count
	public Integer GAME_RATIO_COUNT = 0;
 
	
	Handler handler = new Handler();
	Timer timer = new Timer(); 
	TimerTask timetask; 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game); 
		
		// initial value for first start
		GAME_GETANSWER=1;
		// set all answer button to false
		setButton(false);
		doTask();
		
		/*		
		// get question via level
		getQuestion(GAME_LEVEL);

		// set data
		setData2View(GAME_QUESTION);
 		*/
		
		// initial button
		Button buttonChoice1 = (Button) findViewById(R.id.button1);
		Button buttonChoice2 = (Button) findViewById(R.id.button2);
		Button buttonChoice3 = (Button) findViewById(R.id.button3);
		Button buttonChoice4 = (Button) findViewById(R.id.button4);
		Button buttonChoice5 = (Button) findViewById(R.id.button5);
		Button buttonChoice6 = (Button) findViewById(R.id.button6);
		Button buttonChoice7 = (Button) findViewById(R.id.button7);
		Button buttonChoice8 = (Button) findViewById(R.id.button8);
		Button buttonChoice9 = (Button) findViewById(R.id.button9);
		Button buttonChoice10 = (Button) findViewById(R.id.button10);

		// button lisener
		buttonChoice1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (GAME_ANSWER == 0) {
					GAME_SCORE = GAME_SCORE + 1;
					GAME_RATIO_COUNT = GAME_RATIO_COUNT +1;
					GAME_RESULT = 1;
				} else {
					GAME_RESULT = 0;
					stopTask();
				}
				updateScoreView();
			}
		});

		buttonChoice2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (GAME_ANSWER == 1) {
					GAME_SCORE = GAME_SCORE + 1;
					GAME_RATIO_COUNT = GAME_RATIO_COUNT +1;
					GAME_RESULT = 1;
				} else {
					GAME_RESULT = 0;
					stopTask();
				}
				updateScoreView();
			}
		});

		buttonChoice3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (GAME_ANSWER == 2) {
					GAME_SCORE = GAME_SCORE + 1;
					GAME_RATIO_COUNT = GAME_RATIO_COUNT +1;
					GAME_RESULT = 1;
				} else {
					GAME_RESULT = 0;
					stopTask();
				}
				updateScoreView();
			}
		});

		buttonChoice4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (GAME_ANSWER == 3) {
					GAME_SCORE = GAME_SCORE + 1;
					GAME_RATIO_COUNT = GAME_RATIO_COUNT +1;
					GAME_RESULT = 1;
				} else {
					GAME_RESULT = 0;
					stopTask();
				}
				updateScoreView();
			}
		});

		buttonChoice5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (GAME_ANSWER == 4) {
					GAME_SCORE = GAME_SCORE + 1;
					GAME_RATIO_COUNT = GAME_RATIO_COUNT +1;
					GAME_RESULT = 1;
				} else {
					GAME_RESULT = 0;
					stopTask();
				}
				updateScoreView();
			}
		});

		buttonChoice6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (GAME_ANSWER == 5) {
					GAME_SCORE = GAME_SCORE + 1;
					GAME_RATIO_COUNT = GAME_RATIO_COUNT +1;
					GAME_RESULT = 1;
				} else {
					GAME_RESULT = 0;
					stopTask();
				}
				updateScoreView();
			}
		});

		buttonChoice7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (GAME_ANSWER == 6) {
					GAME_SCORE = GAME_SCORE + 1;
					GAME_RATIO_COUNT = GAME_RATIO_COUNT +1;
					GAME_RESULT = 1;
				} else {
					GAME_RESULT = 0;
					stopTask();
				}
				updateScoreView();
			}
		});

		buttonChoice8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (GAME_ANSWER == 7) {
					GAME_SCORE = GAME_SCORE + 1;
					GAME_RATIO_COUNT = GAME_RATIO_COUNT +1;
					GAME_RESULT = 1;
				} else {
					GAME_RESULT = 0;
					stopTask();
				}
				updateScoreView();
			}
		});

		buttonChoice9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (GAME_ANSWER == 8) {
					GAME_SCORE = GAME_SCORE + 1;
					GAME_RATIO_COUNT = GAME_RATIO_COUNT +1;
					GAME_RESULT = 1;
				} else {
					GAME_RESULT = 0;
					stopTask();
				}
				updateScoreView();
			}
		});

		buttonChoice10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (GAME_ANSWER == 9) {
					GAME_SCORE = GAME_SCORE + 1;
					GAME_RATIO_COUNT = GAME_RATIO_COUNT +1;
					GAME_RESULT = 1;
				} else {
					GAME_RESULT = 0;
					stopTask();
				}
				updateScoreView();
			}

		});  
		
	}


	public void stopTask() {
		// TODO Auto-generated method stub
		setButton(false);
		timetask.cancel();
		final AlertDialog.Builder adb = new AlertDialog.Builder(this);
		adb.setTitle("Game Over!");
		adb.setMessage("Your score = "+ String.valueOf(GAME_SCORE));
		adb.show();
	}
 
	public void doTask(){		
		timetask = new TimerTask() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				handler.post(new Runnable() {					
					@Override
					public void run() {
						// check for timeout if not anwser then stop timer
						
						if (GAME_GETANSWER==1) {
							GAME_GETANSWER=0;
							setButton(true);
							getNewQuestion();
						} else {
							GAME_GETANSWER=0;
							stopTask();
						} 			
					}					
				});
			} 
		};
		timer.schedule(timetask, 0, (GAME_TIMEOUT*1000)); 
	}
	 
	public void getNewQuestion() {
		// get question via level
		getQuestion(GAME_LEVEL);
		// set data
		setData2View(GAME_QUESTION);
	}
	
	protected void updateScoreView() {
		// TODO Auto-generated method stub
		TextView textScore = (TextView) findViewById(R.id.textScore);
		textScore.setText(String.valueOf(GAME_SCORE));		
		GAME_GETANSWER=1;
		// check game ratio and change level
		if (GAME_RATIO_COUNT >= GAME_RATIO) {
			GAME_LEVEL=GAME_LEVEL+1;
			GAME_RATIO_COUNT=0;
		}
		// disable button
		setButton(false);
	}
	 
	
	private void setButton(Boolean value) {
		// TODO noob code will change later it prevent pump score
		Button buttonChoice1 = (Button) findViewById(R.id.button1);
		Button buttonChoice2 = (Button) findViewById(R.id.button2);
		Button buttonChoice3 = (Button) findViewById(R.id.button3);
		Button buttonChoice4 = (Button) findViewById(R.id.button4);
		Button buttonChoice5 = (Button) findViewById(R.id.button5);
		Button buttonChoice6 = (Button) findViewById(R.id.button6);
		Button buttonChoice7 = (Button) findViewById(R.id.button7);
		Button buttonChoice8 = (Button) findViewById(R.id.button8);
		Button buttonChoice9 = (Button) findViewById(R.id.button9);
		Button buttonChoice10 = (Button) findViewById(R.id.button10);
		// set enable or disable
		buttonChoice1.setEnabled(value);
		buttonChoice2.setEnabled(value);
		buttonChoice3.setEnabled(value);
		buttonChoice4.setEnabled(value);
		buttonChoice5.setEnabled(value);
		buttonChoice6.setEnabled(value);
		buttonChoice7.setEnabled(value);
		buttonChoice8.setEnabled(value);
		buttonChoice9.setEnabled(value);
		buttonChoice10.setEnabled(value); 
	}

	public void setTimeOut(Integer val) {
		// TODO Auto-generated method stub
		TextView textScore = (TextView) findViewById(R.id.textScore);
		textScore.setText(String.valueOf(val));
	}

	private void setData2View(String question) {
		// set text question
		TextView textQuestion = (TextView) findViewById(R.id.textQuestion);
		textQuestion.setText(question);
		// set text timeout
		TextView textTimeOut = (TextView) findViewById(R.id.textTimeOut);
		textTimeOut.setText(String.valueOf(GAME_TIMEOUT));
		// set game score
		TextView textScore = (TextView) findViewById(R.id.textScore);
		textScore.setText(String.valueOf(GAME_SCORE));
	}

	private void getQuestion(Integer level) {
		// TODO Auto-generated method stub
		Integer totalNumber = level + 1;

		// if level more than 9 then set to 9 and change algorithms
		if (level >= 9)
			level = 9;

		// random number 0-9 for total number
		Integer i, intVar, intSum = 0, intAnswer = 0;
		String questionNumber = "";
		for (i = 0; i < totalNumber; i++) {
			intVar = (int) (Math.random() * 9);
			intSum += intVar;
			questionNumber += String.valueOf(intVar);
		}
		// set question
		this.GAME_QUESTION = questionNumber;
		Log.d("APP", "Question : " + GAME_QUESTION);

		// find answer check number of lenght
		Integer lenghtSum = String.valueOf(intSum).length();
		Log.d("APP", "Sum Lenght : " + String.valueOf(intSum).length());
		// TODO if lenght is more than 2 should change this
		if (lenghtSum >= 2) {
			// char1 + char2
			String sumChar = String.valueOf(intSum);
			intAnswer = Integer.parseInt(sumChar.substring(0, 1).toString());
			Log.d("APP", "Q1 : " + sumChar.substring(0, 1).toString());
			Log.d("APP", "Q2 : " + sumChar.substring(1, 2).toString());
			intAnswer = Integer.parseInt(sumChar.substring(0, 1))
					+ Integer.parseInt(sumChar.substring(1, 2));
		} else {
			// char1
			intAnswer = intSum;
			Log.d("APP", "Q1 : " + String.valueOf(intSum));
		}
		this.GAME_ANSWER = intAnswer;
		Log.d("APP", "Answer : " + GAME_ANSWER);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_game, menu);
		return true;
	}
}
