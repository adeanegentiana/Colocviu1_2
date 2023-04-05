package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Colocviu1_2_SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu12_secondary);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                setResult(RESULT_CANCELED, null);
            } else {
                String numbers[] = extras.getString("sum").split(" |'|,|.|//+|_");
                int sum = 0;
                for (String number : numbers) {
                    int n = Integer.parseInt(number);
                    sum += n;
                }

                Intent intent = new Intent();
                intent.putExtra("sum", String.valueOf(sum));
                setResult(RESULT_OK, intent);
            }
        } else{
            setResult(RESULT_CANCELED, null);
        }
    }
}