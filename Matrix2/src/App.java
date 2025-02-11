import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] matx = new int[x][y];

        for (int i = 0; i < matx.length; i++) {
            for (int j = 0; j < matx[i].length; j++) {
                matx[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the number to find its position: ");
        int number = sc.nextInt();
        boolean found = false;

 

        System.out.println("Type the number: ");
        
        
        // achar a posição na matrix
        for (int i = 0; i < matx.length; i++) {
            for (int j = 0; j < matx[i].length; j++) {
                
                if (matx[i][j] == number) {
                    System.out.println("Position: (" + i + ", " + j + ")");
                    if (j > 0) {
                        System.out.println("Left: (" + (matx[i][j - 1]) + ")");
                    }
                    if (j < matx[i].length - 1) {
                        System.out.println("Right: (" + (matx[i][j + 1]) + ")");
                    }
                    if (i > 0) {
                        System.out.println("Up: (" + (matx[i - 1][j]) + ")");
                    }
                    if (i < matx.length - 1) {
                        System.out.println("Down: (" + (matx[i + 1][j]) + ")");
                    }
                    found = true;
            } 
        }

        if (found == false) {
            System.out.println("Number not found in the matrix.");
        }

        
        
        
        sc.close();
    }
}
}