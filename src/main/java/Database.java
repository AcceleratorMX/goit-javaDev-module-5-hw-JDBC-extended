import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static Database DATABASE = new Database();
    private String url;
    private Connection connection;

    private Database() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("settings.properties"));
            this.url = props.getProperty("database_url");
            this.connection = DriverManager.getConnection(url);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (DATABASE == null) {
            DATABASE = new Database();
        }
        return DATABASE;
    }

    public Connection getConnection() {
        return connection;
    }
}