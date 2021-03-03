package com.nicootech.discover.view;

import com.nicootech.discover.databinding.RestaurantListItemBinding;
import com.nicootech.discover.model.Restaurant;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class RestaurantItemViewHolder extends RecyclerView.ViewHolder {
    // view binding class instance for easily accessing views in Restaurant item
    private final RestaurantListItemBinding binding;

    public RestaurantItemViewHolder(RestaurantListItemBinding binding) {
        super(binding.getRoot()); // pass the current view to super constructor
        this.binding = binding;
    }

    void bind(@NonNull Restaurant data){
        binding.textName.setText(data.getName());
        binding.textType.setText(data.getDescription());
        //binding.textStatus.setText(data.getDeliveryTime() + " Mins");
        if (data.getCoverImgUrl() != null) {
            Picasso.with(itemView.getContext())
                    .load(data.getCoverImgUrl())
                    .placeholder(android.R.color.darker_gray)
                    .error(android.R.color.darker_gray)
                    .fit()
                    .centerCrop()
                    .into(binding.imageLogo);
        }
    }
}
