package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.testapp.activities.Baseactivity;
import com.example.testapp.adapters.ViewPagerAdapter;

public class MainActivity extends Baseactivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    protected View view;
    private Button btnSkip, btnDone;
    private ViewPager viewPager;
    private LinearLayout pagerIndicator;
    private int dotsCount;
    private ImageView[] dots;
    private ViewPagerAdapter mAdapter;

    private int[] mImageResources = {
            R.drawable.abc1,
            R.drawable.abc2,
            R.drawable.abc3,
            R.drawable.abc4,
            R.drawable.abc5
    };

    private int[] mDescriptionResources = {
            R.string.text1,
            R.string.text2,
            R.string.text3,
            R.string.text4,
            R.string.text5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setReference();
        toolbar.setVisibility(View.GONE);

    }

    @Override
    public void setReference() {
        view = LayoutInflater.from(this).inflate(R.layout.activity_viewpager_demo, container);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        btnSkip = (Button) view.findViewById(R.id.btn_skip);
        btnDone = (Button) view.findViewById(R.id.btn_done);

        pagerIndicator = (LinearLayout) view.findViewById(R.id.viewpager_dots_indicator);

        btnSkip.setOnClickListener(this);
        btnDone.setOnClickListener(this);

        mAdapter = new ViewPagerAdapter(MainActivity.this, mImageResources, mDescriptionResources);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
        setUiPageViewController();
    }

    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        int dotMargin = getResources().getDimensionPixelSize(R.dimen.dots_margin);
        params.setMargins(dotMargin, 0, dotMargin, 0);

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageResource(R.drawable.nonselecteditem_dot);

            pagerIndicator.addView(dots[i], params);
        }

        dots[0].setImageResource(R.drawable.selecteditem_dot);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip:
                viewPager.setCurrentItem((viewPager.getCurrentItem() < dotsCount)
                        ? viewPager.getCurrentItem() + 1 : 0);
                break;

            case R.id.btn_done:
                finish();
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageResource(R.drawable.nonselecteditem_dot);
        }
        dots[position].setImageResource(R.drawable.selecteditem_dot);


        if (position + 1 == dotsCount) {
            btnSkip.setVisibility(View.GONE);
            btnDone.setVisibility(View.VISIBLE);
        } else {
            btnSkip.setVisibility(View.VISIBLE);
            btnDone.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
