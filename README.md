[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RecyclerViewUtils-green.svg?style=true)](https://android-arsenal.com/details/1/3979)

RecyclerViewUtils Library
=============

This library contains a few core classes that are often used alongside a RecyclerView, and are intended to remove some of the tedious boilerplate code from being written many times.

Usage
-----

To have access to the library, add the dependency to your build.gradle:

```java
	compile 'com.adammcneilly:recyclerviewutils:1.0.3'
```


CoreViewHolder
--------------

At the heart of these classes is [CoreViewHolder](https://github.com/AdamMc331/RecyclerViewUtils/blob/master/lib/src/main/java/com/adammcneilly/recyclerviewutils/CoreViewHolder.java) which is a RecyclerView.ViewHolder class used to display an object of a specific type. It has one abstract method for binding an object of that type.

Below is a sample of a CoreViewHolder for Account objects:

```java
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
```

This class also implements the `View.OnClickListener` interface. If you want to handle clicks in your ReyclerView, just ovveride the `onClick()` method in your ViewHolder class.

CoreRecyclerViewAdapter
-----------------------

Using the CoreViewHolder class from above, the [CoreRecyclerViewAdapter](https://github.com/AdamMc331/RecyclerViewUtils/blob/master/lib/src/main/java/com/adammcneilly/recyclerviewutils/CoreRecyclerViewAdapter.java) is an abstract base class for using an adapter of objects with a given type. By using a generic type, we were able to override many boilerplate methods such as:

 * add
 * remove
 * swapItems
 * onBindViewHolder

Thanks to this handy utils class, it cuts down on a ton of boilerplate code inside your adapter, and makes it very simple:

```java
public class AccountAdapter extends CoreRecyclerViewAdapter<Account, AccountAdapter.AccountViewHolder>{
    public AccountAdapter(Context context, List<Account> accounts) {
        super(context, accounts);
    }

    @Override
    public AccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AccountViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_account, parent, false));
    }

    public class AccountViewHolder extends CoreViewHolder<Account> {
        ...
    }
}
```

CoreDividerItemDecoration
-------------------------

The [CoreDividerItemDecoration](https://github.com/AdamMc331/RecyclerViewUtils/blob/master/lib/src/main/java/com/adammcneilly/recyclerviewutils/CoreDividerItemDecoration.java) class is used to display a simple line divider between list items in your RecyclerView.

Credits & Contact
-----------------

This library was created by [Adam McNeilly](http://adammcneilly.com).

And reviewed by [Maurício Pessoa](https://github.com/Mauker1).

Version History
---------------

####1.0.2
 - Added a default constructor and removed adapter's dependency on a Context.
 - Added the List interface to the adapter to allow easier addition/removal of items.

####1.0.1
 - Added View.OnClickListener interface to the CoreViewHolder.
 - Code cleanup and removed deprecated methods.

####1.0.0
 - Initial release.

License
-------

The RecyclerViewUtils library is available under the [MIT License](https://opensource.org/licenses/MIT). You are free to modify and enhance it in any way. If you submit a pull request, please add your name into the credits section! :)
