import java.util.*;

public class exp1 {
    public static void main(String[] args) {
        int emid =0;
        System.out.println("enter the emp id: ");
        Scanner sc = new Scanner(System.in);
        emid = sc.nextInt();
        switch (emid)
        {
            case 1001 :
                System.out.println(findsalary(1001,"Ashish","01/04/2009",'e',"R&D",20000,8000,3000));
                break;
            case 1002:
                System.out.println(findsalary(1002,"Sushma","02/07/2009",'c',"PM",30000,1200,9000));
                break;
            case 1003:
                System.out.println( findsalary(1003,"Rahul","12/11,2008",'k',"Acct",10000,8000,1000));
                break;
            case 1004:
                System.out.println(findsalary(1004,"Chahat","29/01/2023",'c',"PM",12000,6000,2000));
                break;
            case 1005:
                System.out.println(findsalary(1005,"aditya", "31/03/2023",'e', "R&D", 1000,400,200));
            default:
                System.out.println("There is no employee with empid :" + emid);
        }

    }

    static int findsalary(int EmpNo, String name, String joindate, char desigCode, String dept, int basic, int hra, int it)
    {

        int da=0;
        String designation=null;
        if (desigCode=='e')
        {
            da=20000;
            designation="engineer";
        } else if (desigCode=='c')
        {
            da=32000;
            designation="consultant";
        } else if (desigCode=='m')
        {
            da=40000;
            designation="manager";
        }else if (desigCode=='k')
        {
            da=12000;
            designation="Clerk";
        }else if (desigCode=='r')
        {
            da=15000;
            designation="Receptionist";
        }

        int salary = basic+hra+da-it;
        System.out.println("emp id\t"+"emp name\t"+"dept\t"+"\tdesignation\t\t"+"salary\t");
        System.out.println(EmpNo+"\t"+name+"\t\t"+dept+"\t\t"+designation+"\t\t"+salary+"\t");


        return 0;
    }
}