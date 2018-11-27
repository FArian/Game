package lmu.issra;


import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.logging.Logger;

/**
 * * @Author Farhad Arian
 * View
 */
public class View extends GridPane {



    public static final int scale = 30;
    Game game;
    private static Logger LOGGER = Logger.getGlobal();

    public View(Game game) {
        super();
        String black, white, green;
        green = "-fx-font: 10 arial; -fx-base: #b6e7c9;";
        black = "-fx-font: 10 arial; -fx-base: #404040;";
        white = "-fx-font: 10 arial; -fx-base: #9F9F9F;";
        this.game = game;


        // Board
        GridPane boardView = new GridPane();
        for (Cell cell : game.getBoard().getCells()) {
            Position pos = cell.getPosition();
            Button btn = new Button();
            btn.setMinWidth(scale);
            btn.setMinHeight(scale);
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);

            btn.setOnAction(event -> {
                btn.setText(cell.getPosition().toString());

            });
            //
            boolean bolW = game.getBoard().startposW().contains(cell);
            boolean bolB = game.getBoard().startposB().contains(cell);
            if (bolW){
                btn.setStyle(white);
                game.updatePlayer(cell.getPlayer(), ColorType.WHITE.name());
                LOGGER.info(cell.getPlayer().toString());


            }

            if (bolB){
                btn.setStyle(black);
                game.updatePlayer(cell.getPlayer(),ColorType.BLACK.name());
                LOGGER.info(cell.getPlayer().toString());

            }





            boardView.add(btn, pos.getX(), pos.getY());


        }

        this.add(boardView, 0, 0);

    }


}

