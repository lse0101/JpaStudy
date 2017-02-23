package jpabook.embeddedtype;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

/**
 * Created by lse0101 on 2017-02-17.
 */
public class TestMain {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");

    public static void main(String[] args) {
        testSave();
        emf.close();
    }

    private static void testSave() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Address address = new Address();
        ZipCode zipCode = new ZipCode();
        zipCode.setZip("Embedded zip");
        zipCode.setPlusFour("embedded zip four");

        address.setCity("city");
        address.setStreet("street");
        address.setZipcode(zipCode);

        Address companyAddress = new Address();
        ZipCode companyzipcode = new ZipCode();
        companyzipcode.setZip("company zip");
        companyzipcode.setPlusFour("company plus four");

        companyAddress.setCity("companyAddress");
        companyAddress.setStreet("companyStreet");
        companyAddress.setZipcode(companyzipcode);

        Peroid workPeroid = new Peroid();
        workPeroid.setStartDate(new Date());
        workPeroid.setEndDate(new Date());

        PhoneNumber phoneNumber = new PhoneNumber();
        PhoneServiceProvider phoneServiceProvider = new PhoneServiceProvider();
        phoneServiceProvider.setName("phone service provider ID");

        em.persist(phoneServiceProvider);

        phoneNumber.setAreaCode("areaCode1");
        phoneNumber.setLocalNumber("localNumber");
        phoneNumber.setProvider(phoneServiceProvider);

        Set<String> foods = new HashSet<>();
        foods.add("apple");
        foods.add("banana");

        List<Address> addressHistory = new ArrayList<>();
        Address adr1 = new Address();
        Address adr2 = new Address();
        Address adr3 = new Address();

        ZipCode zipCode1 = new ZipCode();
        ZipCode zipCode2 = new ZipCode();
        ZipCode zipCode3 = new ZipCode();

        zipCode1.setZip("zip1");
        zipCode1.setPlusFour("zip1");

        zipCode2.setZip("zip2");
        zipCode2.setPlusFour("zip2");

        zipCode3.setZip("zip3");
        zipCode3.setPlusFour("zip3");

        adr1.setZipcode(zipCode1);
        adr1.setStreet("street1");
        adr1.setCity("city1");

        adr2.setZipcode(zipCode2);
        adr2.setCity("city2");
        adr2.setStreet("street2");

        adr3.setZipcode(zipCode3);
        adr3.setStreet("street3");
        adr3.setCity("city3");

        addressHistory.add(adr1);
        addressHistory.add(adr2);
        addressHistory.add(adr3);

        Member member = new Member();
        member.setWorkPeroid(workPeroid);
        member.setHomeAddress(address);
        member.setPhoneNumber(phoneNumber);
        member.setCompanyAddress(companyAddress);

        member.setFavoriteFoods(foods);
        member.setAddressHistory(addressHistory);

        em.persist(member);

        tx.commit();
        em.close();
    }
}
