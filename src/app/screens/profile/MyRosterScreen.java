package app.screens.profile;




import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.CheckboxField;
import net.rim.device.api.ui.component.DateField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import rubyx.custom_fields.CompositeFieldManager;
import rubyx.custom_fields.CompositeTextBox;
import rubyx.custom_fields.CustomDateField;
import app.AirCrew;
import app.fields.ScreenBannar;
import app.fields.TabbedButton;
import app.fields.profile.CheckboxManager;
import app.managers.profile.ProfileInfo;

public class MyRosterScreen extends MainScreen{
	private ProfileInfo profileInfo;
	private TabbedButton backButton;
	private TabbedButton homeButton;
	
	private CompositeTextBox locationField;
	private CustomDateField dateFrom;
	private CustomDateField dateTo;
	private CompositeTextBox detailsField;
	private CheckboxField allProfile;
	private CheckboxField myFavorites;
	
	private VerticalFieldManager mvrm;
	
	public MyRosterScreen(ProfileInfo _profileInfo){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		profileInfo = _profileInfo;
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(AirCrew.screen_background));
		
		backButton = new TabbedButton("Back", 6, 100, 36);
		backButton.setRVAlue(10);
		homeButton = new TabbedButton("Home", 6, 100, 36);
		homeButton.setRVAlue(10);
		
		setTitle(new ScreenBannar("My Roster", 40, backButton, homeButton));
		mvrm = new VerticalFieldManager(Manager.VERTICAL_SCROLL|Manager.VERTICAL_SCROLLBAR);
		locationField = new CompositeTextBox("Location", "", true);
		dateFrom = new CustomDateField("Date From", System.currentTimeMillis(), DateField.DATE);
		dateTo = new CustomDateField("Date To", System.currentTimeMillis(), DateField.DATE);
		detailsField = new CompositeTextBox("Details", "", true);
		
		CompositeFieldManager manager = new CompositeFieldManager(Manager.VERTICAL_SCROLL | Manager.VERTICAL_SCROLLBAR);
		
		manager.add(locationField);
		manager.add(dateFrom);
		manager.add(dateTo);
		manager.add(detailsField);
		mvrm.add(manager);
		
		CheckboxManager checkboxManager = new CheckboxManager(Manager.VERTICAL_SCROLL|Manager.VERTICAL_SCROLLBAR, Display.getWidth(), 90);
		
		allProfile = new CheckboxField("All Profiles", false, Field.FIELD_HCENTER){
			protected void paint(Graphics g){
				g.setColor(Color.WHITE);
				super.paint(g);
			}
		};
		myFavorites = new CheckboxField("My Favorites", false, Field.FIELD_HCENTER){
			protected void paint(Graphics g){
				g.setColor(Color.WHITE);
				super.paint(g);
			}
		};
		checkboxManager.add(new LabelField("Who can view my roster ?"));
		checkboxManager.add(allProfile);
		checkboxManager.add(myFavorites);
		mvrm.add(checkboxManager);
		
		add(mvrm);
	}
	
	public boolean isDirty() {
	    return false;
	}
}
