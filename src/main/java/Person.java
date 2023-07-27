import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return name;

    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age >= 0) {
            return OptionalInt.of(age);
        }
        return OptionalInt.empty();
    }

    public String getAddress() {
        return hasAddress() ? address : "";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }


    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(surname);
        return child;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {
        if (age < 0 && address == "") {
            return "Person: " + '\n' +
                    "name = " + name + '\n' +
                    "surname = " + surname;
        } else if (age >= 0 && address == " ") {
            return "Person: " + '\n' +
                    "name = " + name + '\n' +
                    "surname = " + surname + '\n' +
                    "age = " + age;
        } else {
            return "Person: " + '\n' +
                    "name = " + name + '\n' +
                    "surname = " + surname + '\n' +
                    "age = " + age + '\n' +
                    "address = " + address + '\n';
        }
    }
}

