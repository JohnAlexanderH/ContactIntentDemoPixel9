package com.ebookfrenzy.contactintentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ebookfrenzy.contactintentdemo.databinding.ActivityContactAddedBinding;
/**
 * ContactIntentDemo
 *
 * Author: John Henderson
 * Professor: Jeremiah Doody
 * Due Date: September 26, 2026
 *
 * This activity receives contact information from MainActivity using an
 * explicit Intent and displays the submitted contact information. Any
 * empty fields are replaced with "N/A".
 */
public class ContactAddedActivity extends AppCompatActivity {

    private ActivityContactAddedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactAddedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // TODO done with helper method
        Intent intent = getIntent();
        String name = checkEmpty(intent.getStringExtra(MainActivity.EXTRA_NAME)); // helper called on each
        String phone = checkEmpty(intent.getStringExtra(MainActivity.EXTRA_PHONE));
        String email = checkEmpty(intent.getStringExtra(MainActivity.EXTRA_EMAIL));



        binding.resultText.setText("Contact Added!\n" + name + "\n" + phone + "\n" + email);
    }
    /**
     * Checks whether a contact field is empty.
     *
     * If the field is empty or null, the no_input_string resource
     * is returned. Otherwise, the original input is returned.
     *
     * @param input the contact information to check
     * @return the original input or "N/A" if no value was provided
     */
    private String checkEmpty(String input){
        if (input == null || input.isEmpty())
            input = getString(R.string.no_input_string);
        return input;

    }
}