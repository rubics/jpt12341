package app.screens.favorites;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import rubyx.custom_fields.ScreenBannar;
import rubyx.tabbedUI.TabbedButton;
import app.fields.listings.ListingField;
import app.models.Images;
import app.screens.profile.GalleryScreen;

public class FavoritesScreen extends MainScreen{
	
	private TabbedButton backButton;
	private TabbedButton homeButton;
	private VerticalFieldManager vrManager;
	
	public FieldChangeListener listener = new FieldChangeListener() {
		public void fieldChanged(Field field, int context) {
			UiApplication.getUiApplication().pushScreen(new ProfileViewScreen(GalleryScreen.images[field.getIndex()]));
		}
	};

	public FavoritesScreen(){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(Images.screen_background));
		backButton = new TabbedButton("Back", 6, 100, 36);
		backButton.setRVAlue(10);
		homeButton = new TabbedButton("Home", 6, 100, 36);
		homeButton.setRVAlue(10);
		
		vrManager = new VerticalFieldManager(Manager.VERTICAL_SCROLL | Manager.VERTICAL_SCROLLBAR);
		
		setTitle(new ScreenBannar("Favorites", 40, backButton, homeButton));
		Bitmap[] images = GalleryScreen.images;
		for (int i=0; i<images.length; i++){
			Field field = new ListingField(images[i], "Title", "Description", (i%3 == 0) ? ListingField.STATUS_OFFLINE : ListingField.STATUS_ONLINE);
			field.setChangeListener(listener);
			vrManager.add(field);
		}
		add(vrManager);
	}
	public boolean isDirty() {
	    return false;
	}
}
