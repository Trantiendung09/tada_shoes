package edu.poly.hello.entity;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class database_jdbc {
	
	private JdbcTemplate jdbctemplate;
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbctemplate=new JdbcTemplate(dataSource);
	}
    public void getnv()
    {
    	String sql="select * from nhanvien";
    	List<NhanVien> list=jdbctemplate.query(sql, new RowMapper<NhanVien>() { 
    		
			public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
    			NhanVien nv=new NhanVien();
    			nv.tennhanvien=rs.getString("tennhanvien");
    			nv.diachi=rs.getString("diachi");
				return nv;
			}
    		
    	});
    	for(NhanVien nv : list)
    	{
    		System.out.println("nhan vien: "+ nv.tennhanvien+" : "+nv.diachi);
    	}
    }
}
