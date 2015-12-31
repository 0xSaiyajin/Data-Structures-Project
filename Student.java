package StudentPackage;

/**
 *
 * @author Syra */
public class Student


{
    private int student_id;
    private String student_name;
    private String student_surname;

    public Student(int S_id,String S_name,String S_sname)
    {
        
        student_id = S_id;
        student_name = S_name; 
        student_surname = S_sname; 
                    
    }
    
    public int getStudent_ID()
    {
        return student_id;  
    }
    
    public String getStudent_Name()
    {
        return student_name;
    }
    
    public String getStudent_Surname()
    {
        return student_surname;
    }
}
