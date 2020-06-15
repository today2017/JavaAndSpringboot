package top.dayu.temp;

/**
 * @Classname FilterEmployeeByAge
 * @Description TODO
 * @Date 2020/6/15 15:48
 * @Author by ldy
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35 ;
    }
}
