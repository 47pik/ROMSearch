package ca.on.rom.romsearch;


import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayExhibitActivity extends FragmentActivity
									implements InputNameDialogFragment.InputNameDialogListener{
	
	
	public final static String EXTRA_MESSAGE2 ="com.example.R.MESSAGE";
	
	public static String exhibit;
	public static Integer[] image_ids;
	public static Integer[] image_thumbs;
	public static String[] image_names;
	public static int pos = 0;
	
	public static ExhibitData savedata;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		setContentView(R.layout.activity_display_exhibit);
		
		//get exhibit title
		exhibit = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		TextView textview = (TextView) findViewById(R.id.exhibit_title);
		textview.setText(exhibit);
		//get image names and ids
		image_names = GridData.getNames().get(exhibit);
		image_ids = GridData.getImages().get(exhibit);
		image_thumbs = GridData.getThumbs().get(exhibit);
		//get savedata
		String data = intent.getStringExtra(MainActivity.EXTRA_SAVEFILE);
		savedata = new ExhibitData(data);
		
		//ensure Honeycomb or higher to use ActionBar APIs
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			//show the up button in the action bar
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		//setup grids
		GridView gridview = (GridView) findViewById(R.id.gridview); //for images
		gridview.setAdapter(new ImageAdapter(this, image_thumbs));
		GridView overlay = (GridView) findViewById(R.id.overlay); //for completion image
		overlay.setAdapter(new ImageAdapter(this, savedata.getOverlay()));
		//Listen for click on overlay
		overlay.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				//get clicked on image, and set the dialog to contain it
				pos = position;
				if (savedata.getArr()[pos]) {
					//if item already completed display info
					DialogFragment dialog = DisplayItemDialogFragment.newInstance(image_ids[pos]);
					FragmentManager fm = getSupportFragmentManager();
					dialog.show(fm, "display_item");
				} else {
					//if item has not been completed, ask for input
					DialogFragment dialog = InputNameDialogFragment.newInstance(image_ids[pos]);	
					FragmentManager fm = getSupportFragmentManager();
					dialog.show(fm, "input_name");
				}
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_exhibit, menu);
		return true;
	}	
	
	@Override
	public void onDialogPositiveClick(DialogFragment dialog, String input) {
		String correct = image_names[pos];
		if (TextMatch(input, correct)) {
			Toast.makeText(DisplayExhibitActivity.this, "Correct! It's " + correct + "!", Toast.LENGTH_SHORT).show();
			//Mark as correct in savedata
			savedata.Progress(pos);
			//save the data
			SharedPreferences sharedPref = this.getSharedPreferences(exhibit, Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = sharedPref.edit();
			editor.putString(exhibit, savedata.getRaw());
			editor.commit();
			//update grid display
			GridView overlay = (GridView) findViewById(R.id.overlay);
			overlay.setAdapter(new ImageAdapter(this, savedata.getOverlay()));
		} else {
			Toast.makeText(DisplayExhibitActivity.this, "Sorry, try again", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {
		
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
	    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
	    startActivityForResult(myIntent, 0);
	    return true;
	}
	
	public boolean TextMatch(String input, String master) {
		input = input.toLowerCase(Locale.getDefault());
		return input.equals(master);
	}
}
