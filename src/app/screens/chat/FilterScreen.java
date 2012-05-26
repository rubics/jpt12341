package app.screens.chat;

import rubyx.custom_fields.ScreenBannar;
import rubyx.custom_fields.SpaceField;
import rubyx.tabbedUI.TabbedButton;
import rubyx.tabbedUI.TabbedButtonManager;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import app.models.Images;

public class FilterScreen extends MainScreen{
	
	private TabbedButton backButton;
	private TabbedButton homeButton;
	
	private VerticalFieldManager vrManager;
	
	public FilterScreen(){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(Images.screen_background));
		
		backButton = new TabbedButton("Back", 6, 100, 36);
		backButton.setRVAlue(10);
		homeButton = new TabbedButton("Home", 6, 100, 36);
		homeButton.setRVAlue(10);
		
		setTitle(new ScreenBannar("Filter", 40, backButton, homeButton));
		
		vrManager = new VerticalFieldManager(Manager.VERTICAL_SCROLL | Manager.VERTICAL_SCROLLBAR);
		
		Manager statusButtonGroup = new TabbedButtonManager(480, 42, true, 2);
		statusButtonGroup.add(new TabbedButton("Online",6));
		statusButtonGroup.add(new TabbedButton("Offline",6));
		statusButtonGroup.add(new TabbedButton("List All",6));
		
		vrManager.add(statusButtonGroup);
		vrManager.add(new SpaceField(3));
		
		Manager genderButtonGroup = new TabbedButtonManager(480, 42, true, 2);
		genderButtonGroup.add(new TabbedButton("Male",6));
		genderButtonGroup.add(new TabbedButton("Female",6));
		genderButtonGroup.add(new TabbedButton("List All",6));
		
		vrManager.add(genderButtonGroup);
		vrManager.add(new SpaceField(3));
		
		Manager crewButtonGroup = new TabbedButtonManager(480, 42, true, 2);
		crewButtonGroup.add(new TabbedButton("Cabin Crew",6));
		crewButtonGroup.add(new TabbedButton("Flight Crew",6));
		crewButtonGroup.add(new TabbedButton("List All",6));
		
		vrManager.add(crewButtonGroup);
		vrManager.add(new SpaceField(3));
		
		add(vrManager);
	}
	
	public boolean isDirty() {
	    return false;
	}
}