package com.handsomezhou.multiplelistitem.fragment;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.handsomezhou.multiplelistitem.R;
import com.handsomezhou.multiplelistitem.adapter.ShareAdapter;
import com.handsomezhou.multiplelistitem.adapter.ShareAdapter.OnShareAdapter;
import com.handsomezhou.multiplelistitem.model.Circle;
import com.handsomezhou.multiplelistitem.model.Rectangle;
import com.handsomezhou.multiplelistitem.model.Shape;
import com.handsomezhou.multiplelistitem.model.Triangle;

public class MainFragment extends BaseFragment implements OnShareAdapter{
    private List<Shape> mShapes;
    private ListView mShapeLv;
    private ShareAdapter mShareAdapter;
    
    @Override
    protected void initData() {
       setContext(getActivity());
       
       initShape();
     
       
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        mShapeLv=(ListView) view.findViewById(R.id.shape_list_view);
        mShareAdapter=new ShareAdapter(getContext(), R.layout.rectangle_list_item, mShapes);
        mShareAdapter.setOnShareAdapter(this);
        mShapeLv.setAdapter(mShareAdapter);
        
        return view;
    }

    @Override
    protected void initListener() {
        
        
    }

    /*start: OnShareAdapter*/
    @Override
    public void onIconClick(Rectangle rectangle) {
        Toast.makeText(getContext(), "I'm Rectangle", Toast.LENGTH_SHORT).show();
        
    }

    @Override
    public void onIconClick(Circle circle) {
        Toast.makeText(getContext(), "I'm Circle", Toast.LENGTH_SHORT).show();        
    }

    @Override
    public void onIconClick(Triangle triangle) {
        Toast.makeText(getContext(), "I'm Triangle", Toast.LENGTH_SHORT).show();        
    }
    
    /*end: OnShareAdapter*/
    private void initShape(){
        if(null==mShapes){
            mShapes=new ArrayList<Shape>();
        }else{
            mShapes.clear();
        }
        
        Rectangle rectangle1=new Rectangle(3, 5);
        mShapes.add(rectangle1);
        
        Rectangle rectangle2=new Rectangle(3, 6);
        mShapes.add(rectangle2);
        
        Rectangle rectangle3=new Rectangle(3, 7);
        mShapes.add(rectangle3);
        
        Rectangle rectangle4=new Rectangle(3, 8);
        mShapes.add(rectangle4);

        Rectangle rectangle5=new Rectangle(3, 9);
        mShapes.add(rectangle5);

        
        Circle circle1=new Circle(6);
        mShapes.add(circle1);
        
        
        Circle circle2=new Circle(7);
        mShapes.add(circle2);
        
        Circle circle3=new Circle(8);
        mShapes.add(circle3);
        
        
        Circle circle4=new Circle(9);
        mShapes.add(circle4);
        
        Circle circle5=new Circle(10);
        mShapes.add(circle5);
        
      
        
        Triangle triangle1=new Triangle(3, 4, 5);
        mShapes.add(triangle1);
        
        
        Triangle triangle2=new Triangle(6, 8, 10);
        mShapes.add(triangle2);
        
        
        Triangle triangle3=new Triangle(9, 12, 15);
        mShapes.add(triangle3);
        
        Triangle triangle4=new Triangle(12, 16, 20);
        mShapes.add(triangle4);
        
        Triangle triangle5=new Triangle(15, 20, 25);
        mShapes.add(triangle5);
        
        Rectangle rectangle6=new Rectangle(3, 10);
        mShapes.add(rectangle6);
        
        Circle circle6=new Circle(11);
        mShapes.add(circle6);
        
        Triangle triangle6=new Triangle(18, 24, 30);
        mShapes.add(triangle6);
        
        
        for(int i=0; i<100; i++){
            Triangle triangle=new Triangle(3*(i+1), 4*(i+1), 5*(i+1));
            mShapes.add(triangle);
        }
        
    }


}
