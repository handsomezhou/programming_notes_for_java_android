
package com.handsomezhou.multiplelistitem.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.handsomezhou.multiplelistitem.R;
import com.handsomezhou.multiplelistitem.model.Circle;
import com.handsomezhou.multiplelistitem.model.Rectangle;
import com.handsomezhou.multiplelistitem.model.Shape;
import com.handsomezhou.multiplelistitem.model.ShapeType;
import com.handsomezhou.multiplelistitem.model.Triangle;

public class ShareAdapter extends ArrayAdapter<Shape> {
    private static final String TAG="ShareAdapter";
    private Context mContext;
    private int mTextViewResourceId;
    private List<Shape> mShapes;
    private OnShareAdapter mOnShareAdapter;

    public interface OnShareAdapter{
        void onIconClick(Rectangle rectangle);
        void onIconClick(Circle circle);
        void onIconClick(Triangle triangle);
    }
    
    public ShareAdapter(Context context, int textViewResourceId, List<Shape> shapes) {
        super(context, textViewResourceId, shapes);
        mContext = context;
        mTextViewResourceId = textViewResourceId;
        mShapes = shapes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        ViewHolderRectangle viewHolderRectangle=null;
        ViewHolderCircle viewHolderCircle=null;
        ViewHolderTriangle viewHolderTriangle=null;
        Shape shape=getItem(position);
        int itemViewType=getItemViewType(position);
        
        Log.i(TAG, "convertView ["+convertView+"]");
        Log.i(TAG, "itemViewType ["+itemViewType+"]");
        if(null==convertView){
            switch (itemViewType) {
                case ShapeType.CIRCLE:
                    view=LayoutInflater.from(mContext).inflate(R.layout.circle_list_item, null);
                    viewHolderCircle=new ViewHolderCircle();
                    viewHolderCircle.mCircleIv=(ImageView) view.findViewById(R.id.circle_image_view);
                    viewHolderCircle.mAreaTv=(TextView)view.findViewById(R.id.area_text_view);
                    viewHolderCircle.mPerimeterTv=(TextView)view.findViewById(R.id.perimeter_text_view);                    
                    view.setTag(viewHolderCircle);
                    
                    break;
                case ShapeType.TRIANGLE:
                    view=LayoutInflater.from(mContext).inflate(R.layout.triangle_list_item, null);
                    viewHolderTriangle=new ViewHolderTriangle();
                    viewHolderTriangle.mTriangleIv=(ImageView) view.findViewById(R.id.triangle_image_view);
                    viewHolderTriangle.mAreaTv=(TextView)view.findViewById(R.id.area_text_view);
                    viewHolderTriangle.mPerimeterTv=(TextView)view.findViewById(R.id.perimeter_text_view); 
                    view.setTag(viewHolderTriangle);
                    
                    break;
                //case ShapeType.RECTANGLE:  
                default:
                    view=LayoutInflater.from(mContext).inflate(R.layout.rectangle_list_item, null);
                    viewHolderRectangle=new ViewHolderRectangle();
                    viewHolderRectangle.mRectangleIv=(ImageView)view.findViewById(R.id.rectangle_image_view);
                    viewHolderRectangle.mAreaTv=(TextView)view.findViewById(R.id.area_text_view);
                    viewHolderRectangle.mPerimeterTv=(TextView)view.findViewById(R.id.perimeter_text_view);
                    view.setTag(viewHolderRectangle);
                    break;
            }
          
           
        }else{
            view=convertView;
            Object object=view.getTag();
            if(object instanceof ViewHolderRectangle){
                viewHolderRectangle=(ViewHolderRectangle) object;
                Log.i(TAG, "viewHolderRectangle XXX["+viewHolderRectangle+"]");
            }else if(object instanceof ViewHolderCircle){
                viewHolderCircle=(ViewHolderCircle) object;
                Log.i(TAG, "viewHolderRectangle XXX["+viewHolderRectangle+"]");

            }else if(object instanceof ViewHolderTriangle){
                viewHolderTriangle=(ViewHolderTriangle) object;
                Log.i(TAG, "viewHolderTriangle XXX["+viewHolderTriangle+"]");

            }
        }
        
        Log.i(TAG, "viewHolderRectangle===["+viewHolderRectangle+"]");
        Log.i(TAG, "viewHolderCircle ===["+viewHolderCircle+"]");
        Log.i(TAG, "viewHolderTriangle=== ["+viewHolderTriangle+"]");

        if(shape instanceof Circle){
            if(null==viewHolderCircle){
                view=LayoutInflater.from(mContext).inflate(R.layout.circle_list_item, null);
                viewHolderCircle=new ViewHolderCircle();
                viewHolderCircle.mCircleIv=(ImageView) view.findViewById(R.id.circle_image_view);
                viewHolderCircle.mAreaTv=(TextView)view.findViewById(R.id.area_text_view);
                viewHolderCircle.mPerimeterTv=(TextView)view.findViewById(R.id.perimeter_text_view);                    
                view.setTag(viewHolderCircle);
            }
            viewHolderCircle.mCircleIv.setBackgroundResource(R.drawable.ic_launcher);
            viewHolderCircle.mAreaTv.setText(((Circle) shape).getArea()+"");
            viewHolderCircle.mPerimeterTv.setText(" "+shape.getPerimeter()); 
            viewHolderCircle.mCircleIv.setTag(position);
            viewHolderCircle.mCircleIv.setOnClickListener(new OnClickListener() {
                
                @Override
                public void onClick(View v) {
                    int pos=(Integer) v.getTag();
                    Shape shape=getItem(pos);
                    if(shape instanceof Circle){
                        if(null!=mOnShareAdapter){
                            mOnShareAdapter.onIconClick((Circle)shape);
                        }
                    }
                    
                }
            });
        }else if(shape instanceof Triangle){
            if(null==viewHolderTriangle){
                view=LayoutInflater.from(mContext).inflate(R.layout.triangle_list_item, null);
                viewHolderTriangle=new ViewHolderTriangle();
                viewHolderTriangle.mTriangleIv=(ImageView) view.findViewById(R.id.triangle_image_view);
                viewHolderTriangle.mAreaTv=(TextView)view.findViewById(R.id.area_text_view);
                viewHolderTriangle.mPerimeterTv=(TextView)view.findViewById(R.id.perimeter_text_view); 
                view.setTag(viewHolderTriangle);
            }
            
            viewHolderTriangle.mTriangleIv.setBackgroundResource(R.drawable.ic_launcher);
            viewHolderTriangle.mAreaTv.setText(" "+shape.getArea());
            viewHolderTriangle.mPerimeterTv.setText(" "+shape.getPerimeter());
            viewHolderTriangle.mTriangleIv.setTag(position);
            viewHolderTriangle.mTriangleIv.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View v) {
                    int pos=(Integer) v.getTag();
                    Shape shape=getItem(pos);
                    if(shape instanceof Triangle){
                        if(null!=mOnShareAdapter){
                            mOnShareAdapter.onIconClick((Triangle)shape);
                        }
                    }
                    
                }
            });
        }else if(shape instanceof Rectangle){
            if(null==viewHolderRectangle){
                view=LayoutInflater.from(mContext).inflate(R.layout.rectangle_list_item, null);
                viewHolderRectangle=new ViewHolderRectangle();
                viewHolderRectangle.mRectangleIv=(ImageView)view.findViewById(R.id.rectangle_image_view);
                viewHolderRectangle.mAreaTv=(TextView)view.findViewById(R.id.area_text_view);
                viewHolderRectangle.mPerimeterTv=(TextView)view.findViewById(R.id.perimeter_text_view);
                view.setTag(viewHolderRectangle);
            }
            
            viewHolderRectangle.mRectangleIv.setBackgroundResource(R.drawable.ic_launcher);
            viewHolderRectangle.mAreaTv.setText(" "+shape.getArea());
            viewHolderRectangle.mPerimeterTv.setText(" "+shape.getPerimeter());
            
            viewHolderRectangle.mRectangleIv.setTag(position);
            viewHolderRectangle.mRectangleIv.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View v) {
                    int pos=(Integer) v.getTag();
                    Shape shape=getItem(pos);
                    if(shape instanceof Rectangle){
                        if(null!=mOnShareAdapter){
                            mOnShareAdapter.onIconClick((Rectangle)shape);
                        }
                    }
                }
            });
        }
        
        Log.i(TAG, " view:"+view.toString());
        return view;
    }

    @Override
    public int getItemViewType(int position) {
        int itemViewType=ShapeType.RECTANGLE;
        Shape shape=getItem(position);
        if(shape instanceof Rectangle){
            itemViewType=ShapeType.RECTANGLE;
        }else if(shape instanceof Circle){
            itemViewType=ShapeType.CIRCLE;
        }else if(shape instanceof Triangle){
            itemViewType=ShapeType.TRIANGLE;
        }
        return itemViewType;
    }
    
    

    @Override
    public int getViewTypeCount() {

        return ShapeType.SHAPE_COUNT;
    }

    public OnShareAdapter getOnShareAdapter() {
        return mOnShareAdapter;
    }

    public void setOnShareAdapter(OnShareAdapter onShareAdapter) {
        mOnShareAdapter = onShareAdapter;
    }


    private class ViewHolderRectangle {
        ImageView mRectangleIv;
        TextView mAreaTv;
        TextView mPerimeterTv;
    }

    private class ViewHolderCircle {
        ImageView mCircleIv;
        TextView mAreaTv;
        TextView mPerimeterTv;
    }

    private class ViewHolderTriangle {
        ImageView mTriangleIv;
        TextView mAreaTv;
        TextView mPerimeterTv;
    }

}
