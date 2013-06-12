package ca.on.rom.romsearch;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayExhibitActivity extends FragmentActivity {
	
	public final static String EXTRA_MESSAGE2 ="com.example.R.MESSAGE";
	
	public static Integer[] image_ids = {
			R.drawable.rom, R.drawable.placeholder,
			R.drawable.placeholder, R.drawable.placeholder,
			R.drawable.placeholder, R.drawable.placeholder,
			R.drawable.placeholder, R.drawable.placeholder,
			R.drawable.placeholder
	};
	
	public static int pos = 0;
	
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
		gridview.setAdapter(new ImageAdapter(this, image_ids));
		
		//Listen for click on image
		gridview.setOnItemClickListener(new OnItemClickListener() {
			/*NOTE: this needs to change. Currently displays only a number, 
			needs to display a pop-up screen*/
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				//get clicked on image, and set the dialog to contain it
				pos = position;
				DialogFragment dialog = new InputNameDialogFragment();	
				FragmentManager fm = getSupportFragmentManager();
				dialog.show(fm, "input_name");

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
	
	//for clicking on images
	public static class InputNameDialogFragment extends DialogFragment {
		
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			//use the builder class for convenient dialog construction
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			
			//get layout inflater and set layout for dialog
			LayoutInflater inflater = getActivity().getLayoutInflater();
			View v = inflater.inflate(R.layout.popup_view, null);
			builder.setView(v)
					//add action buttons
					.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							//User pressed OK
						}
					})
					.setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							//User cancelled the dialog
						}
						
					});
			
			ImageView iv = (ImageView) v.findViewById(R.id.selected_item);
			iv.setImageResource(image_ids[pos]);
			
			//Create the AlertDialog object and return it
			return builder.create();

		}
		
	}

}
