package app.fields;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Graphics;

public class SpaceField extends Field {
	
	int height;
	int color;
	
	public SpaceField(int _height, int _color){
		height = _height;
		color  = _color;
	}
	
	protected void layout(int _width, int _height){
		
		setExtent(_width, height);		
	}
	
	protected void paint(Graphics graphics){

	}	
}
