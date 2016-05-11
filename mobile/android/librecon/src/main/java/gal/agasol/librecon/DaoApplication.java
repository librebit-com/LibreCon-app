package gal.agasol.librecon;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import librecon.DaoMaster;
import librecon.DaoSession;

/**
 * Created by Asier Fernandez on 18/09/14.
 */
public class DaoApplication extends Application {

    private final static String TAG = DaoApplication.class.getSimpleName();

    public DaoSession daoSession;

    public enum TrackerName {
        APP_TRACKER, // Tracker used only in this app.
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
    }

    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "librecon-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
