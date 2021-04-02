package com.nicootech.discover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nicootech.discover.databinding.ActivityMainBinding;
import com.nicootech.discover.view.RestaurantListAdaptor;
import com.nicootech.discover.viewmodel.RestaurantListViewModel;

import static com.nicootech.discover.RestaurantDetailActivity.INTENT_EXTRA_RESTAURANT_ID;

public class MainActivity extends AppCompatActivity {

    private RestaurantListAdaptor adaptor;
    private ActivityMainBinding binding;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adaptor = new RestaurantListAdaptor();
        RecyclerView recyclerView = binding.recyclerView;
        
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adaptor);

        adaptor.setOnRestaurantClickListener(restaurant -> {// Lunching RestaurantDetailActivity
            Intent i = new Intent(MainActivity.this, RestaurantDetailActivity.class);
            i.putExtra(INTENT_EXTRA_RESTAURANT_ID, restaurant.getId());
            startActivity(i);
        });

        // Observe restaurant list LiveData. when list is updated, submit to RecyclerView to display.
        RestaurantListViewModel viewModel = new ViewModelProvider(this).get(RestaurantListViewModel.class);
        viewModel.getRestaurantList().observe(this, restaurants -> {
            binding.progressBar.setVisibility(View.INVISIBLE);
            adaptor.submitList(restaurants);
        });

    }
}
