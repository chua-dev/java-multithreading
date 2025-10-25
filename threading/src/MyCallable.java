import java.io.IOException;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws IOException, InterruptedException {
        Thread.sleep(1000);
        System.out.println("Callable Thread Running: " + Thread.currentThread().getName());
        return "Callable Result";
    }
}
