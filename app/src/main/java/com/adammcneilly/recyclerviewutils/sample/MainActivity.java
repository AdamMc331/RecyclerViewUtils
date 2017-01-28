package com.adammcneilly.recyclerviewutils.sample;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.adammcneilly.CoreDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AccountAdapter accountAdapter;

    private static final int ADD_ACCOUNT = 0;
    public static final String EXTRA_ACCOUNT = "accountExtra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get items
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.account_recycler_view);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.add_fab);

        // Setup adapter
        accountAdapter = new AccountAdapter(getAccounts());

        // Setup RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(accountAdapter);
        recyclerView.addItemDecoration(new CoreDividerItemDecoration(this, CoreDividerItemDecoration.VERTICAL_LIST));

        // Setup fab
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAddAccountActivity();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADD_ACCOUNT && resultCode == RESULT_OK) {
            Account account = data.getParcelableExtra(EXTRA_ACCOUNT);
            accountAdapter.add(account);
        }
    }

    private void startAddAccountActivity() {
        Intent addAccountIntent = new Intent(this, AddAccountActivity.class);
        startActivityForResult(addAccountIntent, ADD_ACCOUNT);
    }

    private List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("Checking", 100));
        accounts.add(new Account("Savings", 10000));

        return accounts;
    }
}
