package jpabook.associcate;

import javax.persistence.*;

/**
 * Created by lse0101 on 2017-02-13.
 */
@Entity
@NamedEntityGraph(name="Member.withTeam", attributeNodes = {@NamedAttributeNode("team")})
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    private Integer age;

    @ManyToOne()
    @JoinColumn(name = "TEAM_ID", nullable = false)
    private Team team;

    public Member(String id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        if (this.team != null) {
            this.team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", team=" + team +
                '}';
    }
}
