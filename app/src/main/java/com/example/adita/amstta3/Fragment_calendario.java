package com.example.adita.amstta3;


import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Fragment_calendario extends Fragment {

    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    public Fragment_calendario() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_fragment_calendario, container, false);
        final CompactCalendarView compactCalendarView = (CompactCalendarView) view.findViewById(R.id.compactcalendar_view);
        final TextView txtMes = (TextView) view.findViewById(R.id.txt_mes);
        Date now = new Date();
        txtMes.setText("");

        CompactCalendarView compactCalendar = (CompactCalendarView) view.findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        //Set an event for Teachers' Professional Day 2016 which is 21st of October

        Event ev1 = new Event(Color.GREEN, 1561131000000L, "Class of AMST");
        compactCalendar.addEvent(ev1);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                List<Event> events = compactCalendarView.getEvents(dateClicked);
                if (events.size() != 0) {
                    Toast.makeText(getContext(), "Day was clicked: " + dateClicked + " with event: " + events.get(0).getData(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "No Events Planned for that day", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                txtMes.setText(dateFormatMonth.format(firstDayOfNewMonth));
            }


        });
        return view;
    }
}
