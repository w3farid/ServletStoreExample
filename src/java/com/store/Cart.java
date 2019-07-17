package com.store;

import com.exceptions.BookNotFoundException;
import java.util.HashMap;
import java.util.Iterator;

public class Cart {

    private HashMap map = new HashMap();

    public Iterator getItems() {
        return map.values().iterator();
    }

    public void addItem(Book book) throws BookNotFoundException {
        Integer id = new Integer(book.getId());
        if (this.map.containsKey(id)) {
            throw new BookNotFoundException("Book exist. "+book);
        }

        this.map.put(id, book);
    }

}
