package app.screens.profile;

import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;
import rubyx.custom_fields.ScreenBannar;
import rubyx.tabbedUI.TabbedButton;
import app.managers.profile.ProfileInfoScreenManager;
import app.models.Images;

public class ProfileSettingsScreen extends MainScreen{
	private ProfileInfoScreenManager profileInfo;
	private TabbedButton backButton;
	private TabbedButton homeButton;
	public ProfileSettingsScreen(ProfileInfoScreenManager _profileInfo){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		profileInfo = _profileInfo;
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(Images.screen_background));
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
