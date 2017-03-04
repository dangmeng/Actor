package com.dm.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.dm.theme.Theme;

/**
 * Created by m on 2017/3/4.
 * ${describe}
 */

public class PreUtils {

    private static SharedPreferences getSharedPreferences(final Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static boolean isFirstTime(Context context, String key) {
        if (getBoolean(context, key, false)) {
            return false;
        } else {
            putBoolean(context, key, true);
            return true;
        }
    }

    public static boolean contains(Context context, String key) {
        return PreUtils.getSharedPreferences(context).contains(key);
    }

    public static int getInt(final Context context, final String key, final int defaultValue) {
        return PreUtils.getSharedPreferences(context).getInt(key, defaultValue);
    }

    public static boolean putInt(final Context context, final String key, final int pValue) {
        final SharedPreferences.Editor editor = PreUtils.getSharedPreferences(context).edit();

        editor.putInt(key, pValue);

        return editor.commit();
    }

    public static long getLong(final Context context, final String key, final long defaultValue) {
        return PreUtils.getSharedPreferences(context).getLong(key, defaultValue);
    }

    public static Long getLong(final Context context, final String key, final Long defaultValue) {
        if (PreUtils.getSharedPreferences(context).contains(key)) {
            return PreUtils.getSharedPreferences(context).getLong(key, 0);
        } else {
            return null;
        }
    }


    public static boolean putLong(final Context context, final String key, final long pValue) {
        final SharedPreferences.Editor editor = PreUtils.getSharedPreferences(context).edit();

        editor.putLong(key, pValue);

        return editor.commit();
    }

    private static boolean getBoolean(final Context context, final String key, final boolean defaultValue) {
        return PreUtils.getSharedPreferences(context).getBoolean(key, defaultValue);
    }

    private static boolean putBoolean(final Context context, final String key, final boolean pValue) {
        final SharedPreferences.Editor editor = PreUtils.getSharedPreferences(context).edit();

        editor.putBoolean(key, pValue);

        return editor.commit();
    }

    private static String getString(final Context context, final String key, final String defaultValue) {
        return PreUtils.getSharedPreferences(context).getString(key, defaultValue);
    }

    private static boolean putString(final Context context, final String key, final String pValue) {
        final SharedPreferences.Editor editor = PreUtils.getSharedPreferences(context).edit();

        editor.putString(key, pValue);

        return editor.commit();
    }


    public static boolean remove(final Context context, final String key) {
        final SharedPreferences.Editor editor = PreUtils.getSharedPreferences(context).edit();

        editor.remove(key);

        return editor.commit();
    }

    public static Theme getCurrentTheme(Context context) {
        return Theme.valueOf(PreUtils.getString(context, "app_theme", Theme.Brown.name()));
    }

    public static void setCurrentTheme(Context context, Theme currentTheme) {
        PreUtils.putString(context, "app_theme", currentTheme.name());
    }
}
