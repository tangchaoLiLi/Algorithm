package questions;

import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        String password = "";
        System.out.println("请输入匹配的字符串：");
        Scanner scanner = new Scanner(System.in);
        password = scanner.nextLine();
        boolean res = false;
        if (password.length() <= 8) {
            res = false;
            System.out.println("结果：" + (res ? "OK" : "NG"));
            return;
        }

        int categoryCount = 0;
        if (password.matches(".*[a-z].*")) { // 包括小写字母
            categoryCount++;
        }
        if (password.matches(".*[A-Z].*")) { // 包括大写字母
            categoryCount++;
        }
        if (password.matches(".*\\d.*")) { // 包括数字
            categoryCount++;
        }
        if (password.matches(".*[^a-zA-Z0-9].*")) { // 包括其它符号
            categoryCount++;
        }
        if (categoryCount < 3) {
            res = false;
            System.out.println("结果：" + (res ? "OK" : "NG"));
            return;
        }

        for (int i = 0; i < password.length() - 3; i++) {
            String substring = password.substring(i, i + 3);
            for (int j = i + 3; j < password.length() - 2; j++) {
                String subsub = password.substring(j, j + 3);
                if (subsub.equals(substring)) {
                    res = false;
                    System.out.println("结果：" + (res ? "OK" : "NG"));
                    return;
                }
            }
        }

        res = true;
        System.out.println("结果：" + (res ? "OK" : "NG"));
    }
}
