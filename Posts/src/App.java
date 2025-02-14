import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class App {
    public static void main(String[] args) throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("have a nice tripe");
        Comment c2 = new Comment("wow thats awesome");
        Post p1 = new Post(sdf.parse("21/04/2025 12:43:32"), "traveling to new zealand", "im going to visit this wonderful country", 12);
        
        p1.addComment(c1);
        p1.addComment(c2);

        System.out.println(p1.toString());
    }
}
