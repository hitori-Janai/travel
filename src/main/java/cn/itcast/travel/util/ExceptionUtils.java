package cn.itcast.travel.util;

public class ExceptionUtils {
    public static void printException(Exception e){
        System.out.print(e.getMessage() + " ");
        System.out.print(e.getStackTrace()[0].getFileName() + " ");
        System.out.print(e.getStackTrace()[0].getLineNumber() + " ");
        System.out.println(e.toString());
    }
}
