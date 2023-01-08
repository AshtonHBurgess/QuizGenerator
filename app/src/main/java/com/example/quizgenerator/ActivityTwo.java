package com.example.quizgenerator;

//import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
//import android.widget.*;
//import android.os.*;
import android.view.*;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {
    Button btnGoToMain;
    Button btnGoToNewQuiz;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        btnGoToMain = findViewById(R.id.btnGoToMain);
        btnGoToNewQuiz = findViewById(R.id.btnGoToNewQuiz);
        display = findViewById(R.id.display);
        String scorestr = getIntent().getStringExtra("score");
        String printout = ("You Got " + scorestr + " Questions Right First Try");
        display.setText(printout);

        btnGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityMain();

            }
        });

        btnGoToNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnGoToNewQuiz();
            }
        });

    }// END OF ONCREATE
    public void openActivityMain(){
        Intent i = new Intent(ActivityTwo.this, MainActivity.class);
        startActivity(i); // brings up the second activity
    }

    public void btnGoToNewQuiz(){
        Intent i = new Intent(ActivityTwo.this, NewQuiz.class);
        startActivity(i); // brings up the second activity
    }
}//END OF CLASS ACTIVITY