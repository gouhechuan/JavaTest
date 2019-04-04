package charlie.myProxy.dynamicProxy;

public class Test {
    @org.junit.Test
    public void Test1(){
        IMember member=new MemberImp();
        ProxyFactory memberProxy=new ProxyFactory(member);
        IMember member1=(IMember)memberProxy.getNewInstance();
        member1.addMember();
    }
}
