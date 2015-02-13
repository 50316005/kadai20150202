package kadai;

import java.awt.Label;
import java.sql.ResultSet;
import java.sql.SQLException;

import lib.FrameSystemController;
import lib.FrameSystemView;

public class DBConsole_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Label ratio1, year1;
		double ratio;
		int year;
		ResultSet rs;
		MySQL mysql = new MySQL();
		rs = mysql.selectAll();
		FrameSystemController controller = new FrameSystemController();
		FrameSystemView frame = new FrameSystemView(controller);
		frame.setBounds(10,10,255,955);
		frame.setVisible(true);
		try {
			while(rs.next()){	
				ratio = rs.getDouble("ratio");	
				year = rs.getInt("year");	
				ratio1 = new Label(String.valueOf(ratio));
				year1 = new Label(String.valueOf(year));
				frame.add(new Label("平成："));
				frame.add(year1);
				frame.add(new Label("普及率（％）"));
				frame.add(ratio1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}