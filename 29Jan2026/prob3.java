public class prob3 {
    

    public static void main(String[] args) {

        try {
            Validate.validateUsername("ram");
            Validate.validateAge(18);
            Validate.validateEmail("abc@gmail");   

            System.out.println("All validations passed");

        }
        catch (InvalidUsernameException e) {
            System.out.println("Username Error: " + e.getMessage());
        }
        catch (InvalidEmailException e) {
            System.out.println("Email Error: " + e.getMessage());
        }
        catch (InvalidAgeException e) {   
            System.out.println("Age Error: " + e.getMessage());
        }
        finally {
            System.out.println("Validation completed");
        }
    }


}
class Validate {

    //name
    public static void validateUsername(String username) throws InvalidUsernameException 
    {
        if (username == null || username.length() < 5) 
        {
            throw new InvalidUsernameException("Username must have at least 5 characters");
        }
    }
//mail
    public static void validateEmail(String email) throws InvalidEmailException 
    {


        if (email == null || !email.contains("@") || !email.contains("."))
        {
            throw new InvalidEmailException("Invalid email format");
        }
    }//age
    public static void validateAge(int age) 
    {
        if (age < 18 || age > 60) 
            {
            throw new InvalidAgeException("Age must be between 18 and 60");
        }
    }
}

class InvalidUsernameException extends Exception
{
    public InvalidUsernameException(String msg) 
    {
        super(msg);
    }
}


class InvalidEmailException extends Exception 
{
    public InvalidEmailException(String msg) 
    {
        super(msg);
    }
}
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}
