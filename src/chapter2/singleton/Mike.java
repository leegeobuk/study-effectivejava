package chapter2.singleton;
/*
Advantages: 1. It could be changed to non-Singleton without changing API.
               Then, it could pass different instances per threads.
            2. It could be changed from static factory to generic Singleton factory.
            3. Reference on static factory method could be used as supplier.
 */
public class Mike {
    private static final Mike INSTANCE = new Mike();
    private Mike() {}

    public static Mike getInstance() {
        return INSTANCE;
    }
    public void leaveTheBuilding() {}
}
