package com.nicootech.discover.view;

import com.nicootech.discover.databinding.RestaurantListItemBinding;
import com.nicootech.discover.model.Restaurant;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class RestaurantItemViewHolder extends RecyclerView.ViewHolder {

    private final RestaurantListItemBinding binding;

    public RestaurantItemViewHolder(RestaurantListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(@NonNull Restaurant data){
        binding.textName.setText(data.getName());
        binding.textType.setText(data.getDescription());

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
