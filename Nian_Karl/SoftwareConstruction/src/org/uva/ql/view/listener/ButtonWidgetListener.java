package org.uva.ql.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;

public class ButtonWidgetListener extends WidgetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Evaluator evaluator = getEvaluator();
		JSONObject json = new JSONObject();
		for (String key : evaluator.getMap().keySet()) {
			Value value = evaluator.getValue(key);
			json.put(key, value.toString());
		}
		try {
			PrintWriter writer;
			writer = new PrintWriter("form.json");
			writer.println(json.toJSONString());
			writer.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("Couldn't make JSON File.");
		}
		System.out.println(json);
	}
}
