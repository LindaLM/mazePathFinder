public class Maze {
    private int rows;
    private int cols;
    private int startRow;
    private int startCol;
    private int endRow;
    private int endCol;
    private char[][] mazeChars;
    private boolean[][] visited;
    // to set direction from which we come to maze element, so we can backtrack path to end point
    private char[][] direction;

    public Maze(int rows, int cols, int startRow, int startCol, int endRow, int endCol, char[][] mazeChars) {
        this.rows = rows;
        this.cols = cols;
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
        this.mazeChars = mazeChars;
        this.visited = new boolean[rows][cols];
        this.direction = new char[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
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

    public char[][] getMazeChars() {
        return mazeChars;
    }

    public boolean[][] getVisited() {
        return visited;
    }

    public char[][] getDirection() {
        return direction;
    }
}
