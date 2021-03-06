package com.light.core.Utils;

import android.graphics.Bitmap;

import com.light.body.Light;

/**
 * Created by xiaoqi on 2017/11/22
 */

public class MemoryComputeUtil {
	private final static String TAG = Light.TAG + "-MemoryComputeUtil";

	//单位kb
	public static int getMemorySize(Bitmap bitmap){
		Bitmap.Config config = bitmap.getConfig();
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		L.e(TAG, "width:" + width + "height:"+ height);
		int totalSize;
		if(config.equals(Bitmap.Config.ALPHA_8)){
			totalSize = width * height;
		}else if(config.equals(Bitmap.Config.ARGB_4444)){
			totalSize = width * height * 2;
		}else if(config.equals(Bitmap.Config.RGB_565)){
			totalSize = width * height * 2;
		}else {
			//ARGB_8888
			totalSize = width * height * 4;
		}
		L.e(TAG, "totalMemorySize:"+ totalSize / 1024 +"kb");
		return totalSize / 1024;
	}

	public static int getMemorySize2(Bitmap bitmap){
		return bitmap.getByteCount();
	}
}
