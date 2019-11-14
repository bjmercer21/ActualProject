package com.hfad.mobilefitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* Coded by Forest Gates */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "MFA_DB";
    private static final int DB_VERSION = 4;

    public DBHelper(Context context){super(context,DB_NAME,null,DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {createDefaultTables(db);}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER");
        db.execSQL("DROP TABLE IF EXISTS EXAM");
        db.execSQL("DROP TABLE IF EXISTS WORKOUT");
        db.execSQL("DROP TABLE IF EXISTS EXERCISE");
        createDefaultTables(db);
    }

    public Cursor viewData(String TABLE_NAME){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor c = db.rawQuery(query,null);

        return c;
    }

    private static void createDefaultTables(SQLiteDatabase db){
        db.execSQL("CREATE TABLE USER( "
                + "GENDER INT, "
                + "AGE INT, "
                + "HEIGHT INT, "
                + "WEIGHT INT, "
                + "UPPERMOD INT, "
                + "LOWERMOD INT, "
                + "CARDIOMOD INT);");

        db.execSQL("CREATE TABLE EXAM( "
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "DATE CHAR, "
                + "PUSHUPS INT, "
                + "SQUATS INT, "
                + "PLANK INT, "
                + "WALK INT);");

        db.execSQL("CREATE TABLE WORKOUT( "
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "DATE CHAR, "
                + "EXERCISES VARCHAR(100));");

        db.execSQL("CREATE TABLE EXERCISE( "
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "SETS INT, "
                + "REPS INT, "
                + "WEIGHT INT, "
                + "DESCR TEXT);");

        insertExercise(db,"WALL PUSHUP","5",5,0,15,"Description");
        insertExercise(db,"PRESS","5",5,0,15,"Description");
        insertExercise(db,"PUSHUP","5",5,0,15,"Description");
        insertExercise(db,"TRX PUSHUP","5",5,0,15,"Description");
        insertExercise(db,"DUMBELL PRESS","5",5,0,15,"Description");
        insertExercise(db,"DUMBELL FLY","5",5,0,15,"Description");
        insertExercise(db,"SQUAT","5",5,0,15,"Description");
        insertExercise(db,"LUNGES","5",5,0,15,"Description");
        insertExercise(db,"DONKEY KICKS","5",5,0,15,"Description");
        insertExercise(db,"PLANK","5",5,0,15,"Description");
        insertExercise(db,"SUPERMAN HOLD","5",5,0,15,"Description");
        insertExercise(db,"SIDE PLANK","5",5,0,15,"Description");
    }

    public static void insertUser(SQLiteDatabase db, int gender, int age, int height, int weight, int upperMod, int lowerMod, int cardioMod){
        ContentValues userVals = new ContentValues();
        userVals.put("GENDER", gender);
        userVals.put("AGE", age);
        userVals.put("HEIGHT", height);
        userVals.put("WEIGHT", weight);
        userVals.put("UPPERMOD", upperMod);
        userVals.put("LOWERMOD", lowerMod);
        userVals.put("CARDIOMOD", cardioMod);
        db.insert("USER",null,userVals);
    }

    public static void insertExam(SQLiteDatabase db, String eid, int pushups, int squats, int plank, int bpm){
        ContentValues examValues = new ContentValues();
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String theDate = date.toString();

        examValues.put("EID", eid);
        examValues.put("DATE", theDate);
        examValues.put("PUSHUPS", pushups);
        examValues.put("SQUATS", squats);
        examValues.put("PLANK", plank);
        examValues.put("WALK", bpm);

        db.insert("EMPLOYEE",null, examValues);
    }

    private static void insertWorkout(SQLiteDatabase db, String wid, String exercises){
        ContentValues workoutValues = new ContentValues();
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String theDate = date.toString();

        workoutValues.put("WID", wid);
        workoutValues.put("DATE", theDate);
        workoutValues.put("EXERCISES", exercises);
        db.insert("ODETAILS",null,workoutValues);
    }

    public static void insertExercise(SQLiteDatabase db, String tid, String name,
                                      int reps, int sets, int weight, String desc){
        ContentValues orderValues = new ContentValues();
        orderValues.put("EID", tid);
        orderValues.put("NAME", name);
        orderValues.put("REPS", reps);
        orderValues.put("SETS", sets);
        orderValues.put("WEIGHT", weight);
        orderValues.put("DESC", desc);
        db.insert("ORDERS",null,orderValues);
    }

}
