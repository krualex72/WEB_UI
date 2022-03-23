package HomeWork7;

import HomeWork7.entity.WeatherData;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepositorySQLiteImpl implements DatabaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE if not exists 'weather' ('id' INTEGER PRIMARY KEY AUTOINCREMENT," +
            "'city' TEXT NOT NULL,'date_time' TEXT NOT NULL,'weather_text' TEXT NOT NULL, 'temperature' REAL NOT NULL);";

    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";

    public DatabaseRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    public void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            System.out.println("Данные записаны в базу данных!!!\n");
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<WeatherData> getAllSavedData() throws IOException, SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            connection.createStatement().execute(createTableQuery);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weather");
            ArrayList<WeatherData> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString(2) + " | " +
                                resultSet.getString(3) + " | " +
                                resultSet.getString(4) + " | " +
                                resultSet.getDouble(5) + " | "
                );
                arrayList.add(new WeatherData(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDouble(5)));

            }
            System.out.println("");
            return arrayList;
        } catch (SQLException throwables){
                throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object"); /// тут завтра думать - надо добавить retunn перед сфеср
        //throw new IOException("Not implemented exception");
    }

}

