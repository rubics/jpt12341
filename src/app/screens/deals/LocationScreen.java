package app.screens.deals;

import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;
import app.fields.ScreenTitle;
import app.managers.deals.AboutDealScreenManager;
import app.models.Images;

public class LocationScreen extends MainScreen{
	private AboutDealScreenManager dealsInfo;
	public LocationScreen(AboutDealScreenManager _dealsInfo){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		dealsInfo = _dealsInfo;
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(Images.screen_background));
		setTitle(new ScreenTitle("Location"));
		add(new LabelField("Location"));
	}
	
	public boolean isDirty() {
	    return false;
	}
}
