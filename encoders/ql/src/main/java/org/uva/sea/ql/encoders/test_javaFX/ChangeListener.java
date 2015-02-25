package org.uva.sea.ql.encoders.test_javaFX;

import javafx.beans.value.ObservableValue;

public class ChangeListener {

	public static void main(String[] args) {

		Sjaak electricBill = new Sjaak();

		electricBill.amountDueProperty().addListener(
				new javafx.beans.value.ChangeListener<Number>() {

					@Override
					public void changed(
							ObservableValue<? extends Number> observable,
							Number oldValue, Number newValue) {
						System.out.println("Electric bill has changed!");
						System.out.println("oldValue=" + oldValue
								+ " newValue=" + newValue);
					}
				});

		electricBill.setAmountDue(100.00);

	}
}