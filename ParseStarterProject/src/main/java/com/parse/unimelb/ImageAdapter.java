package com.parse.unimelb;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.ArrayList;

/**
 * Created by songxue on 29/09/2015.
 * This class is providing the grid view adapter for showing user updated photos in profile fragment
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Bitmap> image_array;
    private int width;

    public ImageAdapter(Context c, ArrayList<Bitmap> data){
            mContext = c;
            image_array = data;
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            width = metrics.widthPixels;
    }

    public int getCount(){
        return image_array.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(width/3, width/3));

            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        //set picture
        imageView.setImageBitmap(image_array.get(position));
        return imageView;
    }

    //get the bitmaps


    public ArrayList<Bitmap> getImage_array() {
        return image_array;
    }

    public void setImage_array(ArrayList<Bitmap> image_array) {
        this.image_array = image_array;
    }
}
