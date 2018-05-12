package org.gamenet.dkienenb.graphics.javafx;

public class Position {

	private double x;
	private double y;

	public Position(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}

	public double distanceTo(Position position2) {
		double a = this.getX() - position2.getX();
		double b = this.getY() - position2.getY();
		double c = Math.sqrt(a * a + b * b);
		return c;
	}

	public Position moveToward(Position position2, double distanceToMove) {
		double a = this.getX() - position2.getX();
		double b = this.getY() - position2.getY();
		double originalDistance = Math.sqrt(a * a + b * b);
		if (originalDistance<distanceToMove) {
			return position2;
		} 
		double newDistance = originalDistance - distanceToMove;
		double x = newDistance * a / originalDistance;
		double y = newDistance * b / originalDistance;
		return new Position(x + position2.getX(), y + position2.getY());

	}
}