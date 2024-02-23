package com.socialchitchat.Utils;

import android.app.Application;
import android.content.Context;

public class UserLastSeenTime extends Application{

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;


    public static String getTimeAgo(long time, Context applicationContext) {
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000;
        }


        long now = System.currentTimeMillis();
        if (time > now || time <= 0) {

            return "Active just now";
            //return null;
        }

        // TODO: localize
        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return "Active few seconds ago";

        } else if (diff < 2 * MINUTE_MILLIS) {
            return "Active a minute ago";

        } else if (diff < 50 * MINUTE_MILLIS) {
            return "Active " + diff / MINUTE_MILLIS + " minutes ago";

        } else if (diff < 90 * MINUTE_MILLIS) {
            return "Active an hour ago";

        } else if (diff < 24 * HOUR_MILLIS) {
            return "Active " + diff / HOUR_MILLIS + " hours ago";

        } else if (diff < 48 * HOUR_MILLIS) {
            return "Active on yesterday";

        } else {
            return "Active " + diff / DAY_MILLIS + " days ago";
        }
    }

}
