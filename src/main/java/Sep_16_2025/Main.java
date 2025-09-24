package Sep_16_2025;

public class Main {

    public static void main(String[] args) {
        try {
            throw new NewException("TEST");
        } catch (NewException e) {
            System.out.println("CATCH");;
        }
    }
}


class NewException extends Exception{
    public NewException(String message){
        super(message);
        System.out.println("EXCEPTIONN");
    }
}
