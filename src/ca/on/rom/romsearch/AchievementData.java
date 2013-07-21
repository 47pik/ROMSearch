package ca.on.rom.romsearch;

public class AchievementData {
	
	private static Achievement[] item_achievements;
	private static Achievement[] exhibit_achievements;
	private static Achievement[] exhibittotal_achievements;
	
	private static Achievement next_item;
	private static Achievement next_exhibittotal;
	
	public Achievement getNextItem() {
		return next_item;
	}
	
	public Achievement getNextExhibitTotal() {
		return next_exhibittotal;
	}
	
	public AchievementData() {
		Achievement[] item_achievements = {new Achievement("First", R.drawable.placeholder, "i", 1)};
		AchievementData.item_achievements = item_achievements;
		
		Achievement[] exhibit_achievements = {new Achievement("Egypt", R.drawable.placeholder, "e", R.string.egypt)};
		AchievementData.exhibit_achievements = exhibit_achievements;
		
		Achievement[] exhibittotal_achievements = {new Achievement("First Exhibit", R.drawable.placeholder, "ne", 1)};
		AchievementData.exhibittotal_achievements = exhibittotal_achievements;
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

