package app.screens.deals;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.GaugeField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import rubyx.custom_fields.ScreenBannar;
import rubyx.custom_fields.SpaceField;
import rubyx.tabbedUI.TabbedButton;
import rubyx.tabbedUI.TabbedButtonManager;
import app.fields.listings.ListingField;
import app.managers.deals.AboutDealScreenManager;
import app.models.Deal;
import app.models.Images;

public class SearchResultScreen extends MainScreen{
	
	private TabbedButton backButton;
	private TabbedButton homeButton;
	
	public static Bitmap[] profile_pics = {Bitmap.getBitmapResource("images/profile_1.png"),
			Bitmap.getBitmapResource("images/profile_2.png"),
			Bitmap.getBitmapResource("images/profile_3.png"),
			Bitmap.getBitmapResource("images/profile_4.png")
		};
	public static String[] names = {"Luxe Dental Clinic","Happy Habitat Petcare","Jacques La Coupe","Dine In Resturant"};
	public static String[] category = {"Dental Care For Your Lifestyle","Petcare","Beauty Salon","Dining"};
	String[] description = {"Welcome to the Luxe Dental Clinic, the centre of luxury for cosmetic dentistry and Smile design in the	heart of Dubai.",
								"We founded Happy Habitat (a professional Pet Sitting Company) out of the desire to provide THE BEST 'at home' pet care solutions to Pet Owners at affordable prices.",
								"In 1996, Avenue Kleber in Paris France, witnessed the launching of the ultimate luxurious La Coupe Beauty Salon.",
								"Jump to casual dining, a casual dining resturant is a resturant that serves moderately priced food in a casual atmosphere."};
	
	ProgressBar progressBar;
	
	private FieldChangeListener listItemListener = new FieldChangeListener() {		
		public void fieldChanged(Field field, int context) {
			int in = (field.getIndex()-3) % 4;
			AboutDealScreenManager aboutDeals = new AboutDealScreenManager(new Deal(names[in], category[in], description[in], profile_pics[in]));
			aboutDeals.pushScreen();			
		}
	};
		
	public SearchResultScreen(){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL);
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(Images.screen_background));
		
		backButton = new TabbedButton("Back", 6, 100, 36);
		backButton.setRVAlue(10);
		homeButton = new TabbedButton("Home", 6, 100, 36);
		homeButton.setRVAlue(10);
		
		setTitle(new ScreenBannar("Deals", 40, backButton, homeButton));
		
		VerticalFieldManager listManager = new VerticalFieldManager(Manager.VERTICAL_SCROLL | Manager.VERTICAL_SCROLLBAR);
		
		listManager.add(new SpaceField(5));
		TabbedButtonManager tbManager = new TabbedButtonManager(Display.getWidth(), 44);
		tbManager.add(new TabbedButton("List View", 6));
		tbManager.add(new TabbedButton("Map View", 6));
		listManager.add(tbManager);
		listManager.add(new SpaceField(5));
		
		for(int i=0; i < profile_pics.length; i++){
			Field listItem = new ListingField(profile_pics[i], names[i], category[i],8);
			listItem.setChangeListener(listItemListener);
			listManager.add(listItem);
		}
		for(int i=0; i < profile_pics.length; i++){
			Field listItem = new ListingField(profile_pics[i], names[i], category[i],8);
			listItem.setChangeListener(listItemListener);
			listManager.add(listItem);
		}
		
		add(listManager);
		
		progressBar = new ProgressBar(0);
		setStatus(progressBar);
		progressBar.update(5, 12);
	}
	
	public boolean isDirty() {
	    return false;
	}
}

class ProgressBar extends HorizontalFieldManager{
	int height = 40;
	GaugeField guageField;
	
	protected ProgressBar(long style){
		super(style);
		guageField = new GaugeField("updating.. 25/100", 0, 100, 0, 0);
		add(guageField);
	}
	
	protected void paint(Graphics g){
		g.setFont(g.getFont().derive(0, 4));
		super.paint(g);
	}
	
	protected void update(int _completed, int _tasks){
		float x = _completed | 0;
		float y = _tasks | 0;
		
		guageField.setValue((int)(x/y * 100));
		guageField.setLabel("Updating.. " + String.valueOf((int)x) + "/" + String.valueOf((int)y));
	}
}
