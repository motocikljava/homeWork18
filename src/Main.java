import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // помогите разобраться почему не проходит проверка логина
        boolean chec = Validate("ssg", "sss", "sыss");
        if (chec) {
            System.out.println("верные данные");
        } else {
            System.out.println("неверные данные");
        }


    }

    public static boolean Validate (String login, String password, String confirmPassword)  {
        if (!password.equals(confirmPassword)) {
            System.out.println("проверка пароля неверная");
        }
        try {
            dataPassword(password, confirmPassword);
            dataLogin(login);

        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return  true;
    }

    public static boolean dataLogin(String login) throws WrongLoginException {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]");
        Matcher matcher = pattern.matcher(login);
        if (matcher.find() == true && login.length() <= 20) {
            return true;
        } else {
            throw new WrongLoginException("неверный логин") ;
        }
    }
    public static boolean dataPassword(String password, String confirmPassword) throws WrongPasswordException {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]");
        Matcher matcher1 = pattern.matcher(password);
        Matcher matcher2 = pattern.matcher(confirmPassword);
        if (matcher1.find() == true && password.length() <= 20 ) {
            return true;
        } else {
            throw new WrongPasswordException("указан неверный пароль");
        }
    }
}