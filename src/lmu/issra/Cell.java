package lmu.issra;

import java.util.ArrayList;
import java.util.Observable;

public class Cell extends Observable {


    private final Position position;
    private ArrayList<Position> posibilityPos = new ArrayList<>();


    private Player player;


    public Cell(Position position) {
        this.position = position;
        this.player=new Player();
        reset();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void reset() {

        setChanged();
        notifyObservers();
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return "" + getPosition();
    }

    public boolean equal() {
        return this.getPosition().getY() == this.getPosition().getX();

    }

    public boolean getNeighbor() {

        return this.getPosition().getY() + 1 == this.getPosition().getX();
    }
}
