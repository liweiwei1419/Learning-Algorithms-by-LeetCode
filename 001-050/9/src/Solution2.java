package study.palindrome.number;

/**
 * 是否是回文数字
 * 9. Palindrome Number
 * Created by liwei on 17/9/26.
 */
public class Main {

    public static void main(String[] args) {
        int num = 12345;

        isPalindromeNumber(num);


    }

    private static boolean isPalindromeNumber(int num){
        int origin = num;
        int modNum = 0;
        while (num!=0){
            modNum = modNum * 10 + num %10;
            // modNum = num %10;
            // y = modNum * 10 + num %10;
            num = num / 10;
            System.out.println(modNum + " " + num);
        }
        return false;
    }

}
