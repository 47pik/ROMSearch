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
		Achievement[] item_achievements = {new Achievement("First Discovery", R.drawable.achievement_item_1, "i", 1),
				new Achievement("First Five", R.drawable.achievement_item_5, "i", 5),
				new Achievement("Top Ten", R.drawable.achievement_item_10, "i", 10),
				new Achievement("Hobbyist", R.drawable.achievement_item_20, "i", 20),
				new Achievement("Enthusiast", R.drawable.achievement_item_30, "i", 30),
				new Achievement("Collector", R.drawable.achievement_item_50, "i", 50),
				new Achievement("Historian", R.drawable.achievement_item_75, "i", 75),
				new Achievement("The Big 100", R.drawable.achievement_item_100, "i", 100),
				new Achievement("Curator", R.drawable.achievement_item_200, "i", 200)
				};
		AchievementData.item_achievements = item_achievements;
		
		Achievement[] exhibittotal_achievements = {new Achievement("Visitor", R.drawable.achievement_exhibit_1, "ne", 1),
				new Achievement("Tourist", R.drawable.achievement_exhibit_2, "ne", 2), 
				new Achievement("Traveler", R.drawable.achievement_exhibit_4, "ne", 4),
				new Achievement("Scholar", R.drawable.achievement_exhibit_7, "ne", 7),
				new Achievement("Explorer", R.drawable.achievement_exhibit_10, "ne", 10),
				new Achievement("World Traveller", R.drawable.achievement_exhibit_15, "ne", 15),
				new Achievement("Master Explorer", R.drawable.achievement_exhibit_20, "ne", 20),
				new Achievement("ROM Master", R.drawable.placeholder, "ne", 24)
				};
		AchievementData.exhibittotal_achievements = exhibittotal_achievements;
		
		exhibit_achievements.put(c.getString(R.string.egypt), 
				new Achievement("Riddle of the Sphinx", R.drawable.achievement_egypt, "e", c.getString(R.string.egypt)));
		exhibit_achievements.put(c.getString(R.string.greece),
				new Achievement("Greece is the Word", R.drawable.achievement_greece, "e", c.getString(R.string.greece)));
		exhibit_achievements.put(c.getString(R.string.south_asia),
				new Achievement("One with the ROM", R.drawable.achievement_southasia, "e", c.getString(R.string.south_asia)));
		exhibit_achievements.put(c.getString(R.string.middle_east),
				new Achievement("1001 Nights", R.drawable.achievement_mideast, "e", c.getString(R.string.middle_east)));
		exhibit_achievements.put(c.getString(R.string.korea),
				new Achievement("The Morning Calm", R.drawable.achievement_korea, "e", c.getString(R.string.korea)));
		exhibit_achievements.put(c.getString(R.string.chinese_architecture),
				new Achievement("If You Build It...", R.drawable.achievement_chinese_arch, "e", c.getString(R.string.chinese_architecture)));
		exhibit_achievements.put(c.getString(R.string.nubia),
				new Achievement("Along the Nile", R.drawable.achievement_nubia, "e", c.getString(R.string.nubia)));
		exhibit_achievements.put(c.getString(R.string.china),
				new Achievement("The Middle Kingdom", R.drawable.achievement_china, "e", c.getString(R.string.china)));
		exhibit_achievements.put(c.getString(R.string.japan),
				new Achievement("The Rising Sun", R.drawable.achievement_japan, "e", c.getString(R.string.japan)));
		exhibit_achievements.put(c.getString(R.string.chinese_sculpture),
				new Achievement("Statuesque", R.drawable.achievement_chinese_sculp, "e", c.getString(R.string.chinese_sculpture)));
		exhibit_achievements.put(c.getString(R.string.rome),
				new Achievement("Not Built in a Day", R.drawable.achievement_rome, "e", c.getString(R.string.rome)));
		exhibit_achievements.put(c.getString(R.string.rome_and_near_east),
				new Achievement("East-Side", R.drawable.achievement_rome_ne, "e", c.getString(R.string.rome_and_near_east)));
		exhibit_achievements.put(c.getString(R.string.aegean),
				new Achievement("Ancient Legends", R.drawable.achievement_agean, "e", c.getString(R.string.aegean)));
		exhibit_achievements.put(c.getString(R.string.cyprus),
				new Achievement("East Meets West", R.drawable.achievement_cyprus, "e", c.getString(R.string.cyprus)));
		exhibit_achievements.put(c.getString(R.string.afamas),
				new Achievement("Celebration Time", R.drawable.achievement_afamas, "e", c.getString(R.string.afamas)));
		exhibit_achievements.put(c.getString(R.string.euro_style),
				new Achievement("History of Style", R.drawable.achievement_euro_style, "e", c.getString(R.string.euro_style)));
		exhibit_achievements.put(c.getString(R.string.euro_themes),
				new Achievement("Specialist", R.drawable.achievement_euro_themes, "e", c.getString(R.string.euro_themes)));
		exhibit_achievements.put(c.getString(R.string.canada),
				new Achievement("O Canada", R.drawable.achievement_canada, "e", c.getString(R.string.canada)));
		exhibit_achievements.put(c.getString(R.string.first_peoples),
				new Achievement("First!", R.drawable.achievement_first_peoples, "e", c.getString(R.string.first_peoples)));
		exhibit_achievements.put(c.getString(R.string.earths_treasures),
				new Achievement("Rock and Roll", R.drawable.achievement_earths_treasures, "e", c.getString(R.string.earths_treasures)));
		exhibit_achievements.put(c.getString(R.string.biodiversity),
				new Achievement("Crisis Alert!", R.drawable.achievement_biodiversity, "e", c.getString(R.string.biodiversity)));
		exhibit_achievements.put(c.getString(R.string.birds),
				new Achievement("I Believe I Can Fly", R.drawable.achievement_birds, "e", c.getString(R.string.birds)));
		exhibit_achievements.put(c.getString(R.string.dinosaurs),
				new Achievement("Rawr!", R.drawable.achievement_dinosaurs, "e", c.getString(R.string.dinosaurs)));
		exhibit_achievements.put(c.getString(R.string.mammals),
				new Achievement("Rise of the Mammals", R.drawable.achievement_mammals, "e", c.getString(R.string.mammals)));
		exhibit_achievements.put(c.getString(R.string.textiles),
				new Achievement("Style Endures", R.drawable.placeholder_s, "e", c.getString(R.string.textiles)));
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

