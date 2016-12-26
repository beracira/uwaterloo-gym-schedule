package me.beracira.uwgymschedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity {

    private CalendarView mCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalendarView = (CalendarView) findViewById(R.id.main_calendar);
        mCalendarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DayView.class);
                startActivity(intent);
                Log.d("Main", "calendar on click");
            }
        });
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                    int dayOfMonth) {
                Intent intent = new Intent(MainActivity.this, DayView.class);
                intent.putExtra("YEAR", year);
                intent.putExtra("MONTH", month);
                intent.putExtra("DAY", dayOfMonth);
                intent.putExtra("SELECTED_DATE", year + "-" + (month + 1) + "-" +dayOfMonth);
                startActivity(intent);
                Log.d("Main", year + "-" + month + "-" +dayOfMonth);
            }
        });
    }
}
