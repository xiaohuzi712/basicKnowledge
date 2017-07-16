package Basic1;

import java.io.Serializable;

/**
 * Created by huchao on 2017/7/16.
 * 任务:
 * 获取一个类的三种方法
 * 1.通过Object实例的getClass()方法获取一个类;
 * 2.通过Class类的静态方法forName()方法获取一个类;
 * 3.通过一个类的静态属性class获取一个类
 * 4.获取当前类的父类
 * 5.获取当前类的所有实现接口
 */
public class Reflect1 implements Serializable,Comparable {
    //获取一个类的所有实现接口
    public static void  getInterface(Class<?> clazz){
        Class<?> intes [] = clazz.getInterfaces();
        for (Class c:intes){
            System.out.println(c.getName());
        }
    }
    //获取一个类的父类
    public static void getParent(Class<?> clazz){
        Class<?> parentClass = clazz.getSuperclass();
        System.out.println("当前类的父类名称为"+parentClass.getName());

    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
    public static void main(String[] args) throws Exception{
        Class<?> clazz1 = Class.forName("Basic1.Reflect1");
        Class<?> clazz2 = Reflect1.class;
        Class<?> clazz3 = new Reflect1().getClass();
        System.out.println(clazz1.getName()); //Basic1,Reflect1
        System.out.println(clazz2.getName());//同上
        System.out.println(clazz3.getName());//同上
        Reflect1.getInterface(clazz1);//java.io.Serializable,java.lang.Comparable
        Reflect1.getParent(clazz2);//java.lang.Object
    }
}
