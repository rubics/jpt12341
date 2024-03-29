package app.screens.deals;

import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;
import app.fields.ScreenTitle;
import app.managers.deals.AboutDealScreenManager;
import app.models.Images;

public class BookmarkScreen extends MainScreen{
	private AboutDealScreenManager dealsInfo;
	public BookmarkScreen(AboutDealScreenManager _dealsInfo){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		dealsInfo = _dealsInfo;
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(Images.screen_background));
		setTitle(new ScreenTitle("Bookmark"));
		add(new LabelField("Bookmark"));
	}
	
	public boolean isDirty() {
	    return false;
	}
}
