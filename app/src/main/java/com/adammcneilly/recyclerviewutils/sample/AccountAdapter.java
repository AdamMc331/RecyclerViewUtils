package com.adammcneilly.recyclerviewutils.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.adammcneilly.CoreRecyclerViewAdapter;
import com.adammcneilly.CoreViewHolder;

import java.util.List;

/**
 * Adapter for displaying Accounts.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
class AccountAdapter extends CoreRecyclerViewAdapter<Account, AccountAdapter.AccountViewHolder>{
    AccountAdapter(List<Account> accounts) {
        super(accounts);
    }

    @Override
    public AccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AccountViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_account, parent, false));
    }

    class AccountViewHolder extends CoreViewHolder<Account> {
        private TextView tvName;
        private TextView tvBalance;

        AccountViewHolder(View view) {
            super(view);

            this.tvName = (TextView) view.findViewById(R.id.account_name);
            this.tvBalance = (TextView) view.findViewById(R.id.account_balance);
        }

        @Override
        protected void bindItem(Account item) {
            this.tvName.setText(item.getName());
            this.tvBalance.setText(String.valueOf(item.getBalance()));
        }

        @Override
        public void onClick(View v) {
            // Toast
            Toast.makeText(v.getContext(), "Clicked item: " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}
