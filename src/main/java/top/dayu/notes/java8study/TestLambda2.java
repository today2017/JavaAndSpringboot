package top.dayu.notes.java8study;

import top.dayu.temp.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Classname TestLambda2
 * @Description lambda 表达式的使用2 （ 核心内置接口，用来解决，需要自己创建函数式接口的问题 ）
 * @Date 2020/6/15 14:50
 * @Author by ldy
 */
@SuppressWarnings("all")
public class TestLambda2 {

    static  List<Employee> employees= Arrays.asList(
            new Employee("张三",23,10000),
            new Employee("李四",33,20000),
            new Employee("王五",43,30000)
    );

    public static void main(String[] args) {
        testLambda1();
    }

    public static void testLambda1() {

        /**
            四大内置核心函数式接口
            1. Consumer<T>:   消费型接口        void accept(T t)
            2. Supplier<T> :  供给型接口        T get()
            3. Function<T,R>: 函数型接口        R apply(T t)
            4. Predicate<T>:  断言(判断)型接口   boolean test(T t)
            5. 其他的查找文档使用
         */

        //消费型->花钱
        happy(10000D, (m) -> System.out.println(m) );

        //供给型->产生指定个数的整数，并放入集合中 (例如产生10个随机数)
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer integer : numList) {
            System.out.println(integer);
        }

        //函数型->(用于处理字符串,去除空格)
        String s = strHandle(" das  ", (str) -> str.trim());
        System.out.println(s);

        //断言型->(满足条件的字符串添加到集合中)
        List<String> strings = Arrays.asList("qwe", "rtyu");
        List<String> strings1 = filterStr(strings, (ss) -> ss.length() > 3);
        System.out.println(strings1);



    }


    public static  List<String> filterStr ( List<String> str , Predicate<String> predicate){
        List<String> list = new ArrayList<>();
        for (String s : str) {
            if( predicate.test(s) ) {
                list.add(s);
            }
        }
        return list;
    }

    public static String strHandle (String str , Function<String,String> function){
        return function.apply(str);
    }

    public static List<Integer> getNumList (int num , Supplier<Integer> sup ){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    public static void happy (double money , Consumer<Double> con ){
        con.accept(money);
    }


}
