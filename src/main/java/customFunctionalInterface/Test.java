package customFunctionalInterface;

import java.io.BufferedReader;

/**
 * 自定义FunctionalInterface注解
 *  1.新增函数接口,使用注解@FunctionalInterface, 且该接口只提供一个抽象方法
 *  2.添加具体方法以此函数接口为参数,内部实现具体逻辑
 *  3.外部调用以lambda方式传参（当然也可以内部类传参）
 * Created by jason-geng on 1/20/17.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        //oop
        System.out.println("oop");
        String res1 = ProcessFile.originProjectFile();
        System.out.println(res1);

        //FP, 灵活定义输入内容
        System.out.println("Functional Programming");
        String res2 = ProcessFile.processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(res2);

        String res3 = ProcessFile.processFile(BufferedReader::readLine);
        System.out.printf(res3);
    }
}
