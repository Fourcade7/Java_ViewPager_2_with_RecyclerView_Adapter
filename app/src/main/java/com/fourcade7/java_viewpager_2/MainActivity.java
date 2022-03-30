package com.fourcade7.java_viewpager_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    DotaAdapter dotaAdapter;
    Button button;
    ViewPager2 viewPager2;

    ArrayList<Dota> dotaArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button2);
        dotaArrayList=new ArrayList<>();
        viewPager2=findViewById(R.id.viewpager2);


        dotaArrayList.add(new Dota(R.drawable.axe));
        dotaArrayList.add(new Dota(R.drawable.prr));
        dotaArrayList.add(new Dota(R.drawable.pubg));
        dotaArrayList.add(new Dota(R.drawable.terror));
        dotaArrayList.add(new Dota(R.drawable.torm));
        dotaArrayList.add(new Dota(R.drawable.axe));
        dotaArrayList.add(new Dota(R.drawable.prr));
        dotaArrayList.add(new Dota(R.drawable.pubg));
        dotaArrayList.add(new Dota(R.drawable.terror));
        dotaArrayList.add(new Dota(R.drawable.torm));
        viewPager2.setAdapter(new DotaAdapter(MainActivity.this,dotaArrayList,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(1);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(5));
        compositePageTransformer.addTransformer((page, position) -> {

                int r= (int) (1-Math.abs(position));
                page.setScaleY(0.85f+r*0.25f);

        });



        viewPager2.setPageTransformer(compositePageTransformer);


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                //Toast.makeText(MainActivity.this, viewPager2.getCurrentItem()+"", Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
            }
        });


    }
}