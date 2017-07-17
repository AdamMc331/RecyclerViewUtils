package com.adammcneilly.recyclerviewutils.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.Button

/**
 * Activity that adds an Account and returns it.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
class AddAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_account)

        val accountName = findViewById(R.id.account_name) as TextInputEditText
        val accountBalance = findViewById(R.id.account_balance) as TextInputEditText
        val submitButton = findViewById(R.id.submit)

        submitButton.setOnClickListener {
            // If we have values, get account, set data, finish.
            if (!accountName.text.toString().isEmpty() && !accountBalance.text.toString().isEmpty()) {

                val account = Account(
                        accountName.text.toString(),
                        accountBalance.text.toString().toDouble()
                )

                val data = Intent()
                data.putExtra(MainActivity.EXTRA_ACCOUNT, account)

                setResult(Activity.RESULT_OK, data)

                finish()
            }
        }
    }
}
