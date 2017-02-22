package jpabook.embeddedtype;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Member.class)
public abstract class Member_ {

	public static volatile SingularAttribute<Member, PhoneNumber> phoneNumber;
	public static volatile SingularAttribute<Member, Peroid> workPeroid;
	public static volatile SingularAttribute<Member, Address> companyAddress;
	public static volatile SingularAttribute<Member, String> name;
	public static volatile SingularAttribute<Member, Long> id;
	public static volatile ListAttribute<Member, Address> addressHistory;
	public static volatile SingularAttribute<Member, Address> homeAddress;
	public static volatile SetAttribute<Member, String> favoriteFoods;

}

