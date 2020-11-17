package com.example.resourceanimation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.resourceanimation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim1);
        Resources res = getResources();
        final String[] animals = res.getStringArray(R.array.동물);

        final AlertDialog.Builder builder;
        switch(item.getItemId()) {
            case R.id.animals:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Select Animals");
                builder.setItems(animals, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (animals[which].equals("호랑이"))
                            binding.basic.setImageResource(R.drawable.tiger);
                        else if (animals[which].equals("토끼"))
                            binding.basic.setImageResource(R.drawable.rabbit);
                        else if (animals[which].equals("원숭이"))
                            binding.basic.setImageResource(R.drawable.monkey);

                        binding.basic.startAnimation(anim);
                    }

                });

                builder.create().show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
