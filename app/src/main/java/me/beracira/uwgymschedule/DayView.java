package me.beracira.uwgymschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DayView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);

        final TextView textView = (TextView) findViewById(R.id.text);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url =
                "http://csclub.uwaterloo"
                        + ".ca/~z283chen/data/All%20Facilities%20%3e%20Physical%20Activities"
                        + "%20Complex%20%3e%20PAC%20Pool.txt";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String result = "";
                        Scanner scanner = new Scanner(response);
                        scanner.nextLine(); // discard first line
                        while (scanner.hasNext()) {
                            String dateString = scanner.nextLine();
                            String selectedDateString = getIntent().getExtras().getString(
                                    "SELECTED_DATE");
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date selectedDate = null;
                            Date curDate = null;
                            try {
                                selectedDate = simpleDateFormat.parse(selectedDateString);
                                curDate = simpleDateFormat.parse(dateString);
                            } catch (ParseException e) {
                                Log.d("DayView", e.toString());
                            }
                            int eventNumber = Integer.parseInt(scanner.nextLine());
                            if (selectedDate != null && selectedDate.equals(curDate)) {
                                for (int i = 0; i < eventNumber; ++i) {
                                    String temp = scanner.nextLine() + scanner.nextLine() + "\n"
                                            + scanner.nextLine() + "\n";
                                    if (temp.contains("Swim")) {
                                        result += temp;
                                    }
                                }
                            } else {
                                for (int i = 0; i < eventNumber * 3; ++i) {
                                    scanner.nextLine();
                                }
                            }
                        }
                        textView.setText(result);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("ERROR");
                    }
                });
        queue.add(stringRequest);
    }
}
