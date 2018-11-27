package lmu.issra;

import java.util.ArrayList;

public class Field {
    private final int max_x; //Breite
    private final int max_y; //Höhe
    private Cell[][] board; // board besteht aus Cells


    public Field(int width, int height) {
        this.max_x = width;
        this.max_y = height;
        this.createBoard(max_x, max_y);
        cellsEqual();
    }

    private void createBoard(int max_x, int max_y) {

        this.board = new Cell[max_x][max_y];
        for (int x = 0; x < max_x; x++) {
            for (int y = 0; y < max_y; y++) {
                board[x][y] = new Cell(new Position(x, y));
            }
        }
    }

    public ArrayList<Cell> cellsEqual() {
        ArrayList<Cell> res = new ArrayList<>();
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                if (i == j) {
                    res.add(new Cell(new Position(i, j)));
                }
            }

        }
        System.out.println("CELL EQUALS : " + res);

        return res;

    }


    public ArrayList<Cell> getCells() {

        ArrayList<Cell> result = new ArrayList<Cell>(max_x * max_y);
        for (int i = 0; i < max_x; i++) {
            for (int j = 0; j < max_y; j++) {
                result.add(board[i][j]);
            }

        }
        return result;
    }
    public Cell getCell(Cell cell) {
        ArrayList<Cell> cells = new ArrayList<Cell>(max_x * max_y);
        for (int i = 0; i <cells.size() ; i++) {
            if(cell.equals(cells.get(i))) return cells.get(i);
        }
        return null;
    }

    public ArrayList<Cell> startposW() {
        ArrayList<Cell> startCells = new ArrayList<>();
        for (Cell c : getCells()) {
            if ((c.getPosition().getX() == max_x / 2 && c.getPosition().getY() == max_y / 2) ||
                    (c.getPosition().getX() == max_x / 2 - 1 && c.getPosition().getY() == max_y / 2 - 1))
                startCells.add(c);
        }

        return startCells;
    }



    public ArrayList<Cell> startposB() {
        ArrayList<Cell> startCells = new ArrayList<>();
        for (Cell c : getCells()) {

            if ((c.getPosition().getX() == max_x / 2 - 1 && c.getPosition().getY() == max_y / 2) ||
                    (c.getPosition().getX() == max_x / 2 && c.getPosition().getY() == max_y / 2 - 1))
                startCells.add(c);

        }

        return startCells;
    }

    public Cell getCell(Position pos) {
        if (pos.getX() >= 0 && pos.getX() < max_x && pos.getY() >= 0 && pos.getY() < max_y) {
            return board[pos.getX()][pos.getY()];
        } else {
            return null;
        }
    }


    public ArrayList<Cell> getNeighbors(Position position) {
        ArrayList<Cell> resualt = new ArrayList<Cell>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    Cell neighbor = this.getCell(new Position(position.getX() + i, position.getY() + j));
                    if (neighbor != null) {
                        resualt.add(neighbor
                        );
                    }
                }


            }

        }
        return resualt;
    }

    public int getWidth() {
        return max_x;
    }

    public int getHeight() {
        return max_y;
    }

}
