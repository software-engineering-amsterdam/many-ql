package org.uva.sea.ql.encoders.visitortest;

public class Car implements Vehicle {

	@Override
	public void accept(VehicleVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public double speed() {
		return 130;
	}

}
