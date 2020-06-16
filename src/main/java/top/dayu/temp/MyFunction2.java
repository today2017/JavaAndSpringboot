package top.dayu.temp;

/**
 * @Classname MyFunction2
 * @Description TODO
 * @Date 2020/6/16 15:14
 * @Author by ldy
 */
public interface MyFunction2<T,R> {

    /**
      泛型：意思是指一种类型，T是一种类型，R是一种类型，所以 【T t1 , T t2】 表示指这个类型的两个参数

     */
    R getValue(T t1 , T t2);

}
