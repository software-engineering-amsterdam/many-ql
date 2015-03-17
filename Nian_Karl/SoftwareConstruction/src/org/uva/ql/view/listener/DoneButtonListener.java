package org.uva.ql.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;

public class DoneButtonListener implements ActionListener {

	private final Evaluator evaluator;

	public DoneButtonListener(Evaluator evaluator) {
		super();
		this.evaluator = evaluator;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JSONObject json = new JSONObject();
		for (Identifier key : evaluator.getMap().keySet()) {
			Value value = evaluator.getValue(key);
			json.put(key.toString(), value.toString());
		}
		try {
			PrintWriter writer;
			writer = new PrintWriter("form.json");
			writer.println(json.toJSONString());
			writer.close();
			System.out.println("Made JSON file in the root of the project folder.w");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("Couldn't make JSON File.");
		}
		System.out.println(json);
	}

}
