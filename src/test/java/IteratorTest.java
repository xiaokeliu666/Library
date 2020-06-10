import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();

        strings.add("1");
        strings.add("2");
        strings.add("3");

        Iterator<String> iterator = strings.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
