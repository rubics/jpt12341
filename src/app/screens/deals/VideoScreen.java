package app.screens.deals;

import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;
import rubyx.custom_fields.CompositeObjectChoiceField;
import rubyx.custom_fields.CustomRichTextField;
import app.AirCrew;
import app.fields.ScreenTitle;
import app.managers.deals.DealsInfo;

public class VideoScreen extends MainScreen{
	private DealsInfo dealsInfo;
	String [] airlines = {"Indian", "Air Deccan", "KingFisher", "Necon"};
	public VideoScreen(DealsInfo _dealsInfo){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		dealsInfo = _dealsInfo;
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(AirCrew.screen_background));
		setTitle(new ScreenTitle("Video"));
		add(new LabelField("Video"));
	}
	
	public boolean isDirty() {
	    return false;
	}
}
