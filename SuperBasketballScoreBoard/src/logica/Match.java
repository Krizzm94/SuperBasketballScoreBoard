package logica;

public class Match {

	private Team localTeam;
	private Team VisitorTeam;
	private String date;
	private String time;
	
	public Match(Team localTeam, Team visitorTeam, String date, String time) {
		super();
		this.localTeam = localTeam;
		VisitorTeam = visitorTeam;
		this.date = date;
		this.time = time;
	}

	public Team getLocalTeam() {
		return localTeam;
	}

	public void setLocalTeam(Team localTeam) {
		this.localTeam = localTeam;
	}

	public Team getVisitorTeam() {
		return VisitorTeam;
	}

	public void setVisitorTeam(Team visitorTeam) {
		VisitorTeam = visitorTeam;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
