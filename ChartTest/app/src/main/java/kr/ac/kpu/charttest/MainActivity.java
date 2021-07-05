package kr.ac.kpu.charttest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    CandleStickChart candleStickChart;
    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        candleStickChart = (CandleStickChart) findViewById(R.id.chart);
        lineChart = (LineChart) findViewById(R.id.chart2);

        CandleDataSet candleDataSet = new CandleDataSet(getRandomData(), "DataSet 1");
        CandleData candleData = new CandleData();

        candleData.addDataSet(candleDataSet);

        ///////////////
        candleDataSet.setDrawIcons(false);
        candleDataSet.setShadowColor(Color.DKGRAY);
        candleDataSet.setShadowWidth(0.7f);

        candleDataSet.setDecreasingColor(Color.RED);
        candleDataSet.setDecreasingPaintStyle(Paint.Style.FILL);

        candleDataSet.setIncreasingColor(Color.BLUE);
        candleDataSet.setIncreasingPaintStyle(Paint.Style.FILL);
        candleDataSet.setNeutralColor(Color.LTGRAY);
        candleStickChart.setDragDecelerationEnabled(false);
        //////////////

        candleStickChart.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartLongPressed(MotionEvent me) {

            }

            @Override
            public void onChartDoubleTapped(MotionEvent me) {

            }

            @Override
            public void onChartSingleTapped(MotionEvent me) {

            }

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

            }

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {

            }
        });

        candleStickChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                CandleEntry ce = (CandleEntry) e;
                Toast.makeText(getApplicationContext(), Float.toString(ce.getOpen()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        candleStickChart.setData(candleData);
        candleStickChart.invalidate();

        LineDataSet lineDataSet = new LineDataSet(getRandomLineData(), "DataSet 1");
        LineData lineData = new LineData();
        lineData.addDataSet(lineDataSet);

        ///////////////////
        lineDataSet.setDrawCircles(false);
        lineDataSet.setValueTextSize(0);
        lineDataSet.setColor(Color.BLACK);
        lineDataSet.setLineWidth(3);
        //////////////////

        lineChart.setData(lineData);
        lineChart.invalidate();

    }

    public static ArrayList<CandleEntry> getRandomData() {
        ArrayList<CandleEntry> values = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            float multi = (i + 1);
            float val = (float) (Math.random() * 40) + multi;

            float high = (float) (Math.random() * 9) + 8f;
            float low = (float) (Math.random() * 9) + 8f;

            float open = (float) (Math.random() * 6) + 1f;
            float close = (float) (Math.random() * 6) + 1f;

            boolean even = i % 2 == 0;

            values.add(new CandleEntry(
                    i, val + high,
                    val - low,
                    even ? val + open : val - open,
                    even ? val - close : val + close));
        }


        return values;
    }

    public static ArrayList<Entry> getRandomLineData() {
        ArrayList<Entry> lineDataList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            lineDataList.add(new Entry(i, (float) Math.random() * 100));

        }

        return lineDataList;
    }

}

