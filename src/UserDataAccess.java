import java.sql.*;
import java.util.List;

public class UserDataAccess {

    public static final String URL = "jdbc:postgresql://localhost:5432/users";
    public static final String USER = "postgres";
    public static final String PASSWORD = "root";
    public static final String UPDATE_USER = "UPDATE users ( Set email = ?, \"password\" = ?, firstname = ?, lastname = ?, role = ?, rating = ?)";
    public static final String DELETE_BY_ID = "DELETE FROM users WHERE id = ?";
    public static final String FIND_BY_ID = "SELECT * FROM users WHERE id = ?";
    public static final String ADD_NEW_USER = "INSERT INTO users (email, password, firstname, lastname, role, rating) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL_USERS = "SELECT id, email, \"password\", firstname, lastname, role, rating FROM users";

    public void updateUser(User user) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getRole());
            statement.setBigDecimal(6, user.getRating());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAIL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User find(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setRole(resultSet.getInt("role"));
                user.setRating(resultSet.getBigDecimal("rating"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAll() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_USERS);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setRole(resultSet.getInt("role"));
                user.setRating(resultSet.getBigDecimal("rating"));
                return (List<User>) user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void create(User user1) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(ADD_NEW_USER);
            User user = new User();
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getRole());
            statement.setBigDecimal(6, user.getRating());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteById(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setLong(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAIL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
