package app.fields;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.container.HorizontalFieldManager;

public class TabbedButtonManager extends HorizontalFieldManager {
	private int width;
	private int height;
	
	public TabbedButtonManager(int _width, int _height){
		super(Field.FIELD_HCENTER);
		width = _width;
		height = _height;
	}
	
	protected void sublayout(int _width, int _height){
		int fieldcount = getFieldCount();
		if(fieldcount == 0)
			return;
		else if(fieldcount==1){
			if(TabbedButton.class.isInstance(getField(0)))
				((TabbedButton)getField(0)).setDrawStyle(TabbedButton.DRAWSTYLE_SINGLE);
		} else {
			if(TabbedButton.class.isInstance(getField(0)))
				((TabbedButton)getField(0)).setDrawStyle(TabbedButton.DRAWSTYLE_FIRST);
			if(TabbedButton.class.isInstance(getField(fieldcount-1)))
				((TabbedButton)getField(fieldcount-1)).setDrawStyle(TabbedButton.DRAWSTYLE_LAST);
			for (int i=1; i<fieldcount-1; i++){
				if(TabbedButton.class.isInstance(getField(i)))
					((TabbedButton)getField(i)).setDrawStyle(TabbedButton.DRAWSTYLE_MIDDLE);
			}
		}

		int w = width/fieldcount;
		for(int i=0; i<fieldcount; i++){
			setPositionChild(getField(i), i*w, 0);
			layoutChild(getField(i), w, height);
		}
		
		setExtent(width, height);
	}
}
