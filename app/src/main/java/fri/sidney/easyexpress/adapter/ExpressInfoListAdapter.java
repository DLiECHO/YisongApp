package fri.sidney.easyexpress.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import fri.sidney.easyexpress.R;
import fri.sidney.easyexpress.entity.ExpressInfo;

import java.util.ArrayList;
import java.util.List;

public class ExpressInfoListAdapter extends BaseAdapter {

    private Context mContext;

    private static List<ExpressInfo> mExpressInfoList = new ArrayList<>();

    static {
        ExpressInfo info1 = new ExpressInfo(R.drawable.ic_outline_access_time_green_30, "苏果超市", true);
        mExpressInfoList.add(info1);
        ExpressInfo info2 = new ExpressInfo(R.drawable.ic_outline_access_time_blue_30, "世纪华联超市", false);
        mExpressInfoList.add(info2);
        ExpressInfo info3 = new ExpressInfo(R.drawable.ic_outline_access_time_blue_30, "麦德龙", false);
        mExpressInfoList.add(info3);
        ExpressInfo info4 = new ExpressInfo(R.drawable.ic_outline_access_time_blue_30, "地铁便利店", false);
        mExpressInfoList.add(info4);
        ExpressInfo info5 = new ExpressInfo(R.drawable.ic_outline_access_time_blue_30, "罗森便利店", false);
        mExpressInfoList.add(info5);
        ExpressInfo info6 = new ExpressInfo(R.drawable.ic_outline_access_time_blue_30, "罗森便利店", false);
        mExpressInfoList.add(info6);
        ExpressInfo info7 = new ExpressInfo(R.drawable.ic_outline_access_time_blue_30, "罗森便利店", false);
        mExpressInfoList.add(info7);
        ExpressInfo info8 = new ExpressInfo(R.drawable.ic_outline_access_time_blue_30, "罗森便利店", false);
        mExpressInfoList.add(info8);
    }

    public ExpressInfoListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mExpressInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mExpressInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        // 如果convertView为空则需要重新创建资源视图,如果不为空则表示可以用来复用.无需再次new一个view来使用.
        if (convertView == null) {
            // 通过R.layout.item 来创建一个item视图资源
            view = LayoutInflater.from(mContext).inflate(R.layout.item_express_home, null);
        } else {
            view = convertView;
        }
        //设置要显示的内容
        ImageView iv_icon = view.findViewById(R.id.iv_time_icon);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_achievement = view.findViewById(R.id.tv_achievement);

        tv_name.setText(mExpressInfoList.get(position).getName());
        if (mExpressInfoList.get(position).isAchievement()) {
            iv_icon.setImageResource(R.drawable.ic_outline_access_time_green_30);
            tv_achievement.setText("配送已完成");
        } else {
            iv_icon.setImageResource(R.drawable.ic_outline_access_time_blue_30);
            tv_achievement.setText("配送未完成");
        }

        return view;
    }
}
