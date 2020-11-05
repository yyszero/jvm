/**
 * java虚拟机栈 栈深度超过
 * @author:Yangying
 * @date:2020-11-4
 */
public class JvmStackSof {
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        JvmStackSof oom=new JvmStackSof();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack Length:"+oom.stackLength);
            throw e;
        }
    }


}
