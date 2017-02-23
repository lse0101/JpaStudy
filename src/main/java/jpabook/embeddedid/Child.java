package jpabook.embeddedid;

import javax.persistence.*;

/**
 * Created by lse0101 on 2017-02-15.
 */
@Entity
public class Child {

    @EmbeddedId
    private ChildId id;
    private String name;

    @MapsId("parentId")
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;

    public ChildId getId() {
        return id;
    }

    public void setId(ChildId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
