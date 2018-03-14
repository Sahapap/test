package com.example.sandman.prople;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by SandMan on 3/14/2018.
 */

public class CreateUser extends AppCompatActivity {

    EditText firstname, lastname;
    Button button;
    private static final String TAG = "CreateUser";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        firstname = findViewById(R.id.first_name);
        lastname = findViewById(R.id.last_name);
        button = findViewById(R.id.button);
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production").allowMainThreadQueries().build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // to do save data to database
                Log.d(TAG, "onClick: firstname: " + firstname.getText().toString());
                User user = new User(firstname.getText().toString(), lastname.getText().toString());
                //db.userDao().insertAll(new User("Sahapap", "panya"));
                db.userDao().insertAll(user);
                startActivity(new Intent(CreateUser.this, MainActivity.class));
            }
        });
    }
}
