import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MazePathFinder mazeFinder = new MazePathFinderStdIn();
        ArrayList<String> stringMaze = mazeFinder.readMaze();
        Maze maze = mazeFinder.splitMaze(stringMaze);
    }
}