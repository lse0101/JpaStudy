package jpabook.listener;

import javax.persistence.*;

/**
 * Created by lse0101 on 2017-03-02.
 */
@Entity
public class Duck {

    @Id @GeneratedValue
    public Long id;

    private String name;

    @PrePersist
    public void prePersist(){
        System.out.println("Duck.prePersist id=" + id);
    }

    @PostPersist
    public void postPersist() {
        System.out.println("Duck.postPersist id="+id);
    }

    @PostLoad
    public void postLoad(){
        System.out.println("Duck.postLoad");
    }

    @PreRemove
    public void preRemove(){
        System.out.println("Duck.preRemove");
    }

    @PostRemove
    public void postRemove(){
        System.out.println("Duck.postRemove");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
