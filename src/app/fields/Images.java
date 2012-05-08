package app.fields;

import net.rim.device.api.system.Bitmap;

public class Images {
	public static final Bitmap arrowhead = Bitmap.getBitmapResource("images/listing/arrowhead.png");
	public static final Bitmap soffline = Bitmap.getBitmapResource("images/listing/soffline.png");
	public static final Bitmap saway = Bitmap.getBitmapResource("images/listing/saway.png");
	
	public static final Bitmap[] toolbox = {Bitmap.getBitmapResource("images/listing/iconCurrency.png"),
		Bitmap.getBitmapResource("images/listing/iconWeather.png"),
		Bitmap.getBitmapResource("images/listing/iconSatelite.png"),
		Bitmap.getBitmapResource("images/listing/iconTaf.png"),
		Bitmap.getBitmapResource("images/listing/iconCrew.png"),
		Bitmap.getBitmapResource("images/listing/iconRecommendation.png")};
	public static final String[] toolbox_names ={"Currency Converter", "Weather Forecast", "Satellite Map", "METAR & TAF", "Crew Discussion", "Recommend 4Aircrew"};
}
