package org.uva.sea.ql.encoders.test_javaFX;
 
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
 
public class ChangeListener {
 
    public static void main(String[] args) {
 
      Sjaak electricBill = new Sjaak();
 
      electricBill.amountDueProperty().addListener(new ChangeListener()
      {
    	  @Override public void changed(ObservableValue o,Object oldVal, Object newVal)
    	  {
    		  System.out.println("Electric bill has changed!");
    	  }
      })
      ;
     
      electricBill.setAmountDue(100.00);
     
    }
}