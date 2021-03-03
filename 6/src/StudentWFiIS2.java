public class StudentWFiIS2 implements StudentUSOS {
    private String[] przedmioty;
    private int rok;
    private Student stud;

    public StudentWFiIS2(String name, String month, int id, int year, String lecture1, double g1, String lecture2, double g2, String lecture3, double g3){
        this.stud = new Student(name, month, id, g1, g2, g3);
        this.rok = year;
        this.przedmioty = new String[] {lecture1, lecture2, lecture3};
    }

    @Override
    public String toString() {
        return "[" + rok + "] " + stud.toString();
    }

    @Override
    public double srednia() {
        System.out.print("\t  ");
        return stud.average();
    }

    @Override
    public void listaPrzedmiotow() {
        for (int i = 0; i < przedmioty.length; ++i) {
            System.out.print("\t\t");
            System.out.println(i+1 + ". " + przedmioty[i] + ": " + stud.getGrade(i));
        }
    }

}
