import java.util.ArrayList;
import java.util.Scanner;

public class MazePathFinderStdIn extends MazePathFinder{

    @Override
    ArrayList<String> readMaze() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter maze matrix");
        ArrayList<String> lines = new ArrayList<>();
        boolean nextLine = true;
        while (nextLine) {
            String line = scanner.nextLine();
            if (line.isEmpty())
                nextLine = false;
            else
                lines.add(line);
        }
        return lines;
    }
}
