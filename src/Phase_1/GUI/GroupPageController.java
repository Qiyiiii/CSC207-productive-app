package Phase_1.GUI;
import Phase_1.Entity.User;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserGroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GroupPageController implements Initializable{
    @FXML
    Button createButton;
    @FXML
    Button joinButton;
    @FXML
    Button leaveButton;
    @FXML
    Button viewButton;
    @FXML
    Button exitButton;
    @FXML
    Label remindLabel;
    GroupManager gm;
    UserManager um;
    String userId;

    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void createPushed() {
    }

    public void joinPushed(){}

    public void leavePushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LeaveGroupGUI.fxml"));
        Parent root = loader.load();
        LeaveGroupController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        mpc1.setUserId(userId);
        Scene scene = new Scene(root);
        Stage stg = new Stage();
        stg.setScene(scene);
        stg.show();

    }

    public void viewPushed(){
    }

    public void exitPushed(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserGroupManager umg = new UserGroupManager();
        if (umg.getMyGroups(um.getUserById(userId)).isEmpty()){
            remindLabel.setText("reminder: You haven't joined any group yet");
        }
        else {
            remindLabel.setText("you currently joined " + umg.getMyGroups(um.getUserById(userId)).size() + " group(s)");
        }
    }
}