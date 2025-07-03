package lib;

public class PasswordValidatorTest{
    
    public static void run() {
        
        System.out.println("--- Running Password Validator Tests ---");
        
        // Test Case 1: รหัสผ่านสั้นควรจะ INVALID
        PasswordStrength result1 = PasswordValidator.validate("abc123");
        if (result1 == PasswordStrength.INVALID) {
            System.out.println("Test Case 1 Passed: Short password is INVALID.");
        } else {
            System.out.println("Test Case 1 FAILED: Expected INVALID but got " + result1);
        }

        // Test Case 2: รหัสผ่านมีตัวใหญ้ตัวนึง
        PasswordStrength result2 = PasswordValidator.validate("ABCDEFGH");
        if (result2 == PasswordStrength.WEAK) {
            System.out.println("Test Case 2 Passed: Short password is WEAK.");
        } else {
            System.out.println("Test Case 2 FAILED: Expected WEAK but got " + result2);
        }

        // Test Case 3: รหัสผ่านผสมกับตัวเลข
        PasswordStrength result3 = PasswordValidator.validate("abc123def");
        if (result3 == PasswordStrength.MEDIUM) {
            System.out.println("Test Case 3 Passed: Short password is MEDIUM.");
        } else {
            System.out.println("Test Case 3 FAILED: Expected MEDIUM but got " + result3);
        }

        // Test Case 4: รหัสผ่านมีตัวอักษรพิเศษ
        PasswordStrength result4 = PasswordValidator.validate("P4ssw0rd!");
        if (result4 == PasswordStrength.STRONG) {
            System.out.println("Test Case 4 Passed: Short password is STRONG.");
        } else {
            System.out.println("Test Case 4 FAILED: Expected STRONG but got " + result4);
        }
        System.out.println("--------------------------------");
    }
}
