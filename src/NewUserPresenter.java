public class NewUserPresenter {
    public void Intro(){
        System.out.println("Welcome new adventurer! \n" +
                "Hope you can enjoy our app :)\n \n" +
                "Please type your preferred UserName");
    }
    public void invalidUserName(String u){
        System.out.println("Sorry, UserName " + u + "has been taken");
    }
    public void askPassword(String u){
        System.out.println("Congrats! UserName" + u + " is valid \n" +
                "Please type in your password: ");
    }
    public void completed(){
        System.out.println("Hurray! your account is created! \n" +
                "Have a nice trip!");
    }
}