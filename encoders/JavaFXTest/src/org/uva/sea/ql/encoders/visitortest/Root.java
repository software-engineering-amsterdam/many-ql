package org.uva.sea.ql.encoders.visitortest;

import java.util.List;

public class Root implements UberNode {

	private final List<Vehicle> children;

	public Root(List<Vehicle> children) {
		this.children = children;
	}

	public List<Vehicle> getChildren() {
		return children;
	}

	@Override
	public void accept(VehicleVisitor visitor) {
		visitor.visit(this);
	}
}
