package com.pumelotech.dev.pumelotree.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import com.pumelotech.dev.pumelotree.R;
import com.pumelotech.dev.pumelotree.ui.GoodsInfo;
import com.pumelotech.dev.pumelotree.ui.LabelDrawer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/9.
 */
public class LabelRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<GoodsInfo> mLabelList;
    private LayoutInflater mInflator;
    private Context mContext;
    private static final int TYPE_HEADER = 2;
    private static final int TYPE_ITEM = 1;

    public LabelRecyclerAdapter(List<GoodsInfo> list) {
        super();
        mLabelList = (ArrayList<GoodsInfo>) list;
    }

    public GoodsInfo getLabelById(String id) {
        if (mLabelList != null&&!mLabelList.isEmpty()) {
            for(GoodsInfo label: mLabelList){
                if(label.Identifier.equals(id)){
                    return label;
                }
            }
        }
        return null;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        if (viewType == TYPE_ITEM) {
            final View view = LayoutInflater.from(context).inflate(R.layout.label_item, parent, false);
            return new RecyclerItemViewHolder(view);
        } else if (viewType == TYPE_HEADER) {
            final View view = LayoutInflater.from(context).inflate(R.layout.recycler_header, parent, false);
            return new RecyclerHeaderViewHolder(view);
        }
        throw new RuntimeException("There is no type that matches the type " + viewType + " + make sure your using types correctly");

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerItemViewHolder viewHolder;
        if (!isPositionHeader(position)) {
            viewHolder = (RecyclerItemViewHolder) holder;
        } else {
            return;
        }
        if (holder == null) {
            return;
        }
        final GoodsInfo goods = mLabelList.get(position - 1);
        viewHolder.labelPreview.setImageBitmap(new LabelDrawer(goods).getBitMap());
        viewHolder.labelPreview.setScaleX(2);
        viewHolder.labelPreview.setScaleY(2);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //our old getItemCount()
    public int getBasicItemCount() {
        return mLabelList == null ? 0 : mLabelList.size();
    }

    //our new getItemCount() that includes header View
    @Override
    public int getItemCount() {
        return getBasicItemCount() + 1; // header
    }

    //added a method that returns viewType for a given position
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    //added a method to check if given position is a header
    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}

