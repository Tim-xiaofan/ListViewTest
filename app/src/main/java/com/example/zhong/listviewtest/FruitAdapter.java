package com.example.zhong.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhong on 2018/3/28.
 * 用于给ListView加载item实例，数据导入
 * 自己本身不直接访问数据库
 */

public class FruitAdapter extends ArrayAdapter<Fruit>{

    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit>objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Fruit fruit= getItem(position);//获取当前Fruit实例
        View view;
        ViewHolder viewHolder;
        if(convertView==null) {
            view = LayoutInflater.from(getContext()).
                    inflate(resourceId, parent, false);//为当前实例加入我们传入的布局，但不包括父布局
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);//控件实例放入viewHolder
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//存储viewHolder在view中
        }
        else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());//设置当前实例图片
        viewHolder.fruitName.setText(fruit.getName());//设置当前实例名字
        return  view;
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
