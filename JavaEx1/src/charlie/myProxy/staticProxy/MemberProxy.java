package charlie.myProxy.staticProxy;

public class MemberProxy implements IMember {

    private IMember memberImp;
    public MemberProxy(IMember memberImp){
        this.memberImp=memberImp;
    }
    @Override
    public void addMember() {
        System.out.println("开始代理类的addd方法.....");
        memberImp.addMember();
        System.out.println("结束代理类的addd方法.....");
    }
}
