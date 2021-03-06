package com.android.utils;

import java.io.InputStream;

import org.apache.http.util.EncodingUtils;

import android.content.Context;

public class Utils {

    public static String parseHexData(String data) {
        StringBuffer sb = new StringBuffer();
        String string = data.replaceAll("\\s{1,}", "");
        if (string.startsWith("02") && string.endsWith("0D0A03")) {
            String value = string.substring(2, string.length() - 6);
            for (int i = 0; i < value.length(); i++) {
                if (i % 2 != 0) {
                    sb.append(value.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    // fetch file from assets fold
    public String getFromAssets(Context context, String fileName) {
        String result = "";
        try {
            InputStream in = context.getResources().getAssets().open(fileName);
            int length = in.available();
            byte[] buffer = new byte[length];
            in.read(buffer);
            result = EncodingUtils.getString(buffer, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
