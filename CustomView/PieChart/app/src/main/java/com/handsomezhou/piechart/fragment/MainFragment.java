
package com.handsomezhou.piechart.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.handsomezhou.piechart.R;
import com.handsomezhou.piechart.view.PieChart;

public class MainFragment extends BaseFragment {
    private PieChart mPieChart;
    private Button mResetBtn;
    @Override
    protected void initData() {
        setContext(getActivity());

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mPieChart = (PieChart) view.findViewById(R.id.Pie);
        mPieChart.addItem("Agamemnon", 2, getContext().getResources().getColor(R.color.seafoam));
        mPieChart.addItem("Bocephus", 3.5f,  getContext().getResources().getColor(R.color.chartreuse));
        mPieChart.addItem("Calliope", 2.5f,  getContext().getResources().getColor(R.color.emerald));
        mPieChart.addItem("Daedalus", 3,  getContext().getResources().getColor(R.color.bluegrass));
        mPieChart.addItem("Euripides", 1,  getContext().getResources().getColor(R.color.turquoise));
        mPieChart.addItem("Ganymede", 3,  getContext().getResources().getColor(R.color.slate));

        mResetBtn=(Button) view.findViewById(R.id.reset_btn);
        return view;
    }

    @Override
    protected void initListener() {
        mResetBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mPieChart.setCurrentItem(0);
            }
        });
    }

}
