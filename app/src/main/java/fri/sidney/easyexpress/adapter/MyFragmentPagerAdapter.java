package fri.sidney.easyexpress.adapter;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import fri.sidney.easyexpress.MainActivity;
import fri.sidney.easyexpress.fragment.HomeFragment;
import fri.sidney.easyexpress.fragment.NavigationFragment;
import fri.sidney.easyexpress.fragment.PersonalFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "MyFragmentPagerAdapter";

    private static final int PAGER_COUNT = 3;

    private final Fragment mHomeFragment;
    private final Fragment mNavigationFragment;
    private final Fragment mPersonalFragment;

    public MyFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        mHomeFragment = new HomeFragment();
        mNavigationFragment = new NavigationFragment();
        mPersonalFragment = new PersonalFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case MainActivity.HOME_FRAGMENT:
                return mHomeFragment;
            case MainActivity.NAVIGATION_FRAGMENT:
                return mNavigationFragment;
            case MainActivity.PERSONAL_FRAGMENT:
                return mPersonalFragment;
            default:
                Log.e(TAG, "getItem: wtf?");
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}
