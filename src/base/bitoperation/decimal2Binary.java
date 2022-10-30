package base.bitoperation;

import org.junit.Test;

/**
 * @author 7991uxug@gmail.com
 * @date 11/5/22 9:55 PM
 */
public class decimal2Binary {
    public String convertToBinary(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            stringBuilder.append((num & (1 << i)) == 0 ? 0 : 1);
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        int num = 234324324;
        System.out.println(convertToBinary(num));
//        System.out.println(234324324 & 1 << 5);
    }
}
