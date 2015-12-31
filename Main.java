/**
 *
 * @author Syra
 */
package StudentPackage;

import java.util.Scanner;
public class Main
{
    
    SinglyLinkedList<Student> list = new SinglyLinkedList<Student>();
    Tree tree = new Tree();
    private int a;
    
    public static void main(String[] args)
    {
        Main main = new Main();
        int blyad;
        Scanner Scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("0.Exit \n1.Add Student \n2.Remove Student\n3.Find Student\n"
                    + "4.List Student\n5.List distinct names\n6.Name Counts\n"
                    + "7.About\n");
           blyad = Scan.nextInt();
           
           switch(blyad)
           {
               case 0:
               {
                   System.out.print("Are you sure? \n1.Yes \n2.No \n");
                   Scan = new Scanner(System.in);
                   blyad = Scan.nextInt();
                   if(blyad == 1)
                       System.exit(0);
                   break;
               }
               case 1:
               {
                   Student Student1 = main.setStudent();
                   if(Student1 != null)
                    {
                        main.add(Student1);
                    }
                   else
                   {
                       System.out.println("Somethings gone wrong!");
                   }
                   break;
               }
               case 2:
                   System.out.println("Enter an ID for Remove Process:\n");
                   Scan = new Scanner(System.in);
                   main.remove(Scan.nextInt()); 
                   break;
               case 3:
                   System.out.println("Enter student's id:\n");
                   Scan = new Scanner(System.in);
                   main.findHop(Scan.nextInt());
                   break;
               
               case 4:
                   System.out.println("1.List\n2.Tree\n");
                   int option1 = Scan.nextInt();
                   if(option1 == 1)
                   {
                       main.printList();
                       break;
                   }
                   else if(option1 == 2)
                   {
                       System.out.println("1. Inorder\t2.\tPostorder\t3. Preorder");
                       Scan = new Scanner(System.in);
                       switch(Scan.nextInt())
                       {
                           case 1:
                                main.InOrder();
                                break;
                            case 2:
                                main.PostOrder();
                                break;
                            case 3:
                                main.PreOrder();
                                break;
                       }
                   }
               case 5:
                   main.printDistinct();
                   break;
               case 6:
                   main.printDistinctCount();
                   break;
               case 7:
                   System.out.println("Authors:\t140316012 - Ataberk Yavuzer\n"
                           + "\t\t140316038 - Furkan Kurşun\n");
           }
        }
    }
    public void remove(int S_id)
    {
        if(list.theSize() > 0)
        {
            list.remove(findIDNode(S_id));
            tree.removeNode(S_id);
        }
    }
    public void findHop(int id)
    {
        tree.clearHopCount();
        int temp = tree.NodeDataFind(id);
        if (temp != -1)
        {
            System.out.println("Tree\nWe found it! Hop Count = " +tree.getHops());
        }
        else
        {
            System.out.println("Tree\nSorry, we didn't find...");
        }
        Student student_temp = findIDNode(id);
        if (student_temp != null)
        {
            System.out.println("LinkedList\nWe found it! Hop Count = " +a);
            System.out.println("Student name =\t" + student_temp.getStudent_Name()+"\nStudent surname =\t" 
                    + student_temp.getStudent_Surname()+"\nStudent ID =\t" 
                    +student_temp.getStudent_ID()+"\n");
        }
        else
            System.out.println("LinkedList\nSorry, we didn't find...");
    }
    public Student setStudent()
    {
        String student_name;
        String student_lastname;
        int student_id;
        Scanner Scan1 = new Scanner(System.in);
        System.out.println("Enter a name: ");
        student_name = Scan1.next();
        System.out.println("Enter a lastname: ");
        student_lastname = Scan1.next();
        System.out.println("Enter an id: ");
        student_id = Scan1.nextInt();
        if(student_id > 0)
        {
            Student newStudent = new Student(student_id, student_name, student_lastname);
            return newStudent;
        }
        else 
            return null;
    }
    public void add(Student student)
    {
        list.add(student);
        tree.InsertNode(student.getStudent_ID());
    }

    public void printList()
    {
        Student student = null;
        for(int i=0;i < list.theSize(); i++)
        {
            student = list.getData(list.getNode(i));
            System.out.println(student.getStudent_ID());
        }
    }
    public Student findIDNode(int id)
    {
        a = 0;
        Student temp = list.getData(list.getNode(a));
        while(true && temp != null)
        {
            if(temp.getStudent_ID() == id)
                return temp;
            else
            {
                a++;
                temp = list.getData(list.getNode(a));
                if(temp == null)
                    break;
            }
        }
        return null;
    }
    public void InOrder()
    {
        tree.clearList();
        String[] splitter = tree.InOrder(tree.getRoot()).split(" ", 0);
        String[] a = new String[splitter.length];
        Student student;
        for(int i = 0; i < tree.size(); i++)
        {
            student = findIDNode(Integer.parseInt(splitter[i]));
            a[i] = student.getStudent_Name() + " " + student.getStudent_Surname()+ " " + student.getStudent_ID();
            System.out.println(a[i]);
        }
        System.out.println();
    }
    public void PostOrder()
    {
        tree.clearList();
        String[] splitter = tree.PostOrder(tree.getRoot()).split(" ", 0);
        String[] a = new String[splitter.length];
        Student student;
        for(int i = 0; i < tree.size(); i++)
        {
            student = findIDNode(Integer.parseInt(splitter[i]));
            a[i] = student.getStudent_Name() + " " + student.getStudent_Surname()+ " " + student.getStudent_ID();
            System.out.println(a[i]);
        }
        System.out.println();
    }
    public void PreOrder()
    {
        tree.clearList();
        String[] splitter = tree.PreOrder(tree.getRoot()).split(" ", 0);
        String[] a = new String[splitter.length];
        Student student;
        for(int i = 0; i < tree.size(); i++)
        {
            student = findIDNode(Integer.parseInt(splitter[i]));
            a[i] = student.getStudent_Name() + " " + student.getStudent_Surname()+ " " + student.getStudent_ID();
            System.out.println(a[i]);
        }
        System.out.println();
    }
    public void printDistinct()
    {
        if(tree.size() > 0)
        {
                tree.clearList();
                String[] splitter = tree.PostOrder(tree.getRoot()).split(" ", 0);
                String[] a = new String[splitter.length];
                String[] names = new String[splitter.length];
                int check = 0;
                int t = 0;
                Student student;
                for(int i = 0; i < splitter.length; i++)
                {
                    student = findIDNode(Integer.parseInt(splitter[i]));
                    a[i] = student.getStudent_Name();
                }
                names[0] = a[0];
                for(int i = 0; i < a.length; i++)
                {
                    for(int j = 0; j <= t; j++)
                    {
                        if(names[j].equals(a[i]))
                        {
                            check = 1;
                            break;
                        }
                    }
                    if(check == 0)
                    {
                        t++;
                        names[t] = a[i];
                    }
                    else
                        check = 0;
                }
                for(int i = 0; i <= t; i++)
                {
                    for(int j = 0; j <= t; j++)
                    {
                        if(names[j].compareTo(names[i]) > 0)
                        {
                            String holder = names[j];
                            names[j] = names[i];
                            names[i] = holder;
                        }
                    }
                }
                for(int i = 0; i <= t; i++)
                {
                    System.out.println(names[i]);
                }
                System.out.println();
            }

        }
    public void printDistinctCount()
    {
        if(tree.size() > 0)
        {
            tree.clearList();
            String[] splitter = tree.PostOrder(tree.getRoot()).split(" ", 0);
            String[] a = new String[splitter.length];
            String[] names = new String[splitter.length];
            int[] counter = new int[a.length];
            int check = 0;
            int t = 0;
            int counter_ctrl = 0;
            int while_ctrl = 0;
            Student student;
            for(int i = 0; i < tree.size(); i++)
            {
                student = findIDNode(Integer.parseInt(splitter[i]));
                a[i] = student.getStudent_Name();
            }
            for(int i = 0; i < a.length; i++)
            {
                for(int j = 0; j < a.length; j++)
                {
                    if(a[j].compareTo(a[i]) > 0)
                    {
                        String holder = a[j];
                        a[j] = a[i];
                        a[i] = holder;
                    }
                }
            }
            while(while_ctrl < a.length - 1 && a[while_ctrl] != null && a[while_ctrl + 1] != null)
            {
                if(a[while_ctrl].equals(a[(while_ctrl + 1)]))
                    counter[counter_ctrl]++;
                else
                    counter_ctrl++;
                while_ctrl++;
            }
            names[0] = a[0];
            for(int i = 0; i < a.length; i++)
            {
                for(int j = 0; j <= t; j++)
                {
                    if(names[j].equals(a[i]))
                    {
                        check = 1;
                        break;
                    }
                }
                if(check == 0)
                {
                    t++;
                    names[t] = a[i];
                }
                else
                    check = 0;
            }
            for(int i = 0; i <= t; i++)
            {
                System.out.println(names[i] + ": " + ++counter[i]);
            }
        }
    }
}
