package jpabook.embeddedtype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lse0101 on 2017-02-17.
 */
@Entity
public class PhoneServiceProvider {

    @Id
    @Column(name = "service_id")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
