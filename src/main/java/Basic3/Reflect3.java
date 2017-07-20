package Basic3;

/**
 * Created by huchao on 2017/7/16.
 * 任务:
 * 将反射机制用于工厂模式
 * 通过反射获取的属性和方法都要声明异常或捕捉异常
 */

interface Fruit{
   public abstract  void eat();
}
class Apple implements Fruit{
    @Override
    public void eat() {
        System.out.println("我是苹果");
    }
}
class Orange implements Fruit{
    @Override
    public void eat() {
        System.out.println("我是橙子");
    }
}
class Factory{
    public static Fruit getInstance(String clazz){
        Fruit f = null;
        try{
            f = (Fruit)Class.forName(clazz).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  f;
    }
}
public class Reflect3 {
    public static void main(String[] args) {
        Fruit fru = Factory.getInstance("Basic3.Orange");
        if (fru!=null){
            fru.eat();//我是橙子
        }
    }
}
