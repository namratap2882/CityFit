package com.example.getfit;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class consultancy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultancy);

        LinearLayout cardiologyLayout = findViewById(R.id.physiotherapyLayout);
        addDoctorContact(cardiologyLayout, "Dr. John Doe", "1234567890");
        addDoctorContact(cardiologyLayout, "Dr. Jane Smith", "9876543210");
        addDoctorContact(cardiologyLayout, "Dr. Alex Johnson", "1111111111");
        addDoctorContact(cardiologyLayout, "Dr. Sarah Brown", "2222222222");

        LinearLayout dermatologyLayout = findViewById(R.id.nutritionLayout);
        addDoctorContact(dermatologyLayout, "Dr. David Johnson", "1112223333");
        addDoctorContact(dermatologyLayout, "Dr. Emily Brown", "4445556666");
        addDoctorContact(dermatologyLayout, "Dr. James Wilson", "7778889999");
        addDoctorContact(dermatologyLayout, "Dr. Lily Davis", "1010101010");

        LinearLayout orthopedicsLayout = findViewById(R.id.psychologyLayout);
        addDoctorContact(orthopedicsLayout, "Dr. Michael Davis", "5556667777");
        addDoctorContact(orthopedicsLayout, "Dr. Sarah Wilson", "8889990000");
        addDoctorContact(orthopedicsLayout, "Dr. Jacob Thompson", "3333333333");
        addDoctorContact(orthopedicsLayout, "Dr. Olivia Parker", "6666666666");

    }

    private void addDoctorContact(LinearLayout layout, String doctorName, String phoneNumber) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 16, 0, 16);

        TextView textView = new TextView(this);
        textView.setLayoutParams(layoutParams);
        textView.setText(String.format("%s: %s", doctorName, phoneNumber));
        textView.setTextColor(getResources().getColor(android.R.color.black));
        textView.setTextSize(16);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneUri = "tel:" + phoneNumber;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneUri));
                startActivity(intent);
            }
        });

        layout.addView(textView);
    }
}
