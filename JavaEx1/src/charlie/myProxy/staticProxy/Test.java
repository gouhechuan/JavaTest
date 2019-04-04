package charlie.myProxy.staticProxy;

public class Test {
    @org.junit.Test
    public void Test1(){
        IMember member=new MemberImp();
        MemberProxy memberProxy=new MemberProxy(member);
        memberProxy.addMember();
    }
}
