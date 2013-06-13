package ca.on.rom.romsearch;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class InputNameDialogFragment extends DialogFragment {
	
	public static int img;
	//public static String input;
	
	
	public static InputNameDialogFragment newInstance(int id) {
		InputNameDialogFragment frag = new InputNameDialogFragment();
		img = id;
		return frag;
		
	}
	
	/*The activity that creates an instance of this dialog fragment must implement this
	 * interface in order to receive event callbacks. Each method passes the DialogFragment
	 * in case the hose needs to query it */
	public interface InputNameDialogListener {
		public void onDialogPositiveClick(DialogFragment dialog, String input);
		public void onDialogNegativeClick(DialogFragment dialog);
	}
	
	//use this instance of the interface to deliver action events
	InputNameDialogListener mListener;
	
	//Override the Fragment.onAttach() method to instantiate the InputNameDialogListener
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// Verify that the host activity implements the callback interface
		try {
			//Instantiate the InputNameDialogListener so we can send events to the host
			mListener = (InputNameDialogListener) activity;
		} catch (ClassCastException e){
			//The activity doesn't implement the interface, throw exception
			throw new ClassCastException(activity.toString() + 
					"must implement InputNameDialogListener");
		}
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//use the builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		//get layout inflater and set layout for dialog
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View v = inflater.inflate(R.layout.popup_view, null);
		final EditText text = (EditText) v.findViewById(R.id.edit_message);
		builder.setView(v)
				//add action buttons
				.setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						//User pressed OK -> send positive button event back to host activity
						String input = text.getText().toString();
						mListener.onDialogPositiveClick(InputNameDialogFragment.this, input);
					}
				})
				.setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						//User cancelled the dialog -> send negative event back to activity
						mListener.onDialogNegativeClick(InputNameDialogFragment.this);
					}
					
				});
		
		ImageView iv = (ImageView) v.findViewById(R.id.selected_item);
		iv.setImageResource(img);
		
		//Create the AlertDialog object and return it
		return builder.create();

	}
	
}