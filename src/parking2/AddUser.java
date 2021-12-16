static class Admin extends person {
        private int SpotCode;

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
