package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class UserValidatorTest {

    @Nested
    class isValidUsername{

        @Test
        void returnsTrueIfOnlyLetters(){
            User user1 = new User("kalua");
            User user2 = new User ("Hannes");
            User user3 = new User("123Hannes123");
            User user4 = new User("!!@");
            String person1;
            String person2;
            String person3;
            String person4;
            person1 = user1.getUsername();
            person2 = user2.getUsername();
            person3 = user3.getUsername();
            person4 = user4.getUsername();
            Assertions.assertTrue(isAlpha(person1));
            Assertions.assertTrue(isAlpha(person2));
            Assertions.assertFalse(isAlpha(person3));
            Assertions.assertFalse(isAlpha(person4));
        }
        //Test only Letters
        public boolean isAlpha(String name){
            char[] chars = name.toCharArray();

            for (char c : chars){
                if(!Character.isLetter(c)){
                    return false;
                }
            }
            return true;
        }

        @Test
        void returnsFalseIfStartsWithNumber(){

        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar(){

        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){
        }
    }

    static class doesUsernameExist{
        //DB used for the test
        private static Database db = FileDatabase.getInstance();

        @Test
        void returnsTrueIfUsernameNotInDBYet(){
            User user1= new User("Kalua");
            User user2= new User("Hannes");

            db.addUser(user1);

            Assertions.assertTrue(UserValidator.isValidUsername(user2.getUsername()) && !UserValidator.doesUsernameExist(user2.getUsername()));
            //Also testing the opposite with user1
            Assertions.assertTrue(UserValidator.isValidUsername(user1.getUsername()) && UserValidator.doesUsernameExist(user1.getUsername()));
        }

        @Test
        void returnsFalseIfUsernameInDB(){
            User user1= new User("Kalua");
            User user2= new User("Kalue");

            db.addUser(user1);

            Assertions.assertTrue(UserValidator.isValidUsername(user2.getUsername()) && !UserValidator.doesUsernameExist(user2.getUsername()));
            //False if in DB
            Assertions.assertFalse(!UserValidator.doesUsernameExist(user1.getUsername()));
        }
    }
}
