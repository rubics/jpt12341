package app.screens;




import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;
import rubyx.layout_managers.TableLayoutManager;
import app.AirCrew;
import app.fields.DashboardItem;
import app.fields.ScreenTitle;
import app.managers.chat.ChatScreenManager;
import app.managers.deals.DealsScreenManager;
import app.managers.profile.ProfileInfoScreenManager;
import app.models.Images;
import app.screens.deals.SearchResultScreen;
import app.screens.favorites.FavoritesScreen;

public class DashboardScreen extends MainScreen{
	
	private static DashboardScreen dashboardScreen;
	
	AirCrew airCrew = (AirCrew)(UiApplication.getUiApplication());
	
	public static Bitmap[] icons = {Bitmap.getBitmapResource("images/dashboard/deals.png"),
				Bitmap.getBitmapResource("images/dashboard/chat.png"),
				Bitmap.getBitmapResource("images/dashboard/bookmarks.png"),
				Bitmap.getBitmapResource("images/dashboard/favourites.png"),
				Bitmap.getBitmapResource("images/dashboard/myprofile.png"),
				Bitmap.getBitmapResource("images/dashboard/visitors.png"),
				Bitmap.getBitmapResource("images/dashboard/toolbox.png"),
				Bitmap.getBitmapResource("images/dashboard/hotdeals.png"),
				Bitmap.getBitmapResource("images/dashboard/settings.png")};
	
	Bitmap[] titles = {Bitmap.getBitmapResource("images/dashboard/deals_title.png"),
			Bitmap.getBitmapResource("images/dashboard/chat_title.png"),
			Bitmap.getBitmapResource("images/dashboard/bookmarks_title.png"),
			Bitmap.getBitmapResource("images/dashboard/favourites_title.png"),
			Bitmap.getBitmapResource("images/dashboard/myprofile_title.png"),
			Bitmap.getBitmapResource("images/dashboard/visitors_title.png"),
			Bitmap.getBitmapResource("images/dashboard/toolbox_title.png"),
			Bitmap.getBitmapResource("images/dashboard/hotdeals_title.png"),
			Bitmap.getBitmapResource("images/dashboard/settings_title.png")};
	
	
	final int[] column_styles = {TableLayoutManager.FIXED_WIDTH,TableLayoutManager.FIXED_WIDTH,TableLayoutManager.FIXED_WIDTH}; 
	final int[] column_widths = {Display.getWidth()/3,Display.getWidth()/3,Display.getWidth()/3};
	final int horizontal_padding = 1;
	
	FieldChangeListener dashboardItemListener = new FieldChangeListener() {
		
		public void fieldChanged(Field field, int context) {
			int index = ((DashboardItem)field).index;
			
			switch (index){
			case 1:
				DealsScreenManager dealsScreenManger = new DealsScreenManager();
				dealsScreenManger.pushScreen();
				break;
			case 2:
				ChatScreenManager chatScreenManager = new ChatScreenManager();
				chatScreenManager.pushScreen();
				break;
			case 3:
				airCrew.pushScreen(new BookmarksScreen());
				break;
			case 4:
				airCrew.pushScreen(new FavoritesScreen());
				break;
			case 5:
				ProfileInfoScreenManager profileInfo = new ProfileInfoScreenManager();
				profileInfo.pushScreen();
				break;
			case 7:
				airCrew.pushScreen(new ToolboxScreen());
				break;
			default:
				break;
			}
		}
	};
	
	public static DashboardScreen createDashboardScreenInstance(){
		if(dashboardScreen == null)
			return new DashboardScreen();
		else
			return dashboardScreen;
	}
	
	private DashboardScreen(){
		super(Manager.USE_ALL_HEIGHT);
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(Images.screen_background));
		setTitle(new ScreenTitle("Dashboard"));
		
		TableLayoutManager layoutManager = new TableLayoutManager(column_styles, column_widths, horizontal_padding, 0) ;
		
		for(int i=0; i<9; i++){
			System.out.println(">> " + i);
			Field dashboardItem = new DashboardItem(icons[i], titles[i], i+1);
			dashboardItem.setChangeListener(dashboardItemListener);
			layoutManager.add(dashboardItem);
		}
		
		add(layoutManager);
	}
	
	public boolean isDirty() {
	    return false;
	}
}

//class BackgroundImageManager extends HorizontalFieldManager{
//	public BackgroundImageManager(){
//		super(HorizontalFieldManager.USE_ALL_WIDTH | HorizontalFieldManager.USE_ALL_HEIGHT);
//	}
//	protected void paint(Graphics g){
//		g.drawBitmap(0, 0, Display.getWidth(), Display.getHeight(), AirCrew.splash_image, 0, 0);
//		super.paint(g);
//	}
//	
//}
