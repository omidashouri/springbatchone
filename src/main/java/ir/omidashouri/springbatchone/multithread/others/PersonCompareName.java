package ir.omidashouri.springbatchone.multithread.others;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


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
