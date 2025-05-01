import java.util.*;

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

        MazeElement[][] mazeChars = new MazeElement[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (stringMaze.get(i).length() == cols) {
                for (int j = 0; j < cols; j++) {
                    char mazeChar = stringMaze.get(i).charAt(j);
                    if (mazeChar == 'S') {
                        if (startRow == -1) {
                            mazeChars[i][j] = new MazeElement(mazeChar);
                            startRow = i;
                            startCol = j;
                        } else {
                            System.out.println("Start 'S' is entered more than once!");
                            return null;
                        }
                    } else if (mazeChar == 'X') {
                        if (endRow == -1) {
                            mazeChars[i][j] = new MazeElement(mazeChar);
                            endRow = i;
                            endCol = j;
                        } else {
                            System.out.println("End 'X' is entered more than once!");
                            return null;
                        }
                    } else if (mazeChar == '.' || mazeChar == '#') {
                        mazeChars[i][j] = new MazeElement(mazeChar);
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
            return new Maze(startRow,startCol,endRow,endCol,mazeChars);
        } else {
            System.out.println("Start 'S' or end 'E' not entered!");
            return null;
        }
    }

    public void findPath(Maze maze){
        char[] directions = {'u','d','l', 'r'};
        int[] rowShift = {-1, 1, 0, 0};
        int[] colShift = {0, 0, -1, 1};
        // queue of elements we need to visit
        Queue<int[]> queue = new LinkedList<>();
        //first add start to queue and set it to visited
        int startRow = maze.getStartRow();
        int startCol = maze.getStartCol();
        MazeElement[][] elements = maze.getElements();
        MazeElement start = elements[startRow][startCol];
        start.setVisited(true);
        queue.add(new int[]{startRow,startCol});
        //go through maze
        while (!queue.isEmpty()){
            int[] pos = queue.remove();
            //MazeElement element = elements[pos[0]][pos[1]];
            MazeElement element;
            int row;
            int col;
            for (int i = 0; i < 4; i++) {
                row = pos[0] + rowShift[i];
                col = pos[1] + colShift[i];
                //System.out.println("next row: " + row + ", next col: " + col);
                if (row >= 0 && col >= 0 && row < elements.length && col < elements[0].length) {
                    element = elements[row][col];
                    if (element.getMazeChar() != '#' && !element.isVisited()) {
                        element.setVisited(true);
                        element.setDirection(directions[i]);
                        queue.add(new int[]{row, col});
                        if (element.getMazeChar() == 'X') {
                            break;
                        }
                    }
                }
            }
        }
        int endRow = maze.getEndRow();
        int endCol = maze.getEndCol();
        MazeElement element = elements[endRow][endCol];
        if (element.isVisited()){
            ArrayList<Character> reverse = new ArrayList<>();
            reverse.add('d');
            reverse.add('u');
            reverse.add('r');
            reverse.add('l');
            ArrayList<Character> path = new ArrayList<>();
            int row = endRow;
            int col = endCol;
            while (element.getMazeChar() != 'S'){
                 char dir = element.getDirection();
                 path.add(dir);
                 int dirIndex = reverse.indexOf(dir);
                 row = row + rowShift[dirIndex];
                 col = col + colShift[dirIndex];
                 element = elements[row][col];
            }
            Collections.reverse(path);
            System.out.println(path);
        } else {
            System.out.println("Path not find.");
        }
    }
}
