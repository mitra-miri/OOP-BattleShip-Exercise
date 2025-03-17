public class Ship {

    private char name ;
    private int size;

    public Ship(char name, int size) {
        this.name = name;
        this.size = size;

    }


    public void setName(char name) {
        this.name = name;
    }
    public char getName() {
        return name;
    }

    public int getSize() {
        return size;
    }


}