package com.example.chart;

import android.graphics.Color;
import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sin;
import android.graphics.Color;
import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class FunActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fun);

        //GraphView graph = (GraphView) findViewById(R.id.graph);
       // LineGraphSeries<DataPoint> series;
       LineChart lineChart;


       /*  using LineGraphSeries it works fine
       double x, y;
        x = -5.0;
        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        for (int i = 0; i < 500; i++) {
            x = x + 0.1;
            y = Math.sin(x);
            series.appendData(new DataPoint(x, y), true, 500);
        }
        graph.addSeries(series); */

            lineChart = (LineChart) findViewById(R.id.graph);

            ArrayList <String> xAXES = new ArrayList<>();
            ArrayList <Entry> yAXESsin = new ArrayList<>();
            ArrayList <Entry> yAXEScos = new ArrayList<>();
            double x = 0;
            int datapoints = 1000 ;
            for (int i=0; i<datapoints; i++)
            {
                float sinFunction = Float.parseFloat(String.valueOf(Math.sin(x)));
                float cosFunction = Float.parseFloat(String.valueOf(Math.cos(x)));
                x = x + 0.1;
                yAXESsin.add(new Entry(sinFunction,i));
                yAXEScos.add(new Entry(cosFunction,i));
                xAXES.add(i, String.valueOf(x));
            }
            String [] xaxes =  new String[xAXES.size()];
            for ( int i=0; i<xAXES.size(); i++)
            {
                xaxes[i] = xAXES.get(i).toString();
            }

            ArrayList <ILineDataSet> linedataSets = new ArrayList<>();
            LineDataSet lineDataSet1 =  new LineDataSet(yAXEScos,"cos");
            lineDataSet1.setDrawCircles(false);
            lineDataSet1.setColor(Color.BLUE);

            LineDataSet lineDataSet2 =  new LineDataSet(yAXESsin,"sin");
            lineDataSet2.setDrawCircles(false);
            lineDataSet2.setColor(Color.RED);

            linedataSets.add(lineDataSet1);
            linedataSets.add(lineDataSet2);

          //  lineChart.setData(new LineData(xaxes,linedataSets));
            lineChart.setVisibleXRangeMaximum(65f);
        }
    }
