package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_2MainActivity extends AppCompatActivity {

    EditText nextTerm;
    Button addButton;
    TextView allTerms;
    Button computeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        nextTerm = findViewById(R.id.next_term_edit_text);
        addButton = findViewById(R.id.add_button);
        allTerms = findViewById(R.id.all_terms_text_view);
        computeButton = findViewById(R.id.compute_button);

        addButton.setOnClickListener(it -> {
            if (allTerms.getText().toString().equals("All terms")) {
                if (!nextTerm.getText().toString().equals("") && nextTerm.getText() != null)
                    allTerms.setText(String.valueOf(nextTerm.getText().toString()));
            }
            else {
                if (!nextTerm.getText().toString().equals("") && nextTerm.getText() != null) {
                    allTerms.append(" + ");
                    allTerms.append(String.valueOf(nextTerm.getText().toString()));
                }
            }
        });

        computeButton.setOnClickListener(it -> {
            Intent intent = new Intent(getApplicationContext(), Colocviu1_2_SecondaryActivity.class);
            intent.putExtra("sum", String.valueOf(allTerms.getText()));
            Log.d("allterms", allTerms.getText().toString());
            startActivityForResult(intent, Constants.REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}