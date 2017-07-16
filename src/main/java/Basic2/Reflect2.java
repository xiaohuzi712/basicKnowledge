package Basic2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by huchao on 2017/7/16.
 * 任务:
 * 1.通过反射机制实例化一个类的对象
 * 2. 动态调用方法
 *      {
 *          1.首先通过反射获得Class类对象
 *          2.调用getMethod()方法获得指定的方法
 *          3.调用invoke(对象实例，xx.class,yy.class)
 *      }
 * 3.获取类的属性并修改
 * 4.在泛型为Integer的ArrayList中存放一个String类型的对象
 */
public class Reflect2 {
    private String proprety  = null;
    public int height = 0;

    //获取类的实例对象
    public static void instanceObject(Class<?> u) throws Exception{
        User user = (User) u.newInstance();
        user.setAge(20);
        user.setName("阿狸");
        System.out.println("我的名字叫"+user.getName()+",今年"+user.getAge());
    }
    //通过反射调用无参方法
    public void method1(){
        System.out.println("我是Reflect2的method1方法");
    }
    //通过反射调用有参方法
    public void method2(int age,String userName){
        System.out.println("我的名字叫"+userName+",今年"+age);
    }
    //操作类的属性
    public static void operateAttribue(Class<?> c) throws Exception{
        Reflect2  reflect2 = (Reflect2)c.newInstance();
        Field field = c.getDeclaredField("height");
        field.setAccessible(true);
        field.set(reflect2, 5);
        System.out.println(field.get(reflect2));
    }

    //泛型为Integer的ArrayList中存放一个String类型的对象
    public static  void saveEle() throws  Exception{
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Method method = arrayList.getClass().getMethod("add",Object.class);
        method.invoke(arrayList,"Java反射机制");
        System.out.println(arrayList.get(0));
    }

    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("Basic2.User");
        Reflect2.instanceObject(clazz);
        Class<?> r = Class.forName("Basic2.Reflect2");
        Method m1 = r.getMethod("method1");
        Method m2 = r.getMethod("method2",int.class,String.class);
        m1.invoke(r.newInstance());//我是Reflect2的method1方法
        m2.invoke(r.newInstance(),20,"阿狸");//我的名字叫阿狸,今年20
        Reflect2.operateAttribue(r);//5
        Reflect2.saveEle();//Java反射机制
    }
}
