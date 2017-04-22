package com.clatschenett.currencycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_compute = (Button) findViewById(R.id.button);
        final EditText edit_input1 = (EditText) (findViewById(R.id.input1));
        final TextView edit_input2 = (TextView) (findViewById(R.id.input2));

        btn_compute.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                double input1_txt = Double.parseDouble(edit_input1.getText().toString());

                String result = currencyCalculation(input1_txt);
                edit_input2.setText(result);
            }
        });

        /*
        edit_input1.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                double input1 = Double.parseDouble(edit_input1.getText().toString());
                double input2 = Double.parseDouble(edit_input2.getText().toString());
            }
        });*/

        //SPINNER creator
        Spinner spinner1 = (Spinner) findViewById(R.id.currencies1);
        Spinner spinner2 = (Spinner) findViewById(R.id.currencies2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencies, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner2.setSelection(2);
    }


    private String currencyCalculation(double amount1) {

        String result;

        result = Double.toString(amount1 * 5);

        return result;

    }
}

