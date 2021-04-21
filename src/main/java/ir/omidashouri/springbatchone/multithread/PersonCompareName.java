package ir.omidashouri.springbatchone.multithread;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PersonCompareName extends Person implements Comparable<Person> {


    public PersonCompareName(int age, String name) {
        super(age,name);
    }

    @Override
    public int compareTo(Person otherPerson) {
        return this.getName().compareTo(otherPerson.getName());
    }


}
