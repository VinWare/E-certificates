package preference;

import java.awt.*;
import java.util.prefs.Preferences;

public class PreferencesClass {
	private static Preferences preferences;
	
	public static void setupPreferences() {
		preferences = Preferences.userRoot().node(PreferencesClass.class.getName());
		
		if(!existsPreferences()) {
			setDefaultPreferences();
		}
	}
	
	private static boolean existsPreferences() {
		return (preferences.get("xName", null) == null);
	}
	
	private static void setDefaultPreferences() {
		preferences.put("xName", String.valueOf(0));
		preferences.put("yName", String.valueOf(0));
		preferences.put("xEventName", String.valueOf(0));
		preferences.put("yEventName", String.valueOf(0));
		preferences.put("Font", getFontString(new Font("Times New Roman", Font.BOLD, 28)));
		preferences.put("Blank", "");
		preferences.put("Certificates", "");
	}
	
	private static String getFontString(Font font) {
		return font.getFontName() + '|' + font.getStyle() + '|' + font.getSize();
	}
	public static String getPreference(String key) {
		return preferences.get(key,null);
	}
	
	public static void setPreferences(String key, String value) {
		if(preferences.get(key, null) == null)
			return;
		preferences.put(key, value);
	}
}
