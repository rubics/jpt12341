package app.fields.favorites;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class ProfileDetails extends Field{
	
	String name;
	String status;
	String location;
	String designation;
	String airlines;
	String aboutMe;
	
	String[] labels = {"Name", "Status", "Location", "Designation", "Airlines", "About Me"};
	String [] values = {"Kristine Jacob", "Online", "Dubai, UAE", "Cabin Crew", "Emirates","Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium," };
	
	private static final Font font = Font.getDefault().derive(Font.PLAIN, 20, Ui.UNITS_px);
	
	public ProfileDetails(){
		super();
	}

	protected void paint(Graphics graphics) {
		graphics.setFont(font);
		graphics.drawText("HELLO there", 0, 0);
		for(int i=0; i<labels.length; i++){
			graphics.setColor(0xF57000);
			graphics.drawText(labels[i], 0, font.getHeight()*i);
			graphics.setColor(Color.GRAY);
			graphics.drawText(values[i], font.getAdvance(labels[i]), font.getHeight()*i);
		}
		
	}


	protected void layout(int width, int height) {
		setExtent(width, height);
	}
}
