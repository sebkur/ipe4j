package de.topobyte.ipe.jaxb.bitmaps;

import de.topobyte.ipe.bitmaps.ImageEncoding;
import de.topobyte.ipe.jaxb.model.Bitmap;

public class Bitmaps
{

	private static final String FlateDecode = "FlateDecode";
	private static final String DCTDecode = "DCTDecode";

	public static String getExtension(ImageEncoding imageEncoding)
	{
		switch (imageEncoding) {
		default:
		case FLATE_DECODE:
			return "png";
		case DCT_DECODE:
			return "jpg";
		}
	}

	public static ImageEncoding getImageEncoding(Bitmap bitmap)
	{
		return getImageEncoding(bitmap.getFilter());
	}

	public static ImageEncoding getImageEncoding(String name)
	{
		if (name.equals(FlateDecode)) {
			return ImageEncoding.FLATE_DECODE;
		} else if (name.equals(DCTDecode)) {
			return ImageEncoding.DCT_DECODE;
		}
		return null;
	}

}
