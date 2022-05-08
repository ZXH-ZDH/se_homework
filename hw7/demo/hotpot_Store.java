package demo;
//选择火锅种类的类
public class hotpot_Store{
    private  hotpot_factory potFactory;
    public void setPotFactory(hotpot_factory potFactory) {
        this.potFactory = potFactory;
    }
    //返回对应子类实例对象
    public hotpot ChooseHot(){
        return  potFactory.CreateFactory();
    }
}