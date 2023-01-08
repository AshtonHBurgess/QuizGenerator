package com.example.quizgenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.Intent;//intents
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
//import android.widget.*;
//import for File IO
//import java.util.*;
//import android.util.*; //for log

public class MainActivity extends AppCompatActivity {

    String selectedButton = "";
    String correctTerm = "";
    String currentDefinition = "";
    int questionCount = 1;
    int score = 0;
    boolean RightOnFirstTry = true;

    Button btnTerm1,btnTerm2,btnTerm3,btnTerm4;
    TextView displayDef;
    TextView questionCountDsiplay;

    ArrayList<String> terms = new ArrayList<>();
    ArrayList<String> definitions = new ArrayList<>();
    ArrayList<String> buttons = new ArrayList<>();
    Map<String, String> map = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnTerm1 = findViewById(R.id.btnTerm1);
        btnTerm2 = findViewById(R.id.btnTerm2);
        btnTerm3 = findViewById(R.id.btnTerm3);
        btnTerm4 = findViewById(R.id.btnTerm4);
        displayDef = findViewById(R.id.displayDef);
        questionCountDsiplay = findViewById(R.id.questionCountDsiplay);

        String questionCountstr = String.valueOf(questionCount);
        String countToDisplay =  ("Q #" + questionCountstr);
        questionCountDsiplay.setText(countToDisplay);

        populateArrays();

        poppulateMap();

        setCurrentTermAndDefinition();

        putFourTermsInButtonsArray();

        Collections.shuffle(buttons);
        btnTerm1.setText(buttons.get(0));
        btnTerm2.setText(buttons.get(1));
        btnTerm3.setText(buttons.get(2));
        btnTerm4.setText(buttons.get(3));



        //HANDLERS -------------------------------------------------------------------------
        btnTerm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            selectedButton = buttons.get(0);
              boolean correctTerm=  checkIfSelectedButtonIsCorrect();
                 if(!correctTerm){ btnTerm1.setBackgroundColor(Color.RED);  RightOnFirstTry =false;}

            }
        });//end of handler
        btnTerm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedButton = buttons.get(1);
                boolean correctTerm=  checkIfSelectedButtonIsCorrect();
                if(!correctTerm){ btnTerm2.setBackgroundColor(Color.RED);RightOnFirstTry =false;}
            }
        });//end of handler
        btnTerm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedButton = buttons.get(2);
                boolean correctTerm=  checkIfSelectedButtonIsCorrect();
                if(!correctTerm){ btnTerm3.setBackgroundColor(Color.RED);RightOnFirstTry =false;}
            }
        });//end of handler
        btnTerm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedButton = buttons.get(3);
                boolean correctTerm=  checkIfSelectedButtonIsCorrect();
                if(!correctTerm){ btnTerm4.setBackgroundColor(Color.RED);RightOnFirstTry =false;}
            }
        });     //END OF HANDLERS

    }//END OF ON CREATE


    public void nextQuestion(){
        if(questionCount >=10){ openActivityTwo(); }
        else {
            RightOnFirstTry = true;
            questionCount++;
            String questionCountstr = String.valueOf(questionCount);
            String countToDisplay =  ("Q #" + questionCountstr);
            questionCountDsiplay.setText(countToDisplay);

            btnTerm1.setBackgroundColor(Color.CYAN);
            btnTerm2.setBackgroundColor(Color.CYAN);
            btnTerm3.setBackgroundColor(Color.CYAN);
            btnTerm4.setBackgroundColor(Color.CYAN);

            buttons.clear();
            setCurrentTermAndDefinition();
            putFourTermsInButtonsArray();

            Collections.shuffle(buttons);
            btnTerm1.setText(buttons.get(0));
            btnTerm2.setText(buttons.get(1));
            btnTerm3.setText(buttons.get(2));
            btnTerm4.setText(buttons.get(3));

        }
    }//nextQuestion


    public void putFourTermsInButtonsArray(){
        buttons.add(correctTerm);
        int buttonCount = 0;
        for (int i = 0; i < terms.size(); i++) {
            String term = terms.get(i);
            if(!term.equals(correctTerm) && buttonCount <3){  buttons.add(term);
                System.out.println(term + ": was added to buttons list");
                buttonCount++;
            }
        }

    }//putFourTermsInButtonsArray


    public void populateArrays(){
        String strLine = null;
        BufferedReader br = null;
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.quiztext);
            br = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("File in RAW is open");
            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);

                StringTokenizer tokens = new StringTokenizer(strLine, "$");
                //append to arrayList
                definitions.add(tokens.nextToken());
                terms.add(tokens.nextToken());
            }
            inputStream.close();
            System.out.println("File in RAW is closed");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//populateArrays

    public void poppulateMap(){
        //        terms.forEach((term) -> System.out.println(term));
        //        definitions.forEach((def) -> System.out.println(def));
        int termsSize = terms.size();
        // fills my map
        for (int i = 0; i < termsSize; i++) {
            map.put(definitions.get(i), terms.get(i));
        }

    }//poppulateMap

    public void setCurrentTermAndDefinition(){

        currentDefinition = definitions.get(0);
        displayDef.setText( definitions.get(0));
        correctTerm =  map.get(currentDefinition);
        definitions.remove(0);
        //shuffle terms
        Collections.shuffle(terms);

        //Get the matching term
        System.out.println(currentDefinition + ": Term is");
        System.out.println(correctTerm + ": is the correct term!!");

    }//setCurrentTermAndDefinition

    public void openActivityTwo(){
        Intent i = new Intent(MainActivity.this, ActivityTwo.class);
        String scorestr = String.valueOf(score);
        i.putExtra("score", scorestr);
        startActivity(i); // brings up the second activity

    }//openActivityTwo




    public boolean checkIfSelectedButtonIsCorrect(){
        if(selectedButton.equals(correctTerm)){
            System.out.println("you Picked Correct!!");
            // btnTerm1.setBackgroundColor(Color.GREEN);
            if(RightOnFirstTry){ score++;}

            //Go To next Def
         nextQuestion();
            return true;
        }
        else{
            //btnTerm1.setBackgroundColor(Color.RED);
            System.out.println("you Picked WRONG...");
            return false;
        }
    }//END OF checkIfSelectedButtonIsCorrect


    public void btnGoToNewQuiz(){
        Intent i = new Intent(MainActivity.this, NewQuiz.class);
        startActivity(i); // brings up the second activity
    }

}//END OF CLASS ACTIVITY
