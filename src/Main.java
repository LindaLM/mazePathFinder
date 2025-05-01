import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MazePathFinder mazeFinder = new MazePathFinderFile();
        ArrayList<String> stringMaze = mazeFinder.readMaze();
        System.out.println(stringMaze);
        Maze maze = mazeFinder.splitMaze(stringMaze);
        if (maze != null) {
            System.out.println(maze);
            mazeFinder.findPath(maze);
        }
    }
}