package javaee.demo.angular2.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by yehoshuamatamorosvalverde on 1/3/17.
 */
public class DBConnection {

    List<Object> arguments = null;

    public void setArguments(ArrayList arguments){
        this.arguments = new ArrayList<Object>();
        this.arguments.add(arguments);
    }

    private List<Object> getArguments(){
        return this.arguments;
    }
    public static int mapParams(PreparedStatement ps, Object... args) throws SQLException {
        int i = 1;
        ArrayList argsMap = ((ArrayList)((List<Object>)args[0]).get(0));
        ResultSetMetaData ArgsNames = ps.getMetaData();
        for (Object args2 : argsMap) {
            if (args2 instanceof Date) {
                ps.setTimestamp(i++, new Timestamp(((Date) args2).getTime()));
            } else if (args2 instanceof Integer) {
                ps.setInt(i++, (Integer) args2);
            } else if (args2 instanceof Long) {
                ps.setLong(i++, (Long) args2);
            } else if (args2 instanceof Double) {
                ps.setDouble(i++, (Double) args2);
            } else if (args2 instanceof Float) {
                ps.setFloat(i++, (Float) args2);
            } else {
                ps.setString(i, (String) args2);
            }
            i++;
        }
        return 1;
    }

    public int execute(String statement) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/iservice","root","root");
            preparedStatement = con.prepareStatement(statement);
            int result = mapParams(preparedStatement,getArguments());
            if (result>0){
                ResultSet rs=preparedStatement.executeQuery();
                while(rs.next())
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
            return -1;
        }finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (con != null) {
                con.close();
            }

        }
        return 1;
    }
}
