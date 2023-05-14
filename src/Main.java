public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    public static void main(String[] args) {
        try {
            LoginOptions("Absolut0", "data", "data");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());;
        }


    }
    public static void LoginOptions(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("Символы в логине не соответствует требованиям");
        }
        if (login.length()>20) {
            throw new WrongLoginException("Количество символов превышает 20");
        }
        if (!password.matches(REGEX)) {
            throw new WrongPasswordException("Символ в пароле не соответствует требованиям");
        }
        if (password.length()>20) {
            throw new WrongPasswordException("Пароль символов превышает 20");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль не совпадает");
        }
    }
}