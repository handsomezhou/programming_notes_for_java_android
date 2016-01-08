
package com.handsomezhou.listviewloadmore.view;



import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.handsomezhou.listviewloadmore.R;

/*
 * http://www.imooc.com/note/136?sort=last
 * */

public class LoadListView extends ListView implements OnScrollListener {
    View footer;// 底部布局；
    int totalItemCount;// 总数量；
    int lastVisibleItem;// 最后一个可见的item；
    boolean isLoading;// 正在加载；

    private OnLoad mOnLoad;

    // 加载更多数据的回调接口
    public interface OnLoad {
        public void onStartLoad();
    }

    public LoadListView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        initView(context);
    }

    public LoadListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        initView(context);
    }

    public LoadListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        initView(context);
    }

    /**
     * 添加底部加载提示布局到listview
     * 
     * @param context
     */
    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        footer = inflater.inflate(R.layout.footer_layout, null);
        footer.findViewById(R.id.load_layout).setVisibility(View.GONE);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
            int visibleItemCount, int totalItemCount) {
        // TODO Auto-generated method stub
        this.lastVisibleItem = firstVisibleItem + visibleItemCount;
        this.totalItemCount = totalItemCount;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // TODO Auto-generated method stub
        if (totalItemCount == lastVisibleItem
                && scrollState == SCROLL_STATE_IDLE) {
            if (!isLoading) {
                isLoading = true;
                footer.findViewById(R.id.load_layout).setVisibility(
                        View.VISIBLE);
                // 加载更多
                if (null != mOnLoad) {
                    mOnLoad.onStartLoad();
                }
            }
        }
    }

    /**
     * 加载完毕
     */
    public void loadComplete() {
        isLoading = false;
        footer.findViewById(R.id.load_layout).setVisibility(
                View.GONE);
    }

    public OnLoad getOnLoad() {
        return mOnLoad;
    }

    public void setOnLoad(OnLoad onLoad) {
        mOnLoad = onLoad;
    }

}
