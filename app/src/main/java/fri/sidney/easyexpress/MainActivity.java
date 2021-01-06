package fri.sidney.easyexpress;

import android.Manifest;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import fri.sidney.easyexpress.adapter.MyFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private static final String TAG = "MainActivity";

    public static final int HOME_FRAGMENT = 0;
    public static final int NAVIGATION_FRAGMENT = 1;
    public static final int PERSONAL_FRAGMENT = 2;

    private TextView mHomeBtn;
    private TextView mNavigationBtn;
    private TextView mPersonalBtn;
    private ViewPager mContentVp;

    private static final String[] REQUEST_PERMISSION_LIST = new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_WIFI_STATE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        selectedBtn(mHomeBtn);
    }

    private void bindView() {
        mHomeBtn = findViewById(R.id.btn_home);
        mHomeBtn.setOnClickListener(MainActivity.this);
        mNavigationBtn = findViewById(R.id.btn_navigation);
        mNavigationBtn.setOnClickListener(MainActivity.this);
        mPersonalBtn = findViewById(R.id.btn_personal);
        mPersonalBtn.setOnClickListener(MainActivity.this);

        mContentVp = findViewById(R.id.vp_content);
        FragmentPagerAdapter mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContentVp.setAdapter(mAdapter);
        mContentVp.setCurrentItem(0);
        mContentVp.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home:
                selectedBtn(mHomeBtn);
                mContentVp.setCurrentItem(HOME_FRAGMENT);
                break;
            case R.id.btn_navigation:
                selectedBtn(mNavigationBtn);
                mContentVp.setCurrentItem(NAVIGATION_FRAGMENT);
                break;
            case R.id.btn_personal:
                selectedBtn(mPersonalBtn);
                mContentVp.setCurrentItem(PERSONAL_FRAGMENT);
                break;
            default:
                Log.e(TAG, "onClick: wtf?");
        }
    }

    private void selectedBtn(TextView btn) {
        mHomeBtn.setBackgroundColor(R.color.white);
        mNavigationBtn.setBackgroundColor(R.color.white);
        mPersonalBtn.setBackgroundColor(R.color.white);
        btn.setBackgroundColor(R.color.colorAccent);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d(TAG, "onPageScrolled: nothing to do..");
    }

    @Override
    public void onPageSelected(int position) {
        Log.d(TAG, "onPageSelected: nothing to do..");
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        // state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (mContentVp.getCurrentItem()) {
                case HOME_FRAGMENT:
                    selectedBtn(mHomeBtn);
                    break;
                case NAVIGATION_FRAGMENT:
                    selectedBtn(mNavigationBtn);
                    break;
                case PERSONAL_FRAGMENT:
                    selectedBtn(mPersonalBtn);
                    break;
                default:
                    Log.e(TAG, "onPageScrollStateChanged: wtf?");
            }
        }
    }
}