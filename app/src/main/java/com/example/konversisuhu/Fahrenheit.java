package com.example.konversisuhu;


import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fahrenheit extends Fragment {

    TextView re,ce,ke;
    EditText input;
    Button konversi;
    ImageView iv;
    double reamur,celcius,kelvin;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;

    public Fahrenheit() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fahreneit, container, false);
        re = v.findViewById(R.id.setReamur);
        ce = v.findViewById(R.id.setCelcius);
        ke = v.findViewById(R.id.setKelvin);
        input = v.findViewById(R.id.editText);
        konversi = v.findViewById(R.id.btnKonversiFahrenheit);
        iv = v.findViewById(R.id.imAboutFahrenheit);

        re.setVisibility(View.INVISIBLE);
        ce.setVisibility(View.INVISIBLE);
        ke.setVisibility(View.INVISIBLE);

        konversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Konversi();
            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampilDialog();
            }
        });
        return v;
    }
    private void Konversi()
    {
        final String inp = input.getText().toString();
        if (TextUtils.isEmpty(inp))
        {
            input.setError("Masukan Angka terlebih dahulu");
            input.requestFocus();
            return;
        }
        int nilaiInputan = Integer.parseInt(inp);
        reamur = 0.44444444444 * (nilaiInputan - 32);
        celcius = 0.55555555555 * (nilaiInputan - 32);
        kelvin = 0.55555555555 * (nilaiInputan - 32) + 273;

        re.setVisibility(View.VISIBLE);
        ce.setVisibility(View.VISIBLE);
        ke.setVisibility(View.VISIBLE);

        re.setText(""+reamur+ " R");
        ce.setText(""+celcius+ " C");
        ke.setText(""+kelvin+ " K");
    }

    private void tampilDialog()
    {
        dialog = new AlertDialog.Builder(getContext());
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.about, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
//        dialog.setIcon(R.mipmap.ic_launcher);
//        dialog.setTitle("Form Biodata");
        dialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


}
