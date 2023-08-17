package org.obs.utility;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class RandomData {
    public static Faker faker;

    public static String getFirstName() {
        faker = new Faker();
        String firstName = faker.name().firstName();
        return firstName;
    }

    public static String getLastName() {
        faker = new Faker();
        String lastName = faker.name().lastName();
        return lastName;
    }
    public static String getMobileNumber(){
        faker=new Faker();
      String mNumber=faker.phoneNumber().cellPhone();
      return mNumber;
    }
    public static String getStreetName(){
        faker=new Faker();
        String streetName=faker.address().streetName();
        return streetName;
    }
    public static String getCity(){
        faker=new Faker();
        String city=faker.address().country();
        return city;
    }
    public static String getState(){
        faker=new Faker();
        String state=faker.address().state();
        return state;
    }
    public static String getPinCode(){
        faker=new Faker();
        String PinCode=faker.address().zipCode();
        return PinCode;
    }


}

