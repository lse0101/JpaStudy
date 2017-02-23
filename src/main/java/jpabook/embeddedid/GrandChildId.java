package jpabook.embeddedid;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by lse0101 on 2017-02-15.
 */
@Embeddable
public class GrandChildId implements Serializable{

    private ChildId childId;

    @Column(name = "GRANDCHILD_ID")
    private String grandChildId;

    public ChildId getChildId() {
        return childId;
    }

    public void setChildId(ChildId childId) {
        this.childId = childId;
    }

    public String getGrandChildId() {
        return grandChildId;
    }

    public void setGrandChildId(String grandChildId) {
        this.grandChildId = grandChildId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrandChildId that = (GrandChildId) o;

        if (childId != null ? !childId.equals(that.childId) : that.childId != null) return false;
        return grandChildId != null ? grandChildId.equals(that.grandChildId) : that.grandChildId == null;
    }

    @Override
    public int hashCode() {
        int result = childId != null ? childId.hashCode() : 0;
        result = 31 * result + (grandChildId != null ? grandChildId.hashCode() : 0);
        return result;
    }
}
