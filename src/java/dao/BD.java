/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

    public static Connection getConexao()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/automovel", "root", "");
        return conexao;
    }

    public static void fecharConexao(Connection conexao) throws SQLException {
        try {
            if (!conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
}