/* [BDatabase]
 *  Desc: To create Operationnal Database Link fast :)
 *  GitHub: https://github.com/lalBi94
 *  Created by: Bilal Boudjemline
 *  28/09/2022 at 20:35
 * */

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.mariadb.jdbc.*;

import javax.swing.*;

/**
 * <p>Methodes pour les interaction avec une base de donnees</p>
 * @author <a href="https://github.com/lalBi94">Bilal Boudjemline</a>
 * */

public class BDatabase {
    private final String db_host;
    private final String db_name;
    private final String db_user;
    private final String db_password;
    protected Connection sharedObject;
    private boolean status;

    /**
     * @param host Adresse de l'hote (jdbc:mariadb://+HOST)
     * @param db Nom de la base de donnees
     * @param user Utilisateur
     * @param password Mot de passe
     * */
    public BDatabase(String host, String db, String user, String password) {
        this.db_host = "jdbc:mariadb://" + host;
        this.db_name = db;
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
            this.status = true;
        } catch (SQLException e) {
            System.out.println("Erreur de liaison avec la base de donnees.");
        }
    }

    /**
     * Creer un tableau en parametre de fonction pour les requetes qui necessite des colonnes
     *
     * @param val Selecteur de colonnes
     * @return Retourne le tableau de colonnes a traite
     * */
    public String[] inlineArray(String... val) {
        String[] tmp = new String[val.length];

        for(int i = 0; i <= val.length-1; i++) {
            tmp[i] = val[i];
        }

        return tmp;
    }

    /**
     * Recuperer les informations d'un requete de type SELECT.
     *
     * @param request Le SELECT a faire (il y aura plus d'argument prochainement)
     * @return Les resultats engendre par la requete
     */
    public ArrayList<String> fetchAll(String request) {
        try {
            ArrayList<String> toReturn = new ArrayList<String>();
            ResultSet rs = this.sharedObject.prepareStatement(request).executeQuery();

            for(int i = 0; rs.next(); i++) {
                toReturn.add(i, String.valueOf(rs.getString(1)));
            }

            System.out.println("Succes: " + request);
            return toReturn;
        } catch(SQLException e) {
            System.out.println("Erreur de la requete : " + e);
            return null;
        }
    }

    /**
     * Insert une ligne dans une table.
     *
     * @param table La table
     * @param col   Tableau qui contient les colonnes d'affectation
     * @param value Valeur des colonnes
     * @return Retourne true si ca a reussit et false dans le cas inverse
     */
    public boolean insertRow(String table, String[] col, String[] value) {
        StringBuilder collumns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        Iterator<String> iteCol = Arrays.stream(col).iterator();
        Iterator<String> iteVal = Arrays.stream(value).iterator();

        collumns.append("(");
        while(iteCol.hasNext()) {
            collumns.append(iteCol.next()).append(", ");
        }
        collumns.setLength(collumns.length()-2);
        collumns.append(")");

        values.append("(");
        while(iteVal.hasNext()) {
            values.append("\"").append(iteVal.next()).append("\"").append(", ");
        }
        values.setLength(values.length()-2);
        values.append(")");

        String request = "INSERT INTO " + table + collumns + " VALUES" + values + ";";

        System.out.println(request);

        try {
            this.sharedObject.prepareStatement(request).executeQuery();
            System.out.println("Succes: " + request);
            return true;
        } catch(SQLException e) {
            return false;
        }
    }

    /**
     * Faire des requetes de type UPDATE SET (il y aura plus d'argument prochainement).
     *
     * @param request the request
     * @return the boolean
     */
    public boolean updateRow(String request) {
        try {
            this.sharedObject.prepareStatement(request).executeQuery();
            System.out.println("Succes: " + request);
            return true;
        } catch(SQLException e) {
            return false;
        }
    }

    /**
     * Recuperer l'objet Connection pour pouvoir utiliser ses methodes.
     *
     * @return L'objet Connection
     */
    public Connection getSharedObject() {
        return this.sharedObject;
    }

    /**
     * Recuperer l'utilisateur courant.
     *
     * @return L'utilisateur
     */
    public String getUser() {
        return this.db_user;
    }

    /**
     * Recuperer l'hote courant.
     *
     * @return L'hote
     */
    public String getHost() {
        return this.db_host;
    }

    /**
     * Recuperer le nom de la base de donnees.
     *
     * @return Le nom de la base de donnees
     */
    public String getDatabaseName() {
        return this.db_name;
    }

    public boolean getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return this.db_host + "\n" + this.db_name + "\n" + this.db_user + "\n";
    }
}