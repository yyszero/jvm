import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author:Yangying
 * @date:2020-10-29
 */
public class HeapOOM {
    static class OOMobject{}

    public static void main(String[] args) {
        List<OOMobject> list=new ArrayList<OOMobject>();
        while (true){
            list.add(new OOMobject());
        }
    }
}
