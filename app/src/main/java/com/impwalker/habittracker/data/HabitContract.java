package com.impwalker.habittracker.data;

import android.provider.BaseColumns;

public final class HabitContract {

  private HabitContract() {
  }

  public static final class HabitEntry implements BaseColumns {
    public static final String DEFAULT_HABIT_NAME = "Take out the trash";
    public static final String TABLE_NAME = "habits";

    public static final String _ID = BaseColumns._ID;
    public final static String COLUMN_HABIT_NAME = "name";
    public final static String COLUMN_DONE_THIS_WEEK = "done_this_week";

    public final static int DONE_THIS_WEEK_FALSE = 0;
    public final static int DONE_THIS_WEEK_TRUE = 1;
  }
}
