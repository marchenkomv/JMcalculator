import java.util.Scanner;

public class Requester {
    private static final String DELIMETER = " ";

    public String[] getInputFromUser() {
        System.out.println("Введите действие над числами:");
        return new Scanner(System.in).nextLine()
                .toUpperCase()
                .split(DELIMETER);
    }
}