package jpabook.embeddedtype;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PhoneNumber.class)
public abstract class PhoneNumber_ {

	public static volatile SingularAttribute<PhoneNumber, String> areaCode;
	public static volatile SingularAttribute<PhoneNumber, PhoneServiceProvider> provider;
	public static volatile SingularAttribute<PhoneNumber, String> localNumber;

}

