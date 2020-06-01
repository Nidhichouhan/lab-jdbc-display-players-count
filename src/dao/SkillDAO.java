package dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO
{
	public TreeMap<Integer,Skill> skillCount() throws ClassNotFoundException, IOException, SQLException {
		Connection con=ConnectionManager.getConnection();
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("SELECT * FROM PLAYER2");
		int countBatting=0;
		int countBowling=0;
		int countAllRounder=0;
		while(rs.next()) {
			if(rs.getInt(3)==1) {
				countBatting++;
			}else if(rs.getInt(3)==2) {
				countBowling++;
			}
			else {
				countAllRounder++;
			}
				
				
		}
		Skill s1=new Skill(1,"BATTING");
		Skill s2=new Skill(2,"BOWLING");
		Skill s3=new Skill(3,"ALL ROUNDER");
		
		Integer i1=countBatting;
		Integer i2=countBowling;
		Integer i3=countAllRounder;
		
		TreeMap<Integer, Skill> map=new TreeMap<Integer,Skill>();
		map.put(i1,s1);
		map.put(i2,s2);
		map.put(i3,s3);
		
		con.close();
		
		return map;
	}
}