package lmu.issra;

import java.util.Observable;


public class Game extends Observable {

    private Field field;





    public Game() {
        this(12, 12);
    }

    public Game(int width, int height) {

        this.field = new Field(width, height);

    }

    public Field getBoard() {

        return field;
    }


    public Position posiblePos(){
        for (int i = 0; i <field.getHeight(); i++) {
            for (int j = 0; j <field.getWidth() ; j++) {
                //TODO

            }

        }
        return null;
    }
    public void updatePlayer(Player player,String name){
        player.setName(name);
        setChanged();
        notifyObservers();

    }
    public Player getPlayer(Cell cell){
        return cell.getPlayer();
    }

}


