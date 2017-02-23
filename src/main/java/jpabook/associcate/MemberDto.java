package jpabook.associcate;

/**
 * Created by lse0101 on 2017-02-20.
 */
public class MemberDto {
    private String name;
    private Integer age;

    public MemberDto() {
    }

    public MemberDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
