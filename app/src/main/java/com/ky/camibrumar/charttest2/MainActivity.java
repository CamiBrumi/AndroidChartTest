package com.ky.camibrumar.charttest2;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    BarChart chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    MyBarDataSet Bardataset ;
    BarData BARDATA ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chart = (BarChart) findViewById(R.id.chart1);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();

        AddValuesToBarEntryLabels();

        Bardataset = new MyBarDataSet(BARENTRY, "Your happiness");

        Bardataset.setColors(new int[]{ContextCompat.getColor(getApplicationContext(), R.color.red),
                ContextCompat.getColor(getApplicationContext(), R.color.orange),
                ContextCompat.getColor(getApplicationContext(), R.color.green)});

        BARDATA = new BarData(Bardataset);

        //Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(BarEntryLabels)); //TODO: sa vad daca se aseaza bine sau cum sa le pun mai bine (acum se pun labelurile undeva sus perse chart)

        chart.animateY(3000);

        //-------------------------------

        /*
        BarChart chart = (BarChart) findViewById(R.id.chart);

        List<String> xValues = new ArrayList<String>();
        xValues.add("Monday");
        xValues.add("Tuesday");
        xValues.add("Thursday");
        xValues.add("Friday");
        xValues.add("Saturday");
        xValues.add("Sunday");


        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new MyValueFormatter(xValues));


        Pair[] dataObjects = new Pair[3];
        dataObjects[0] = new Pair(1.5f, 2.3f);
        dataObjects[1] = new Pair(2.5f, 3.3f);
        dataObjects[2] = new Pair(4.5f, 5.3f);



        List<BarEntry> entries = new ArrayList<BarEntry>();


        for (Pair data : dataObjects) {

            // turn your data into Entry objects
            entries.add(new BarEntry(data.key(), data.value()));
        }

        BarDataSet dataSet = new BarDataSet(entries, "Label"); // add entries to dataset
        //dataSet.setValueTextColor(...); // styling, ...

        BarData barData = new BarData(dataSet);
        chart.setData(barData);
        chart.invalidate(); // refresh
        */
    }

    public void AddValuesToBARENTRY(){

        BARENTRY.add(new BarEntry(0f, 1, R.drawable.happy));
        BARENTRY.add(new BarEntry(1f, 2));
        BARENTRY.add(new BarEntry(2f, 3));
        BARENTRY.add(new BarEntry(3f, 4));
        BARENTRY.add(new BarEntry(4f, 5));
        BARENTRY.add(new BarEntry(5f, 6, R.drawable.happy));

    }

    public void AddValuesToBarEntryLabels(){

        BarEntryLabels.add("January");
        BarEntryLabels.add("February");
        BarEntryLabels.add("March");
        BarEntryLabels.add("April");
        BarEntryLabels.add("May");
        BarEntryLabels.add("June");

    }

}
