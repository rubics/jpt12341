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
		add(new CustomRichTextField("Hello, lkdfjs dslkfjsd dkfj alowpl vnlkie cnkdfopwlv vcn wjdicn dslf dkfj aaxcc xcxkc oikz ,xcisix cwsdc k.x jq sk ois sjdilskd  ", 240));
		
		add(new CompositeObjectChoiceField("Airline", airlines,0));
	}
	
	public boolean isDirty() {
	    return false;
	}
}
