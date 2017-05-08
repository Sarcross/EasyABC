package edu.cpp.awh.easyabc.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import edu.cpp.awh.easyabc.R;
import edu.cpp.awh.easyabc.model.ActivityBundle;
import edu.cpp.awh.easyabc.model.Observation;
import edu.cpp.awh.easyabc.model.Student;
import edu.cpp.awh.easyabc.model.User;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "easyabc.db";
    private static final int DATABASE_VERSION = 2;

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
            TableUtils.createTableIfNotExists(connectionSource, Student.class);
            TableUtils.createTableIfNotExists(connectionSource, Observation.class);
            TableUtils.createTableIfNotExists(connectionSource, ActivityBundle.class);
            TableUtils.createTableIfNotExists(connectionSource, User.class);
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

    public Dao<Student, Integer> getStudentDao() throws SQLException{
        if(studentDao == null)
            studentDao = getDao(Student.class);
        return studentDao;
    }

    public Dao<Observation, Integer> getObservationDao() throws SQLException {
        if(observationDao == null)
            observationDao = getDao(Observation.class);
        return observationDao;
    }

    public Dao<ActivityBundle, Integer> getActivityBundleDao() throws SQLException {
        if(activityBundleDao == null)
            activityBundleDao = getDao(ActivityBundle.class);
        return activityBundleDao;
    }

    public Dao<User, Integer> getUserDao() throws SQLException {
        if(userDao == null)
            userDao = getDao(User.class);
        return userDao;
    }

    @Override
    public void close() {

        studentDao = null;
        observationDao = null;
        activityBundleDao = null;
        userDao = null;

        super.close();
    }
}
