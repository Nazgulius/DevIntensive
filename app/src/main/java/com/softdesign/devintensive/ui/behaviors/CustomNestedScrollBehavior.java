package com.softdesign.devintensive.ui.behaviors;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.softdesign.devintensive.R;
import com.softdesign.devintensive.utils.UIHelper;

public class CustomNestedScrollBehavior  extends AppBarLayout.ScrollingViewBehavior{

    private final int mMaxAppbarHeight;
    private final int mMinAppbarHeight;
    private final int mMaxUserInfoHeight;

    public CustomNestedScrollBehavior (Context context, AttributeSet attrs){
        super (context, attrs);

        mMinAppbarHeight = UIHelper.getStatusBarHeight()+UIHelper.getActionBarHeight(); //80dp
        mMaxAppbarHeight = context.getResources().getDimensionPixelSize(R.dimen.image_profil_spacing_256dp);
        mMaxUserInfoHeight = context.getResources().getDimensionPixelOffset(R.dimen.spacing_larger_104dp) ;
    }

    @Override
    public  boolean onDependentViewChanged (CoordinatorLayout parent, View child, final View dependency){
        float friction = UIHelper.currentFriction(mMinAppbarHeight, mMaxAppbarHeight, dependency.getBottom());
        int offsetY = UIHelper.lerp(mMaxUserInfoHeight/2, mMaxUserInfoHeight, friction);

        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        lp.topMargin = offsetY;
        child.setLayoutParams(lp);

        return super.onDependentViewChanged(parent, child, dependency);
    }

    @Override
    public boolean layoutDependsOn (CoordinatorLayout parent, View child, View dependency){
        return dependency instanceof AppBarLayout;
    }
}
