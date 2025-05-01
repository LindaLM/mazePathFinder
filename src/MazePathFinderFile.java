import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MazePathFinderFile extends MazePathFinder{
    @Override
    ArrayList<String> readMaze() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter fiel with matrix");
        String filename = scanner.nextLine();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> stringMaze = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringMaze.add(data);
            }
            myReader.close();
            return stringMaze;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
