package com.example.adita.amstta3;

import com.github.mikephil.charting.formatter.ValueFormatter;

public class ChartAXisValueFormatter extends ValueFormatter {

    private String[] mValues;

    public ChartAXisValueFormatter(String[] values) {
        mValues = values;
    }

    @Override
    public String getFormattedValue(float value) {

        int val = (int) (value);
        String label = "";
        if (val >= 0 && val < mValues.length) {
            label = mValues[val];
        } else {
            label = "";
        }
        return label;
    }
}
