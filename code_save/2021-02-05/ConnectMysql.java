import java.sql.*;
public class ConnectMysql {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/2020_competion?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "ROOT";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT tyid, pid, content, ans FROM `210549999-exam-question`";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String tyid  = rs.getString("tyid");
                int pid = rs.getInt("pid");
                String content = rs.getString("content");
                int ans = rs.getInt("ans");
                // 输出数据
                System.out.print("题号: " + tyid);
                System.out.print(", 类型: " + pid);
                System.out.print(", 题目: " + content);
                System.out.print(" 选项: " + ans);
                System.out.println();
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch(Exception se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }// 处理 Class.forName 错误
        finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
