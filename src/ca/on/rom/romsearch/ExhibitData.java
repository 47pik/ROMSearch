package ca.on.rom.romsearch;

import java.util.ArrayList;

public class ExhibitData {
	
	private String rawdata; //string represenation of savedata
	private Boolean[] listdata; //boolean values for items 0-8 related to completion
	private Integer[] completion_overlay; //images to be displayed on overlay
	private int completed; //# of items completed from exhibit
	private double completion; //completion % of exhibit
	
	public ExhibitData(String rawdata) {
		this.rawdata = rawdata;
		this.listdata = MakeArr();
		this.Update();
	}
	
	public int getCompleted() {
		return this.completed;
	}
	
	public double getCompletion() {
		return this.completion;
	}
	
	public Boolean[] getArr() {
		return this.listdata;
	}
	
	public String getRaw() {
		return this.rawdata;
	}
	
	public Integer[] getOverlay() {
		return this.completion_overlay;
	}
	
	/*Create the boolean array listdata based on the raw string
	 * data in rawdata (1 = true, 0 = f)
	 */
	private Boolean[] MakeArr() {
		ArrayList<Boolean> bool_list = new ArrayList<Boolean>();
		//create list based on each digit's t/f value
		for (int i = 0; i < rawdata.length(); i++) {
			if (rawdata.charAt(i) == '1') {
				bool_list.add(true);
			} else {
				bool_list.add(false);
			}
		}
		Boolean[] bool_arr = new Boolean[bool_list.size()];
		bool_arr = bool_list.toArray(bool_arr);
		return bool_arr;
	}
	
	/*
	 * Update values based on the listdata
	 */
	private void Update() {
		Integer[] overlay = new Integer[9];
		int completed = 0;
		for (int i = 0; i < this.listdata.length; i++) {
			if (this.listdata[i]) {
				completed++;
				overlay[i] = R.drawable.check;
			} else {
				overlay[i] = R.drawable.blank;
			}
		}
		this.completed = completed;
		this.completion = ((double) completed) / 9;
		this.completion_overlay = overlay;
	}
	
	/*
	 * Make progress towards exhibit completion
	 */
	public void Progress(int i) {
		this.listdata[i] = true;
		//alter raw data
		StringBuilder newdata = new StringBuilder(this.rawdata);
		newdata.setCharAt(i, '1');
		this.rawdata = newdata.toString();
		this.Update();
	}
}
