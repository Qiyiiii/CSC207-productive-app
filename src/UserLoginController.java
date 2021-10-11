import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class UserLoginController {
    public final UserLoginPresenter nlp = new UserLoginPresenter();
    public void run(){BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nlp.welcomePage();
        UserManager um = new UserManager();
        try{
            nlp.typeUserId();
            String userId = reader.readLine();
            nlp.typePassword();
            String password = reader.readLine();
            boolean stop = false;
            while (!stop) {
                if (um.login(userId, password)){
                    nlp.success(userId);
                    break;
                }
                else
                {nlp.fail();
                nlp.again();
                String s = reader.readLine();
                if (!s.equals("0")){
                    stop = true;
                }
                else {
                    nlp.typeUserId();
                    userId = reader.readLine();
                    nlp.typePassword();
                    password = reader.readLine();
                }
            }

        }} catch (IOException e){
            System.out.println("Please type a valid number");
        }

}}
