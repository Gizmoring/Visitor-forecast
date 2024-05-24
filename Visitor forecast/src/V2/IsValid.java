package V2;

public class IsValid {
    public static boolean isValid(String input) {
        String table = "0123456789";
        boolean isValid = false;
        for (char c : input.toCharArray()) {
            if (table.indexOf(c) == -1) {
                return false;
            }
        }return true;
    }

    public static boolean exitIsValid(String input) {
        String table = "YN";
        boolean isValid = false;
        for (char c : input.toCharArray()) {
            if (table.indexOf(c) == -1) {
                return false;
            }
        }return true;
    }

}
// 숫자가 맞다면 false를 반환하고 숫자가 안들어온경우에는 true를 반환해준다.