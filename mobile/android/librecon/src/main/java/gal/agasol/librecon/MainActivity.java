package gal.agasol.librecon;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import gal.agasol.librecon.api.APILibrecon;
import gal.agasol.librecon.config.Config;
import gal.agasol.librecon.domains.MeDomain;
import gal.agasol.librecon.fragments.AssistantsFragment;
import gal.agasol.librecon.fragments.MeetingsFragment;
import gal.agasol.librecon.fragments.NavigationDrawerFragment;
import gal.agasol.librecon.fragments.PhotoCallFragment;
import gal.agasol.librecon.fragments.PlacesFragment;
import gal.agasol.librecon.fragments.RequestCodeFragment;
import gal.agasol.librecon.fragments.ScheduleFragment;
import gal.agasol.librecon.fragments.SponsorsFragment;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

import librecon.Me;


public class MainActivity extends BaseActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private final static String TAG = MainActivity.class.getSimpleName();

    // UI
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private ActionBar mActionBar;
    private Me mMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            mMe = intent.getExtras().getParcelable("me");
        }

        if (mMe != null) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    String gcmRegId = getValidGCMRegId();
                    APILibrecon api = APILibrecon.getInstance();
                    JSONObject jsonObj = new JSONObject();
                    try {
                        jsonObj.put("uuid", gcmRegId);
                        jsonObj.put("device", "android");
                        jsonObj.put("lang", Locale.getDefault().getLanguage());
                        api.put(mMe.getHash(), APILibrecon.ASSISTANTS, jsonObj.toString());
                    } catch (JSONException jsEx) {
                        jsEx.printStackTrace();
                    } catch (IOException ioEx) {
                        ioEx.printStackTrace();
                    }
                    Log.d(TAG, gcmRegId);
                }
            };
            thread.start();

        }

        mActionBar = getActionBar();
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    public String getValidGCMRegId() {
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        try {
            return gcm.register(Config.GCM_SENDER_ID);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void refreshFragmentView() {
        if (mNavigationDrawerFragment != null) {
            mNavigationDrawerFragment.refreshView();
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = null;
        mMe = MeDomain.get(this);
        switch (position) {
            case 1:
                fragment = new ScheduleFragment();
                break;
            case 2:
                if (mMe != null && !mMe.getHash().isEmpty())
                    fragment = new AssistantsFragment();
                else
                    fragment = new RequestCodeFragment();
                break;
            case 3:
                if (mMe != null && !mMe.getHash().isEmpty())
                    fragment = new MeetingsFragment();
                else
                    fragment = new RequestCodeFragment();
                break;
            case 4:
                fragment = new PlacesFragment();
                break;
            case 5:
                fragment = new SponsorsFragment();
                break;
            case 6:
                fragment = new PhotoCallFragment();
                break;
        }
        if (fragment != null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        } else  if (id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
