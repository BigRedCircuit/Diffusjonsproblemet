package gui;

public class Water {
    private Location location;

    public Water(Location location){
        this.location = location;
    }

    public int getYIndex(){
        return location.getRow();
    }

    public int getXIndex(){
        return location.getCol();
    }
}
