package com.baina.sample.contentprovider.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Book {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "CATEGORY")
    private String category;
    @Property(nameInDb = "BOOKNAME")
    private String bookName;
    @Generated(hash = 372600030)
    public Book(Long id, String category, String bookName) {
        this.id = id;
        this.category = category;
        this.bookName = bookName;
    }
    @Generated(hash = 1839243756)
    public Book() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getBookName() {
        return this.bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}  