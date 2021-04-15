package com.expensemanage.all;

import java.sql.Connection;
import java.sql.DriverManager;

public class Daoexpense {
private static Connection con1;

public static Connection getConnection() {

try {
Class.forName("com.mysql.jdbc.Driver");
con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/expense_data", "root", "root");
} catch (Exception e) {
System.out.println(e);
}
return con1;
}

}