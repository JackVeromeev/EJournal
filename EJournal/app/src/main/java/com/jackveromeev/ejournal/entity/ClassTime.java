package com.jackveromeev.ejournal.entity;

/**
 * Created by Jack on 09.12.2016.
 */

public class ClassTime {
    public int startHour, startMinute, endHour, endMinute;

    ClassTime (int sh, int sm, int eh, int em) {
        startHour = sh;
        startMinute = sm;
        endHour = eh;
        endMinute = em;
    }

    public ClassTime(String sh, String sm, String eh, String em) {
        new ClassTime(Integer.parseInt(sh),
                Integer.parseInt(sm),
                Integer.parseInt(eh),
                Integer.parseInt(em));
    }

    @Override
    public String toString() {
        return startHour + " " + startMinute + " " + endHour + " " + endMinute;
    }
}
