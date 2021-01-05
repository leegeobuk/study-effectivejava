package chapter2.singleton;
/*
In this way, it is clearly shown in API that this class is Singleton
Also, it is brief
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {

    }
    public void leaveTheBuilding() {}
}
