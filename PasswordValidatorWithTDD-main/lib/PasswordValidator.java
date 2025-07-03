package lib;

public class PasswordValidator {

    /**
     * คุณจะต้องเขียน Javadoc ที่สมบูรณ์ที่นี่ในอนาคต
     * เพื่ออธิบายกฎการทำงานของเมธอด
     */
    // TODO: แก้ไข return type ของเมธอดนี้ให้ถูกต้อง
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
        
        //return null ; // TODO: การคืนค่านี้ถูกต้องหรือไม่?
    }
}