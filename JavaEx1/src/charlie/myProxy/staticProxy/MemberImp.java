package charlie.myProxy.staticProxy;

public class MemberImp implements IMember {

    @Override
    public void addMember() {
        System.out.println("我是原生态的Add方法。。");
    }
}