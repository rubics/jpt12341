package app.screens;

import net.rim.device.api.system.Bitmap;
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
import app.fields.ListItem;

public class SearchResults extends MainScreen{
	Bitmap search_results_title_bar = Bitmap.getBitmapResource("images/search_results_title_bar.png");
	
	Bitmap[] profile_pics = {Bitmap.getBitmapResource("images/profile_1.png"),
			Bitmap.getBitmapResource("images/profile_2.png"),
			Bitmap.getBitmapResource("images/profile_3.png"),
			Bitmap.getBitmapResource("images/profile_4.png")
		};
	String[] names = {"Jimmy Jimmy","Jimmy Jimmy","Jimmy Jimmy","Jimmy Jimmy"};
	String[] descriptions = {"description","description","description","description"};
	
	ProgressBar progressBar;
	
	
	
	public SearchResults(){
		super(Manager.USE_ALL_HEIGHT);
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(AirCrew.screen_background));
		mainManager.add(new BitmapField(search_results_title_bar));
		
		VerticalFieldManager listManager = new VerticalFieldManager();
		
		for(int i=0; i < profile_pics.length; i++){
			listManager.add(new ListItem(profile_pics[i], names[i], descriptions[i]));
		}
		
		add(listManager);
		
		progressBar = new ProgressBar(0);
		setStatus(progressBar);
		progressBar.update(5, 12);
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
