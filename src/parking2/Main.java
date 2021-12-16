package parking2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
        Admin add = new Admin();
        add.AddUser(UserName, Password, RoleID, shiftID);
        add.AddSpot("F5FH");

    }

    static class Admin extends person {
        private int SpotCode; hh

        public void AddUser(String UserName, String Password, int RoleID, int shiftID) {
            File file = new File("AddUser.txt");
            FileWriter fr = null;
            try {
                fr = new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.write(RoleID + " " + UserName + " " + Password + " " + shiftID + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public boolean AddSpot(String SpotCode) throws Exception {
            boolean status = false;
            File file = new File("AddSpot.txt");
            Scanner input = new Scanner(file);
            File file2 = new File("AddSpotTemp.txt");
            PrintWriter tmp = new PrintWriter(file2);

            while (input.hasNext()) {
                SpotCode = input.next();

                if (SpotCode.equals(this.SpotCode)) {
                    tmp.print(SpotCode + " ");

                    status = true;
                } else {
                    tmp.print(SpotCode + " ");

                }
            }
            tmp.close();
            Scanner input2 = new Scanner(file2);
            PrintWriter main = new PrintWriter(file);

            while (input2.hasNext()) {
                SpotCode = input2.next();
                main.print(SpotCode + " ");
            }
            main.close();
            return status;
        }
    }

    class customer extends person {
    }

    class operator extends person {
    }
}
