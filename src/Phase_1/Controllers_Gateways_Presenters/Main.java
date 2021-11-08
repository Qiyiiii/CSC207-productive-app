package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Group;
import Phase_1.Entity.User;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<User> users = new ArrayList<User>();
        HashMap<String, Group> groups = new HashMap<String, Group>();
        UserDataGateway udg = new UserDataGateway("userData.ser");
        GroupDataGateWay gdw = new GroupDataGateWay("groupData.ser");
        try{users = udg.readFromFile();}
        catch (IOException ioException){
            System.out.println("No User stored in the file");
        }
        try {
            groups = gdw.readFromFile();
        }catch (IOException ioException){
            System.out.println("No Group stored in the file");
        }
        UserManager um = new UserManager(users);
        GroupManager gm = new GroupManager(groups);
        MainPageController mp = new MainPageController(um, gm);
        System.out.println(um.login("2","2"));
        mp.run();
        try{udg.saveToFile(users);}
        catch (IOException ioException){
            System.out.println("No user data is stored in database");
        }
        try{gdw.saveToFile(groups);}
        catch (IOException ioException){
            System.out.println("No group data is stored in database");
        }
    }

}