package com.neilcastellino.bon;

//import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

//import com.lusfold.spinnerloading.SpinnerLoading;

public class Homepage extends Activity {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.content_homepage);

//        SpinnerLoading view = findViewById(R.id.spinner_loading);
//        view.setPaintMode(h1);
//        view.setCircleRadius(30);
//        view.setItemCount(8);

        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
        @Override
        public void run (){
            Intent i = new Intent(Homepage.this, Login.class);
            startActivity(i);

            this.finish();
        }
        private void finish() {
    }
    },4000);
};

}
