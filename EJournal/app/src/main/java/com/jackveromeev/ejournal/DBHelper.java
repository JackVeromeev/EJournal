package com.jackveromeev.ejournal;

import java.util.ArrayList;

/**
 * Created by Jack on 09.12.2016.
 */

public class DBHelper {
    public class ClassTime {
        public int startHour, startMinute, endHour, endMinute;
    }
    private static ArrayList<ClassTime> classTimes;
    public static ArrayList<ClassTime> sTempTimes;
    public DBHelper() {
        if (classTimes == null) {
            classTimes = new ArrayList<ClassTime>();
        }
            sTempTimes = new ArrayList<ClassTime>(classTimes);
    }
    public int getClassesAmount() {
        int i = 0;
        try {
            i = classTimes.size();
        } catch (Exception e) {
        }
        return i;
    }
}
