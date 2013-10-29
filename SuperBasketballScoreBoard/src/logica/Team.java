package logica;

public class Team {

	private String name;
	private byte numPlayers;
	private String color;
	private String place;
	
	public Team(String name, byte numPlayers, String color, String place) {
		super();
		this.name = name;
		this.numPlayers = numPlayers;
		this.color = color;
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(byte numPlayers) {
		this.numPlayers = numPlayers;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	
}
