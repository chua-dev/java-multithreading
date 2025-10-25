import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Threading extends Thread {
    private final List<String> arrayList;
    private HashMap<String, Integer> hashMap;
    private final ConcurrentHashMap<String, Integer> cHashMap;

    public Threading(List<String> arrayList, ConcurrentHashMap<String, Integer> cHashMap, HashMap<String, Integer> hashMap) {
        this.arrayList = arrayList;
        this.cHashMap = cHashMap;
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        arrayList.add("thread");
        System.out.println("Thread running: " + Threading.currentThread().getName());
        arrayList.add("thread2");
        cHashMap.put("thread", 1);
        cHashMap.compute("thread", (k, v) -> v == null ? 1 : v + 1 );
        cHashMap.compute("thread", (k, v) -> v == null ? 1 : v + 1 );
        hashMap.compute("thread", (k, v) -> v == null ? 1 : v + 1);
        System.out.println(arrayList);
        System.out.println("Concurrent HashMap: " + cHashMap);
        System.out.println("HashMap: " + hashMap);
    }
}
