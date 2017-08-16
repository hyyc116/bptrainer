package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Stats extends Model{
	
	private long totalcount;
	private Date updatetime;
	private Date start_time;
	private Date last_time;
	private String gm_dict;
	private String cluster_dict;
	
	public long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(long totalcount) {
		this.totalcount = totalcount;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getLast_time() {
		return last_time;
	}
	public void setLast_time(Date last_time) {
		this.last_time = last_time;
	}
	public String getGm_dict() {
		return gm_dict;
	}
	public void setGm_dict(String gm_dict) {
		this.gm_dict = gm_dict;
	}
	public String getCluster_dict() {
		return cluster_dict;
	}
	public void setCluster_dict(String cluster_dict) {
		this.cluster_dict = cluster_dict;
	}
	
}
