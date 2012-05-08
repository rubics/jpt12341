package app.screens.profile;

import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;
import app.AirCrew;
import app.fields.ScreenBannar;
import app.fields.ScreenTitle;
import app.fields.TabbedButton;
import app.managers.profile.ProfileInfo;

public class ProfileSettingsScreen extends MainScreen{
	private ProfileInfo profileInfo;
	private TabbedButton backButton;
	private TabbedButton homeButton;
	public ProfileSettingsScreen(ProfileInfo _profileInfo){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		profileInfo = _profileInfo;
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(AirCrew.screen_background));
		backButton = new TabbedButton("Back", 6, 100, 36);
		backButton.setRVAlue(10);
		homeButton = new TabbedButton("Home", 6, 100, 36);
		homeButton.setRVAlue(10);
		
		setTitle(new ScreenBannar("Settings", 40, backButton, homeButton));
	}
	public boolean isDirty() {
	    return false;
	}
}
