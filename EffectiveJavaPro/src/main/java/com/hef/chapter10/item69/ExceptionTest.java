package com.hef.chapter10.item69;

/**
 * @Date 2020/2/15
 * @Author lifei
 */
public class ExceptionTest {

    public static void main(String[] args) {
        String[] range = new String[]{"aa","bb","cc"};
        loopByExceptionTest(range);
    }

    /**
     * 异常的错误用法
     * @param range
     */
    private static void loopByExceptionTest(String[] range){
        try{
            int i=0;
            while (true){
                System.out.println(range[i++]);
            }
        }catch (ArrayIndexOutOfBoundsException e){

        }
    }
}
