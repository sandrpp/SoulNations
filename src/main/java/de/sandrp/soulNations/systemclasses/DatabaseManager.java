package de.sandrp.soulNations.systemclasses;

import java.sql.*;

public class DatabaseManager {

    private static Connection connection;

    // Replace with your actual database credentials
    private static final String HOST = "162.55.253.235";
    private static final String PORT = "3375";
    private static final String DATABASE = "soulsmp";
    private static final String USERNAME = "soulplugins";
    private static final String PASSWORD = "Yu4!4Apu61li.OQOME?u@E3a7APOY!";

    public void connect() {
        try {
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            System.out.println("Connected to database!");
        } catch (SQLException e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Failed to close connection: " + e.getMessage());
        }
    }

    // Example: Get punishment type for a player
    public String getPunishmentType(String playerName) {
        String punishmentType = null;

        try {
            String query = "SELECT punishmentType FROM Punishments WHERE name = \"" + playerName + "\"";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                punishmentType = resultSet.getString("punishmentType");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error retrieving punishment type: " + e.getMessage());
        }

        return punishmentType;
    }




}
