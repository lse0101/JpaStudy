package jpabook.inheritancejoinmapping;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Movie.class)
public abstract class Movie_ extends jpabook.inheritancejoinmapping.Item_ {

	public static volatile SingularAttribute<Movie, String> actor;
	public static volatile SingularAttribute<Movie, String> director;

}

