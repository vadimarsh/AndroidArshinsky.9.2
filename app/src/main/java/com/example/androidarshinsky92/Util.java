package com.example.androidarshinsky92;

import android.app.Activity;

public class Util {

    public final static int THEME_DEFAULT = 0;
    public final static int THEME_LITTLE = 1;
    public final static int THEME_MEDIUM = 2;
    public final static int THEME_BIG = 3;
    private static int sTheme;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.recreate();
    }

    /**
     * Set the theme of the activity, according to the configuration.
     */
    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_LITTLE:
                activity.setTheme(R.style.MarginLittle);
                break;
            case THEME_MEDIUM:
                activity.setTheme(R.style.MarginMedium);
                break;
            case THEME_BIG:
                activity.setTheme(R.style.MarginBig);
                break;
        }
    }
}

