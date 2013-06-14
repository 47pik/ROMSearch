package ca.on.rom.romsearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	public static final String EXTRA_MESSAGE = "ca.on.rom.ROMSEARCH.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GridData.setupTables(getApplicationContext());
		setContentView(R.layout.activity_main);
//		onCreateSpinner();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
//	public void onCreateSpinner() {
//		Spinner spinner = (Spinner) findViewById(R.id.exhibit_spinner);
//		//Create an ArrayAdapter using the string array and a default spinner layout
//		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//				R.array.exhibit_array, android.R.layout.simple_spinner_dropdown_item);
//		//Specify the layout to use when the list of choices appears
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		//Apply the adapter to the spinner
//		spinner.setAdapter(adapter);
//	}
//	
//	public void chooseExhibit(View view) {
//		Intent intent = new Intent(this, DisplayExhibitActivity.class);
//		Spinner spinner = (Spinner) findViewById(R.id.exhibit_spinner);
//		String exhibit = spinner.getSelectedItem().toString();
//		intent.putExtra(EXTRA_MESSAGE, exhibit);
//		startActivity(intent);
//	}
	
	public void gotoEgypt(View view) {
		Intent intent = new Intent(this, DisplayExhibitActivity.class);
		String exhibit = "Galleries of Africa: Egypt";
		intent.putExtra(EXTRA_MESSAGE, exhibit);
		startActivity(intent);
	}
	
	public void gotoGreece(View view) {
		Intent intent = new Intent(this, DisplayExhibitActivity.class);
		String exhibit = "Gallery of Greece";
		intent.putExtra(EXTRA_MESSAGE, exhibit);
		startActivity(intent);
	}

}
