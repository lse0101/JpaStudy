package jpabook.jointable;

import javax.persistence.*;

/**
 * Created by lse0101 on 2017-02-15.
 */
@Entity
public class Parent {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    @OneToOne
    @JoinTable(name="PARENT_CHILD",
                joinColumns = @JoinColumn(name = "PARENT_ID"),
                inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
    private Child child;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
