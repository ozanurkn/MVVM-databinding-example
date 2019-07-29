package com.ozan.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ozan.myapplication.R;
import com.ozan.myapplication.adapter.RecyclerAdapter;
import com.ozan.myapplication.databinding.ActivityMainBinding;
import com.ozan.myapplication.model.TutorialData;
import com.ozan.myapplication.utils.DummyDataHelper;
import com.ozan.myapplication.viewmodel.DataItemViewModel;
import com.ozan.myapplication.viewmodel.DataViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity implements Observer {

    private DataViewModel dataViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bind();
        initRecyclerView(binding.recyclerview);
        setupObserver(dataViewModel);
    }

    private void bind(){
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        dataViewModel = new DataViewModel(getContext());
        binding.setViewModel(dataViewModel);
    }

    private void initRecyclerView(RecyclerView recyclerView) {
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
    }

    private Context getContext(){
        return MainActivity.this;
    }

    private void setupObserver(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof DataViewModel){
            DataViewModel dataViewModel = (DataViewModel) o;
            RecyclerAdapter recyclerAdapter = (RecyclerAdapter) binding.recyclerview.getAdapter();
            recyclerAdapter.setList(dataViewModel.getAllTdList());
        }
    }
}
