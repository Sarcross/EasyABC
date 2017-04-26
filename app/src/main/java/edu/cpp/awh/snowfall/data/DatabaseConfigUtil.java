package edu.cpp.awh.snowfall.data;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import edu.cpp.awh.snowfall.model.ActivityBundle;
import edu.cpp.awh.snowfall.model.Observation;
import edu.cpp.awh.snowfall.model.Student;
import edu.cpp.awh.snowfall.model.User;

public class DatabaseConfigUtil extends OrmLiteConfigUtil{
    private static final Class<?>[] classes = new Class[]
            {
                    Student.class,
                    Observation.class,
                    ActivityBundle.class,
                    User.class
            };
    public static void main(String[] args) throws IOException, SQLException {
        writeConfigFile(new File("C:/Users/antzy_000/Documents/Programming/Android/Snowfall/app/src/main/res/raw/ormlite_config.txt"), classes);
    }
}
