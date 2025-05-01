import java.util.ArrayList;

abstract class MazePathFinder {
    public MazePathFinder() {
    }

    abstract ArrayList<String> readMaze();

    // split string to chars and verify if maze is defined correctly
    public Maze splitMaze(ArrayList<String> stringMaze){
        int rows = stringMaze.size();
        int cols = stringMaze.get(0).length();
        int startRow = -1;
        int startCol = -1;
        int endRow = -1;
        int endCol = -1;

        char[][] mazeChars = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (stringMaze.get(i).length() == cols) {
                for (int j = 0; j < cols; j++) {
                    char mazeChar = stringMaze.get(i).charAt(j);
                    if (mazeChar == 'S') {
                        if (startRow == -1) {
                            mazeChars[i][j] = mazeChar;
                            startRow = i;
                            startCol = j;
                        } else {
                            System.out.println("Start 'S' is entered more than once!");
                            return null;
                        }
                    } else if (mazeChar == 'E') {
                        if (endRow == -1) {
                            mazeChars[i][j] = mazeChar;
                            endRow = i;
                            endCol = j;
                        } else {
                            System.out.println("End 'E' is entered more than once!");
                            return null;
                        }
                    } else if (mazeChar == '.' || mazeChar == 'X') {
                        mazeChars[i][j] = mazeChar;
                    } else {
                        System.out.println("Unsupported character!");
                        return null;
                    }
                }
            } else {
                System.out.println("Incorrect matrix format!");
                return null;
            }
        }
        if (startRow != -1 && endRow != -1){
            return new Maze(rows,cols,startRow,startCol,endRow,endCol,mazeChars);
        } else {
            System.out.println("Start 'S' or end 'E' not entered!");
            return null;
        }
    }

    public void findPath(Maze maze){

    }
}
