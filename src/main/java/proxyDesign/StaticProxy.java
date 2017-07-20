package proxyDesign;
/**
 * Created by huchao on 2017/7/16.
 * 任务:
 *  实现设计模式之静态代理
 */
interface AbstractObject{
    public void toDo();
}
class RealObject implements AbstractObject{
    @Override
    public void toDo() {
        System.out.println("我是被代理类");
    }
}
class ProxyObject implements AbstractObject{
    AbstractObject realObject = null;
    public ProxyObject(AbstractObject realObject){
        this.realObject = realObject;
    }
    @Override
    public void toDo() {
        realObject.toDo();
    }
}
public class StaticProxy {
    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        ProxyObject proxyObject = new ProxyObject(realObject);
        proxyObject.toDo();
    }
}
