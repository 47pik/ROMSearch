package ca.on.rom.romsearch;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class DisplayTutorialDialogFragment extends DialogFragment {
	
	public static int img;
	
	public static DisplayTutorialDialogFragment newInstance(int id) {
		DisplayTutorialDialogFragment frag = new DisplayTutorialDialogFragment();
		img = id;
		return frag;
		
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//use the builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		//get layout inflater and set layout for dialog
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View v = inflater.inflate(R.layout.tutorial_view, null);
		builder.setView(v)
				//add action buttons
				.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						//User pressed OK -> send positive button event back to host activity
					}
				});
		
		LinearLayout layout = (LinearLayout) v.findViewById(R.id.tutorial_layout);
		layout.setBackgroundResource(img);
		
		//Create the AlertDialog object and return it
		AlertDialog alert = builder.create();
		alert.show();
		//Skin the button, and remove the text
		Button button = (Button) alert.findViewById(android.R.id.button1);
		button.setBackgroundResource(R.drawable.tutorial_okay);
		button.setText(null);
		return alert;

	}
	
}
