package com.impwalker.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.impwalker.habittracker.data.HabitContract.HabitEntry;
import com.impwalker.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {
  private HabitDbHelper mDbHelper;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  private void displayDatabaseInfo() {
    mDbHelper = new HabitDbHelper(this);
    SQLiteDatabase db = mDbHelper.getReadableDatabase();

    Cursor cursor = db.query(HabitEntry.TABLE_NAME, null, null, null, null, null, null);
    cursor.close();
  }

  private void insertHabit() {
    mDbHelper = new HabitDbHelper(this);
    SQLiteDatabase db = mDbHelper.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(HabitEntry.COLUMN_HABIT_NAME, HabitEntry.DEFAULT_HABIT_NAME);
    values.put(HabitEntry.COLUMN_DONE_THIS_WEEK, HabitEntry.DONE_THIS_WEEK_TRUE);

    db.insert(HabitEntry.TABLE_NAME, null, values);
  }
}
