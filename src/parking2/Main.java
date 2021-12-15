/*package parking2;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.File;
zzclass person {
    protected String UserName;
    protected String Password;
    protected int RoleID;
    protected int ID;

}
public class Main extends person {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
       Admin add = new Admin();
        System.out.println("Enter 1.for Admin\n 2.for operator\n 3.for customer\n");
        int operation = scan.nextInt();
        System.out.println("Enter UserName");
         UserName = scan.next();
        System.out.println("Enter Password");
        String Password = scan.next();
        System.out.println("Enter RoleID");
        int RoleID = scan.nextInt();
        System.out.println("Enter ID");
        int shiftID = scan.nextInt();

        add.AddUser(UserName,Password,RoleID,shiftID);


    }

    class Customer extends person {
        private String plateNumbre;
        public String Ticket ;

        public Customer(String plateNumbre){
            this.plateNumbre = plateNumbre;
        }
    }

    class operator extends person {
    }

      class  Admin extends person  {
        private String SpotCode;


        public void AddUser (String UserName , String Password, int RoleID, int shiftID){
            File file = new File("AddUser.txt");
            FileWriter fr = null;
            try {
                fr = new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.write(RoleID + " " + UserName + " " + Password + " " + shiftID+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public boolean AddSpot (String SpotCode)throws Exception {
            File file = null;

            file = new File("AddSpot.txt");
            Scanner input = new Scanner(file);
            File file2 = new File("AddSpot.txt");
            PrintWriter tmp = new PrintWriter(file2);
            boolean Empty = false;
            while (input.hasNext()) {
                SpotCode = input.next();}


                if (this.SpotCode == SpotCode) {
                    tmp.print(SpotCode + " ");
                    Empty = true;
                } else {
                    tmp.print(SpotCode + " ");
                    tmp.print(Empty + " ");
                }

            tmp.close();

            Scanner input2 = new Scanner(file2);
            PrintWriter main = new PrintWriter(file);

            while (input2.hasNext()) {
                SpotCode = input2.next();
                Empty = Boolean.parseBoolean(input2.next());

                main.print(SpotCode + " ");
                main.print(Empty + " ");

            }
            main.close();
            return Empty;
        }

            }
        }*/
package parking2;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
class person {
    protected String UserName;
    protected String Password;
    protected int RoleID;
    protected int ID;
}
public class Main extends person {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 1.for Admin\n 2.for operator\n 3.for customer\n");
        int operation = scan.nextInt();
        System.out.println("Enter UserName");
        String UserName = scan.next();
        System.out.println("Enter Password");
        String Password = scan.next();
        System.out.println("Enter RoleID");
        int RoleID = scan.nextInt();
        System.out.println("Enter ID");
        int shiftID = scan.nextInt();
        Admin add= new Admin();
        add.AddUser(UserName,Password,RoleID,shiftID);
add.AddSpot(101);

    }

    class customer extends person {
    }

    class operator extends person {
    }

    static class  Admin extends person  {
        private int SpotCode;

        public void AddUser (String UserName , String Password, int RoleID, int shiftID){
            File file = new File("AddUser.txt");
            FileWriter fr = null;
            try {
                fr = new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.write(RoleID + " " + UserName + " " + Password + " " + shiftID+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public boolean AddSpot (int SpotCode)throws Exception {
            boolean status=true;
            File file = new File("AddSpot.txt");
            FileWriter fr = null;
            try {
                fr = new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.write(SpotCode + " " + status+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
return status;
            public boolean UpdateUser(String UserName, int roleId) throws Exception {
                String userName;
                int id;
                String password;
                int shiftId;
                File file = new File("D:\\pl2 project\\data.txt");

                Scanner input = new Scanner(file);
                File file2 = new File("D:\\pl2 project\\tmp.txt");
                PrintWriter tmp = new PrintWriter(file2);
                boolean found = false;

                while (input.hasNext()) {
                    id = input.nextInt();
                    userName = input.next();
                    password = input.next();
                    shiftId = input.nextInt();

                    if (id == roleId) {
                        tmp.print(id + " ");
                        tmp.print(UserName + " ");
                        tmp.print(password + " ");
                        tmp.println(shiftId);
                        found = true;
                    } else {
                        tmp.print(id + " ");
                        tmp.print(userName + " ");
                        tmp.print(password + " ");
                        tmp.println(shiftId);
                    }
                }
                tmp.close();

                Scanner input2 = new Scanner(file2);
                PrintWriter main = new PrintWriter(file);

                while (input2.hasNext()) {
                    id = input2.nextInt();
                    userName = input2.next();
                    password = input2.next();
                    shiftId = input2.nextInt();

                    main.print(id + " ");
                    main.print(userName + " ");
                    main.print(password + " ");
                    main.println(shiftId);
                }
                main.close();

                return found;
            }
            public boolean AddSpot (int SpotCode)throws Exception {
                File file = null;

                file = new File("AddSpot.txt");
                Scanner input = new Scanner(file);
                File file2 = new File("AddSpotTemp.txt");
                PrintWriter tmp = new PrintWriter(file2);
                boolean Empty = false;
                while (input.hasNext()) {
                    SpotCode = input.nextInt();}


                if (this.SpotCode == SpotCode) {
                    tmp.print(SpotCode + " ");
                    Empty = true;
                } else {
                    tmp.print(SpotCode + " ");
                    tmp.print(Empty + " ");
                }

                tmp.close();

                Scanner input2 = new Scanner(file2);
                PrintWriter main = new PrintWriter(file);

                while (input2.hasNext()) {
                    SpotCode = input2.nextInt();
                    Empty = Boolean.parseBoolean(input2.next());

                    main.print(SpotCode + " ");
                    main.print(Empty + " ");

                }
                main.close();
                return Empty;
            }
    }
}}






