package com.adammcneilly.recyclerviewutils.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.adammcneilly.CoreDividerItemDecoration
import java.util.*

class MainActivity : AppCompatActivity() {
    private var accountAdapter: AccountAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get items
        val recyclerView = findViewById(R.id.account_recycler_view) as RecyclerView
        val floatingActionButton = findViewById(R.id.add_fab) as FloatingActionButton

        // Setup adapter
        accountAdapter = AccountAdapter(accounts)

        // Setup RecyclerView
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = accountAdapter
        recyclerView.addItemDecoration(CoreDividerItemDecoration(this, CoreDividerItemDecoration.VERTICAL_LIST))

        // Setup fab
        floatingActionButton.setOnClickListener { startAddAccountActivity() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == ADD_ACCOUNT && resultCode == Activity.RESULT_OK) {
            val account = data.getParcelableExtra<Account>(EXTRA_ACCOUNT)
            accountAdapter?.add(account)
        }
    }

    private fun startAddAccountActivity() {
        val addAccountIntent = Intent(this, AddAccountActivity::class.java)
        startActivityForResult(addAccountIntent, ADD_ACCOUNT)
    }

    private val accounts: MutableList<Account>
        get() {
            val accounts = ArrayList<Account>()

            accounts.add(Account("Checking", 100.0))
            accounts.add(Account("Savings", 10000.0))

            return accounts
        }

    companion object {
        private val ADD_ACCOUNT = 0
        val EXTRA_ACCOUNT = "accountExtra"
    }
}
