import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        Iterator<String> iterator = strings.iterator();
//        List<String> strings2 = new ArrayList<String>();
        strings.add("xliu294@uottawa.ca");
        strings.add("xliu294@uottawa.ca");
        strings.add("550477200@qq.com");
        strings.add("4");
        strings.add("5");
        strings.add("6");
//        strings2.add("一");
//        strings2.add("二");
//        strings2.add("三");
//        strings2.add("四");
//        strings2.add("五");
//        strings2.add("六");



//        Iterator<String> iterator1 = strings2.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
//            System.out.println(iterator1.next());
        }
    }
}
