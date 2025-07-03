package lib;

public class PasswordValidator {

   /**
    * โปรแกรมสำหรับตรวจสอบรหัสผ่านที่กรอกเข้ามาว่ามีความแข็งแกร้งขนาดไหน
    * @param password ข้อความที่เราใส่เพื่อวัดค่าความแข่งแกร่งของรหัสผ่าน
    * @return วัดความหนาแน่นของรหัสผ่าน ด้วย PasswordStrength 
            มีการรีเทิร์นรหัสผ่านโดยนับจาก Count แล้วเทียบตามเงี่อนไขที่กำหนดไว้
            เงื่อนไข  1 รหัสผ่านต้องมีอย่างน้อย 8 ตัวอักษร
                    2 รหัสผ่านต้องมีตัวพิมพ์ใหญ่
                    3 รหัสผ่านต้องมีทั้งตัวเลข - ตัวอักษร
                    4 รหัสผ่านต้องมีตัวอักษรพิเศษอย่างน้อย 1 ตัว
    */
    public static PasswordStrength validate(String password) { 
        
        int minLength = 8; 
        int count = 0 ;
        boolean c1 = false ,c2= false,c3= false,a= false,b = false ;
        
// case 0         
        if (password==null || password.length()<minLength)
                return PasswordStrength.INVALID; 
// case 1
        for(int i = 0 ; i< password.length() ; i ++){
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                c1 = true;
            }
        }
        if (c1 == true) {
            count ++;
        }
// case 2
        for(int i = 0 ; i< password.length();i++){
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                a =  true ; 
            }else if (Character.isLetter(ch)) {
                b = true ;
            }
        }  if (a && b) {
            c2 = true ;
            count++;
        }
// case 3 
        for(int i = 0 ; i < password.length();i++){
            char ch = password.charAt(i);
            if (!Character.isAlphabetic(ch)) {
                c3=true;
            }
        }
        if (c3==true) {
            count++;
        }

        if (count == 3) {
            return PasswordStrength.STRONG;
        }else if (count == 2) {
            return PasswordStrength.MEDIUM;
        }else{
            return PasswordStrength.WEAK;
        }
        
    }
}