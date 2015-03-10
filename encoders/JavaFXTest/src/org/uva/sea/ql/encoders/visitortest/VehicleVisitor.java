package org.uva.sea.ql.encoders.visitortest;

public interface VehicleVisitor {

	void visit(Root root);

	void visit(Car car);

	void visit(Bus bus);

}