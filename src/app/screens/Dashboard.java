package app.screens;


import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;
import rubyx.layout_managers.TableLayoutManager;
import app.AirCrew;
import app.fields.DashboardItem;

public class Dashboard extends MainScreen{
	
	AirCrew airCrew = (AirCrew)(UiApplication.getUiApplication());
	
	Bitmap dashboard_title = Bitmap.getBitmapResource("images/dashboard_title_bar.png");
	
	Bitmap[] icons = {Bitmap.getBitmapResource("images/deals.png"),
				Bitmap.getBitmapResource("images/chat.png"),
				Bitmap.getBitmapResource("images/bookmarks.png"),
				Bitmap.getBitmapResource("images/favourites.png"),
				Bitmap.getBitmapResource("images/myprofile.png"),
				Bitmap.getBitmapResource("images/visitors.png"),
				Bitmap.getBitmapResource("images/toolbox.png"),
				Bitmap.getBitmapResource("images/hotdeals.png"),
				Bitmap.getBitmapResource("images/settings.png")};
	
	Bitmap[] titles = {Bitmap.getBitmapResource("images/deals_title.png"),
			Bitmap.getBitmapResource("images/chat_title.png"),
			Bitmap.getBitmapResource("images/bookmarks_title.png"),
			Bitmap.getBitmapResource("images/favourites_title.png"),
			Bitmap.getBitmapResource("images/myprofile_title.png"),
			Bitmap.getBitmapResource("images/visitors_title.png"),
			Bitmap.getBitmapResource("images/toolbox_title.png"),
			Bitmap.getBitmapResource("images/hotdeals_title.png"),
			Bitmap.getBitmapResource("images/settings_title.png")};
	
	
	final int[] column_styles = {TableLayoutManager.FIXED_WIDTH,TableLayoutManager.FIXED_WIDTH,TableLayoutManager.FIXED_WIDTH}; 
	final int[] column_widths = {Display.getWidth()/3,Display.getWidth()/3,Display.getWidth()/3};
	final int horizontal_padding = 1;
	
	FieldChangeListener dashboardItemListener = new FieldChangeListener() {
		
		public void fieldChanged(Field field, int context) {
			int index = ((DashboardItem)field).index;
			
			switch (index){
			case 1:
				airCrew.pushScreen(new SearchResults());
				break;
			default:
				break;
			}
		}
	};
	
	public Dashboard(){
		super(Manager.USE_ALL_HEIGHT);
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(AirCrew.screen_background));
		mainManager.add(new BitmapField(dashboard_title));
		
		TableLayoutManager layoutManager = new TableLayoutManager(column_styles, column_widths, horizontal_padding, 0) ;
		
		for(int i=0; i<9; i++){
			Field dashboardItem = new DashboardItem(icons[i], titles[i], i+1);
			dashboardItem.setChangeListener(dashboardItemListener);
			layoutManager.add(dashboardItem);
		}
		
		add(layoutManager);
	}
	
}

class BackgroundImageManager extends HorizontalFieldManager{
	public BackgroundImageManager(){
		super(HorizontalFieldManager.USE_ALL_WIDTH | HorizontalFieldManager.USE_ALL_HEIGHT);
	}
	protected void paint(Graphics g){
		g.drawBitmap(0, 0, Display.getWidth(), Display.getHeight(), AirCrew.splash_image, 0, 0);
		super.paint(g);
	}
	
}
