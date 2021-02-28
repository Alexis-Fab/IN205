package ensta.ships;
import ensta.*;

public class ShipState {
	private AbstractShip shipRef;
	private boolean struck;

	public ShipState() {
		this.shipRef = null;
		this.struck = false;
	}
	public ShipState(AbstractShip ship) {
		this.shipRef = ship;
		this.struck = false;
	}

	public void addStrike() {
		this.struck = true;	
		shipRef.addStrike();
	};
	public boolean isStruck() {
		return(this.struck);
	}
	public String toString() {
		if (this.struck)
			return(ColorUtil.colorize(String.valueOf(this.shipRef.getLabel()), Color.RED));
		else
			return(String.valueOf(this.shipRef.getLabel()));
//		return(shipRef.getLabel()); //todo deal with color
	}
	public boolean isSunk() {
		return(shipRef.isSunk());
	}
	public AbstractShip getShip() {
		return(this.shipRef);
	}
	public void setShip(AbstractShip ship) {
		this.shipRef = ship;
	}
}	