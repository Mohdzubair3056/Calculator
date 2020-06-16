package com.example.mycalculator;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PreviousActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    private ProgressDialog pd;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private GoogleSignInClient googleSignInClient;
    private List<String> dataList;
    private ArrayAdapter<String > arrayAdapter;
    private String user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous);

        mAuth =FirebaseAuth.getInstance();
        ListView history =findViewById(R.id.history);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Previous calculations");
        dataList= new ArrayList<>();
        arrayAdapter =new ArrayAdapter<>(this,R.layout.layout,dataList);
        user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        history.setAdapter(arrayAdapter);

        GoogleSignInOptions gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();

        googleSignInClient = GoogleSignIn.getClient(this,gso);

        databaseReference.child(user).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String DATA = (String) dataSnapshot.getValue();
                    dataList.add(0,DATA);
                    arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                pd =new ProgressDialog(PreviousActivity.this);
                pd.show();
                pd.setContentView(R.layout.pd_logout);
                googleSignInClient.signOut();
                mAuth.signOut();
                startActivity(new Intent(PreviousActivity.this,LoginActivity.class));
                finish();

            case R.id.history_deleted:
                databaseReference.child(user).removeValue();

                if(!dataList.isEmpty()) {
                    dataList.removeAll(dataList);
                    arrayAdapter.notifyDataSetChanged();
                    Toast.makeText(this, "History Deleted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "Nothing to delete", Toast.LENGTH_SHORT).show();
                }
        }
        return true;
    }
}
