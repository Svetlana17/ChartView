package com.example.chart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.Pie;
import com.anychart.anychart.ValueDataEntry;
import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;
import java.util.List;
 // библиотека   implementation 'com.github.AnyChart:AnyChart-Android:0.0.3'
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       PieChart t = (PieChart)  findViewById(R.id.piechart);



        Pie pie = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("John", 10000));
        data.add(new ValueDataEntry("Jake", 12000));
        data.add(new ValueDataEntry("Peter", 18000));
        pie.setData(data);

    //    AnyChartView anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);
     //   anyChartView.setChart(pie);



        Button bt = (Button) findViewById(R.id.showPie);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChartActivity.class);
                startActivity(intent);
            }
        });
/*
        Button btFun = (Button) findViewById(R.id.btFun);
        btFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FunActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
