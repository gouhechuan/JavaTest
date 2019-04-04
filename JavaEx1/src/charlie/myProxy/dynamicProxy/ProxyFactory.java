package charlie.myProxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private Object memberImp;
    public ProxyFactory(Object memberImp){
        this.memberImp=memberImp;
    }

   public Object getNewInstance(){
        return Proxy.newProxyInstance(memberImp.getClass().getClassLoader(),
                memberImp.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {



                        System.out.println("开始代理类的addd方法.....");
                        method.invoke(memberImp,args);
                        System.out.println("结束代理类的addd方法.....");
                        return null;
                    }
                });
   }
}
