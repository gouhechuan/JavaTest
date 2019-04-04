package charlie.mybatis.Day01;

import javassist.bytecode.stackmap.BasicBlock;
import jdk.nashorn.internal.ir.WhileNode;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {
    @Test
    public void TestJdbc() {
        Connection connection = null;
        PreparedStatement statement= null;
        ResultSet resultSet= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/myjavadb", "root", "1234");
            connection.setAutoCommit(false);
            String sql="select * from UserInfo where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,4);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
            connection.commit();
        } catch (Exception e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        finally {
            try {
                if(resultSet!=null) resultSet.close();
                if(statement!=null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    @Test
    public void testJdbcUpdate() {
        Connection connection = null;
        PreparedStatement statement= null;
        ResultSet resultSet= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/myjavadb", "root", "1234");
            connection.setAutoCommit(false);
            String sql="update UserInfo set point=point+1 where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,1);
            int is = statement.executeUpdate();

            statement.setInt(1,1);
            statement.executeUpdate();


            System.out.println(is);
            connection.commit();
        } catch (Exception e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        finally {
            try {
                if(resultSet!=null) resultSet.close();
                if(statement!=null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }



    @Test
    public void testJdbcforSqlServerUpdate() {
        Connection connection = null;
        PreparedStatement statement= null;
        ResultSet resultSet= null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=TestDB", "sa", "1");
            connection.setAutoCommit(false);
            String sql="update TranTestTable set Age=Age+1 where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,1);
            int is = statement.executeUpdate();

            statement.setInt(1,1);
            statement.executeUpdate();


            System.out.println(is);
            connection.commit();
        } catch (Exception e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        finally {
            try {
                if(resultSet!=null) resultSet.close();
                if(statement!=null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
