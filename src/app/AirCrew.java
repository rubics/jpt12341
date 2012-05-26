package app;

import app.screens.SigninScreen;
import app.screens.SplashScreen;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.UiApplication;

public class AirCrew extends UiApplication {
	
	private static AirCrew app;
	
	public static AirCrew createAirCrewInstance(){
		if(app == null)
			return new AirCrew();
		else
			return app;
	}

	protected AirCrew(){
		SigninScreen signinScreen = new SigninScreen();
		pushScreen(signinScreen);
		
		SplashScreen splash = new SplashScreen((float) 0.5);
		pushScreen(splash);
	}
	
	public static void main(String [] args){
		
		AirCrew app = AirCrew.createAirCrewInstance();
		app.enterEventDispatcher();
	}
}
