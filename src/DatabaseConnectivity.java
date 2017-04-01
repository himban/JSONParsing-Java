import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Himanshu on 01-04-2017.
 */
public class DatabaseConnectivity {

    public static void main(String[] args) {

        Connection connection;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://db-test.cjbcgb22au7o.us-east-1.rds.amazonaws.com:3306/db_test_mysql", "admin_test", "h1_rohini");
            String url = "INSERT INTO `innodb`.`students` (`id`, `name`, `percentage`) VALUES ('3', 'Anil', '78');";  // Insert a student into the table
            Statement statement = connection.createStatement();
            statement.execute(url);
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }


}
