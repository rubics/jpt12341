package app.screens.deals;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.GaugeField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import app.AirCrew;
import app.fields.ScreenTitle;
import app.fields.deals.ListItem;
import app.fields.deals.TabbedPaneButton;
import app.managers.deals.DealsInfo;
import app.models.Deal;

public class SearchResultScreen extends MainScreen{
	
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
			DealsInfo aboutDeals = new DealsInfo(((ListItem)field).deal);
			aboutDeals.pushScreen();			
		}
	};
	
	
	
	public SearchResultScreen(){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL);
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(AirCrew.screen_background));
		setTitle(new ScreenTitle("Search Results"));
		
		VerticalFieldManager listManager = new VerticalFieldManager(Manager.VERTICAL_SCROLL | Manager.VERTICAL_SCROLLBAR);
		
		for(int i=0; i < profile_pics.length; i++){
			Field listItem = new ListItem(new Deal(names[i], category[i], description[i], profile_pics[i]), true);
			listItem.setChangeListener(listItemListener);
			listManager.add(listItem);
		}
		for(int i=0; i < profile_pics.length; i++){
			Field listItem = new ListItem(new Deal(names[i], category[i], description[i], profile_pics[i]), true);
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
