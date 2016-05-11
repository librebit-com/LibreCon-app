package gal.agasol.librecon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.MenuItem;

import gal.agasol.librecon.domains.MeDomain;
import gal.agasol.librecon.fragments.LoginPageOneFragment;
import gal.agasol.librecon.fragments.LoginPageTwoFragment;
import gal.agasol.librecon.ui.NonSwipeableViewPager;
import com.nvanbenschoten.motion.ParallaxImageView;

import librecon.Me;

public class LoginPagerActivity extends FragmentActivity implements
        LoginPageOneFragment.OnFragmentInteractionListener,
        LoginPageTwoFragment.OnFragmentInteractionListener {

    private static final int NUM_PAGES = 2;
    private NonSwipeableViewPager mPager;
    private ScreenSlidePagerAdapter mPagerAdapter;
    private ParallaxImageView mBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_pager);

        finishWithUserIfPossible();

        mBackground = (ParallaxImageView) findViewById(R.id.background);
        mBackground.setForwardTiltOffset(.35f);
        mBackground.setParallaxIntensity(1.1f);
        mBackground.registerSensorManager();

        mPager = (NonSwipeableViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position > 0)
                return new LoginPageTwoFragment();
            else
                return new LoginPageOneFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public void switchToNextPage() {
        if (mPager != null)
            mPager.setCurrentItem(1);
    }

    public void switchToPrevPage() {
        if (mPager != null)
            mPager.setCurrentItem(0);
    }

    public void finishWithUserIfPossible() {
        Me me = MeDomain.get(this);
        if (me != null && !me.getHash().isEmpty()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("me", me);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBackground.registerSensorManager();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBackground.unregisterSensorManager();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

}
