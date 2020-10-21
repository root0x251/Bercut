import model.PersonalData;

public class Main {

    // field length
    private static int differenceFieldsLengthError = 0;

    // different character
    private static int resultCharError = 0;

    // number of permutations
    private static int numberPermutations = 0;

    // form is valid
    private static boolean isValid = true;

    public static void main(String[] args) {

        // equal (isValid)
        PersonalData firstUser = new PersonalData("вячеслав", "Бортниченко", "Алексеевич");
        PersonalData secondUser = new PersonalData("вячеслав", "Бортниченко", "Алексеевич");

        // two character representation (in one field) (isValid)
        PersonalData thirdUser = new PersonalData("вячеслав", "Бортниченок", "Алексеевич");
        PersonalData fourthUser = new PersonalData("вячеслав", "Бортниченко", "Алексеевич");

        // two character representation (in one field) (!isValid)
        PersonalData fifthUser = new PersonalData("вячеслав", "оБртниченок", "Алексеевич");
        PersonalData sixthUser = new PersonalData("вячеслав", "Бортниченко", "Алексеевич");

        // one mismatched character (in one field) (isValid)
        PersonalData seventhUser = new PersonalData("вячеслав", "Бортниченк", "Алексеевич");
        PersonalData eighthUser = new PersonalData("вячеслав", "Бортниченко", "Алексеевич");

        // two mismatched character (in one field) (!isValid)
        PersonalData ninthUser = new PersonalData("вячеслав", "Бортничен", "Алексеевич");
        PersonalData tenthUser = new PersonalData("вячеслав", "Бортниченко", "Алексеевич");

        // two mismatched character (in one field) and two character representation (in one field) (!isValid)
        PersonalData eleventhUser = new PersonalData("вячеслав", "оБтрничен", "Алексеевич");
        PersonalData twelfthUser = new PersonalData("вячеслав", "Бортниченко", "Алексеевич");

        // two mismatched character (in one field) and two character representation (in one field) (!isValid)
        PersonalData thirteenUser = new PersonalData("Иванов", "Иван", "Иванович");
        PersonalData fourteenthUser = new PersonalData("вячеслав", "Бортниченко", "Алексеевич");

        objectManipulation(firstUser, secondUser);
        objectManipulation(thirdUser, fourthUser);
        objectManipulation(fifthUser, sixthUser);
        objectManipulation(seventhUser, eighthUser);
        objectManipulation(ninthUser, tenthUser);
        objectManipulation(eleventhUser, twelfthUser);
        objectManipulation(thirteenUser, fourteenthUser);

    }

    private static void objectManipulation(PersonalData firstUser, PersonalData secondUser) {
//        необходимо исключать знаки препинания, символы, не являющиеся буквами и цифрами
//        эквивалентными считаются строчные и прописные символы
        String[] userOne = addToArray(firstUser);
        String[] userTwo = addToArray(secondUser);

        int totalErrorCount = 0;

        for (int i = 0; i < 2; i++) {
            resultCharError += compareFields(userOne[i], userTwo[i]);

            // эквивалентными считаются поле имеются не более двух переставленных символов
            // эквивалентными считаютсяесли количество не совпадающих символов в поле не превышает одного
            if (numberPermutations > 2 || (resultCharError + differenceFieldsLengthError) > 1) {
                isValid = false;
            }

            totalErrorCount += resultCharError + numberPermutations + differenceFieldsLengthError;

        }

        System.out.println("Result {\n isValid : " + isValid + "\n errCnt : " + (totalErrorCount) + "\n}");

        differenceFieldsLengthError = 0;
        resultCharError = 0;
        numberPermutations = 0;
        isValid = true;
    }

    // removing unnecessary characters
    private static String[] addToArray(PersonalData user) {
        String regex = "[^a-zA-Zа-яёА-ЯЁ0-9]";

        return new String[]{user.getFirstName().replaceAll(regex, "").toLowerCase(),
                user.getSecondName().replaceAll(regex, "").toLowerCase(),
                user.getPatronymicName().replaceAll(regex, "").toLowerCase()};
    }

    // compare fields with each other
    private static int compareFields(String firstUser, String secondUser) {
        int counter = 0;

        char[] firstUserField = firstUser.toCharArray();
        char[] secondUserField = secondUser.toCharArray();

        int minLength = Math.min(firstUserField.length, secondUserField.length);

        // делаем проверку на длины полей
        differenceFieldsLengthError += Math.max(firstUserField.length, secondUserField.length) - minLength;

        for (int i = 0; i < minLength; i++) {
            if (firstUserField[i] != secondUserField[i]) {
                try {
                    if (counter < 2) {
                        if (firstUserField[i] != secondUserField[i + 1] || firstUserField[i] != secondUserField[i - 1]) {
                            counter++;
                            numberPermutations++;
                        }
                    }
                } catch (IndexOutOfBoundsException ignore) {
                }
            }
        }
        return counter;
    }
}

//МАРИЯ
//СЛАВА
