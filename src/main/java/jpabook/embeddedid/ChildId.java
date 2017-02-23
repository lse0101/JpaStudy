package jpabook.embeddedid;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by lse0101 on 2017-02-15.
 */
@Embeddable
public class ChildId implements Serializable{
    private String parentId;

    @Column(name = "CHILD_ID")
    private String id;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

        ChildId childId = (ChildId) o;

        if (parentId != null ? !parentId.equals(childId.parentId) : childId.parentId != null) return false;
        return id != null ? id.equals(childId.id) : childId.id == null;
    }

    @Override
    public int hashCode() {
        int result = parentId != null ? parentId.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
