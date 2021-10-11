package ua.goit.util;

public class NumericConverter {

    public static Long getLong(String string) {
        try {
            return Long.valueOf(string);
        }catch (NumberFormatException e) {
            return 0L;
        }
    }

    public static Integer getInteger(String string) {
        try {
            return Integer.valueOf(string);
        }catch (NumberFormatException e) {
            return 0;
        }
    }
}
