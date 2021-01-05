package chapter2.singleton;

/*
Similar to Elvis but more brief, could be serialized easily and even prevents complicated serialization
and reflection attack.
It could seem awkward but in most cases, it is the best practice for making Singleton.
One exception is that if the Singleton needs to inherit that is not Enum,
Singleton should not be implemented this way.
 */
public enum Dustin {
    INSTANCE;

    public void leaveTheBuilding() {}
}
