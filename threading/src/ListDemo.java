import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        System.out.println("Starting demo list");


        String[] myArray = {"1", "2", "5"};

        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 6, 7, 8));
        arrayList.add(1);
        System.out.println(arrayList);


        LinkedList<String> linkedList = new LinkedList<>(List.of("1", "8"));
        linkedList.addLast("99");
        linkedList.add("10");
        linkedList.addFirst("50");
        System.out.println(linkedList);
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.pollLast());

    }
}
