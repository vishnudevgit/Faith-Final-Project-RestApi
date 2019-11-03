package com.faith.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

import com.faith.model.VustVendorDet;

public class VustVendordetDao implements IVustVendordetDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<VustVendorDet> getAllVendordetDetails() {
		return template.query(
				"select v.vdid,v.vdname,v.vdaddr,v.vdlocation,v.vdservice,v.vdpin,c.cpid,c.cpVdid,c.cpname,c.cpdepartment,c.cpemail,c.cpphone from ustvendor v join ustcontact c on(v.vdid=c.cpvdid) where v.isactive='Y' order by v.vdid desc ",
				new RowMapper<VustVendorDet>() {

					public VustVendorDet mapRow(ResultSet rs, int row) throws SQLException {

						VustVendorDet vd = new VustVendorDet();
						vd.setVdId(rs.getInt(1));
						vd.setVdName(rs.getString(2));
						vd.setVdAddr(rs.getString(3));
						vd.setVdLocation(rs.getString(4));
						vd.setVdService(rs.getString(5));
						vd.setVdPin(rs.getInt(6));
						vd.setCpId(rs.getInt(7));
						vd.setCpVdid(rs.getInt(8));
						vd.setCpName(rs.getString(9));
						vd.setCpDepartment(rs.getString(10));
						vd.setCpEmail(rs.getString(11));
						vd.setCpPhone(rs.getString(12));
						return vd;
					}
				});
	}

	@Override
	public VustVendorDet getVendordetById(int vdId) {
		String sql = "select v.vdid,v.vdname,v.vdaddr,v.vdlocation,v.vdservice,v.vdpin,c.cpid,c.cpVdid,c.cpname,c.cpdepartment,c.cpemail,c.cpphone from ustvendor v join ustcontact c on(v.vdid=c.cpvdid) where v.isactive='Y' and v.vdid=?";

		return template.queryForObject(sql, new Object[] { vdId },
				new BeanPropertyRowMapper<VustVendorDet>(VustVendorDet.class));
	}

	@Override
	public int disableVendordet(int vdId) {
		String sql = "update ustvendor set isActive='N' where vdId = ?";
		return template.update(sql, new Object[] { vdId });
	}

	@Override
	public int insertVendordetDetails(VustVendorDet uv) {
		String sqlv = "insert into ustvendor(vdName,vdAddr,vdLocation,vdservice,vdpin) values ('" + uv.getVdName()
				+ "','" + uv.getVdAddr() + "','" + uv.getVdLocation() + "','" + uv.getVdService() + "'," + uv.getVdPin()
				+ ")";
		template.update(sqlv);
		

		Integer mVdid = getMaxVdId();

		String sqlc = "insert into ustcontact(cpname,cpvdid,cpdepartment,cpemail,cpphone) values ('" + uv.getCpName()
				+ "',?,'" + uv.getCpDepartment() + "','" + uv.getCpEmail() + "','" + uv.getCpPhone() + "')";
		return template.update(sqlc, new Object[] { mVdid });

	}

	private Integer getMaxVdId() {
		String sql = "select MAX(vdid) from ustvendor";
		Integer res = template.queryForObject(sql, new Object[] {}, Integer.class);
		return res;
	}

	@Override
	public int updateVendordetDetails(VustVendorDet uv) {
		String sqlv = "update ustvendor set vdName='" + uv.getVdName() + "',vdAddr='" + uv.getVdAddr()
				+ "',vdLocation='" + uv.getVdLocation() + "',vdservice='" + uv.getVdService() + "',vdpin="
				+ uv.getVdPin() + " where vdid=?";
		template.update(sqlv,new Object[] {uv.getVdId()});

		String sqlc ="update ustcontact set cpname='"+uv.getCpName()+"',cpdepartment='"+
		uv.getCpDepartment()+"',cpemail='"+uv.getCpEmail()+"',cpphone='"+uv.getCpPhone()+"' where cpvdid=?";
		return template.update(sqlc,new Object[] {uv.getVdId()});
	}

	@Override
	public VustVendorDet duplication(String cpPhone, String cpEmail) {
		String sql=" select c.cpemail,c.cpphone from ustvendor v join ustcontact c on(v.vdid=c.cpvdid) where (c.cpPhone=? or c.cpEmail=?) and v.isactive='Y' ";
	  	return template.queryForObject(sql,new Object[] {cpPhone,cpEmail},
	  			new BeanPropertyRowMapper<VustVendorDet>(VustVendorDet.class));
	}

	@Override
	public List<VustVendorDet> searchVvendor(String searchString) {
		return template.query("SELECT v.vdid,v.vdname,v.vdlocation,v.vdservice,c.cpname,c.cpdepartment,c.cpphone,v.vdaddr,c.cpemail,"+
	"v.vdpin from ustvendor v JOIN ustcontact c ON(v.vdid=c.cpvdid) where v.isactive='Y' and (v.vdname like '%"+searchString+"%' or "+
				"v.vdlocation like '%"+searchString+"%' or v.vdservice like '%"+searchString+"%')",
				new RowMapper<VustVendorDet>(){
			public VustVendorDet mapRow(ResultSet rs, int row) throws SQLException{
				VustVendorDet uv = new VustVendorDet();
				uv.setVdId(rs.getInt(1));
				uv.setVdName(rs.getString(2));
				uv.setVdLocation(rs.getString(3));
				uv.setVdService(rs.getString(4));
				uv.setCpName(rs.getString(5));
				uv.setCpDepartment(rs.getString(6));
				uv.setCpPhone(rs.getString(7));
				uv.setVdAddr(rs.getString(8));
				uv.setCpEmail(rs.getString(9));
				uv.setVdPin(rs.getInt(10));
				return uv;
				
			}
		});
		
	}

	
}
