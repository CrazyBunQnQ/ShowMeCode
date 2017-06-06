package proxy.statics;

/**
 * 目标对象，实现 Subject 接口
 * Created by CrazyBunQnQ on 17-6-6.
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject");
    }
}
