public class StudentWFiIS1 extends Student implements StudentUSOS {
    private String[] przedmioty;
    private int rok;

    public StudentWFiIS1(String name, String month, int id, int year, String lecture1, double g1, String lecture2, double g2, String lecture3, double g3) {
        super(name, month, id, g1, g2, g3);
        this.rok = year;
        this.przedmioty = new String[] {lecture1, lecture2, lecture3};
    }

    @Override
    public String toString() {
        return "[" + rok + "] " + super.toString();
    }

    @Override
    public double srednia() {
        System.out.print("\t  ");
        return super.average();
    }

    @Override
    public void listaPrzedmiotow() {
        for (int i = 0; i < przedmioty.length; ++i){
            System.out.print("\t\t");
            System.out.println(i+1 + ". " + przedmioty[i] + ": " + getGrade(i));
        }
    }

}
