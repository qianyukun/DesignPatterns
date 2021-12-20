package create.prototype;

/**
 * 内部引用的对象需要实现Cloneable接口
 */
class BaseInfo implements Cloneable {

    private String info;

    //如果还有其他引用类型，还需要在进行深拷贝
    public BaseInfo(String info) {
        this.info = info;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ProtoType implements Cloneable {
    //可以通过clone实现复制，浅拷贝
    private String name;
    private String function;
    //clone之后需要替换成新的对象，否则会引用同一个引用，深拷贝
    private BaseInfo baseInfo;

    public ProtoType(String name, String function, BaseInfo baseInfo) {
        this.name = name;
        this.function = function;
        this.baseInfo = baseInfo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ProtoType clone = (ProtoType) super.clone();
        clone.baseInfo = (BaseInfo) clone.baseInfo.clone();
        return clone;
    }

    @Override
    public String toString() {
        return hashCode() + " ProtoType{" +
                "name='" + name + '\'' +
                ", function='" + function + '\'' +
                ", baseInfo='" + baseInfo + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ProtoType protoType = new ProtoType("aaa", "bbbb", new BaseInfo("aaa"));
        System.out.println(protoType);
        try {
            System.out.println(protoType.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

//        1528902577 ProtoType{name='aaa', function='bbbb', baseInfo='create.prototype.BaseInfo@6d311334'}
//        1747585824 ProtoType{name='aaa', function='bbbb', baseInfo='create.prototype.BaseInfo@3d075dc0'}
    }
}
