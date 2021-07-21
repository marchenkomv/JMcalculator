import java.util.Objects;

public class InputValidator {
    private static final int ARRAY_LENGTH = 3;
    private static final int MIN_THRESHOLD = 1;
    private static final int MAX_THRESHOLD = 10;

    public void validateInputSize(String[] inputArray) {
        if (inputArray.length != ARRAY_LENGTH) {
            throw new IllegalArgumentException("Неверный формат ввода. Ожидаемый формат: " +
                    "первое число, операция, второе число. Разделитель - символ пробела.");
        }
    }

    public int[] validateNumbers(String first, String second) {
        int firstNumber = 0;
        int secondNumber = 0;
        if (isArabic(first) && isArabic(second)) {
            firstNumber = getParsedInt(first);
            secondNumber = getParsedInt(second);
            validateThreshold(firstNumber, secondNumber);
        } else if (isRoman(first) && isRoman(second)) {
            ConvertManager converter = new ConvertManager();
            firstNumber = converter.romanToArabic(first);
            secondNumber = converter.romanToArabic(second);
            validateThreshold(firstNumber, secondNumber);
        } else {
            throw new IllegalArgumentException("Числа должны быть либо арабскими, либо римскими");
        }
        return new int[]{firstNumber, secondNumber};
    }

    public Operation validateOperation(String operation) {
        Operation targetOperation = null;
        for (Operation availableOperation : Operation.getAvailableOperations()) {
            if (operation.equals(availableOperation.getValue())) {
                targetOperation = availableOperation;
                break;
            }
        }
        if (Objects.isNull(targetOperation)) {
            throw new IllegalArgumentException("Введена недопустимая операция над числами");
        }
        return targetOperation;
    }

    private boolean isArabic(String number) {
        boolean isArabic;
        try {
            getParsedInt(number);
            isArabic = true;
        } catch (NumberFormatException e) {
            isArabic = false;
        }
        return isArabic;
    }

    private boolean isRoman(String number) {
        boolean isRoman;
        try {
            new ConvertManager().romanToArabic(number);
            isRoman = true;
        } catch (IllegalArgumentException e) {
            isRoman = false;
        }
        return isRoman;
    }

    public boolean needConvertToRoman(String number) {
        return isRoman(number);
    }

    private int getParsedInt(String number) {
        return Integer.parseInt(number);
    }

    private void validateThreshold(int first, int second) {
        if (first < MIN_THRESHOLD || first > MAX_THRESHOLD || second < MIN_THRESHOLD || second > MAX_THRESHOLD) {
            throw new IllegalArgumentException("Нельзя вводить символы меньше 1(I) и больше 10(X)");
        }
    }
}