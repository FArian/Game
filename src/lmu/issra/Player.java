package lmu.issra;

public class Player {
    private String name;
    private String green = "-fx-font: 10 arial; -fx-base: #b6e7c9;";
    private int id;
    private String status;
    private String color;


    public Player() {
        this.name =ColorType.GREEN.name();
        this.color = green;
        this.id = 0;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    private void update(){
        String green,black,white;
        green = "-fx-font: 10 arial; -fx-base: #b6e7c9;";
        black = "-fx-font: 10 arial; -fx-base: #404040;";
        white = "-fx-font: 10 arial; -fx-base: #9F9F9F;";
        if(this.getName().equals(ColorType.GREEN.name())){
            setColor(green);
            this.setId(0);
        }
        if(this.getName().equals(ColorType.BLACK.name())){
            setColor(black);
            this.setId(2);
        }
        if(this.getName().equals(ColorType.WHITE.name())){
            this.setId(1);
            setColor(white);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        update();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return " name: " +getName()+" id: "+getId();
    }
}
