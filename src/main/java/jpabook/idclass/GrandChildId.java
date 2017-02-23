package jpabook.idclass;

import java.io.Serializable;

/**
 * Created by lse0101 on 2017-02-15.
 */
public class GrandChildId implements Serializable{
    private ChildId child;
    private String id;

    public ChildId getChild() {
        return child;
    }

    public void setChild(ChildId child) {
        this.child = child;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrandChildId that = (GrandChildId) o;

        if (child != null ? !child.equals(that.child) : that.child != null) return false;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        int result = child != null ? child.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
