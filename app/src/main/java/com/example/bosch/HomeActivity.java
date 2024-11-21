package com.example.bosch;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bosch.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

static  String TAG = HomeActivity.class.getSimpleName();
    ActivityHomeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        ConstraintLayout view = binding.getRoot();
        setContentView(view);

       /*String data = getIntent().getExtras().getString("mykey");
       binding.tvHome.setText(data);*/

       binding.btnSelect.setOnClickListener(this);
    }

    public void handleSelect(View view) {

    }


   @Override
    public void onClick(View view) {
       Log.i(TAG,"onnclick");
        String contactData = binding.etContact.getText().toString();
        Intent dIntent = new Intent();
        dIntent.putExtra("conkey",contactData);
        setResult(RESULT_OK,dIntent);  //resultcode=RESULTOK= nose
       finish(); //close the activty 2
      // throw new NullPointerException("demo");
   }
}