package calculator.created.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.created.calculator.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private enum OPERATOR{
        PLUS,SUBTRACT,MULTIPLY,DIVIDE,EQUAL
    }


    private TextView calculation;
    private TextView result;

private String currentnumber;
private String leftnumber;
private String rightnumber;
private OPERATOR currentoperator;
private int calculationresult;
private String calprocess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentnumber="";
        calculationresult=0;
        calprocess="";
        calculation=findViewById(R.id.txtcal);
        result=findViewById(R.id.textviewresult);
        Button equal=findViewById(R.id.equal);
        Button one=findViewById(R.id.button2);
        Button two=findViewById(R.id.button3);
        Button three=findViewById(R.id.button4);
        Button four=findViewById(R.id.button6);
        Button five=findViewById(R.id.button7);
        Button six=findViewById(R.id.button8);
        Button seven=findViewById(R.id.button10);
        Button eight=findViewById(R.id.button11);
        Button nine=findViewById(R.id.button12);
        Button multiply=findViewById(R.id.button5);
        Button add=findViewById(R.id.button9);
        Button subtract=findViewById(R.id.button13);
        Button clear=findViewById(R.id.button14);
        Button zero=findViewById(R.id.button15);
        Button divide=findViewById(R.id.button16);

        equal.setOnClickListener(MainActivity.this);
        one.setOnClickListener(MainActivity.this);
        two.setOnClickListener(MainActivity.this);
        three.setOnClickListener(MainActivity.this);
        four.setOnClickListener(MainActivity.this);
        five.setOnClickListener(MainActivity.this);
        six.setOnClickListener(MainActivity.this);
        seven.setOnClickListener(MainActivity.this);
        eight.setOnClickListener(MainActivity.this);
        nine.setOnClickListener(MainActivity.this);
        multiply.setOnClickListener(MainActivity.this);
        add.setOnClickListener(MainActivity.this);
        subtract.setOnClickListener(MainActivity.this);
        clear.setOnClickListener(MainActivity.this);
        zero.setOnClickListener(MainActivity.this);
        divide.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.equal:

                operatortapped(OPERATOR.EQUAL);


                break;


            case R.id.button2:

                tapped(1);

                break;

            case R.id.button3:

                tapped(2);

                break;

            case R.id.button4:
                tapped(3);


                break;

            case R.id.button5:
operatortapped(OPERATOR.MULTIPLY);

calprocess=calprocess+" * ";
                this.calculation.setText(calprocess);

                break;

            case R.id.button6:
                tapped(4);


                break;

            case R.id.button7:

                tapped(5);

                break;

            case R.id.button8:

                tapped(6);

                break;

            case R.id.button9:

                operatortapped(OPERATOR.PLUS);

                calprocess=calprocess+" + ";
                this.calculation.setText(calprocess);

                break;

            case R.id.button10:

                tapped(7);

                break;

            case R.id.button11:
                tapped(8);


                break;

            case R.id.button12:
                tapped(9);


                break;

            case R.id.button13:
                operatortapped(OPERATOR.SUBTRACT);


                calprocess=calprocess+" - ";
                this.calculation.setText(calprocess);

                break;

            case R.id.button14:

clear();
                break;

            case R.id.button15:
                tapped(0);


                break;

            case R.id.button16:
                operatortapped(OPERATOR.DIVIDE);

                calprocess=calprocess+" / ";
                this.calculation.setText(calprocess);


                break;

        }




    }

    public void tapped(int tappednumber){

        this.currentnumber+= Integer.toString(tappednumber);
        this.result.setText(currentnumber);
        calprocess=currentnumber;
        this.calculation.setText(calprocess);
    }


    public void operatortapped(OPERATOR tappedoperator){

        if(currentoperator!=null) {
            if (currentnumber != "") {

                this.rightnumber = currentnumber;
                currentnumber = "";

                switch (currentoperator) {

                    case PLUS:
                        calculationresult = Integer.parseInt(leftnumber) + Integer.parseInt(rightnumber);


                        break;

                    case SUBTRACT:

                        calculationresult = Integer.parseInt(leftnumber) - Integer.parseInt(rightnumber);


                        break;

                    case MULTIPLY:

                        calculationresult = Integer.parseInt(leftnumber) * Integer.parseInt(rightnumber);


                        break;

                    case DIVIDE:

                        calculationresult = Integer.parseInt(leftnumber) / Integer.parseInt(rightnumber);


                        break;


                }

                leftnumber = String.valueOf(calculationresult);

                  this.result.setText(String.valueOf(calculationresult));
                calprocess = String.valueOf(calculationresult);
this.calculation.setText(calprocess);
            }
        }
        else{
            leftnumber=currentnumber;
            currentnumber="";
            //this.result.setText(currentnumber);

        }
        currentoperator=tappedoperator;


    }

    public void clear(){
        this.leftnumber="";

        this.rightnumber="";
        calculationresult=0;
        currentoperator=null;
        calculation.setText("");
        result.setText("0");
        calprocess="";
        currentnumber="";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if(item.getItemId()==R.id.BMI){

            Intent intent=new Intent(MainActivity.this,Bmiactivity.class);
            startActivity(intent);

        }
        if(item.getItemId()==R.id.length){

            Intent intent=new Intent(MainActivity.this,Lengthactivity.class);
            startActivity(intent);

        }
        if(item.getItemId()==R.id.feedbck){

            Intent intent=new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:nikkubisht12@gmail.com"));
            startActivity(intent);

        }



        return true;
    }
}
