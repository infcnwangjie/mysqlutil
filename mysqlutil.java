//关于端口 用户名密码在mysql中测试后填写
public class GetConnection {
    private Connection connection =null;
    //连接emptyclassroom数据库
    private String DatabaseName="emptyclassroom";

    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "数据库用户名";//默认root  
    public static final String password = "数据库密码"; //默认root 
    public Connection getCon(){
        String url = "jdbc:mysql://localhost:3306/"+DatabaseName+"?useUnicode=true&characterEncoding=utf8&useSSL=true";
        try{
            Class.forName("com.mysql.jdbc.Driver");

            connection=DriverManager.getConnection(url,user,password);
//          System.out.println(connection.getMetaData().getURL());

            return connection;
        }catch(Exception e){
            System.out.println("创建连接失败");
            e.printStackTrace();
        }
        return null;
    }
    public void closeCon(){
            try { 
                this.connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("关闭连接失败");
                e.printStackTrace();
            }
    }

//batch

public static void insertTest(Map<String,String> mysqlDbInfo){

Connection conn=getconnect(mysqldbinfo);

try{
PrepareStatement statement=conn.preparestatement("insert into test(Z004023,h00012,dfadf) values (?,?,?);");

for(int n=0;n<10;n++){

for(int i=0;i<3;i++){

statement.setString(i,'test'+i);
}
statement.addBatch();
}

statement.executeBatch();
statement.close();
conn.close();

}}

}


}
