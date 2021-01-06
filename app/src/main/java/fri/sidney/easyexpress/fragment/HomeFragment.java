package fri.sidney.easyexpress.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import fri.sidney.easyexpress.MainActivity;
import fri.sidney.easyexpress.R;
import fri.sidney.easyexpress.adapter.ExpressInfoListAdapter;
import fri.sidney.easyexpress.utils.DensityUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    public static final int POSITION = 0;

    private MapView mMapView;
    private AMap mAMap;
    private View mHomeLayout;

    SwipeMenuListView mExpressInfoListSmlv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mHomeLayout == null) {
            mHomeLayout = inflater.inflate(R.layout.fragment_home, null);
            mMapView = mHomeLayout.findViewById(R.id.home_map);
            mMapView.onCreate(savedInstanceState);
            if (mAMap == null) {
                mAMap = mMapView.getMap();
            }
            mExpressInfoListSmlv = mHomeLayout.findViewById(R.id.lv_express_info);
            ExpressInfoListAdapter adapter = new ExpressInfoListAdapter(Objects.requireNonNull(getContext()).getApplicationContext());
            mExpressInfoListSmlv.setAdapter(adapter);
            mExpressInfoListSmlv.setMenuCreator(mCreator);
            mExpressInfoListSmlv.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                    switch (index) {
                        case 0:
                            // 确认
                            showNormalDialog();
                            Log.d(TAG, "onMenuItemClick: confirm..");
                            break;
                        case 1:
                            // 详情
                            showNormalDialog();
                            Log.d(TAG, "onMenuItemClick: details..");
                            break;
                    }
                    // false : close the menu; true : not close the menu
                    return false;
                }
            });
            mExpressInfoListSmlv.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
        } else {
            if (mHomeLayout.getParent() != null) {
                ((ViewGroup) mHomeLayout.getParent()).removeView(mHomeLayout);
            }
        }
        return mHomeLayout;
    }

    private void showNormalDialog(){
        final AlertDialog.Builder normalDialog = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
        normalDialog.setTitle("确认配送完成？");
        normalDialog.setMessage("确认后订单状态不可修改，确定该订单配送完成？");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        normalDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }

    SwipeMenuCreator mCreator = new SwipeMenuCreator() {

        @Override
        public void create(SwipeMenu menu) {
            // create "确收" item
            SwipeMenuItem confirmItem = new SwipeMenuItem(Objects.requireNonNull(getContext()).getApplicationContext());
            confirmItem.setBackground(new ColorDrawable(Color.rgb(0xFF, 0x00, 0x00)));
            confirmItem.setWidth(DensityUtil.dip2px(getContext(), 40));
            confirmItem.setTitle("确收");
            confirmItem.setTitleSize(12);
            confirmItem.setTitleColor(Color.BLACK);
            menu.addMenuItem(confirmItem);

            // create "详情" item
            SwipeMenuItem detailItem = new SwipeMenuItem(Objects.requireNonNull(getContext()).getApplicationContext());
            detailItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9, 0xCE)));
            detailItem.setWidth(DensityUtil.dip2px(getContext(), 40));
            detailItem.setTitle("详情");
            detailItem.setTitleSize(12);
            detailItem.setTitleColor(Color.WHITE);
            menu.addMenuItem(detailItem);
        }
    };

    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    /**
     * 方法必须重写
     * map的生命周期方法
     */
    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    /**
     * 方法必须重写
     * map的生命周期方法
     */
    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     * map的生命周期方法
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
}
