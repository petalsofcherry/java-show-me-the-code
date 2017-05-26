/**
 * Created by luojingyu on 17-5-26.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;

public class Problem2 {
    public static Connection getConnection() {    //连接方法
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "123456");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(Connection conn, PreparedStatement ps, Statement st, ResultSet rs) {    //关闭方法
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Object[] getRandom() {
        Random random = new Random();
        Object[] values = new Object[200];

        HashSet<Integer> hashSet = new HashSet<Integer>();

        while (hashSet.size() < values.length) {
            hashSet.add(random.nextInt(600));
        }

        values = hashSet.toArray();
        return values;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        String sql1 = "CREATE TABLE problem " +
                "(id INTEGER," +
                "num INTEGER," +
                "primary key(id));";
        String sql2 = "INSERT INTO problem (id, num) values (?, ?);";
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
        }
        try {
            st.executeUpdate(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[] randomNum = getRandom();
        for (int i=1; i<=200; i++) {
            try {
                ps.setInt(1, i);
                ps.setInt(2, (Integer) randomNum[i-1]);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        closeAll(conn, ps, st, null);
    }
}
