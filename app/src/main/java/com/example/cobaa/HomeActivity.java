package com.example.cobaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.carouselView)
    CarouselView carouselView;
    @BindView(R.id.btnSumatera)
    LinearLayout btnSumatera;
    @BindView(R.id.btnJawa)
    LinearLayout btnJawa;
    @BindView(R.id.btnKalimantan)
    LinearLayout btnKalimantan;
    @BindView(R.id.btnSulawesi)
    LinearLayout btnSulawesi;
    @BindView(R.id.btnMalukuIrian)
    LinearLayout btnMalukuIrian;

    int[] sampleImages = {R.drawable.ic_slide1, R.drawable.ic_slide2, R.drawable.ic_slide3};
    String daerah = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setup();
    }

    @OnClick({R.id.btnSumatera, R.id.btnJawa, R.id.btnKalimantan, R.id.btnSulawesi, R.id.btnMalukuIrian})
    void onClick(View v) {
        if (v == btnSumatera) {
            daerah = Question.SUMATERA;
            startgame();
        }
        if (v == btnJawa) {
            daerah = Question.JAWA;
            startgame();
        }
        if (v == btnKalimantan) {
            daerah = Question.KALIMANTAN;
            startgame();
        }
        if (v == btnSulawesi) {
            daerah = Question.SULAWESI;
            startgame();
        }
        if (v == btnMalukuIrian) {
            daerah = Question.MALUKU_IRIANJAYA;
            startgame();
        }
    }

    void setup() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
    }

    private void startgame() {
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("Daerah", daerah);
        startActivity(intent);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}