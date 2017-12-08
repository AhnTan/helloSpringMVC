package kr.ac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.model.Offer;

@Repository
// @Component("offerDAO")   // beans.xml에서 <bean id="offerDAO" class="kr.ac.hansung.csemall.OfferDAO"> 부분 대신 사용
public class OfferDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired // beans.xml에서 property부분 대신 쓰는 Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	//query and return a single object
	public Offer getOffer(String name) {
		String sqlStatement = "select * from offers where name=?";
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name}, 
				new RowMapper<Offer>(){
					@Override
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						//rs = record   
						Offer offer = new Offer();
						
						//offer.setNum(rs.getInt("num"));
						offer.setYear(rs.getInt("year"));
						offer.setTerm(rs.getInt("term"));
						offer.setSubject(rs.getString("subject"));
						offer.setCode(rs.getString("code"));
						offer.setDivision(rs.getString("division"));
						offer.setGrade(rs.getInt("grade"));
						
						/*offer.setId(rs.getInt("id"));
						offer.setName(rs.getString("name"));
						offer.setEmail(rs.getString("email"));
						offer.setText(rs.getString("text"));*/
						
						return offer;
					}
			});
	}
	
	// 링크버튼을 누르면 해당되는 과목들을 가져옴
	public List<Offer> getLinks(int year, int term){
		
		String sqlStatement = "select subject, code, division from offers where year=? and term=?";
		
		return jdbcTemplate.query(sqlStatement,	new Object[] {year, term}, new RowMapper<Offer>(){
					@Override
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						//rs = record   
						Offer offer = new Offer();
						
						//offer.setNum(rs.getInt("num"));
						//offer.setYear(rs.getInt("year"));
						//offer.setTerm(rs.getInt("term"));
						offer.setSubject(rs.getString("subject"));
						offer.setCode(rs.getString("code"));
						offer.setDivision(rs.getString("division"));
						//offer.setGrade(rs.getInt("sum(grade)"));
						
						return offer;
					}
			});
	}
	
	
		// 년도와 학기를 구분하여 가져옴
		public List<Offer> getyears(){
			String sqlStatement = "select year, term, sum(grade) from offers group by year, term" ;
			
			
			return jdbcTemplate.query(sqlStatement,	new RowMapper<Offer>(){
						@Override
						public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
							//rs = record   
							Offer offer = new Offer();
							
							//offer.setNum(rs.getInt("num"));
							offer.setYear(rs.getInt("year"));
							offer.setTerm(rs.getInt("term"));
							//offer.setSubject(rs.getString("subject"));
							//offer.setCode(rs.getString("code"));
							//offer.setDivision(rs.getString("division"));
							offer.setGrade(rs.getInt("sum(grade)"));
							
							return offer;
						}
				});
		}
		
		
		// 이수내용과 각 이수총점들
		public List<Offer> getDetail(){
			String sqlStatement = "select division, sum(grade) from offers group by division";
			
			
			return jdbcTemplate.query(sqlStatement,	new RowMapper<Offer>(){
						@Override
						public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
							//rs = record   
							Offer offer = new Offer();
							
							//offer.setNum(rs.getInt("num"));
							//offer.setYear(rs.getInt("year"));
							//offer.setTerm(rs.getInt("term"));
							//offer.setSubject(rs.getString("subject"));
							//offer.setCode(rs.getString("code"));
							offer.setDivision(rs.getString("division"));
							offer.setGrade(rs.getInt("sum(grade)"));
							
							return offer;
						}
				});
		}
	
	
		//query and return a multiple objects
		public List<Offer> getOffers() {
			String sqlStatement = "select * from offers";
			
			return jdbcTemplate.query(sqlStatement, 
					new RowMapper<Offer>(){
						@Override
						public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
							//rs = record   
							Offer offer = new Offer();
							
							//offer.setNum(rs.getInt("num"));
							offer.setYear(rs.getInt("year"));
							offer.setTerm(rs.getInt("term"));
							offer.setSubject(rs.getString("subject"));
							offer.setCode(rs.getString("code"));
							offer.setDivision(rs.getString("division"));
							offer.setGrade(rs.getInt("grade"));
							
							return offer;
						}
				});
		}
		
		
		
		public List<Offer> getFutures() {
			String sqlStatement = "select * from offers where year=? and term=?";
			
			return jdbcTemplate.query(sqlStatement, new Object[] {2018, 1},
					new RowMapper<Offer>(){
						@Override
						public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
							//rs = record   
							Offer offer = new Offer();
							
							//offer.setNum(rs.getInt("num"));
							offer.setYear(rs.getInt("year"));
							offer.setTerm(rs.getInt("term"));
							offer.setSubject(rs.getString("subject"));
							offer.setCode(rs.getString("code"));
							offer.setDivision(rs.getString("division"));
							offer.setGrade(rs.getInt("grade"));
							
							return offer;
						}
				});
		}
		
		
		
		public boolean insert(Offer offer) {
		/*	String name = offer.getName();
			String email = offer.getEmail();
			String text = offer.getText();
			*/
			//int num = offer.getNum();
			int year = offer.getYear();
			int term = offer.getTerm();
			String subject = offer.getSubject();
			String code = offer.getCode();
			String division = offer.getDivision();
			int grade = offer.getGrade();
			
			
			String sqlStatement = "insert into offers (year, term, subject, code, division, grade) values (?, ?, ?, ?, ?, ?)";
						
			return (jdbcTemplate.update(sqlStatement, new Object[]{year, term, subject, code, division, grade}) == 1);
		}
		
		public boolean update(Offer offer) {
			/*
			int id = offer.getId();
			String name = offer.getName();
			String email = offer.getEmail();
			String text = offer.getText();
			*/
			//int num = offer.getNum();
			int year = offer.getYear();
			int term = offer.getTerm();
			String subject = offer.getSubject();
			String code = offer.getCode();
			String division = offer.getDivision();
			int grade = offer.getGrade();
			
			//String sqlStatement = "update offers set name=?, email=?, text=? where id=?";
			String sqlStatement = "update offers set year=?, term=?, subject=?, code=?, division=?, grade=?";
			
			return (jdbcTemplate.update(sqlStatement, new Object[]{year, term, subject, code, division, grade}) == 1);
		}
		
		public boolean delete(int id) {
			String sqlStatement = "delete from offers where id=?";
			return (jdbcTemplate.update(sqlStatement, new Object[]{id}) == 1);
		}
	
	
}

