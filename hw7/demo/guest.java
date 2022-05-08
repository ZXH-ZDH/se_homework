package demo;
//测试
//测试顾客的点餐
public class guest{
    public static void main(String[] args){
        //首先到火锅店创建一个火锅店对象
        hotpot_Store hotpotStore=new hotpot_Store();
        //选择成都火锅，由成都火锅工厂hotpot1_factory创建实例
        hotpot1_factory hotpot1_factory=new hotpot1_factory();
        //成都火锅的子类实例化对象
        hotpotStore.setPotFactory(hotpot1_factory);
        //将成都火锅上给客人
        hotpot hotpot=hotpotStore.ChooseHot();

        System.out.println(hotpot.getName());
    }
}
