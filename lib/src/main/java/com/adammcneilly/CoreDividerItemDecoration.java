package com.adammcneilly;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * DividerItemDecoration to show between RecyclerView items.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
public class CoreDividerItemDecoration extends RecyclerView.ItemDecoration {

    // Attributes for the divider
    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };
    private static final int DIVIDER_POSITION = 0;

    // List orientations
    private static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private int orientation;

    /**
     * The actual divider that is displayed.
     */
    private final Drawable divider;

    public CoreDividerItemDecoration(Context context, int orientation) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        divider = a.getDrawable(DIVIDER_POSITION);
        a.recycle();
        setOrientation(orientation);
    }

    /**
     * Sets the orientation of this item decoration. An exception is thrown if it is not one of
     * the two given orientations.
     */
    private void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }

        this.orientation = orientation;
    }

    /**
     * Draws the divider depending on the orientation of the RecyclerView.
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
        switch(orientation) {
            case VERTICAL_LIST:
                drawVertical(c, parent);
                break;
            case HORIZONTAL_LIST:
                drawHorizontal(c, parent);
                break;
            default:
                break;
        }
    }

    /**
     * Draws a divider for a vertical RecyclerView list.
     */
    private void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    /**
     * Draws a divider for a horizontal RecyclerView list.
     */
    private void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    /**
     * Determines the offset of the divider based on the orientation of the list.
     */
    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        switch(orientation) {
            case VERTICAL_LIST:
                outRect.set(0, 0, 0, divider.getIntrinsicHeight());
                break;
            case HORIZONTAL_LIST:
                outRect.set(0, 0, divider.getIntrinsicWidth(), 0);
        }
    }
}
