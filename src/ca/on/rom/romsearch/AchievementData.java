package ca.on.rom.romsearch;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;

public class AchievementData {
	
	private static Achievement[] item_achievements;
	private static Achievement[] exhibittotal_achievements;
	HashMap<String, Achievement> exhibit_achievements = new HashMap<String, Achievement>();
	
	private static Achievement next_item;
	private static Achievement next_exhibittotal;
	
	private Context c;
	
	public Achievement[] getAllAchievements(){
		ArrayList<Achievement> achievements = new ArrayList<Achievement>();
		for (int i = 0; i < item_achievements.length; i++) {
			achievements.add(item_achievements[i]);
		}
		for (int i = 0; i < exhibittotal_achievements.length; i++) {
			achievements.add(exhibittotal_achievements[i]);
		}
		String[] exhibits = c.getResources().getStringArray(R.array.exhibit_array);
		for (int i = 0; i < exhibits.length; i++) {
			achievements.add(getExhibitAchievement(exhibits[i]));
		}
		Achievement[] achievementArr = new Achievement[achievements.size()];
		achievementArr = achievements.toArray(achievementArr);
		return achievementArr;
	}
	
	public Achievement getNextItem() {
		return next_item;
	}
	
	public Achievement getNextExhibitTotal() {
		return next_exhibittotal;
	}
	
	public Achievement getExhibitAchievement(String exhibit) {
		return exhibit_achievements.get(exhibit);
	}
	
	public void setupAchievements(Context c) {
		this.c = c;
		Achievement[] item_achievements = {new Achievement("First Discovery", R.drawable.placeholder_s, "i", 1),
				};
		AchievementData.item_achievements = item_achievements;
		
		Achievement[] exhibittotal_achievements = {new Achievement("Tourist", R.drawable.placeholder_s, "ne", 1)
				};
		AchievementData.exhibittotal_achievements = exhibittotal_achievements;
		
		exhibit_achievements.put(c.getString(R.string.egypt), 
				new Achievement("Riddle of the Sphinx", R.drawable.placeholder_s, "e", c.getString(R.string.egypt)));
		exhibit_achievements.put(c.getString(R.string.greece),
				new Achievement("Greece is the Word", R.drawable.placeholder_s, "e", c.getString(R.string.greece)));
		exhibit_achievements.put(c.getString(R.string.south_asia),
				new Achievement("placeholder name", R.drawable.placeholder_s, "e", c.getString(R.string.south_asia)));
		exhibit_achievements.put(c.getString(R.string.middle_east),
				new Achievement("placeholder name", R.drawable.placeholder_s, "e", c.getString(R.string.middle_east)));
	}
	
	/*
	 * based on current progress, set the next achievements to be unlocked
	 */
	public void getNextAchievements(int curr_items, int curr_exhibits) {
		AchievementData.next_item = getNextItemAchievement(curr_items);
		AchievementData.next_exhibittotal = getNextExhibitTotalAchievement(curr_exhibits);
	}
	
	/*
	 * based on the current number of items completed, return the next item achievement to be unlocked
	 */
	private Achievement getNextItemAchievement(int current) {
		Achievement next = null;
		//find the first achievement with a greater requirement than current player progress
		for (int i = 0; i < item_achievements.length; i++) {
			next = item_achievements[i];
			if (current < next.getRequirement()) {
				return next;
			}
		}
		return null;
	}
	
	/*
	 * based on the current number of exhibits completed, return the next item achievement to be unlocked
	 */
	private Achievement getNextExhibitTotalAchievement(int current) {
		Achievement next = null;
		//find the first achievement with a greater requirement than current player progress
		for (int i = 0; i < exhibittotal_achievements.length; i++) {
			next = exhibittotal_achievements[i];
			if (current < next.getRequirement()) {
				return next;
			}
		}
		return null;
	}
}

