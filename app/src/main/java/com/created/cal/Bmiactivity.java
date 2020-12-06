package calculator.created.cal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.created.calculator.R;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Bmiactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bmiactivity);

        getSupportActionBar().setTitle("BMI");


      final   EditText weight=findViewById(R.id.editText);

        final EditText height=findViewById(R.id.editText2);

        Button calculate=findViewById(R.id.button);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double heightint=Double.parseDouble(height.getText().toString())/100;
heightint*=heightint;

                DecimalFormat df=new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);
                df.format(heightint);
                Log.d("weight", String.valueOf(heightint));
                double weightint=Integer.parseInt(weight.getText().toString());

                double bmi=weightint/heightint;
                String condition="";
                if(bmi>=18.5 && bmi<=24.5){
                    condition="Normal";
                }

               else if(bmi>=25 && bmi<=29.9){
                    condition="Overweight";
                }
              else  if(bmi>=30 && bmi<=39.9){
                    condition="Obese";
                }
                else{
                    condition="Morbidly Obese";
                }

                AlertDialog.Builder builder=new AlertDialog.Builder(Bmiactivity.this);

                builder.setTitle("Your BMI is "+String.valueOf(bmi));

                builder.setMessage("You are "+condition);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog d=builder.create();
                d.show();
            }
        });

    }
}
