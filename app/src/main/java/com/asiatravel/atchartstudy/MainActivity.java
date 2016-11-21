package com.asiatravel.atchartstudy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asiatravel.atchartstudy.model.MonthData;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final float TEXT_SIZE = 18;
    private PieChart mPieChart;
    private List<MonthData> mMonthData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPieChart = (PieChart) findViewById(R.id.chart_view);
        initData();
        initPieData();
    }

    private void initData() {
        mMonthData = new ArrayList<>();
        MonthData playing = new MonthData();
        playing.setLabel("娱乐");
        playing.setValue(213);
        MonthData pay = new MonthData();
        pay.setLabel("消费");
        pay.setValue(239);
        MonthData shopping = new MonthData();
        shopping.setLabel("网购");
        shopping.setValue(682);
        MonthData mobile = new MonthData();
        mobile.setLabel("线下");
        mobile.setValue(100);
        mMonthData.add(playing);
        mMonthData.add(pay);
        mMonthData.add(shopping);
        mMonthData.add(mobile);
    }

    private void initPieData() {
        PieData mPieData = new PieData();
        List<PieEntry> mEntry = new ArrayList<>();
        String mLabel = "其他";
        for (MonthData monthData : mMonthData) {
            PieEntry entry = new PieEntry(monthData.getValue(), monthData.getLabel());
            mEntry.add(entry);
        }
        PieDataSet mDataSet = new PieDataSet(mEntry, mLabel);
        mDataSet.setColors(Color.rgb(60, 179, 113), Color.rgb(255, 69, 0),
                Color.rgb(255, 185, 15), Color.rgb(30, 144, 255));
        mPieData.setDataSet(mDataSet);
        mPieData.setValueTextSize(TEXT_SIZE);
        mPieData.setValueTextColor(Color.WHITE);
        mPieChart.setDescription(new Description());
        mPieChart.setData(mPieData);
    }

}
