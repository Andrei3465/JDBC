import java.math.BigDecimal;

public class Main {
   public static void main(String[] args) {

       UserDataAccess userDataAccess = new UserDataAccess();
       User user1 = new User("ivan@mail.com", "ivan1234", "Ivan", "Ivanov", 2, new BigDecimal(3.3));
       User user2 = new User("ivan1@mail.com", "1ivan1234", "Ivan1", "Ivanov1", 2, new BigDecimal(3.3));
       User user3 = new User("ivan2@mail.com", "2ivan1234", "Ivan2", "Ivanov2", 2, new BigDecimal(3.3));
       User user4 = new User("ivan3@mail.com", "3ivan1234", "Ivan3", "Ivanov3", 2, new BigDecimal(3.3));
       User user5 = new User("ivan4@mail.com", "4ivan1234", "Ivan4", "Ivanov4", 2, new BigDecimal(3.3));
       User user6 = new User("ivan5@mail.com", "5ivan1234", "Ivan5", "Ivanov5", 2, new BigDecimal(3.3));
       User user7 = new User("ivan6@mail.com", "6ivan1234", "Ivan6", "Ivanov6", 2, new BigDecimal(3.3));

       userDataAccess.create(user1);

    }
}