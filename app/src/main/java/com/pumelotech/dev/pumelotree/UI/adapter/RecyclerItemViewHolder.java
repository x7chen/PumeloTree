package com.pumelotech.dev.pumelotree.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.pumelotech.dev.pumelotree.MyApplication;
import com.pumelotech.dev.pumelotree.R;
import com.pumelotech.dev.pumelotree.transfer.ESLHandler;
import com.pumelotech.dev.pumelotree.ui.GoodsInfo;
import com.pumelotech.dev.pumelotree.ui.LabelDrawer;

public class RecyclerItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    ImageView labelPreview;

    public RecyclerItemViewHolder(final View parent) {
        super(parent);
        labelPreview = (ImageView) parent.findViewById(R.id.label_preview);
        parent.setOnClickListener(this);
        parent.setOnLongClickListener(this);
    }


    @Override
    public void onClick(View v) {
        final GoodsInfo label = MyApplication.mLabelList.get(getLayoutPosition() - 1);
        ESLHandler.getInstance().setScreenData(new LabelDrawer(label).getLabelData());
        ESLHandler.getInstance().startSendScreenData();

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
