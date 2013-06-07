package ca.on.rom.romsearch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayExhibitActivity extends Activity {
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		setContentView(R.layout.activity_display_exhibit);
		
		//ensure Honeycomb or higher to use ActionBar APIs
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			//show the up button in the action bar
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		//setup grid
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));
		
		//Listen for click on image
		gridview.setOnItemClickListener(new OnItemClickListener() {
			/*NOTE: this needs to change. Currently displays only a number, 
			needs to display a pop-up screen*/
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast.makeText(DisplayExhibitActivity.this, "" + position, Toast.LENGTH_SHORT).show();
			}
		});
		
		//get exhibit title
		String exhibit = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		TextView textview = (TextView) findViewById(R.id.exhibit_title);
		textview.setText(exhibit);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_exhibit, menu);
		return true;
	}
	

}
