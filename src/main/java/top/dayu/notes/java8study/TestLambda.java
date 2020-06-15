package top.dayu.notes.java8study;

import org.apache.catalina.core.FrameworkListener;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Classname TestLambda
 * @Description lambda 表达式的使用
 * @Date 2020/6/15 14:50
 * @Author by ldy
 */
public class TestLambda {

    public static void main(String[] args) {
        testLambda();
    }


    public static void testLambda() {

        /**
         Integer.compare(x,y) === x.compareTo(y)
         并且：
            对象大于目标参数,返回1   对象小于目标参数,返回-1   对象等于目标参数,返回0



         */

        //传统的比较器，匿名函数
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        //创建一个TreeSet，指定比较排序方法。
        TreeSet<Integer> set1 = new TreeSet<>(com1);

        //使用Lambda表达式
        Comparator<Integer> com2 = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> set2 = new TreeSet<>(com2);



    }
}
