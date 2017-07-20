
package proxyDesign;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by huchao on 2017/7/16.
 * 任务:
 * 实现设计模式之动态代理
 * 优点:1.无需手动写代理类，只用实现InvocationHandler,就可以代理接口的所有方法
 *  2.扩展性更强
 *  应用场景
 *  Spring AOP
 */
interface IGamePlayer{
    //登录游戏
    public void login(String username,String password);
    //杀怪
    public void  killBoss();
    //升级
    public void upgrade();
}
class GamePlayer implements IGamePlayer{
    private String name = "";
    public GamePlayer(String _name){
        this.name = _name;
    }
    @Override
    //登录
    public void login(String user, String password) {
        System.out.println("登录名为"+user+"的用户,登录成功!");
    }
    //打怪
    @Override
    public void killBoss() {
        System.out.println(this.name+"在杀怪!");
    }
    //升级
    @Override
    public void upgrade() {
        System.out.println(this.name+"又升了一级");
    }
}
//代理实现类
class GamePlayIH implements InvocationHandler{
    //被代理的实例
    IGamePlayer iGamePlayer = null;
    //我要代理谁
    public  GamePlayIH(IGamePlayer iGamePlayer1){
        this.iGamePlayer = iGamePlayer1;
    }
    @Override
    //代理方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("xxx");
        //执行被代理的方法
        IGamePlayer result =(IGamePlayer)method.invoke(this.iGamePlayer, args);
        if (method.getName().equalsIgnoreCase("login")){
            System.out.println("有人在用我的号登录");
        }
        return result;
    }
}
public class DynamicProxy {
    public static void main(String[] args) {
        //定义一个痴迷的玩家
        GamePlayer gamePlayer = new GamePlayer("张三");
        //创建自定义的调用处理器
        InvocationHandler invocationHandler = new GamePlayIH(gamePlayer);
        //装载代理类的加载器，目的是将字节码加载到虚拟机，然后被使用
        ClassLoader classLoader = gamePlayer.getClass().getClassLoader();
        //动态产生一个代理类实例,此代理类可以代理多个接口
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, new Class[]{IGamePlayer.class}, invocationHandler);
        proxy.login("张三","password");
    }
}
