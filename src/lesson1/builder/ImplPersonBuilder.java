package lesson1.builder;

public class ImplPersonBuilder implements PersonBuilder{
    private String firstName;
    private String middleName;
    private String lastName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    @Override
    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public PersonBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @Override
    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public PersonBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public PersonBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public PersonBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public Person build(){
        return new Person(firstName, middleName, lastName, country, address, phone, age, gender);
    }

    public Person getResult(){
        return new Person(firstName, middleName, lastName, country, address, phone, age, gender);
    }
}
