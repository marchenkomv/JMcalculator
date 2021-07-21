public class Main {
    public static void main(String[] args) {
        while (true) {
            String[] input = new Requester().getInputFromUser();
            InputValidator validator = new InputValidator();
            validator.validateInputSize(input);
            String first = input[CommonConstants.FIRST_NUMBER];
            String second = input[CommonConstants.SECOND_NUMBER];
            int[] parsedNumbers = validator.validateNumbers(first, second);
            Operation operation = validator.validateOperation(input[CommonConstants.OPERATION]);
            int result = new Calculator().calculate(parsedNumbers[CommonConstants.FIRST_PARSED_NUMBER],
                    parsedNumbers[CommonConstants.SECOND_PARSED_NUMBER],
                    operation);
            if (validator.needConvertToRoman(input[CommonConstants.FIRST_NUMBER])) {
                System.out.println(new ConvertManager().arabicToRoman(result));
            } else {
                System.out.println(result);
            }
        }
    }
}