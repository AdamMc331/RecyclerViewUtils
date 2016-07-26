package com.adammcneilly.recyclerviewutils.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Activity that adds an Account and returns it.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
public class AddAccountActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        final TextInputEditText accountName = (TextInputEditText) findViewById(R.id.account_name);
        final TextInputEditText accountBalance = (TextInputEditText) findViewById(R.id.account_balance);

        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If we have values, get account, set data, finish.
                if(!accountName.getText().toString().isEmpty() && !accountBalance.getText().toString().isEmpty()) {
                    Account account = new Account(
                            accountName.getText().toString(),
                            Double.parseDouble(accountBalance.getText().toString())
                    );

                    Intent data = new Intent();
                    data.putExtra(MainActivity.EXTRA_ACCOUNT, account);

                    setResult(RESULT_OK, data);

                    finish();
                }
            }
        });
    }
}
