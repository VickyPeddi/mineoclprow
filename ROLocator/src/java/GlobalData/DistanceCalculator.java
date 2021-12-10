package GlobalData;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

class DistanceCalculator {

//   distance(32.9697, -96.80322, 29.46786, -98.53506, "K")
    public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        String ret = "";
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        }
        double final_dist = roundTwoDecimals(dist);
//        if (final_dist < 1) {
//            ret = String.valueOf(final_dist * 1000);
//        } else {
//            ret = String.valueOf(final_dist);
//        }
        return final_dist;
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    public static double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }
}
