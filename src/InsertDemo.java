import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class InsertDemo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/laptop?serverTimezone=UTC";
        String user = "root";
        String password = "Queen!&(20)";

        Connection connection = null;
        Statement statement = null;
        try{
            connection= DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();

            LaptopInfo laptop = new LaptopInfo(115,"ASUS",1100.99,"windows");
            String query2 = "insert into laptopinfo(id,name,price,operating_system)"+"values("+laptop.getId()+", '"+laptop.getName()+"',"+laptop.getPrice()+",'"+laptop.getOperatingSystem()+"');";
            statement.execute(query2);
            System.out.println("laptop added");
            String query = "update laptopinfo set price = 1300.99 where name = 'macbookpro'";
            statement.execute(query);
            System.out.println("information updated!!!");

            String query1 = "delete from laptopinfo where id = 113";
            statement.execute(query1);
            System.out.println("Deleted successfully");

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something went wrong with the connection");
        }
        finally {
            statement.close();
            connection.close();
        }
    }
}
