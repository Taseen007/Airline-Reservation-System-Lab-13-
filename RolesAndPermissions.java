public class RolesAndPermissions {
    private String[][] adminUserNameAndPassword = new String[10][2];

    public int isPrivilegedUserOrNot(String username, String password) {
        for (int i = 0; i < adminUserNameAndPassword.length; i++) {
            if (adminUserNameAndPassword[i][0] != null && adminUserNameAndPassword[i][0].equals(username) && adminUserNameAndPassword[i][1].equals(password)) {
                return 1;
            }
        }
        if (username.equals("root") && password.equals("root")) {
            return 0;
        }
        return -1;
    }

    public void addAdminUser(String username, String password) {
        for (int i = 0; i < adminUserNameAndPassword.length; i++) {
            if (adminUserNameAndPassword[i][0] == null) {
                adminUserNameAndPassword[i][0] = username;
                adminUserNameAndPassword[i][1] = password;
                break;
            }
        }
    }
}