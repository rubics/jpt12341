package app.screens.favorites;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import app.AirCrew;
import app.fields.ScreenBannar;
import app.fields.TabbedButton;
import app.fields.favorites.ProfileDetails;
import app.fields.favorites.ProfileView;

public class ProfileViewScreen extends MainScreen{
	private TabbedButton backButton;
	private TabbedButton homeButton;
	private VerticalFieldManager vrm;
	
	private ProfileView profileView;
	
	Bitmap p_image;
	
	public ProfileViewScreen(Bitmap img){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		p_image = img;
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(AirCrew.screen_background));
		backButton = new TabbedButton("Back", 6, 100, 36);
		backButton.setRVAlue(10);
		homeButton = new TabbedButton("Home", 6, 100, 36);
		homeButton.setRVAlue(10);
		
		vrm = new VerticalFieldManager(Manager.VERTICAL_SCROLL | Manager.VERTICAL_SCROLLBAR);
		
		setTitle(new ScreenBannar("Kristine", 40, backButton, homeButton));
		
		profileView = new ProfileView(0,p_image);
		vrm.add(profileView);
		
		vrm.add(new ProfileDetails());
		vrm.add(new ButtonField("Button"));
		add(vrm);
	}
	
	public boolean isDirty() {
	    return false;
	}
}