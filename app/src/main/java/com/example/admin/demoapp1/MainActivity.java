package com.example.admin.demoapp1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart = (BarChart) findViewById(R.id.bargraph);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(100f, 0));
        barEntries.add(new BarEntry(88f, 1));
        barEntries.add(new BarEntry(66f, 2));
        barEntries.add(new BarEntry(12f, 3));
        barEntries.add(new BarEntry(19f, 4));
        barEntries.add(new BarEntry(91f, 5));
        barEntries.add(new BarEntry(91f, 6));
        barEntries.add(new BarEntry(91f, 7));
        barEntries.add(new BarEntry(91f, 8));
        BarDataSet barDataSet = new BarDataSet(barEntries, "Dates");
        int[] Colors = {Color.rgb(193, 37, 82),
                Color.rgb(255, 102, 0),
                Color.rgb(245, 199, 0),
                Color.rgb(106, 150, 31),
                Color.rgb(179, 100, 53),
                Color.rgb(191, 134, 134),
                Color.rgb(179, 48, 80),};
        //barDataSet.setColors(Colors);
         barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        // barDataSet.setColor(getResources().getColor(R.color.colorAccent));


        barDataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return Math.round(value) + "";
            }
        });
         barDataSet.setDrawValues(true);//above heading in bar


        ArrayList<String> theDates = new ArrayList<>();
        theDates.add("April");
        theDates.add("May");
        theDates.add("June");
        theDates.add("Jullay");
        theDates.add("August");
        theDates.add("September");
        theDates.add("October");
        theDates.add("October1");
        theDates.add("October2");


        BarData theData = new BarData(theDates, barDataSet);
        barChart.setData(theData);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);// when long tuch to screen it zooms
        barChart.animateY(3000);
        barChart.getData().setHighlightEnabled(false);   // when click on bar chart high light is false

        YAxis y = barChart.getAxisLeft();
        y.setAxisMaxValue(100);
        y.setAxisMinValue(0);
        y.setDrawAxisLine(true);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);


        YAxis Right = barChart.getAxisRight();
        Right.setEnabled(false);


        Legend legend = barChart.getLegend();
        // legend.setYOffset(40);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        legend.setWordWrapEnabled(true);  ///wrap the leget
        legend.setCustom(ColorTemplate.COLORFUL_COLORS, new String[]{"Set1", "Set2", "Set3", "Set4", "Set5"});
        legend.setTextSize(10);

        barChart.getXAxis().setDrawGridLines(false);  //vertical grid lines visibility false
        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

                if (e.getXIndex() == 0) {

                    Toast.makeText(MainActivity.this, "entry 0", Toast.LENGTH_SHORT).show();
                } else if (e.getXIndex() == 1) {
                    Toast.makeText(MainActivity.this, "entry 1", Toast.LENGTH_SHORT).show();
                } else if (e.getXIndex() == 2) {
                    Toast.makeText(MainActivity.this, "entry 2", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected() {

            }
        });


    }
}



