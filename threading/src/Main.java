import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Hello world!");

        if (true) {

            int[] questionOne = {5, 5, 1, 9, 7, 10, 7, 7, 11, 1, 8, 5};
            int[] questionTwo = {1, -1, 6, -2, 7};
            int[] answerOne = ArrayProblem.sumOfTwoInArray(questionOne, 6);
            System.out.println(Arrays.toString(answerOne));
            System.out.println(ArrayProblem.duplicateInArray(questionOne));
            System.out.println(ArrayProblem.maximumSubArray(questionTwo));
            return;
        }

        if (true) {
            String[] myList = {"129394", "120", "1294", "12345", "123"};

            String myAns = CommonPrefix.longestCommonPrefix(myList);
            System.out.println(myAns);
            return;
        }

        // New ArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(Arrays.asList("default", "default2"));
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Thread 0
        ThreadPrint threadPrint = new ThreadPrint();
        threadPrint.start(); // open thread

        // Thread
        Thread thread = new Threading(list, concurrentHashMap, hashMap);
        thread.start();
        //thread.run(); // run still run at the same thread

        // Thread function
        thread.setName("My First Thread");
        thread.getName();
        Thread.currentThread();
        Thread.sleep(100); // millisecond
        thread.setPriority(1);
        thread.getPriority();

        // Runnable
        MyRunnable runnable = new MyRunnable(list, concurrentHashMap);
        Thread runnableThread = new Thread(runnable);
        runnableThread.start();

        // Callable
        MyCallable callable = new MyCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> result = executorService.submit(callable);
        Future<?> futureResult2 = executorService.submit(runnable); // runnable can to here as well

        // Callable 2
        MyCallable2 callable2 = new MyCallable2();
        FutureTask<Integer> ft = new FutureTask<>(callable2);
        Thread t2 = new Thread(ft);
        t2.start();
        Integer answer = ft.get();
        System.out.println(answer);

        String actualResult = result.get();
        System.out.println(actualResult);
        System.out.println(futureResult2.get());

        executorService.shutdown();
        System.out.println("Hello world Finish!");
    }

    // Get duplicate word with string
    public Set<Character> getDuplicateCharInString(String word) {
        Set<Character> result = new HashSet<>();
        Map<Character, Integer> freqMap = new HashMap<>();

        for ( char c : word.toCharArray()) {
            if (Character.isWhitespace(c)) continue;
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            if (freqMap.get(c) > 1) {
                result.add(c);
            }
        }

        return result;
    }


    public void reverseArray(int[] arr) {
        int start = 0; // 0, 1, 2
        int end = arr.length - 1; // 3, 2, 1
        while (end > start) { //{10, 9, 8, 1}
            int temp = arr[start]; // 10, 9
            arr[start] = arr[end]; // 1, 8, 8, 1
            arr[end] = temp; // 1, 8, 9, 10
            start++;
            end--;
        }
    }
}

