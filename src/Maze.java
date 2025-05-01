import java.util.Arrays;

public class Maze {
    private int startRow;
    private int startCol;
    private int endRow;
    private int endCol;
    private MazeElement[][] elements;
    //private char[][] mazeChars;
    //private boolean[][] visited;
    // to set direction from which we come to maze element, so we can backtrack path to end point
    //private char[][] direction;

    public Maze(int startRow, int startCol, int endRow, int endCol, MazeElement[][] elements) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
        this.elements = elements;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getEndCol() {
        return endCol;
    }

    public MazeElement[][] getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return "Maze{" +
                "elements=" + Arrays.deepToString(elements) +
                '}';
    }
}
