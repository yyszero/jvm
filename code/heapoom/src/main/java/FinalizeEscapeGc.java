/**
 * 一次对象自我拯救 通过finalize
 * 对象在被GC时候可以自我拯救
 * 自救的机会只有一次 因为一个对象的finalize()方法最多只会被系统调用一次
 * @author:Yangying
 * @date:2020-11-4
 */
public class FinalizeEscapeGc {

    public static FinalizeEscapeGc save_hook=null;
    public void isAlive(){
        System.out.println("yes,i am still alive!");
    }
    @Override
    protected void finalize()throws Throwable{
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGc.save_hook=this;
    }

    public static void main(String[] args) throws Throwable {
        save_hook=new FinalizeEscapeGc();
        //对象第一次成功拯救自己
        save_hook=null;
        System.gc();
        //因为Finalize方法优先级很低，暂停0.5秒 等待他
        Thread.sleep(500);
        if(save_hook!=null){
            save_hook.isAlive();
        }else {
            System.out.println("no, i am dead!");
        }

        //下面这段代码和上面一样 但是这次自救却失败了
        save_hook=null;
        System.gc();
        //因为Finalize方法优先级很低，暂停0.5秒 等待他
        Thread.sleep(500);
        if(save_hook!=null){
            save_hook.isAlive();
        }else {
            System.out.println("no, i am dead!");
        }
    }
}
