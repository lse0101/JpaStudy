package jpabook.mappedsuperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by lse0101 on 2017-02-15.
 */
@Entity
@AttributeOverrides({
        @AttributeOverride(name="id", column = @Column(name="member_id")),
        @AttributeOverride(name="name", column = @Column(name = "member_name"))
})
public class Member extends BaseEntity{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
