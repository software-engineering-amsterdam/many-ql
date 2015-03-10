package org.uva.sea.ql.encoders.visitortest;

import java.util.ArrayList;
import java.util.List;

public class VehicleVisitorImpl implements VehicleVisitor {

	public static void main(String[] args) {
		VehicleVisitor vehicleVisitor = new VehicleVisitorImpl();
		List<Vehicle> children = new ArrayList<Vehicle>();
		children.add(new Car());
		children.add(new Bus());
		Root root = new Root(children);
		root.accept(vehicleVisitor);
	}

	@Override
	public void visit(Root root) {
		System.out.println("root");
		List<Vehicle> children = root.getChildren();
		for (Vehicle vehicle : children) {
			vehicle.accept(this);
		}
	}

	@Override
	public void visit(Car car) {
		System.out.println("car");
	}

	@Override
	public void visit(Bus bus) {
		System.out.println("bus");
	}
}
