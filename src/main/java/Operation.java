import java.util.Arrays;
import java.util.List;

public enum Operation {
    MINUS("-"),
    PLUS("+"),
    MULT("*"),
    DIVIDE ("/");

    private String value;

    private Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<Operation> getAvailableOperations(){
        return Arrays.asList(values());
    }
}
