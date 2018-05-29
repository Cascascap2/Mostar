package logica.modelos;

import java.util.Date;

import javax.persistence.Id;

public class UsuCont {
	@Id
	private int id;
	private int UserId;
	private int ContId;
	private Date Time;
	private int Rate;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getContId() {
		return ContId;
	}
	public void setContId(int contId) {
		ContId = contId;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public int getRate() {
		return Rate;
	}
	public void setRate(int rate) {
		Rate = rate;
	}
	@Override
	public String toString() {
		return "UsuCont [id=" + id + ", UserId=" + UserId + ", ContId=" + ContId + ", Time=" + Time + ", Rate=" + Rate
				+ "]";
	}
	public UsuCont(int userId, int contId, Date time, int rate) {
		super();
		UserId = userId;
		ContId = contId;
		Time = time;
		Rate = rate;
	}
	
	
}
