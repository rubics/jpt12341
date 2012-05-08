package app.screens.deals;

import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;
import app.AirCrew;
import app.fields.ScreenTitle;
import app.managers.deals.DealsInfo;

public class BookmarkScreen extends MainScreen{
	private DealsInfo dealsInfo;
	public BookmarkScreen(DealsInfo _dealsInfo){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		dealsInfo = _dealsInfo;
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(AirCrew.screen_background));
		setTitle(new ScreenTitle("Bookmark"));
		add(new LabelField("Bookmark"));
	}
	
	public boolean isDirty() {
	    return false;
	}
}
