package com.bework.beworktracking.common.constants;

import java.util.Calendar;

public class Consts {

    private static long CURRENT_TIME_WITHOUT_TIME = 0;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        CURRENT_TIME_WITHOUT_TIME = calendar.getTimeInMillis();
       //Tracking.TIME_IN_FIRST_1 = 2500 + CURRENT_TIME_WITHOUT_TIME;

    }

    public static void init() {
        Tracking.ACCEPT_TIME = 300000l;
       // Tracking.TIME_IN_FIRST_1 = 2500 + CURRENT_TIME_WITHOUT_TIME;
        Tracking.TIME_IN_FIRST_1 = 25200000l + CURRENT_TIME_WITHOUT_TIME;
        Tracking.TIME_IN_FIRST_2 = 41400000l + CURRENT_TIME_WITHOUT_TIME;
        Tracking.TIME_OUT_FIRST_1 = 41400000l + CURRENT_TIME_WITHOUT_TIME;
        Tracking.TIME_OUT_FIRST_2 = 44100000l + CURRENT_TIME_WITHOUT_TIME;
        Tracking.TIME_IN_SECOND_1 = 44100000l + CURRENT_TIME_WITHOUT_TIME;
        Tracking.TIME_IN_SECOND_2 = 54000000l + CURRENT_TIME_WITHOUT_TIME;
        Tracking.TIME_OUT_SECOND_1 = 54600000l + CURRENT_TIME_WITHOUT_TIME;
        Tracking.TIME_OUT_SECOND_2 = 72000000l + CURRENT_TIME_WITHOUT_TIME;



    }

    public static class Tracking {
        public static long ACCEPT_TIME = 0;
        public static  long TIME_IN_FIRST_1 =  0; //7H
       // public static  long TIME_IN_FIRST_2 =  25200000L; //7H
       public static  long TIME_IN_FIRST_2 = 0;
       public static long TIME_OUT_FIRST_1 = 0;
       public static long TIME_OUT_FIRST_2 = 0;
       public static long TIME_IN_SECOND_1 = 0;
       public static long TIME_IN_SECOND_2 = 0;
       public static long TIME_OUT_SECOND_1 = 0;
       public static long TIME_OUT_SECOND_2 = 0;

    }
/*
    public final static long ACCEPT_TIME = 0;//= 300000l;//5 PHÚT

    public final static long TRACKING_TIME_IN_FIRST_1 = CURRENT_TIME_WITHOUT_TIME + 25200000L; //7H

    public final static long TRACKING_TIME_IN_FIRST_2 = CURRENT_TIME_WITHOUT_TIME + 41400000L;//11H30'41,400,000

    public final static long TRACKING_TIME_OUT_FIRST_1 = CURRENT_TIME_WITHOUT_TIME + 41400000L;//11h30'


    public final static long TRACKING_TIME_OUT_FIRST_2 = CURRENT_TIME_WITHOUT_TIME + 44100000L;//12H15'

    public final static long TRACKING_TIME_IN_SECOND_1 = CURRENT_TIME_WITHOUT_TIME + 44100000L;//12H15'

    public final static long TRACKING_TIME_IN_SECOND_2 = CURRENT_TIME_WITHOUT_TIME + 54000000L;//15H00'

    public final static long TRACKING_TIME_OUT_SECOND_1 = CURRENT_TIME_WITHOUT_TIME + 54600000L;//15H10'

    public final static long TRACKING_TIME_OUT_SECOND_2 = CURRENT_TIME_WITHOUT_TIME + 72000000L;//20H00'
    */
}
