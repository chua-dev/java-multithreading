import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MyRunnable implements Runnable {
    private final List<String> arrayList;
    private final ConcurrentHashMap<String, Integer> cHashMap;

    public MyRunnable(List<String> arrayList, ConcurrentHashMap<String, Integer> cHashMap) {
        this.arrayList = arrayList;
        this.cHashMap = cHashMap;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        arrayList.add("runnable");
        System.out.println("Runnable thread running: " + Thread.currentThread().getName());
        arrayList.add("runnable2");
        cHashMap.compute("runnable", (k, v) -> v == null ? 1 : v + 1 );
        cHashMap.compute("runnable", (k, v) -> v == null ? 1 : v + 1 );
        System.out.println(arrayList);
        System.out.println(cHashMap);
    }
}
