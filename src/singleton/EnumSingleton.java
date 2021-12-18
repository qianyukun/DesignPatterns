package singleton;

public enum EnumSingleton {
    SINGLETON;

    public void print(){
        System.out.println(this.hashCode());
    }
}
