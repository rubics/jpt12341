package app.fields;


import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Keypad;
import net.rim.device.api.ui.container.HorizontalFieldManager;

public class ListItem extends Field{
	
	static int width = Display.getWidth();
	static int height = 72;
	static int bitmap_dimension = 60;
	
	static int bitmap_offset_h = 20;
	static int bitmap_offset_v = 5;
	
	static int name_offset_h = 2*bitmap_offset_h + bitmap_dimension;
	static int description_offset_v = height/2;
	
	static Bitmap focus_background = Bitmap.getBitmapResource("images/listItem_background.png");
	
	
	Bitmap profilePicture;
	String name;
	String description;
	
	public ListItem( Bitmap _profilePicture, String _name, String _description){
		profilePicture = new Bitmap( bitmap_dimension, bitmap_dimension);
		_profilePicture.scaleInto(0, 0, _profilePicture.getWidth(), _profilePicture.getHeight(), profilePicture, 0, 0, profilePicture.getWidth(), profilePicture.getHeight(), Bitmap.FILTER_BILINEAR);
		name = _name;
		description = _description;
	}
	
	protected void paint(Graphics g){
		if(isFocus()){
			g.drawBitmap(0,0, width, height, focus_background, 0, 0);
		}
		g.drawBitmap(bitmap_offset_h, bitmap_offset_v, bitmap_dimension, bitmap_dimension, profilePicture, 0, 0);
		g.drawText(name, name_offset_h , bitmap_offset_v);
		g.drawText(description, name_offset_h, description_offset_v);
		g.setColor(0x555555);
		g.fillRect(5, 70, width-10, 2);
	}

	protected void layout(int _width, int _height) {
		setExtent(width, height);
	}
	
	protected void drawFocus(Graphics _graphics, boolean on) {

	}
	
	public boolean isFocusable(){
		return true;
	}
	
	protected boolean navigationClick(int status, int time){
		fieldChangeNotify(0);
		return true;
	}
	
	protected boolean keyChar(char character, int status, int time){
		if(character == Keypad.KEY_ENTER){
			fieldChangeNotify(0);
			return true;
		}
		return super.keyChar(character, status, time);
	}
	
	protected boolean trackwheelClick(int arg0, int arg1) {
		return super.trackwheelClick(arg0, arg1);		
	}
	
	protected void fieldChangeNotify(int context) {
		super.fieldChangeNotify(context);
	}

}
