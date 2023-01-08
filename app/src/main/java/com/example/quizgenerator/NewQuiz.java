package com.example.quizgenerator;

import androidx.appcompat.app.AppCompatActivity;

//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;

import android.content.Intent;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.io.*;
import java.util.ArrayList;

public class NewQuiz extends AppCompatActivity {
//private static final String FILE_NAME = "newQuiz.txt";

EditText def,def2, def3, def4, def5, def6, def7, def8, def9, def10;
    EditText trm, trm2, trm3, trm4, trm5, trm6, trm7, trm8, trm9, trm10;

    Button enterButton, loadQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_quiz);

        def.findViewById(R.id.trm);
        trm.findViewById(R.id.def);
        def2.findViewById(R.id.trm2);
        trm2.findViewById(R.id.def2);
        def3.findViewById(R.id.trm3);
        trm3.findViewById(R.id.def3);
        def4.findViewById(R.id.trm4);
        trm4.findViewById(R.id.def4);
        def5.findViewById(R.id.trm5);
        trm5.findViewById(R.id.def5);
        def6.findViewById(R.id.trm6);
        trm6.findViewById(R.id.def6);
        def7.findViewById(R.id.trm7);
        trm7.findViewById(R.id.def7);
        def8.findViewById(R.id.trm8);
        trm8.findViewById(R.id.def8);
        def9.findViewById(R.id.trm9);
        trm9.findViewById(R.id.def9);
        def10.findViewById(R.id.trm10);
        trm10.findViewById(R.id.def10);
        enterButton.findViewById(R.id.enter);
        loadQuiz.findViewById(R.id.loadquiz);

//        enterButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                try {
////FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
//                    FileOutputStream fileout=openFileOutput("newquiz.txt",
//                            MODE_APPEND);
//                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
//                    System.out.println("File open for write");
//                    String quizTxt = buildtxt();
//                    outputWriter.write(quizTxt);
//                    outputWriter.close();
////display file saved message
//                    System.out.println("File saved and closed");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//
//
//            }
//        });//end of handler
//        loadQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(NewQuiz.this, MainActivity.class);
//                startActivity(i); // brings up the second activity
//            }
//        });//end of handler
//
//
//
//

      }
//

    public String buildtxt(){
        String quizTxt;

        String l1 =trm.getText().toString() + "$" + def.getText().toString() + "\n";
        String l2 =trm2.getText().toString() + "$" + def2.getText().toString() + "\n";
        String l3 =trm3.getText().toString() + "$" + def3.getText().toString() + "\n";
        String l4 =trm4.getText().toString() + "$" + def4.getText().toString() + "\n";
        String l5 =trm5.getText().toString() + "$" + def5.getText().toString() + "\n";
        String l6 =trm6.getText().toString() + "$" + def6.getText().toString() + "\n";
        String l7 =trm7.getText().toString() + "$" + def7.getText().toString() + "\n";
        String l8 =trm8.getText().toString() + "$" + def8.getText().toString() + "\n";
        String l9 =trm9.getText().toString() + "$" + def9.getText().toString() + "\n";
        String l10 =trm10.getText().toString() + "$" + def10.getText().toString() + "\n";

        quizTxt = l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 + l10 ;
        return quizTxt;
    }
}//END