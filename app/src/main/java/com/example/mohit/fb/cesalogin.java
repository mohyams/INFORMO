package com.example.mohit.fb;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.darwindeveloper.horizontalscrollmenulibrary.custom_views.HorizontalScrollMenuView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class cesalogin extends AppCompatActivity {


    private static final int PICK_IMAGE_REQUEST = 1;

    private Button mButtonChooseImage;
    private Button mButtonUpload;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private EditText mEventName;
    private EditText mContent;
    private EditText mTime;
    private EditText mDate;
    private EditText mVenue;




    private Uri mImageUri;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mButtonChooseImage = findViewById(R.id.btnchoose);
        mButtonUpload = findViewById(R.id.btnupload);
        mImageView = findViewById(R.id.ivImage);
        mProgressBar = findViewById(R.id.pbProgress);
        mEventName = findViewById(R.id.etEvent);
        mContent = findViewById(R.id.etContent);
        mTime = findViewById(R.id.etTime);
        mDate = findViewById(R.id.etDate);
        mVenue = findViewById(R.id.etVenue);



        Toast.makeText(cesalogin.this,"WELCOME TO CESA UPDATION",Toast.LENGTH_LONG).show();



        mStorageRef = FirebaseStorage.getInstance().getReference("CESA");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("CESA");

        mButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUploadTask != null && mUploadTask.isInProgress()) {
                    Toast.makeText(cesalogin.this, "Upload in Progress", Toast.LENGTH_SHORT).show();
                } else {
                    uploadFile();
                }

            }
        });


    }

    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data !=null && data.getData()!=null)
        {
            mImageUri = data.getData();
            Picasso.with(this).load(mImageUri).into(mImageView);

        }
    }

    private String getFileExtension(Uri uri)
    {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile()
    {
        if(mEventName != null){
            StorageReference fileRefernce = mStorageRef.child(System.currentTimeMillis()
                    + "." +getFileExtension(mImageUri));

            mUploadTask = fileRefernce.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(0);
                                }
                            },2000);

                            Toast.makeText(cesalogin.this,"Uploaded Successfully",Toast.LENGTH_LONG).show();
                            Upload upload = new Upload(mEventName.getText().toString().trim(),
                                    mContent.getText().toString().trim(),
                                    mTime.getText().toString().trim(),
                                    mDate.getText().toString().trim(),
                                    mVenue.getText().toString().trim(),
                                    taskSnapshot.getDownloadUrl().toString());
                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadId).setValue(upload);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(cesalogin.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    })

                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                            double progress = (100.0  * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar.setProgress((int)progress);

                        }
                    });

        }
        else
        {
            Toast.makeText(this,"Event Name to be inserted ",Toast.LENGTH_SHORT).show();
        }
    }
}
