package ru.ant.servlet;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.MessageFormat;

@WebServlet(name = "ConnectServlet", value = "/child")
public class ConnectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/children_section",
                    "postgres", "Biline4041608");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT name_child FROM child");

            while (resultSet.next())
                printWriter.println(resultSet.getString("name_child"));

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

