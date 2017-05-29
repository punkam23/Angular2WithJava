package javaee.demo.angular2.service;

import javaee.demo.angular2.DBConnection.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by yehoshuamatamorosvalverde on 26/2/17.
 */
@Service
public class LoginServiceImpl implements LoginService  {

    @Override
    public int isValidUser(String user, String password) {
        Integer result = null;
        DBConnection dbConnection = new DBConnection();
        ArrayList hm= new ArrayList();
        hm.add(user);
        hm.add(password);
        dbConnection.setArguments(hm);
        try{
            result = dbConnection.execute("SELECT * FROM users WHERE username = ? and password2 = ?;");
        }catch (SQLException ex){

        }
        return result;
    }
}
