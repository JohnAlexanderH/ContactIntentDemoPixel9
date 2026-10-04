package com.ebookfrenzy.contactintentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ebookfrenzy.contactintentdemo.databinding.ActivityMainBinding;
/**
 * ContactIntentDemo
 *
 * Author: John Henderson
 * Professor: Jeremiah Doody
 * Due Date: September 26, 2026
 *
 * This activity collects a contact's name, phone number, and email address.
 * The contact information is sent to ContactAddedActivity using an explicit
 * Intent.
 */
public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_PHONE = "phone";
    public static final String EXTRA_EMAIL = "email";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    /**
     * Retrieves the contact information entered by the user and sends it
     * to ContactAddedActivity using an explicit Intent.
     *
     * @param view the view that triggered the method
     */
    public void addContact(View view) {
        String name = binding.nameText.getText().toString();
        String phone = binding.phoneText.getText().toString();
        String email = binding.emailText.getText().toString();

        Intent intent = new Intent(this, ContactAddedActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_PHONE, phone);
        intent.putExtra(EXTRA_EMAIL, email);
        startActivity(intent);
    }
}