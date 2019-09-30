package np.com.softwarica.labincalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button0, buttonAdd, buttonSub,
            buttonMultiply, buttonDivide, buttonEqual, buttonClear;
    TextView txtResult;
    double first, second;
    String opcmd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonDivide = findViewById(R.id.buttonDivide);
        txtResult = findViewById(R.id.txtResult);
        buttonClear = findViewById(R.id.buttonClear);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        try {

            switch (view.getId()) {
                case R.id.button0:
                    setNumber(0);
                    break;
                case R.id.button1:
                    setNumber(1);
                    break;
                case R.id.button2:
                    setNumber(2);
                    break;
                case R.id.button3:
                    setNumber(3);
                    break;
                case R.id.button4:
                    setNumber(4);
                    break;
                case R.id.button5:
                    setNumber(5);
                    break;
                case R.id.button6:
                    setNumber(6);
                    break;
                case R.id.button7:
                    setNumber(7);
                    break;
                case R.id.button8:
                    setNumber(8);
                    break;
                case R.id.button9:
                    setNumber(9);
                    break;

                case R.id.buttonAdd:
                    first = getResult();
                    clearText();
                    opcmd = "+";
                    break;
                case R.id.buttonSub:
                    first = getResult();
                    clearText();
                    opcmd = "-";
                    break;
                case R.id.buttonMultiply:
                    first = getResult();
                    clearText();
                    opcmd = "*";
                    break;
                case R.id.buttonDivide:
                    first = getResult();
                    clearText();
                    opcmd = "/";
                    break;
                case R.id.buttonEqual:
//                    try {
//                        Thread.sleep(3000);
//                        txtResult.setText("");
//                    } catch (Exception e) {
//                    }
                    second = getResult();
                    calculateOperation(opcmd);
                    break;
                case R.id.buttonClear:
                    clearText();
                    first = 0;
                    second = 0;
                    break;
                default:
                    txtResult.setError("--ERROR!!!--");
                    Toast.makeText(this, "ERROR!!!", Toast.LENGTH_LONG).show();
                    break;
            }
        } catch (Exception e) {
            txtResult.setError(e.getMessage());

        }
    }

    //    android:inputType="textCapSentences|textMultiLine"
    private void clearText() {
        txtResult.setText("");

    }

    private void setNumber(int number) {
        txtResult.append("" + Integer.toString(number));
    }

    private double getResult() {
        return Integer.parseInt(txtResult.getText().toString());
    }

    private void calculateOperation(String operator) {
        try {
            switch (operator) {
                case "+":
                    double a = first + second;
                    txtResult.setText("" + a);
                    break;
                case "-":
                    double s = first - second;
                    txtResult.setText("" + s);
                    break;

                case "*":
                    double m = first * second;
                    txtResult.setText("" + m);
                    break;

                case "/":
                    double d = first / second;
                    txtResult.setText("" + d);
                    break;
            }

        } catch (Exception e) {
            txtResult.setError(e.getMessage());

        }
    }
}