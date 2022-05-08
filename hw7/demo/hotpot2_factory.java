package demo;

public class hotpot2_factory implements hotpot_factory{
    public hotpot CreateFactory(){
        return new hotpot2();
    }
}
