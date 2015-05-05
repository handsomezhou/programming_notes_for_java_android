
package com.handsomezhou.fragmentdemo.fragment;

import java.util.ArrayList;
import java.util.List;

import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.adapter.GridViewAdapter;
import com.handsomezhou.fragmentdemo.model.IconButtonData;
import com.handsomezhou.fragmentdemo.model.IconButtonValue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewFragment extends BaseFragment {
    private Button mBackBtn;

    private List<IconButtonData> mGridViewData;
    private GridView mGridViewGv;
    private GridViewAdapter mGridViewAdapter;

    public enum GRID_VIEW_TAG {
        ZERO,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
    }

    @Override
    protected void initData() {
        setContext(getActivity());
        mGridViewData = new ArrayList<IconButtonData>();
        /* Start: zero IconButtonData */
        IconButtonValue zeroIconButtonValue = new IconButtonValue(GRID_VIEW_TAG.ZERO,
                R.drawable.zero_icon_selected_unfocused, R.drawable.zero_icon_unselected,
                R.string.zero);
        IconButtonData zeroIconButtonData = new IconButtonData(getContext(), zeroIconButtonValue);
        mGridViewData.add(zeroIconButtonData);
        /* End: zero IconButtonData */

        /* Start: one IconButtonData */
        IconButtonValue oneIconButtonValue = new IconButtonValue(GRID_VIEW_TAG.ONE,
                R.drawable.one_icon_selected_unfocused, R.drawable.one_icon_unselected,
                R.string.one);
        IconButtonData oneIconButtonData = new IconButtonData(getContext(), oneIconButtonValue);
        mGridViewData.add(oneIconButtonData);
        /* End: one IconButtonData */

        /* Start: two IconButtonData */
        IconButtonValue twoIconButtonValue = new IconButtonValue(GRID_VIEW_TAG.TWO,
                R.drawable.two_icon_selected_unfocused, R.drawable.two_icon_unselected,
                R.string.two);
        IconButtonData twoIconButtonData = new IconButtonData(getContext(), twoIconButtonValue);
        mGridViewData.add(twoIconButtonData);
        /* End: two IconButtonData */

        /* Start: three IconButtonData */
        IconButtonValue threeIconButtonValue = new IconButtonValue(GRID_VIEW_TAG.THREE,
                R.drawable.three_icon_selected_unfocused, R.drawable.three_icon_unselected,
                R.string.three);
        IconButtonData threeIconButtonData = new IconButtonData(getContext(), threeIconButtonValue);
        mGridViewData.add(threeIconButtonData);
        /* End: three IconButtonData */

        /* Start: four IconButtonData */
        IconButtonValue fourIconButtonValue = new IconButtonValue(GRID_VIEW_TAG.FOUR,
                R.drawable.four_icon_selected_unfocused, R.drawable.four_icon_unselected,
                R.string.four);
        IconButtonData fourIconButtonData = new IconButtonData(getContext(), fourIconButtonValue);
        mGridViewData.add(fourIconButtonData);
        /* End: four IconButtonData */

        /* Start: five IconButtonData */
        IconButtonValue fiveIconButtonValue = new IconButtonValue(GRID_VIEW_TAG.FIVE,
                R.drawable.five_icon_selected_unfocused, R.drawable.five_icon_unselected,
                R.string.five);
        IconButtonData fiveIconButtonData = new IconButtonData(getContext(), fiveIconButtonValue);
        mGridViewData.add(fiveIconButtonData);
        /* End: five IconButtonData */

        /* Start: six IconButtonData */
        IconButtonValue sixIconButtonValue = new IconButtonValue(GRID_VIEW_TAG.SIX,
                R.drawable.six_icon_selected_unfocused, R.drawable.six_icon_unselected,
                R.string.six);
        IconButtonData sixIconButtonData = new IconButtonData(getContext(), sixIconButtonValue);
        mGridViewData.add(sixIconButtonData);
        /* End: six IconButtonData */

        /* Start: seven IconButtonData */
        IconButtonValue sevenIconButtonValue = new IconButtonValue(GRID_VIEW_TAG.SEVEN,
                R.drawable.seven_icon_selected_unfocused, R.drawable.seven_icon_unselected,
                R.string.seven);
        IconButtonData sevenIconButtonData = new IconButtonData(getContext(), sevenIconButtonValue);
        mGridViewData.add(sevenIconButtonData);
        /* End: seven IconButtonData */

        /* Start: eight IconButtonData */
        IconButtonValue eightIconButtonValue = new IconButtonValue(GRID_VIEW_TAG.EIGHT,
                R.drawable.eight_icon_selected_unfocused, R.drawable.eight_icon_unselected,
                R.string.eight);
        IconButtonData eightIconButtonData = new IconButtonData(getContext(), eightIconButtonValue);
        mGridViewData.add(eightIconButtonData);
        /* End: eight IconButtonData */

        /* Start: nine IconButtonData */
        IconButtonValue nineIconButtonValue = new IconButtonValue(GRID_VIEW_TAG.NINE,
                R.drawable.nine_icon_selected_unfocused, R.drawable.nine_icon_unselected,
                R.string.nine);
        IconButtonData nineIconButtonData = new IconButtonData(getContext(), nineIconButtonValue);
        mGridViewData.add(nineIconButtonData);
        /* End: nine IconButtonData */

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_grid_view, container, false);
        mBackBtn = (Button) view.findViewById(R.id.back_btn);
        mGridViewGv = (GridView) view.findViewById(R.id.grid_view_grid_view);

        mGridViewAdapter = new GridViewAdapter(getContext(), R.layout.icon_button_grid_item,
                mGridViewData);
        mGridViewGv.setAdapter(mGridViewAdapter);

        return view;
    }

    @Override
    protected void initListener() {

        mBackBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                back();
            }
        });

        mGridViewGv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IconButtonData iconButtonData= mGridViewData.get(position);
                ViewSelect(iconButtonData);
            }
        });
    }

    private void back() {
        getActivity().finish();
    }

    private void ViewSelect(IconButtonData iconButtonData) {
        if (null == iconButtonData) {
            return;
        }

        switch ((GRID_VIEW_TAG) iconButtonData.getIconButtonValue().getTag()) {
            case ZERO:
               
                break;
            case ONE:

                break;
            case TWO:

                break;
            case THREE:

                break;
            case FOUR:

                break;
            case FIVE:

                break;
            case SIX:

                break;
            case SEVEN:

                break;
            case EIGHT:

                break;
            case NINE:

                break;

            default:
                break;
        }
        
        Toast.makeText(getContext(), iconButtonData.getIconButtonValue().getTag().toString(), Toast.LENGTH_SHORT).show();
    }

}
