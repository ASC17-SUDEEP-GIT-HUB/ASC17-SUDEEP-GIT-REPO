package org.demo.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdGenaratorUtil {

    public static String generateId(Connection conn, String prefix, String tableName, String idColumnName) {
        String query = "SELECT " + idColumnName + " FROM " + tableName + " ORDER BY " + idColumnName + " DESC LIMIT 1";

        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {
            if(resultSet.next()) {
                String lastId = resultSet.getString(1);
                int num = Integer.parseInt(lastId.substring(1) + 1);
                return prefix + String.format("%03d", num);
            }else {
                return prefix + "001";
            }
        }catch(SQLException s) {
            s.printStackTrace();
            return null;
        }
    }
}
