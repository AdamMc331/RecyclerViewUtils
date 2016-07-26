RecyclerViewUtils Library
=============

This library contains a few core classes that are often used alongside a RecyclerView, and are intended to remove some of the tidious boilerplate code from being written many times.

Usage
-----

To have access to the library, add the dependency to your build.gradle:

```java
	compile 'com.adammcneilly:recyclerviewutils:1.0.0'
```

At the time of publication, the library has not yet been linked to JCenter, so you will also have to add the link to my Maven repository as well:

```java
	repositories {
    	maven {
        	url  "http://dl.bintray.com/adammc331/maven"
    	}
	}
```

CoreViewHolder
--------------

At the heart of these classes is [CoreViewHolder](https://github.com/AdamMc331/RecyclerViewUtils/blob/master/lib/src/main/java/com/adammcneilly/recyclerviewutils/CoreViewHolder.java) which is a RecyclerView.ViewHolder class used to display an object of a specific type. It has one abstract method for binding an object of that type.

CoreRecyclerViewAdapter
-----------------------

Using the CoreViewHolder class from above, the [CoreRecyclerViewAdapter](https://github.com/AdamMc331/RecyclerViewUtils/blob/master/lib/src/main/java/com/adammcneilly/recyclerviewutils/CoreRecyclerViewAdapter.java) is an abstract base class for using an adapter of objects with a given type. By using a generic type, we were able to override many boilerplate methods such as:

 * add
 * remove
 * swapItems
 * onBindViewHolder

CoreDividerItemDecoration
-------------------------

The [CoreDividerItemDecoration](https://github.com/AdamMc331/RecyclerViewUtils/blob/master/lib/src/main/java/com/adammcneilly/recyclerviewutils/CoreDividerItemDecoration.java) class is used to display a simple line divider between list items in your RecyclerView.

Credits & Contact
-----------------

This library was created by [Adam McNeilly](http://adammcneilly.com).

License
-------

The RecyclerViewUtils library is available under the [MIT License](https://opensource.org/licenses/MIT). You are free to modify and enhance it in any way. If you submit a pull request, please add your name into the credits section! :)