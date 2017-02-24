package jpabook.jpashop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by lse0101 on 2017-02-24.
 */
@Entity
@DiscriminatorValue("B")
public class Book extends Item {
    private String author;
    private String isdb;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsdb() {
        return isdb;
    }

    public void setIsdb(String isdb) {
        this.isdb = isdb;
    }
}
