package com.adammcneilly.recyclerviewutils.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.adammcneilly.CoreRecyclerViewAdapter
import com.adammcneilly.CoreViewHolder

/**
 * Adapter for displaying Accounts.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
internal class AccountAdapter(accounts: MutableList<Account>) : CoreRecyclerViewAdapter<Account, AccountAdapter.AccountViewHolder>(accounts) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AccountViewHolder {
        val context = parent?.context
        val view = LayoutInflater.from(context)?.inflate(R.layout.list_item_account, parent, false)
        return AccountViewHolder(view)
    }

    class AccountViewHolder(view: View?) : CoreViewHolder<Account>(view) {
        private val tvName = view?.findViewById(R.id.account_name) as TextView
        private val tvBalance = view?.findViewById(R.id.account_balance) as TextView

        override fun bindItem(item: Account?) {
            this.tvName.text = item?.name
            this.tvBalance.text = item?.balance.toString()
        }

        override fun onClick(v: View) {
            Toast.makeText(v.context, "Clicked item: " + adapterPosition, Toast.LENGTH_SHORT).show()
        }
    }
}
