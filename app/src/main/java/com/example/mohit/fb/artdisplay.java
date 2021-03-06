package com.example.mohit.fb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class artdisplay extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private artAdapter madapter;

    private DatabaseReference mDatabaseRef;
    Upload info;
    private ArrayList<Upload> muploads;
    ArrayAdapter<Upload> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artdisplay);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        muploads = new ArrayList<>();
        adapter = new ArrayAdapter<Upload>(this,R.layout.artdisp,R.id.tvevent);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("ARTCIRCLE");

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload upload = postSnapshot.getValue(Upload.class);
                    //String content = postSnapshot.child("content").getValue().toString();
                    muploads.add(upload);

                }

                madapter = new artAdapter(artdisplay.this,muploads);

                mRecyclerView.setAdapter(madapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(artdisplay.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });
    }
}
