import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<String> list = new ArrayList<>();

        list.add("Ana");
        list.add("Anna");
        list.add("Banana");
        list.add("Salamaleku");
        list.add("Ali");
        list.add("Marcelo");
        list.add(2, "Marcio");
        
        System.out.println(list.size());

        for (String x : list){
            System.out.println(x);
        }

        System.out.println("---------------------------");
        list.remove(2);
        list.remove("Ana");
        list.removeIf(x -> x.charAt(0) == 'M');
        
        for (String x : list){
            System.out.println(x);
        }
        
        System.out.println("---------------------------");
        System.out.println("Index of Marcelo: " + list.indexOf("Marcelo"));
        System.out.println("Index of Salamaleku: " + list.indexOf("Salamaleku"));
        
        System.out.println("---------------------------");
        List<String> result = list.stream()
        .filter(x -> x.charAt(0) == 'A')
        .collect(Collectors.toList());
        for (String x : result){
            System.out.println(x);
        }
        
        System.out.println("---------------------------");
        String name = list.stream()
        .filter(x -> x.charAt(0) == 'K')
        .findFirst()
        .orElse(null);
        System.out.println(name);
    }
}
