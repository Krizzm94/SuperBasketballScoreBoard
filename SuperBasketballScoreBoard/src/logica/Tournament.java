package logica;

public class Tournament {

	private String name;
	private byte numTeams;
	
	public Tournament(String name, byte numTeams) {
		super();
		this.name = name;
		this.numTeams = numTeams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getNumTeams() {
		return numTeams;
	}

	public void setNumTeams(byte numTeams) {
		this.numTeams = numTeams;
	}

}
