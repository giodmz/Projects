import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        
        // hashset não garante a ordem, mas é rápido
        // Set<String> set = new HashSet<>();

        // treeset garante a ordem (nesse caso alfabetica)
        // Set<String> set = new TreeSet<>();

        // linkedhashset garente a ordem dos elementos na ordem que foram inseridos
        // Set<String> set = new LinkedHashSet<>();

        // set.add("TV");
        // set.add("Smartphone");
        // set.add("Notebook");

        // set.removeIf(x -> x.charAt(0) == 'T');

        // System.out.println(set.contains("TV"));

        // for(String p : set) {
        //     System.out.println(p);
        // }

        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        //uniao
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        //intersecao
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);

        //diff
        Set<Integer> e= new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);

    }
}
