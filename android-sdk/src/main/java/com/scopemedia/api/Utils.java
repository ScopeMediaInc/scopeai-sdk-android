package com.scopemedia.api;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * @author Maikel Rehl on 8/25/2017.
 */

public class Utils {

    /**
     * Encode a bitmap into a base64 String
     * The Bitmap will be resized to max 299x299
     * @param bitmap
     * @return
     */
    public static String bitmap2base64(Bitmap bitmap){
        if (bitmap == null) return "";
        try {
            int max = 299;
            float srcWidth = bitmap.getWidth();
            float srcHeight = bitmap.getHeight();

            int newWidth = max;
            int newHeight = max;
            if (srcWidth > srcHeight) {
                newHeight = (int) ((srcHeight * max) / srcWidth);
            } else {
                newWidth = (int) ((srcWidth * max) / srcHeight);
            }

            Bitmap result = Bitmap.createBitmap(max, max, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            int left = (int)((max - newWidth) / 2f);
            int top = (int)((max - newHeight) / 2f);
            canvas.drawBitmap(bitmap, null, new RectF(left, top, newWidth + left, newHeight + top), paint);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            result.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream .toByteArray();
            return Base64.encodeToString(byteArray, Base64.DEFAULT);
        }
        catch (Exception e) {
            return "";
        }
    }
}
