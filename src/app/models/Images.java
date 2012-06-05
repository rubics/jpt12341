package app.models;

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
	
	public static final Bitmap nextProfile = Bitmap.getBitmapResource("images/favorites/nextProfile.png");
	public static final Bitmap prevProfile = Bitmap.getBitmapResource("images/favorites/prevProfile.png");
	public static final Bitmap avatar = Bitmap.getBitmapResource("images/favorites/avatar.png");
	public static final Bitmap avatar_a = Bitmap.getBitmapResource("images/profile/gallery_1.png");
	
	public static final Bitmap[] chatScreenIcons = {Bitmap.getBitmapResource("images/chat/filter.png"),
		Bitmap.getBitmapResource("images/chat/favorites.png"),
		Bitmap.getBitmapResource("images/chat/nearme.png"),
		Bitmap.getBitmapResource("images/chat/history.png")};
	
	public static final Bitmap screen_background = Bitmap.getBitmapResource("images/screen_background.png");
	
	public static final Bitmap[] deals_tabbed_button = {Bitmap.getBitmapResource("images/deals/nearme.png"),
		Bitmap.getBitmapResource("images/deals/filter.png")};
	
	public static final Bitmap[] profile_pics = {Bitmap.getBitmapResource("images/profile_1.png"),
		Bitmap.getBitmapResource("images/profile_2.png"),
		Bitmap.getBitmapResource("images/profile_3.png"),
		Bitmap.getBitmapResource("images/profile_4.png")
	};
}
