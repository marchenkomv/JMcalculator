public class Calculator {

    public int calculate(int first, int second, Operation operation) {
        int result = 0;
        switch (operation) {
            case PLUS:
                result = first + second;
                break;
            case MINUS:
                result = first - second;
                break;
            case MULT:
                result = first * second;
                break;
            case DIVIDE:
                result = first / second;
                break;
            default:
                throw new IllegalStateException("Неизвестная операция: " + operation);
        }
        return result;
    }
}