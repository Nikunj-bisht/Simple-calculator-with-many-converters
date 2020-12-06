package calculator.created.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.created.calculator.R;

public class Lengthactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lengthactivity);

        getSupportActionBar().setTitle("Length converter");

        final EditText editText=findViewById(R.id.metertxt);

      final  EditText cm=findViewById(R.id.entercm);


        final TextView showcm=findViewById(R.id.cmtext);

     final    TextView shmeter=findViewById(R.id.showmeter);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(editText.getText().toString().length()>0) {
                    long meteres = Long.parseLong(editText.getText().toString());
                    String strmeter = String.valueOf(meteres * 100);
                    showcm.setText(strmeter + " cm");
                    //   cm.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (cm.getText().toString().length() > 0) {

                    long centimeter = Long.parseLong(cm.getText().toString());
                    double convert = centimeter / 100;
                    String strmeter = String.valueOf(convert);

                    shmeter.setText(strmeter + " m");
                    //   editText.setText("");

                }
            }
            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }
    }


