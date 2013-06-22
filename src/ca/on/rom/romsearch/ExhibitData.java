package ca.on.rom.romsearch;

import java.util.ArrayList;

public class ExhibitData {
	
	private String rawdata;
	private Boolean[] listdata;
	private int completed;
	private double completion;
	
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
		int completed = 0;
		for (int i = 0; i < this.listdata.length; i++) {
			if (this.listdata[i]) {
				completed++;
			}
		}
		this.completed = completed;
		this.completion = ((double) completed) / 9;
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
