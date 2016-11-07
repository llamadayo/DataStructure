public class Student
{
    private int student_id;
    private String name;
    private int grade;

    public Student(int id, String n, int g)
    {
        student_id = id;
        name = n;
        grade = g;
    }

    public int getID()
    {
        return student_id;
    }

    public String getName()
    {
        return name;
    }

    public int getGrade()
    {
        return grade;
    }

    public void rename(String n)
    {
        name = n;
    }

    public void changingScore(int score)
    {
        grade = score;
    }

    public void showDetails()
    {
        System.out.println(this.student_id+this.name+this.grade);
    }
}
