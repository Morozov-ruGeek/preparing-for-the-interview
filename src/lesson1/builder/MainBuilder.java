package lesson1.builder;

public class MainBuilder {
    public static void main(String[] args) {
        PersonBuilder builder = new ImplPersonBuilder();
        builder.setFirstName("Alexsey");
        builder.setMiddleName("Olegovich");
        builder.setLastName("Morozov");
        builder.setCountry("Russia");
        builder.setAddress("Izhevsk");
        builder.setPhone("112");
        builder.setAge(30);
        builder.setGender("M");
        System.out.println(builder.build());
    }
}
