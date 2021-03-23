public enum Direction{
    LEFT,
    RIGHT,
    UP,
    DOWN;

    private int x;
    private int y;

    Direction(){
        switch(name()){
            case "LEFT":
                x = -1;
                y = 0;
                break;
            case "RIGHT":
                x = 1;
                y = 0;
                break;
            case "UP":
                x = 0;
                y = 1;
                break;
            case "DOWN":
                x = 0;
                y = -1;
                break;
        }
    }

    public int getX(){ return x; }
    public int getY(){ return y; }

    @Override
    public String toString(){
        return "[" + x + ", " + y + "]";
    }
}