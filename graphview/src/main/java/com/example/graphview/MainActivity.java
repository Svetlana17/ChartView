package com.example.graphview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.graphview.R;
import com.scichart.charting.model.AxisCollection;
import com.scichart.charting.model.ChartModifierCollection;
import com.scichart.charting.model.RenderableSeriesCollection;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.modifiers.PinchZoomModifier;
import com.scichart.charting.modifiers.ZoomExtentsModifier;
import com.scichart.charting.modifiers.ZoomPanModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.HorizontalAnchorPoint;
import com.scichart.charting.visuals.annotations.TextAnnotation;
import com.scichart.charting.visuals.annotations.VerticalAnchorPoint;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.DateAxis;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.core.model.DateValues;
import com.scichart.core.model.DoubleValues;
import com.scichart.core.utility.DateIntervalUtil;
import com.scichart.drawing.common.PenStyle;
import com.scichart.drawing.common.SolidPenStyle;
import com.scichart.drawing.utility.ColorUtil;
import com.scichart.extensions.builders.SciChartBuilder;

import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SciChartSurface chartSurface = (SciChartSurface) findViewById(R.id.view);
        try {

        }catch (Exception e){
            e.printStackTrace();
        }


        DateAxis xAxis = new DateAxis(this);

        AxisCollection xAxes = chartSurface.getXAxes();
        xAxes.add(xAxis);

        xAxis.setAxisTitle("X Axis");
        NumericAxis yAxis = new NumericAxis(this);

        AxisCollection yAxes = chartSurface.getYAxes();
        yAxes.add(yAxis);


        yAxis.setAxisAlignment(AxisAlignment.Left);
        yAxis.setAxisTitle("Y Axis");

        FastLineRenderableSeries lineSeries = new FastLineRenderableSeries();

        RenderableSeriesCollection renderableSeries = chartSurface.getRenderableSeries();

        renderableSeries.add(lineSeries);
        PenStyle penStyle = new SolidPenStyle(ColorUtil.Green, true, 2f, null);


        lineSeries.setStrokeStyle(penStyle);
        XyDataSeries<Date, Double> dataSeries = new XyDataSeries<>(Date.class, Double.class);

        int size = 100;
        DateValues xValues = new DateValues(size);
        DoubleValues yValues = new DoubleValues(size);

        Random random = new Random();
        for (double i = 0; i < size; ++i) {

            long xValue = new Date().getTime() + DateIntervalUtil.fromDays(i);
            xValues.add(new Date(xValue));

            yValues.add(random.nextDouble());
        }


        dataSeries.append(xValues, yValues);
        lineSeries.setDataSeries(dataSeries);

        chartSurface.zoomExtents();
        PinchZoomModifier zoomModifier = new PinchZoomModifier();
        ZoomPanModifier panModifier = new ZoomPanModifier();

        ChartModifierCollection chartModifiers = chartSurface.getChartModifiers();
        chartModifiers.add(zoomModifier);
        chartModifiers.add(panModifier);
        ZoomExtentsModifier zoomExtentsModifier = new ZoomExtentsModifier();
        chartModifiers.add(zoomExtentsModifier);
}}