package jpabook.associcate1;

import javax.persistence.*;

/**
 * Created by lse0101 on 2017-02-13.
 */
@Entity
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    @Column(name = "TEAM_ID")
    private String team_id;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    public Member(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public Member() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }
}
