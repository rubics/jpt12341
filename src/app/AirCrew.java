package app;

import app.screens.Dashboard;
import rubyx.screens.SplashScreen;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;

public class AirCrew extends UiApplication {
	
	public static final Bitmap splash_image = Bitmap.getBitmapResource("images/splash_screen.png");
	public static final Bitmap screen_background = Bitmap.getBitmapResource("images/screen_background.png");
	
	public AirCrew(){

		Dashboard dashboard = new Dashboard();
		pushScreen(dashboard);
		
		SplashScreen splash = new SplashScreen(splash_image,1);
		pushScreen(splash);
	}
	
	public static void main(String [] args){
		
		AirCrew app = new AirCrew();
		app.enterEventDispatcher();
	}
}
