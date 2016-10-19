package assertions;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ideadapt on 09.10.16.
 */
public class Person {

    private String firstName = null;
    private String lastName = null;
    private LocalDate birthDate = null;
    private Pattern p = Pattern.compile("[0-9]");


    public Person(String firstName, String lastName, LocalDate birthDate) {
        if(isValidString(firstName)){
            this.firstName = firstName.trim();
        }
        if(isValidString(lastName)){
            this.lastName = lastName.trim();
        }
        if(isValidDate(birthDate)) {
            this.birthDate = birthDate;
        }
    }

    private boolean isValidDate(LocalDate date)throws IllegalArgumentException{
        if(date == null || date.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("not allowed null or date after actual time for birthDate");
        }
        return  true;
    }

    private boolean isValidString(String inString)throws IllegalArgumentException{
        if(inString == null ){
            throw new IllegalArgumentException("not allowed null for String argument");
        }
        if(inString.isEmpty()){
            throw new IllegalArgumentException("not allowed empty String");
        }
        if(checkForNumbers(inString)){
            throw new IllegalArgumentException("numbers not allowed in name");
        }
        if(!(inString.trim().length() > 0)){
            throw new IllegalArgumentException("not allowed only white spaces");
        }
        return  true;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public Period getAge(){
        return Period.between(birthDate, LocalDate.now());
    }

    private boolean checkForNumbers(String name){
        Matcher m = p.matcher(name);
        return m.find();
    }
}
