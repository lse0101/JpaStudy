package jpabook.listener;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 * Created by lse0101 on 2017-03-02.
 */
public class DuckListener {
    @PrePersist
    public void prePersist(Object obj) {
        System.out.println("prePersist"+obj.toString());
    }

    @PostPersist
    public void postPersist(Object object) {
        System.out.println("postPersist"+object.toString());
    }
}
