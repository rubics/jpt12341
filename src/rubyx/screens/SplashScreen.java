package rubyx.screens;

import java.util.Timer;
import java.util.TimerTask;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.MainScreen;
 
public class SplashScreen extends MainScreen {
 
    Bitmap sbmp;
    Screen screen = this;
    int screenWidth = Display.getWidth();
    int screenHeight = Display.getHeight();
    
    Timer timer = new Timer();
 
    public SplashScreen(Bitmap popup, int seconds) {
        
        TimerTask timerTask = new TimerTask() {
            public void run() {
                DismissSplash();
            }
        };
        
        timer.schedule(timerTask, seconds*1000);
        sbmp = new Bitmap(Display.getWidth(),Display.getHeight());
        popup.scaleInto(0, 0, popup.getWidth(), popup.getHeight(), sbmp,0,0,Display.getWidth(),Display.getHeight(),Bitmap.FILTER_BILINEAR );
        
    }
 
    protected void paint(Graphics graphics) {
        super.paint(graphics);
        
        graphics.drawBitmap(0, 0, sbmp.getWidth(), sbmp.getHeight(), sbmp, 0, 0);
    }
 
    protected boolean navigationMovement(int dx, int dy, int status, int time) {
        return DismissSplash();
    }
 
    protected boolean navigationClick(int status, int time) {
        return DismissSplash();
    }
 
    protected boolean keyChar(char c, int status, int time) {
        return DismissSplash();
    }
 
    private boolean DismissSplash() {
       timer.cancel();
       UiApplication.getUiApplication().invokeLater(new Runnable() {
           public void run() {
               UiApplication.getUiApplication().popScreen(screen);
           }
       });
       return true;
    }
}