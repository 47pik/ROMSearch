package ca.on.rom.romsearch;

public class Achievement {

	private String name; //name of achievement
	private int image; //address of image
	private String type; // e - exhibit, ne = number of exhibits, i - number of items
	private int requirement; //how much needs completing
	private String exhibit; //which exhibit needs completing (only for exhibit-type achievement)
	
	public Achievement(String name, int image, String type, int requirement) {
		this.name = name;
		this.image = image;
		this.type = type;
		this.requirement = requirement;
	}
	
	public Achievement(String name, int image, String type, String exhibit) {
		this.name = name;
		this.image = image;
		this.type = type;
		this.requirement = 100;
		this.exhibit = exhibit;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getImage() {
		return this.image;
	}
	
	public int getRequirement() {
		return this.requirement;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getExhibit() {
		return this.exhibit;
	}
	
	public boolean checkCompletion(int val) {
		return val >= this.requirement;
	}
}
