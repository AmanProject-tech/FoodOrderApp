package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper helper = new DBHelper(this);
        if(getIntent().getIntExtra("type", 0) == 1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailimage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.textView4.setText(name);
            binding.detailDescription.setText(description);


            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.insertOrders(
                            binding.nameBook.getText().toString(),
                            binding.phoneBook.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );
                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Successfully Saved Data", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else{
            final int id = getIntent().getIntExtra("id", 0);

            Cursor cursor = helper.getOrderById(id);
            final int image = cursor.getInt(4);
            binding.detailimage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", cursor.getInt(3)));
            binding.textView4.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(5));

            binding.nameBook.setText(cursor.getString(1));
            binding.phoneBook.setText(cursor.getString(2));
            binding.insertBtn.setText("Update Now");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isUpdated = helper.updateOrder(
                            binding.nameBook.getText().toString(),
                            binding.phoneBook.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.textView4.getText().toString(),
                            1,
                            id
                        );
                        if(isUpdated)
                        {
                            Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }

                }
            });


        }
    }
}