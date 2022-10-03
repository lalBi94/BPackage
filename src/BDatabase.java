/* [BDatabase]
 *  Desc: To create Operationnal Database Link fast :)
 *  GitHub: https://github.com/lalBi94
 *  Created by: Bilal Boudjemline
 *  28/09/2022 at 20:35
 * */

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import org.mariadb.jdbc.*;

// Syntax : jdbc:mariadb://

public class BDatabase {
    public String db_host;
    public String db_name;
    public String db_user;
    protected String db_password;
    protected Connection sharedObject;

    public BDatabase(String host, String user, String password, String database) {
        this.db_host = "jdbc:mariadb://" + host + "/";
        this.db_name = database;
        this.db_user = user;
        this.db_password = password;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.sharedObject = DriverManager.getConnection(this.db_host + this.db_name, this.db_user, this.db_password);
            System.out.println("Success Connected.");
        } catch (SQLException e) {
            System.out.println("Error with SQL connexion.\n" + e);
            System.exit(-1);
        }
    }

    public ArrayList<String> fetchAll(String request) {
        try {
            ArrayList<String> toReturn = new ArrayList<String>();
            ResultSet rs = this.sharedObject.prepareStatement(request).executeQuery();

            for(int i = 0; rs.next(); i++) {
                toReturn.add(i, String.valueOf(rs.getString(1)));
            }

            return toReturn;
        } catch(SQLException e) {
            System.out.println("Error with the statement : " + e);

            return null;
        }
    }

    public Connection getSharedObject() {
        return this.sharedObject;
    }

    public String getUser() {
        return this.db_user;
    }

    public String getHost() {
        return this.db_host;
    }

    public String getDatabaseName() {
        return this.db_name;
    }

    @Override
    public String toString() {
        return this.db_host + "\n" + this.db_name + "\n" + this.db_user + "\n";
    }
}