import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        boolean nextLine = true;

        while (nextLine) {
            String line = scanner.nextLine();
            if (line.isEmpty())
                nextLine = false;
            else
                lines.add(line);
        }

        System.out.println(lines);
    }
}