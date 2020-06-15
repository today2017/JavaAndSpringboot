package top.dayu.notes.java8study;

import top.dayu.temp.Employee;
import top.dayu.temp.FilterEmployeeByAge;
import top.dayu.temp.FilterEmployeeBySalary;
import top.dayu.temp.MyPredicate;
import java.util.*;

/**
 * @Classname TestLambda
 * @Description lambda 表达式的使用
 * @Date 2020/6/15 14:50
 * @Author by ldy
 */
public class TestLambda {

    public static void main(String[] args) {
        testLambda1();
    }

    public static void testLambda1() {

        /**
         Integer.compare(x,y) === x.compareTo(y)
         并且：
            对象大于目标参数,返回1   对象小于目标参数,返回-1   对象等于目标参数,返回0

         */

        //TODO 1. 传统的比较器，匿名函数
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

        //TODO 2. 获取当前公司中员工年龄>35的员工信息  （ Arrays.asList(): 数组转集合 ）
        List<Employee> employees= Arrays.asList(
                new Employee("张三",23,10000),
                new Employee("李四",33,20000),
                new Employee("王五",43,30000)
        );

        //传统方法: 写一个方法1，方法中遍历集合，age属性大于35的放进新集合，遍历结束后返回
        //如果过滤 工资大于10000的还得再写个 方法2 方法中遍历集合，salary属性大于10000的放进新集合，遍历结束后返回

        /**
          优化；最好的优化代码的方法 就是设计模式 （策略模式）
          新建一个接口MyPredicate,里面定义一个boolean的方法，然后写几个过滤类 实现这个接口，在每个过滤类中实现方法，然后编写自己的过滤规则
          再使用的时候,只需要写一个过滤的方法，传入要过滤的数组和按照什么规则过滤（写了过滤规则的子类）

         给什么策略按照什么策略过滤（age>35  or salary>10000）
         策略模式把对象本身和运算规则区分开来，因此我们整个模式也分为三个部分。
         环境类(Context): 用来操作策略的上下文环境，也就是我们游客。
         抽象策略类(Strategy): 策略的抽象，出行方式的抽象
         具体策略类(ConcreteStrategy): 具体的策略实现，每一种出行方式的具体实现。

         */

        //按照年龄过滤 >35
        List<Employee> filterEmp1 = filterEmployee(employees, new FilterEmployeeByAge());

        //按照工资过滤 >10000
        List<Employee> filterEmp2 = filterEmployee(employees, new FilterEmployeeBySalary());

        //继续优化 ---> 上文中麻烦的地方在于 每实现一种过滤需要创建一个MyPredicate的子类 优化可以使用匿名内部类
        //按照工资过滤 > 20000 (不用创建过滤规则类了)
        List<Employee> filterEmp3 = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 20000 ;
            }
        });

        //继续使用lambda 优化
        List<Employee> filterEmp4 = filterEmployee(employees, (e) -> e.getSalary() >20000 );
        filterEmp4.forEach(System.out::println);

        //*** 继续优化(工资大于20000，取前两条) （ stream API ）
        employees.stream()
                .filter( (e) -> e.getSalary() > 20000 )
                .limit(2)
                .forEach(System.out::println);

        //*** 获取集合中的所有人的名字并打印
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

    }

    public void testLambda2 (){
        /**
         （左侧）->（右侧） : lambda 表达式的新操作符
         操作符左侧：参数列表
         操作符右侧：所需执行的功能（lambda体）
         */

        //语法格式： 无参数无返回值： () -> 功能(eg. System.out.println();)
        //传统的匿名内部类方式 无参数无返回值
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };

        //使用lambda优化后
        Runnable runnable2 = () -> System.out.println(1);


    }



    public static List<Employee> filterEmployee (List<Employee> employees, MyPredicate<Employee> myPredicate ){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : employees) {
            if(myPredicate.test(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }

}
