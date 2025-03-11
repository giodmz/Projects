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
        Set<String> set = new LinkedHashSet<>();

        set.add("TV");
        set.add("Smartphone");
        set.add("Notebook");

        set.removeIf(x -> x.charAt(0) == 'T');

        System.out.println(set.contains("TV"));

        for(String p : set) {
            System.out.println(p);
        }
    }
}
