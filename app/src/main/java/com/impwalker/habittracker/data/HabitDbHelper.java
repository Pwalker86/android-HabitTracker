package com.impwalker.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.impwalker.habittracker.data.HabitContract.HabitEntry;

public class HabitDbHelper extends SQLiteOpenHelper {
  private static final String DATABASE_NAME = "habit_tracker.db";
  private static final int DATABASE_VERSION = 1;

  public HabitDbHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  private static final String SQL_CREATE_ENTRIES =
      "CREATE TABLE " + HabitEntry.TABLE_NAME + " (" +
          HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
          HabitEntry.COLUMN_DONE_THIS_WEEK + " INTEGER DEFAULT 0," +
          HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL)";

  private static final String SQL_DELETE_ENTRIES =
      "DROP TABLE IF EXISTS " + HabitEntry.TABLE_NAME;

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

  }
}
