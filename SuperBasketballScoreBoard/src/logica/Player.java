package logica;

public class Player {

	private byte id;
	private byte number;
	private Foul [] foul;
	

	public Player(byte id, byte number, Foul[] foul) {
		super();
		this.id = id;
		this.number = number;
		this.foul = foul;
	}


	public byte getNumber() {
		return number;
	}


	public void setNumber(byte number) {
		this.number = number;
	}


	public Foul[] getFoul() {
		return foul;
	}


	public void setFoul(Foul[] foul) {
		this.foul = foul;
	}


	public byte getId() {
		return id;
	}


	public void setId(byte id) {
		this.id = id;
	}

	
	
}
