package com.example.testapp.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.testapp.R;


public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mResources;
    private int[] mDescriptionResources;

    public ViewPagerAdapter(Context mContext, int[] mResources, int[] mDescriptionResources) {
        this.mContext = mContext;
        this.mResources = mResources;
        this.mDescriptionResources = mDescriptionResources;
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.pager_image);
        imageView.setImageResource(mResources[position]);

        TextView description = (TextView) itemView.findViewById(R.id.pager_description);
        description.setText(mDescriptionResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
