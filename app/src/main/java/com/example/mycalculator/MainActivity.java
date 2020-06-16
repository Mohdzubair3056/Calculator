package com.example.mycalculator;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static final String MSG = "previous calculations";

    private boolean isSymbolpressed =false;

    private  double firstNumber =0;

    private  int secondNumberIndex =0;

    private  char currentPressed;

    private  boolean doneCalci = false;

    private  boolean percentagePressed =false;

    private  boolean noDigitPressed = true;

    private boolean dotPressed =false;


    private GoogleSignInClient googleSignInClient;


    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String user;
    private ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth =FirebaseAuth.getInstance();

        final Button n0 =findViewById(R.id.n0);
        final Button n1 =findViewById(R.id.n1);
        final Button n2 =findViewById(R.id.n2);
        final Button n3 =findViewById(R.id.n3);
        final Button n4 =findViewById(R.id.n4);
        final Button n5 =findViewById(R.id.n5);
        final Button n6 =findViewById(R.id.n6);
        final Button n7 =findViewById(R.id.n7);
        final Button n8 =findViewById(R.id.n8);
        final Button n9 =findViewById(R.id.n9);
        final Button plus =findViewById(R.id.plus);
        final Button equal =findViewById(R.id.equal);
        final Button subtract =findViewById(R.id.subtract);
        final Button multiply =findViewById(R.id.multiply);
        final Button divide =findViewById(R.id.divide);
        final Button dot =findViewById(R.id.dot);
        final Button percent =findViewById(R.id.percent);
        final Button delAll =findViewById(R.id.delAll);
        final Button remove =findViewById(R.id.remove);
        final Button square =findViewById(R.id.upon);

        final TextView screen =findViewById(R.id.screen);
        final ImageButton more_options =findViewById(R.id.more_options);
        final  ImageButton previous =findViewById(R.id.previous);
        firebaseDatabase = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        databaseReference = firebaseDatabase.getReference("Previous calculations");



        GoogleSignInOptions gso =new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();

        googleSignInClient = GoogleSignIn.getClient(this,gso);

        final View.OnClickListener listener =new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final int id =v.getId();
                switch (id){
                    case R.id.n0:
                        if(screen.length() < 23){
                        if(!doneCalci) {
                            screen.append("0");
                            noDigitPressed = false;
                            }


                        else{
                            doneCalci =false;
                            screen.setText("");
                            screen.append("0");
                            noDigitPressed = false;
                        }}
                        else{
                            Toast.makeText(MainActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;




                    case R.id.dot:
                        if(!dotPressed){
                        if(!doneCalci) {
                            screen.append(".");
                            noDigitPressed = false;
                            dotPressed =true;
                        }
                        else{
                            doneCalci =false;
                            screen.setText("");
                            screen.append(".");
                            noDigitPressed = false;
                            dotPressed =true;
                        }}

                        break;





                    case R.id.n1:
                        if(screen.length() <23) {
                            if (!doneCalci) {
                                screen.append("1");
                                noDigitPressed = false;
                            } else {
                                doneCalci = false;
                                screen.setText("");
                                screen.append("1");
                                noDigitPressed = false;
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;






                    case R.id.n2:
                        if(screen.length() <23){
                        if(!doneCalci) {
                            screen.append("2");
                            noDigitPressed = false;
                        }
                        else{
                            doneCalci =false;
                            screen.setText("");
                            screen.append("2");
                            noDigitPressed = false;
                        }}
                        else{
                            Toast.makeText(MainActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;




                    case R.id.n3:
                        if(screen.length()<23){
                        if(!doneCalci) {
                            screen.append("3");
                            noDigitPressed = false;
                        }
                        else{
                            doneCalci =false;
                            screen.setText("");
                            screen.append("3");
                            noDigitPressed = false;
                        }}
                        else{
                            Toast.makeText(MainActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;





                    case R.id.n4:
                        if(screen.length()<23){
                        if(!doneCalci) {
                            screen.append("4");
                            noDigitPressed = false;
                        }
                        else{
                            doneCalci =false;
                            screen.setText("");
                            screen.append("4");
                            noDigitPressed = false;
                        }}
                        else{
                            Toast.makeText(MainActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;





                    case R.id.n5:
                        if(screen.length()<23){
                        if(!doneCalci) {
                            screen.append("5");
                            noDigitPressed = false;
                        }
                        else{
                            doneCalci =false;
                            screen.setText("");
                            screen.append("5");
                            noDigitPressed = false;
                        }}
                        else{
                            Toast.makeText(MainActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;




                    case R.id.n6:
                        if(screen.length()<23){
                        if(!doneCalci) {
                            screen.append("6");
                            noDigitPressed = false;
                        }
                        else{
                            doneCalci =false;
                            screen.setText("");
                            screen.append("6");
                            noDigitPressed = false;
                        }}
                        else{
                            Toast.makeText(MainActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;





                    case R.id.n7:
                        if(screen.length()<23){
                        if(!doneCalci) {
                            screen.append("7");
                            noDigitPressed = false;
                        }
                        else{
                            doneCalci =false;
                            screen.setText("");
                            screen.append("7");
                            noDigitPressed = false;
                        }}
                        else{
                            Toast.makeText(MainActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;




                    case R.id.n8:
                        if(screen.length()<23){
                        if(!doneCalci) {
                            screen.append("8");
                            noDigitPressed = false;
                        }
                        else{
                            doneCalci =false;
                            screen.setText("");
                            screen.append("8");
                            noDigitPressed = false;
                        }}
                        else{
                            Toast.makeText(MainActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;



                    case R.id.n9:
                        if(screen.length()<23){
                        if(!doneCalci) {
                            screen.append("9");
                            noDigitPressed = false;
                        }
                        else{
                            doneCalci =false;
                            screen.setText("");
                            screen.append("9");
                            noDigitPressed = false;
                        }}
                        else{
                            Toast.makeText(MainActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;




                    case R.id.plus:
                        String screenContentplus = screen.getText().toString();
                        if(!noDigitPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex = screenContentplus.length() + 1;
                                firstNumber = Double.parseDouble(screenContentplus);
                                if (!doneCalci) {
                                    screen.append("+");
                                } else {
                                    doneCalci = false;
                                    screen.append("+");
                                }
                                dotPressed =false;
                                isSymbolpressed = true;
                                currentPressed = '+';
                            } else {
                                Toast.makeText(MainActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();
                        }
                        break;



                    case R.id.subtract:
                        String screenContentsubs =screen.getText().toString();
                        if(!noDigitPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex = screenContentsubs.length() + 1;
                                firstNumber = Double.parseDouble(screenContentsubs);
                                if (!doneCalci) {
                                    screen.append("-");
                                } else {
                                    doneCalci = false;
                                    screen.append("-");
                                }
                                dotPressed =false;
                                isSymbolpressed = true;
                                currentPressed = '-';
                            } else {
                                Toast.makeText(MainActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();
                        }
                        break;



                    case R.id.multiply:
                        String screenContentmulty =screen.getText().toString();
                        if(!noDigitPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex = screenContentmulty.length() + 1;
                                firstNumber = Double.parseDouble(screenContentmulty);
                                if (!doneCalci) {
                                    screen.append("×");
                                } else {
                                    doneCalci = false;
                                    screen.append("×");
                                }
                                dotPressed =false;
                                isSymbolpressed = true;
                                currentPressed = '×';
                            } else {
                                Toast.makeText(MainActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();
                        }
                        break;



                    case R.id.divide:
                        String screenContentdiv =screen.getText().toString();
                        if(!noDigitPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex = screenContentdiv.length() + 1;
                                firstNumber = Double.parseDouble(screenContentdiv);
                                if (!doneCalci) {
                                    screen.append("÷");
                                } else {
                                    doneCalci = false;
                                    screen.append("÷");
                                }
                                dotPressed =false;
                                isSymbolpressed = true;
                                currentPressed = '÷';
                            } else {
                                Toast.makeText(MainActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();
                        }
                        break;



                    case R.id.percent:
                        String screenContentpercent =screen.getText().toString();
                        if(!noDigitPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex = screenContentpercent.length() + 1;
                                firstNumber = Double.parseDouble(screenContentpercent);
                                if (!doneCalci) {
                                    screen.append("%");
                                } else {
                                    doneCalci = false;
                                    screen.append("%");
                                }
                                isSymbolpressed = true;
                                percentagePressed = true;
                                currentPressed = '%';
                            } else {
                                Toast.makeText(MainActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();
                        }
                        break;



                    case R.id.upon:
                        String screenContentupon =screen.getText().toString();
                        if(!noDigitPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex = screenContentupon.length() + 2;
                                firstNumber = Double.parseDouble(screenContentupon);
                                if (!doneCalci) {
                                    screen.append("⁻¹");
                                } else {
                                    doneCalci = false;
                                    screen.append("⁻¹");
                                }
                                isSymbolpressed = true;
                                percentagePressed = true;
                                currentPressed = '⁻';
                            } else {
                                Toast.makeText(MainActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();
                        }
                        break;



                    case R.id.equal:
                        if(isSymbolpressed) {
                            if(currentPressed == '+'){
                                screenContentplus = screen.getText().toString();

                                if(!(secondNumberIndex == screenContentplus.length())) {
                                    double secondNumber = Double.parseDouble(screenContentplus.substring(secondNumberIndex, screenContentplus.length()));
                                    secondNumber += firstNumber;
                                    screen.setText(String.valueOf(secondNumber));
                                    String toAdd = screenContentplus +" = "+ screen.getText().toString();
                                    String ID =databaseReference.push().getKey();
                                    databaseReference.child(user).child(ID).setValue(toAdd);
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
                                    screen.setText("");
                                    noDigitPressed =true;
                                    dotPressed=false;
                                }
                                isSymbolpressed = false;
                            }


                            if(currentPressed == '-'){
                                screenContentsubs = screen.getText().toString();
                                if(!(secondNumberIndex == screenContentsubs.length())) {
                                    double secondNumber = Double.parseDouble(screenContentsubs.substring(secondNumberIndex, screenContentsubs.length()));
                                    secondNumber = firstNumber - secondNumber;
                                    screen.setText(String.valueOf(secondNumber));
                                    String toAdd = screenContentsubs +" = "+ screen.getText().toString();
                                    String ID =databaseReference.push().getKey();
                                    databaseReference.child(user).child(ID).setValue(toAdd);
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
                                    screen.setText("");
                                    noDigitPressed =true;
                                    dotPressed=false;
                                }
                                isSymbolpressed = false;
                            }


                            if(currentPressed == '÷'){
                                screenContentdiv = screen.getText().toString();
                                if(!( secondNumberIndex == screenContentdiv.length())) {
                                    double secondNumber = Double.parseDouble(screenContentdiv.substring(secondNumberIndex, screenContentdiv.length()));
                                    secondNumber = firstNumber / secondNumber;
                                    screen.setText(String.valueOf(secondNumber));
                                    String toAdd = screenContentdiv + " = " + screen.getText().toString();
                                    String ID = databaseReference.push().getKey();
                                    databaseReference.child(user).child(ID).setValue(toAdd);
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
                                    screen.setText("");
                                    noDigitPressed =true;
                                    dotPressed=false;
                                }
                                isSymbolpressed = false;
                            }


                            if(currentPressed == '×'){
                                screenContentmulty = screen.getText().toString();
                                if(!(secondNumberIndex == screenContentmulty.length())) {
                                    double secondNumber = Double.parseDouble(screenContentmulty.substring(secondNumberIndex, screenContentmulty.length()));
                                    secondNumber = firstNumber * secondNumber;
                                    screen.setText(String.valueOf(secondNumber));
                                    String toAdd = screenContentmulty +" = "+ screen.getText().toString();
                                    String ID =databaseReference.push().getKey();
                                    databaseReference.child(user).child(ID).setValue(toAdd);

                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
                                    screen.setText("");
                                    noDigitPressed =true;
                                    dotPressed=false;
                                }
                                isSymbolpressed = false;
                            }


                            if(currentPressed == '%'){
                                screenContentpercent = screen.getText().toString();
                                if(secondNumberIndex == screenContentpercent.length()){
                                double secondNumber = firstNumber/(double)100;
                                screen.setText(String.valueOf(secondNumber));
                                String toAdd = screenContentpercent +" = "+ screen.getText().toString();
                                String ID =databaseReference.push().getKey();
                                databaseReference.child(user).child(ID).setValue(toAdd);
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
                                    screen.setText("");
                                    noDigitPressed =true;
                                    dotPressed=false;
                                }

                                isSymbolpressed = false;
                            }


                            if(currentPressed == '⁻'){
                                screenContentupon = screen.getText().toString();
                                if(secondNumberIndex == screenContentupon.length()) {
                                    double result = 1/firstNumber;
                                    screen.setText(String.valueOf(result));
                                    String toAdd =screenContentupon +" = "+ screen.getText().toString();
                                    String ID =databaseReference.push().getKey();
                                    databaseReference.child(user).child(ID).setValue(toAdd);

                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
                                    screen.setText("");
                                    noDigitPressed =true;
                                    dotPressed=false;
                                }
                                isSymbolpressed = false;
                            }

                            doneCalci =true;
                        }
                        break;

                    case R.id.delAll:
                        screen.setText("");
                        noDigitPressed= true;
                        isSymbolpressed =false;
                        dotPressed =false;
                        break;


                    case R.id.remove:
                        String digits =screen.getText().toString();
                        int length = digits.length();
                        if(length>0){
                            digits = digits.substring(0,length-1);
                        }
                        screen.setText(digits);
                        if(digits.length() ==0){
                            noDigitPressed =true;
                            isSymbolpressed =false;
                            dotPressed =false;
                        }
                        else {
                            if (digits.contains("/") || digits.contains("+") || digits.contains("-") || digits.contains("*") || digits.contains("%")
                                    || digits.contains("2^")) {

                                isSymbolpressed = true;
                                if (digits.contains(".")) { dotPressed = true; }
                                else{ dotPressed =false; }
                            }

                            else {

                                isSymbolpressed = false;
                                if (digits.contains(".")) { dotPressed = true; }
                                else{ dotPressed =false; }
                            }

                        }
                        break;




                }
            }
        };
        n0.setOnClickListener(listener);
        n1.setOnClickListener(listener);
        n2.setOnClickListener(listener);
        n3.setOnClickListener(listener);
        n4.setOnClickListener(listener);
        n5.setOnClickListener(listener);
        n6.setOnClickListener(listener);
        n6.setOnClickListener(listener);
        n7.setOnClickListener(listener);
        n8.setOnClickListener(listener);
        n9.setOnClickListener(listener);
        plus.setOnClickListener(listener);
        subtract.setOnClickListener(listener);
        divide.setOnClickListener(listener);
        multiply.setOnClickListener(listener);
        dot.setOnClickListener(listener);
        equal.setOnClickListener(listener);
        percent.setOnClickListener(listener);
        square.setOnClickListener(listener);
        remove.setOnClickListener(listener);
        delAll.setOnClickListener(listener);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,PreviousActivity.class);
                startActivity(intent);

            }
        });
        more_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MoreOptionsActivity.class));
                finish();
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                pd =new ProgressDialog(MainActivity.this);
                pd.show();
                pd.setContentView(R.layout.pd_logout);
                mAuth.signOut();
                googleSignInClient.signOut();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();
        }
        return true;
    }

}
