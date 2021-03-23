public enum Option {
    RESET,
    LEFT,
    RIGHT,
    UP,
    DOWN,
    EXIT;

    private char c;
    private String description;
    private Direction direction;

    Option(){
        switch(name()){
            case "RIGHT":
                c = 'l';
                description = "Przesuniecie w prawo";
                direction = Direction.RIGHT;
                break;
            case "LEFT":
                c = 'h';
                description = "Przesuniecie w lewo";
                direction = Direction.LEFT;
                break;
            case "UP":
                c = 'j';
                description = "Przesuniecie w gore";
                direction = Direction.UP;
                break;
            case "DOWN":
                c = 'k';
                description = "Przesuniecie w dol";
                direction = Direction.DOWN;
                break;
            case "RESET":
                c = '0';
                description = "Resetowanie gry";
                break;

            case "EXIT":
                c = 'q';
                description = "Zakonczenie gry";
                break;
        }
    }

    public char getChar() { return c; }
    public String getDescription() { return description; }
    public Direction getDirection() { return direction; }

    @Override
    public String toString(){
        if(c == '0' || c == 'q'){
            return "'" + getChar() + "' ==> opcja " + name() + ", opis: " + getDescription();
        }
        return "'" + getChar() + "' ==> opcja "+ name() + ", opis: " + getDescription() + ", wektor przesuniecia: " + getDirection();
    }
}