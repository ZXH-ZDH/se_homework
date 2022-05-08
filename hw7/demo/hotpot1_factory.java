package demo;
//成都火锅子类的实现并返回
public class hotpot1_factory implements hotpot_factory {
    public hotpot CreateFactory(){
        return new hotpot1();
    }
}
