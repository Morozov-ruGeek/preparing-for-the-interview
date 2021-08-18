package lesson1.builder;

public interface PersonBuilder {
    public PersonBuilder setFirstName(String firstName);

    public PersonBuilder setMiddleName(String middleName);

    public PersonBuilder setLastName(String lastName);

    public PersonBuilder setCountry(String country);

    public PersonBuilder setAddress(String address);

    public PersonBuilder setPhone(String phone);

    public PersonBuilder setAge(int age);

    public PersonBuilder setGender(String gender);

    public Person build();
}
