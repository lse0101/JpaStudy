package jpabook.inheritancetablepermapping;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by lse0101 on 2017-02-15.
 */
@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
    private String director;
    private String actor;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
