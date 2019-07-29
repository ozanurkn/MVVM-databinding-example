package com.ozan.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ozan.myapplication.R;
import com.ozan.myapplication.databinding.RecyclerItemBinding;
import com.ozan.myapplication.model.TutorialData;
import com.ozan.myapplication.viewmodel.DataItemViewModel;

import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<TutorialData> tdList;

    public RecyclerAdapter() {
        this.tdList = Collections.emptyList();
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerItemBinding recyclerItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_item, parent, false);
        return new MyViewHolder(recyclerItemBinding);   //Binding datası gönderiliyor Holder ımıza.
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        holder.bindRecycler(tdList.get(position));
    }

    public void setList(List<TutorialData> tutorialList) {
        this.tdList = tutorialList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.tdList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerItemBinding mRecyclerItemBinding;

        public MyViewHolder(RecyclerItemBinding recyclerItemBinding) {
            super(recyclerItemBinding.clLayout);
            this.mRecyclerItemBinding = recyclerItemBinding;
        }

        void bindRecycler(TutorialData tutorialData) {
            if (mRecyclerItemBinding.getDataItemViewModel() == null) {
                mRecyclerItemBinding.setDataItemViewModel(new DataItemViewModel(itemView.getContext(), tutorialData));
            } else {
                mRecyclerItemBinding.getDataItemViewModel().setTutorialData(tutorialData);
            }
        }
    }
}
