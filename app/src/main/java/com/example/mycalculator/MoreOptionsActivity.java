package com.example.mycalculator;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static java.lang.Math.log;
import static java.lang.Math.log10;

public class MoreOptionsActivity extends AppCompatActivity {

    public static final String MSG =  "history";

    private boolean isSymbolpressed =false;

    private  double firstNumber =0;

    private  int secondNumberIndex =0;

    private  char currentPressed;

    private  boolean doneCalci = false;

    private  boolean noDigitPressed = true;

    private boolean dotPressed =false;

    private boolean factorialPressed =false;

    private boolean noEntryPressed =true;

    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private String user;

    private ArrayList<String> historyMsg =new ArrayList<>();

    private FirebaseAuth mAuth;

    private ProgressDialog pd;

    private GoogleSignInClient googleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_options);

        mAuth =FirebaseAuth.getInstance();

        final ImageButton back_main_activity =findViewById(R.id.back_main_activity);
        final ImageButton history =findViewById(R.id.history);
        final Button cube =findViewById(R.id.cube);
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
        final Button sqr_root =findViewById(R.id.sqr_root);
        final Button equal =findViewById(R.id.equal);
        final Button factorial =findViewById(R.id.sqr);
        final Button ln =findViewById(R.id.ln);
        final Button log =findViewById(R.id.log);
        final Button dot =findViewById(R.id.dot);
        final Button pi =findViewById(R.id.cube_root);
        final Button delAll =findViewById(R.id.delAll);
        final Button remove =findViewById(R.id.remove);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference("Previous calculations");
        user = FirebaseAuth.getInstance().getCurrentUser().getUid();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();

        googleSignInClient = GoogleSignIn.getClient(this,gso);


        final TextView screen =findViewById(R.id.screen);

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
                                noEntryPressed =false;
                            }


                            else{
                                doneCalci =false;
                                screen.setText("");
                                screen.append("0");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }}
                        else{
                            Toast.makeText(MoreOptionsActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;




                    case R.id.dot:
                        if(!dotPressed){
                            if(!doneCalci) {
                                screen.append(".");
                                noDigitPressed = false;
                                dotPressed =true;
                                noEntryPressed =false;
                            }
                            else{
                                doneCalci =false;
                                screen.setText("");
                                screen.append(".");
                                noDigitPressed = false;
                                dotPressed =true;
                                noEntryPressed =false;
                            }}

                        break;





                    case R.id.n1:
                        if(screen.length() <23) {
                            if (!doneCalci) {
                                screen.append("1");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            } else {
                                doneCalci = false;
                                screen.setText("");
                                screen.append("1");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }
                        }
                        else{
                            Toast.makeText(MoreOptionsActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;






                    case R.id.n2:
                        if(screen.length() <23){
                            if(!doneCalci) {
                                screen.append("2");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }
                            else{
                                doneCalci =false;
                                screen.setText("");
                                screen.append("2");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }}
                        else{
                            Toast.makeText(MoreOptionsActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;




                    case R.id.n3:
                        if(screen.length()<23){
                            if(!doneCalci) {
                                screen.append("3");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }
                            else{
                                doneCalci =false;
                                screen.setText("");
                                screen.append("3");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }}
                        else{
                            Toast.makeText(MoreOptionsActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;





                    case R.id.n4:
                        if(screen.length()<23){
                            if(!doneCalci) {
                                screen.append("4");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }
                            else{
                                doneCalci =false;
                                screen.setText("");
                                screen.append("4");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }}
                        else{
                            Toast.makeText(MoreOptionsActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;





                    case R.id.n5:
                        if(screen.length()<23){
                            if(!doneCalci) {
                                screen.append("5");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }
                            else{
                                doneCalci =false;
                                screen.setText("");
                                screen.append("5");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }}
                        else{
                            Toast.makeText(MoreOptionsActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;




                    case R.id.n6:
                        if(screen.length()<23){
                            if(!doneCalci) {
                                screen.append("6");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }
                            else{
                                doneCalci =false;
                                screen.setText("");
                                screen.append("6");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }}
                        else{
                            Toast.makeText(MoreOptionsActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;





                    case R.id.n7:
                        if(screen.length()<23){
                            if(!doneCalci) {
                                screen.append("7");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }
                            else{
                                doneCalci =false;
                                screen.setText("");
                                screen.append("7");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }}
                        else{
                            Toast.makeText(MoreOptionsActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;




                    case R.id.n8:
                        if(screen.length()<23){
                            if(!doneCalci) {
                                screen.append("8");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }
                            else{
                                doneCalci =false;
                                screen.setText("");
                                screen.append("8");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }}
                        else{
                            Toast.makeText(MoreOptionsActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;



                    case R.id.n9:
                        if(screen.length()<23){
                            if(!doneCalci) {
                                screen.append("9");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }
                            else{
                                doneCalci =false;
                                screen.setText("");
                                screen.append("9");
                                noDigitPressed = false;
                                noEntryPressed =false;
                            }}
                        else{
                            Toast.makeText(MoreOptionsActivity.this, "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
                        }
                        break;




                    case R.id.log:
                        String screenContentlog;
                        if(noEntryPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex =4;
                                if (!doneCalci) {
                                    screen.append("log(");
                                } else {
                                    doneCalci = false;
                                    screen.setText("");
                                    screen.append("log(");
                                }
                                dotPressed =false;
                                isSymbolpressed = true;
                                currentPressed = '1';
                            } else {
                                Toast.makeText(MoreOptionsActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            if (isSymbolpressed) {
                                Toast.makeText(MoreOptionsActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MoreOptionsActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        break;



                    case R.id.ln:
                        String screenContentln ;
                        if(noEntryPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex = 3;
                                if (!doneCalci) {
                                    screen.append("ln(");
                                } else {
                                    doneCalci = false;
                                    screen.setText("");
                                    screen.append("ln(");
                                }
                                dotPressed =false;
                                isSymbolpressed = true;
                                currentPressed = 'e';
                            } else {
                                Toast.makeText(MoreOptionsActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            if (isSymbolpressed) {
                                Toast.makeText(MoreOptionsActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MoreOptionsActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        break;



                    case R.id.sqr_root:
                        String screenContentsqr_root =screen.getText().toString();
                        if(noEntryPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex = screenContentsqr_root.length() + 2;
                                if(!doneCalci) {
                                    screen.append("√");
                                }
                                if (doneCalci) {
                                    doneCalci = false;
                                    screen.setText("");
                                    screen.append("√");

                                    dotPressed =false;
                                    isSymbolpressed = true;
                                    currentPressed = '√';
                                }

                                dotPressed =false;
                                isSymbolpressed = true;
                                currentPressed = '√';
                            } else {
                                Toast.makeText(MoreOptionsActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {

                                Toast.makeText(MoreOptionsActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();

                        }
                        break;



                    case R.id.sqr:
                        String screenContentsqr =screen.getText().toString();
                        if(!noDigitPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex = screenContentsqr.length()+1;
                                firstNumber = Double.parseDouble(screenContentsqr);
                                if (!doneCalci) {
                                    screen.append("²");
                                } else {
                                    doneCalci = false;
                                    screen.append("²");
                                }
                                isSymbolpressed = true;
                                currentPressed = '²';
                            } else {
                                Toast.makeText(MoreOptionsActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{

                            Toast.makeText(MoreOptionsActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();
                        }
                        break;



                    case R.id.cube_root:
                        String screenContentcube_root =screen.getText().toString();
                        if(noEntryPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex = screenContentcube_root.length() + 2;
                                if (!doneCalci) {
                                    screen.append("∛");
                                } else {
                                    doneCalci = false;
                                    screen.setText("");
                                    screen.append("∛");
                                }
                                dotPressed =false;
                                isSymbolpressed = true;
                                currentPressed = '∛';
                            } else {
                                Toast.makeText(MoreOptionsActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {

                                Toast.makeText(MoreOptionsActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();

                        }
                        break;



                    case R.id.cube:
                        String screenContentcube =screen.getText().toString();
                        if(!noDigitPressed) {
                            if (!isSymbolpressed) {
                                secondNumberIndex = screenContentcube.length() +1;
                                firstNumber = Double.parseDouble(screenContentcube);
                                if (!doneCalci) {
                                    screen.append("³");
                                } else {
                                    doneCalci = false;
                                    screen.append("³");
                                }
                                isSymbolpressed = true;
                                currentPressed = '³';
                            } else {
                                Toast.makeText(MoreOptionsActivity.this, "Sorry! This calculator is limited to one calculation at a time", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MoreOptionsActivity.this, "Invalid Entry Pressed", Toast.LENGTH_SHORT).show();
                        }
                        break;



                    case R.id.equal:


                            if(currentPressed == '1'){
                                screenContentlog = screen.getText().toString();

                                    if(secondNumberIndex == 4) {
                                        double secondNumber = Double.parseDouble(screenContentlog.substring(secondNumberIndex, screenContentlog.length()));
                                        secondNumber = Math.log10(secondNumber);
                                        screen.setText(String.valueOf(secondNumber));
                                        String toAdd =screenContentlog + " = " + screen.getText().toString();
                                        String ID =databaseReference.push().getKey();
                                        databaseReference.child(user).child(ID).setValue(toAdd);
                                    }

                                else{
                                    Toast.makeText(MoreOptionsActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
                                    screen.setText("");
                                    noDigitPressed =true;
                                    dotPressed=false;
                                }

                                noDigitPressed=false;
                                noEntryPressed =true;
                                isSymbolpressed = false;
                                dotPressed=false;
                            }


                            if(currentPressed == 'e'){
                                screenContentln = screen.getText().toString();
                                    if(secondNumberIndex == 3) {
                                        double secondNumber = Double.parseDouble(screenContentln.substring(secondNumberIndex, screenContentln.length()));
                                        secondNumber = 2.30258509299 * Math.log10(secondNumber);
                                        screen.setText(String.valueOf(secondNumber));
                                        String toAdd = screenContentln + " = " + screen.getText().toString();
                                        String ID =databaseReference.push().getKey();
                                        databaseReference.child(user).child(ID).setValue(toAdd);
                                    }

                                else{
                                    Toast.makeText(MoreOptionsActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
                                    screen.setText("");
                                    noDigitPressed =true;
                                    dotPressed=false;
                                }
                                noDigitPressed=false;
                                doneCalci=true;
                                noEntryPressed =true;
                                isSymbolpressed = false;
                            }


                            if(currentPressed == '²'){
                                screenContentsqr = screen.getText().toString();
                                if(secondNumberIndex == screenContentsqr.length()) {
                                    double result = firstNumber*firstNumber;
                                    screen.setText(String.valueOf(result));
                                    String  toAdd = screenContentsqr +" = "+ screen.getText().toString();
                                    String ID =databaseReference.push().getKey();
                                    databaseReference.child(user).child(ID).setValue(toAdd);
                                }
                                else{
                                    Toast.makeText(MoreOptionsActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
                                    screen.setText("");
                                    noDigitPressed =true;
                                    dotPressed=false;
                                }
                                noEntryPressed =true;
                                isSymbolpressed = false;
                            }



                            if(currentPressed == '√'){
                                screenContentsqr_root = screen.getText().toString();

                                    double secondNumber = Double.parseDouble(screenContentsqr_root.substring(1, screenContentsqr_root.length()));
                                    secondNumber = Math.sqrt(secondNumber);
                                    screen.setText(String.valueOf(secondNumber));
                                    String  toAdd = screenContentsqr_root +" = "+ screen.getText().toString();
                                    String ID =databaseReference.push().getKey();
                                    databaseReference.child(user).child(ID).setValue(toAdd);

//                                else{
//                                    Toast.makeText(MoreOptionsActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
//                                    screen.setText("");
//                                    noDigitPressed =true;
//                                    dotPressed=false;
//                                }
                                noEntryPressed =true;
                                isSymbolpressed = false;
                            }


                            if(currentPressed == '∛'){
                                screenContentcube_root = screen.getText().toString();

                                    double secondNumber = Double.parseDouble(screenContentcube_root.substring(1, screenContentcube_root.length()));
                                    secondNumber =Math.cbrt(secondNumber);
                                    screen.setText(String.valueOf(secondNumber));
                                    String  toAdd = screenContentcube_root +" = "+ screen.getText().toString();
                                    String ID =databaseReference.push().getKey();
                                    databaseReference.child(user).child(ID).setValue(toAdd);

//                                else{
//                                    Toast.makeText(MoreOptionsActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
//                                    screen.setText("");
//                                    noDigitPressed =true;
//                                    dotPressed=false;
//                                }
                                noEntryPressed =true;
                                isSymbolpressed = false;
                            }


                            if(currentPressed == '³'){
                                screenContentcube = screen.getText().toString();
                                if(secondNumberIndex == screenContentcube.length()) {
                                    double result = firstNumber*firstNumber*firstNumber;
                                    screen.setText(String.valueOf(result));
                                    String  toAdd = screenContentcube +" = "+ screen.getText().toString();
                                    String ID =databaseReference.push().getKey();
                                    databaseReference.child(user).child(ID).setValue(toAdd);
                                }
                                else{
                                    Toast.makeText(MoreOptionsActivity.this, "Invalid calculation type Error!!!", Toast.LENGTH_SHORT).show();
                                    screen.setText("");
                                    noDigitPressed =true;
                                    dotPressed=false;
                                }
                                noEntryPressed =true;
                                isSymbolpressed = false;
                            }

                            doneCalci =true;

                        break;

                    case R.id.delAll:
                        screen.setText("");
                        noDigitPressed= true;
                        isSymbolpressed =false;
                        noEntryPressed =true;
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
                            noEntryPressed= true;
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
        log.setOnClickListener(listener);
        ln.setOnClickListener(listener);
        pi.setOnClickListener(listener);
        cube.setOnClickListener(listener);
        dot.setOnClickListener(listener);
        equal.setOnClickListener(listener);
        factorial.setOnClickListener(listener);
        sqr_root.setOnClickListener(listener);
        remove.setOnClickListener(listener);
        delAll.setOnClickListener(listener);


        back_main_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MoreOptionsActivity.this,MainActivity.class));
                finish();
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MoreOptionsActivity.this,PreviousActivity.class);
                startActivity(intent);

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
                pd =new ProgressDialog(MoreOptionsActivity.this);
                pd.show();
                pd.setContentView(R.layout.pd_logout);
                mAuth.signOut();
                googleSignInClient.signOut();
                startActivity(new Intent(MoreOptionsActivity.this,LoginActivity.class));
                finish();
        }
        return true;
    }
}
