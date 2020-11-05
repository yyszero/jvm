/**
 * jvm如何确定一个对象是可回收的对象
 * @author:Yangying
 * @date:2020-11-4
 */
public class ReferenceCountingGc {
    public Object instance=null;
    private static final int _1MB=1024*1024;
    private byte[]bigSize=new byte[2*_1MB];
    public static void testGC(){
        ReferenceCountingGc objA=new ReferenceCountingGc();
        ReferenceCountingGc objB=new ReferenceCountingGc();
         objA.instance=objB;
         objB.instance=objA;
         objA=null;
         objB=null;
         System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
