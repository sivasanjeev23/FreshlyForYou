package practice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Freshly {
	private Connection con;
	public Freshly() throws SQLException {
		con=Dbconnect.dbCon();
	}
	public String login(String email,String password) throws SQLException {
		String name=null;
		PreparedStatement pst= con.prepareStatement("select name from fuser where email=? and password=?");
		pst.setString(1, email);
		pst.setString(2, password);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
			name=rs.getString("name");
		return name;
	}
	public String fcat() throws SQLException{
		String cat="";int i=1;
		PreparedStatement pst= con.prepareStatement("select * from fprocat");
		ResultSet rs=pst.executeQuery();
		while(rs.next()) cat += rs.getString("name")+" "+i+++"\n";
		return cat;
		}
	
	public String fprod(int k) throws SQLException {
		String prod="";int i=1;
		PreparedStatement pst= con.prepareStatement("select * from prod where catid=?");
		pst.setInt(1,k);ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			if(i++==1) prod +="----------------------------\n"; 
				prod+=rs.getString("name")+" Select "+rs.getInt("pid")+"\n"+
				"Price : "+rs.getInt("price")+"\n"+
				"Available Stock(Kg) : "+rs.getInt("Quantity")+"\n"+
				"----------------------------"+
				"\n";
		}return prod;  }
	public int forder(String n,int k) throws SQLException {
		int r=0;
		PreparedStatement pst1=con.prepareStatement("select * from prod where pid=?");
		pst1.setInt(1, k);
		ResultSet rs=pst1.executeQuery();int cid=0,pid=0,price=0;String name="";
		while(rs.next()) {cid=rs.getInt("catid");
		pid=rs.getInt("pid");price=rs.getInt("price");name=rs.getString("name");}
		if(cid!=0) {
		PreparedStatement pst=con.prepareStatement("insert into forder values(?,?,?,?,?)");
		pst.setString(1,n);pst.setInt(2, cid);pst.setInt(3, pid);pst.setString(4,name);
		pst.setInt(5,price);r=pst.executeUpdate();
		if(r>0) {
			PreparedStatement pst2=con.prepareStatement("update prod set quantity=quantity-1 where pid=?");
			pst2.setInt(1,k);pst2.executeUpdate();}
	}
		return r;
	}
}
