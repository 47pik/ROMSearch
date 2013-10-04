package ca.on.rom.romsearch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity{
	
	private int initialPaddingTop = 0;
	
	@SuppressLint({ "NewApi", "InlinedApi" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Following line is for testing when there is no bottom nav-bar.
//		getWindow().getDecorView()
//        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		setCorrectSpacing();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//reload the save in case new savedata has been written
		setCorrectSpacing();
	}
	
	public void goToExhibits(View view) {
		startActivity(new Intent(this, ChooseExhibitActivity.class));
	}
	
	public void setCorrectSpacing() {
		DisplayMetrics metrics = new DisplayMetrics();
		LinearLayout main = (LinearLayout) findViewById(R.id.mainmenu);
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		if (initialPaddingTop == 0){
			initialPaddingTop = main.getPaddingTop();
		}		
		if (metrics.heightPixels == 1280){
			// XHDPI device; no nav-bar
			main.setPadding(0, initialPaddingTop + 48, 0, main.getPaddingBottom());
		} else if (metrics.heightPixels == 1920){
			// XXHDPI device; no nav-bar
			main.setPadding(0, initialPaddingTop + 144, 0, main.getPaddingBottom());
		}
	}
	public void goToAchievements(View view) {
		startActivity(new Intent(this, AchievementListActivity.class));	
	}
}
