package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Alarm.AlarmStarter;
import Phase_1.Entity.NormalUser;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.NotificationManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Objects;

public class UserPageController {
    private String userId;
    private final UserPagePresenter upp;
    private UserManager um;
    private GroupPageController gpc;
    private CategoryPageController cpc;
    private NotificationPageController npc;
    private NotificationManager nm = new NotificationManager();

    public UserPageController(UserManager um, String userId, GroupManager gm) {
        this.userId = userId;
        this.upp = new UserPagePresenter(um.displayUserDetail(um.getUserById(userId)));
        this.um = um;
        this.gpc = new GroupPageController(userId, um, gm);
        this.cpc = new CategoryPageController(userId, um, nm);

        this.npc = new NotificationPageController(this.nm);

        nm.setAlarmMenu(new AlarmStarter());
        Thread notificationSystem = new Thread(nm);
        notificationSystem.start();
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        while (!Objects.equals(input, "4")) {
            upp.userProfilePage();
            upp.availableOptions();
            input = reader.readLine();

            if (input.equals("1")) {      // My Group
                gpc.run();
            }
            if (input.equals("2")) {      // My Category
                cpc.run();
            }
            if (input.equals("3")) {      // My Category
                npc.run();
            }
        }

    }

}
