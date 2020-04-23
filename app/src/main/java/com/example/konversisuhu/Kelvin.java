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
public class Kelvin extends Fragment {
    TextView re,fa,ce;
    EditText input;
    Button konversi;
    ImageView iv;
    double reamur,fahrenheit,celcius;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;

    public Kelvin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kelvin, container, false);
        re = v.findViewById(R.id.setReamur);
        fa = v.findViewById(R.id.setFahrenheit);
        ce = v.findViewById(R.id.setCelciusfKelvin);
        input = v.findViewById(R.id.editText);
        konversi = v.findViewById(R.id.btnKonversiKelvin);
        iv = v.findViewById(R.id.imAboutKelvin);

        re.setVisibility(View.INVISIBLE);
        fa.setVisibility(View.INVISIBLE);
        ce.setVisibility(View.INVISIBLE);

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
        reamur = 0.8 * (nilaiInputan - 273);
        fahrenheit = 1.8 * (nilaiInputan - 273) + 32;
        celcius = nilaiInputan - 273;

        re.setVisibility(View.VISIBLE);
        fa.setVisibility(View.VISIBLE);
        ce.setVisibility(View.VISIBLE);

        re.setText(""+reamur+ " R");
        fa.setText(""+fahrenheit+ " F");
        ce.setText(""+celcius+ " C");
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
