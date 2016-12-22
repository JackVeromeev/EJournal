package com.jackveromeev.ejournal.filework;

import android.util.Log;

import com.jackveromeev.ejournal.entity.ClassTime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Jack on 12/22/2016.
 */

public class ClassTimeFile implements IFileHelper {

    final static String FILE_NAME = "ClassTime.dat";

    private ArrayList<ClassTime> data = null;

    private static ClassTimeFile entity;

    private ClassTimeFile() {
        data = new ArrayList<ClassTime>();
        loadData();
    }

    @Override
    public void loadData() {
        File dataFile = new File(FILE_NAME);
        String[] params;
        String line;
        if (dataFile.exists()) {
            try {
                BufferedReader in = new BufferedReader(
                        new FileReader(dataFile.getAbsoluteFile()));
                try {
                    while((line = in.readLine()) != null) {
                        params = line.split(" ");
                        if (params.length != 4) throw new Exception("Class time file if corrupted");
                        data.add(new ClassTime(params[0], params[1], params[2], params[3]));
                    }
                } finally {
                    in.close();
                }
            } catch (Exception e) {
                Log.d(LOG_TAG, "Load file of class-time crashed (" + e.getMessage() + ")");
            }
        }
    }

    public static ArrayList<ClassTime> getData() {
        if (entity == null) {
            entity = new ClassTimeFile();
        }
        return entity.data;
    }

    public static void saveData() {
        try {
            File dataFile = new File(FILE_NAME);
            dataFile.createNewFile();
            PrintWriter out = new PrintWriter(dataFile.getAbsoluteFile());
            try {
                for (ClassTime ct : entity.data) {
                    out.println(ct.toString());
                }
            } finally {
                out.close();
            }
        } catch (Exception e) {
            Log.d(LOG_TAG, "Save file of class-time crashed (" + e.getMessage() + ")");
        }
    }
}