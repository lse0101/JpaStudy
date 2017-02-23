package jpabook.idclass;

import java.io.Serializable;

/**
 * Created by lse0101 on 2017-02-15.
 */
public class ChildId implements Serializable{
    private String parent;
    private String childId;

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChildId childId1 = (ChildId) o;

        if (parent != null ? !parent.equals(childId1.parent) : childId1.parent != null) return false;
        return childId != null ? childId.equals(childId1.childId) : childId1.childId == null;
    }

    @Override
    public int hashCode() {
        int result = parent != null ? parent.hashCode() : 0;
        result = 31 * result + (childId != null ? childId.hashCode() : 0);
        return result;
    }
}
