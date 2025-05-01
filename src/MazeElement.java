public class MazeElement {
    private char mazeChar;
    //to set direction from which we come to maze element, so we can backtrack path to end point
    private char direction;
    private boolean visited;

    public MazeElement(char mazeChar) {
        this.mazeChar = mazeChar;
        this.visited = false;
        this.direction = 'n';
    }

    public char getMazeChar() {
        return mazeChar;
    }

    public char getDirection() {
        return direction;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "" + mazeChar;
    }
}
