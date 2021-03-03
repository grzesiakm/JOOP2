public class StudentWFiIS3 extends Student {
    private StudentUSOS stud;

    public StudentUSOS getStudentUSOS(int year, String lecture1, String lecture2, String lecture3){
        return new StudentUSOS(){
            private String[] przedmioty;
            private int rok;
            {
                przedmioty = new String[] {lecture1, lecture2, lecture3};
                rok = year;
            }
            @Override
            public double srednia() {
                System.out.print("\t");
                return average();
            }

            @Override
            public void listaPrzedmiotow() {
                for(int i = 0; i < przedmioty.length; ++i)
                    System.out.println("\t\t" + (i+1) + ". " + przedmioty[i] + ": " + getGrade(i));
            }

            @Override
            public String toString() {
                return "[" + rok + "] ";
            }
        };
    }

    public StudentWFiIS3(String name, String month, int id, int year, String lecture1, double g1, String lecture2, double g2, String lecture3, double g3){
        super(name, month, id, g1, g2, g3);
        stud = getStudentUSOS(year, lecture1, lecture2, lecture3);
    }

    @Override
    public String toString(){
        return stud.toString() + super.toString();
    }

    public double srednia() {
        return stud.srednia();
    }

    public void listaPrzedmiotow() {
        stud.listaPrzedmiotow();
    }

}