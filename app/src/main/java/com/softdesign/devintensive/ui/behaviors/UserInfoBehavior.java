package com.softdesign.devintensive.ui.behaviors;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.softdesign.devintensive.R;
import com.softdesign.devintensive.utils.UIHelper;

import java.util.jar.Attributes;

public class UserInfoBehavior<V extends LinearLayout> extends AppBarLayout.ScrollingViewBehavior {
    private final int mMaxAppbarHeight;
    private final int mMinAppbarHeight;
    private final int mMaxUserInfoHeight;
    private final int mMinUserInfoHeight;

    public UserInfoBehavior (Context context, Attributes attrs){
        super(context, (AttributeSet) attrs);
        TypedArray a = context.obtainStyledAttributes((AttributeSet) attrs,
                R.styleable.UserInfoBehavior);
        mMinUserInfoHeight = a.getDimensionPixelSize(
                R.styleable.UserInfoBehavior_behavior_min_height, 56);
        a.recycle();
        mMinAppbarHeight = UIHelper.getStatusBarHeight()+UIHelper.getActionBarHeight(); //80dp
        mMaxAppbarHeight = context.getResources().getDimensionPixelSize(R.dimen.image_profil_spacing_256dp); //256dp
        mMaxUserInfoHeight = context.getResources().getDimensionPixelOffset(R.dimen.spacing_larger_104dp) ; //104dp(112)
    }
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, final View dependency){
        float  currentFriction = UIHelper.currentFriction(mMinAppbarHeight, mMaxAppbarHeight, dependency.getBottom());
        int currentHeight = UIHelper.lerp(mMinUserInfoHeight, mMaxUserInfoHeight, currentFriction);

        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        lp.height = currentHeight;
        child.setLayoutParams(lp);

        return super.onDependentViewChanged(parent, child, dependency);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency){
        return dependency instanceof AppBarLayout;
    }
}
