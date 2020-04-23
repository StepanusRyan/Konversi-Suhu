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
public class Celcius extends Fragment {
    TextView re,fa,ke;
    EditText input;
    Button konversi;
    ImageView iv;
    double reamur,fahrenheit,kelvin;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;

    public Celcius() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_celcius, container, false);


        re = v.findViewById(R.id.setReamur);
        fa = v.findViewById(R.id.setFahrenheit);
        ke = v.findViewById(R.id.setKelvin);
        input = v.findViewById(R.id.editText);
        konversi = v.findViewById(R.id.btnKonversi);
        iv = v.findViewById(R.id.imAboutCelcius);

        re.setVisibility(View.INVISIBLE);
        fa.setVisibility(View.INVISIBLE);
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
        reamur = 0.8 * nilaiInputan;
        fahrenheit = (1.8 * nilaiInputan) + 32;
        kelvin = nilaiInputan + 273;

        re.setVisibility(View.VISIBLE);
        fa.setVisibility(View.VISIBLE);
        ke.setVisibility(View.VISIBLE);

        re.setText(""+reamur+ " R");
        fa.setText(""+fahrenheit+ " F");
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
