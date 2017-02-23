package jpabook.inheritancesingletablemapping;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by lse0101 on 2017-02-15.
 */
@Entity
@DiscriminatorValue("A")
public class Album extends Item{
    private String albumName;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
