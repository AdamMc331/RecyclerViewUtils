package com.adammcneilly.recyclerviewutils.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adammcneilly.recyclerviewutils.CoreRecyclerViewAdapter;
import com.adammcneilly.recyclerviewutils.CoreViewHolder;

import java.util.List;

/**
 * Adapter for displaying Accounts.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
public class AccountAdapter extends CoreRecyclerViewAdapter<Account, AccountAdapter.AccountViewHolder>{
    public AccountAdapter(Context context, List<Account> accounts) {
        super(context, accounts);
    }

    @Override
    public AccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AccountViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_account, parent, false));
    }

    public class AccountViewHolder extends CoreViewHolder<Account> {
        private TextView tvName;
        private TextView tvBalance;

        public AccountViewHolder(View view) {
            super(view);

            this.tvName = (TextView) view.findViewById(R.id.account_name);
            this.tvBalance = (TextView) view.findViewById(R.id.account_balance);
        }

        @Override
        protected void bindItem(Account item) {
            this.tvName.setText(item.getName());
            this.tvBalance.setText(String.valueOf(item.getBalance()));
        }
    }
}
