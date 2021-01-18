package com.example.mohit.fb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class elesadisplay extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    private elesaAdapter mAdapter;

    private DatabaseReference mDatabaseRef;
    private List<Upload> mUploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elesadisplay);

        mRecyclerview = findViewById(R.id.recycler_view);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        mUploads = new ArrayList<>();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("ELESA");

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Upload upload = postSnapshot.getValue(Upload.class);
                    mUploads.add(upload);
                }

                mAdapter = new elesaAdapter(elesadisplay.this,mUploads);

                mRecyclerview.setAdapter(mAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(elesadisplay.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
