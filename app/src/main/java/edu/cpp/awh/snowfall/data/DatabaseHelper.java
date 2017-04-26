package edu.cpp.awh.snowfall.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import edu.cpp.awh.snowfall.R;
import edu.cpp.awh.snowfall.model.ActivityBundle;
import edu.cpp.awh.snowfall.model.Observation;
import edu.cpp.awh.snowfall.model.Student;
import edu.cpp.awh.snowfall.model.User;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "snowfall.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Student, Integer> studentDao;
    private Dao<Observation, Integer> observationDao;
    private Dao<ActivityBundle, Integer> activityBundleDao;
    private Dao<User, Integer> userDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try
        {
            TableUtils.createTable(connectionSource, Student.class);
            TableUtils.createTable(connectionSource, Observation.class);
            TableUtils.createTable(connectionSource, ActivityBundle.class);
            TableUtils.createTable(connectionSource, User.class);
        }
        catch(SQLException e)
        {
            Log.e(DatabaseHelper.class.getName(), "Unable to create databases");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try
        {
            TableUtils.dropTable(connectionSource, Student.class, true);
            TableUtils.dropTable(connectionSource, Observation.class, true);
            TableUtils.dropTable(connectionSource, ActivityBundle.class, true);
            TableUtils.dropTable(connectionSource, User.class, true);

            onCreate(sqLiteDatabase, connectionSource);
        }
        catch(SQLException e)
        {
            Log.e(DatabaseHelper.class.getName(), "Unable to upgrade database from version " + oldVersion + " to new " + newVersion, e);
        }
    }
}
