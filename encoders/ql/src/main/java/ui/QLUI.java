package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.Collection;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.uva.sea.ql.encoders.model.DataType;
import org.uva.sea.ql.encoders.model.Question;
import org.uva.sea.ql.encoders.model.Questionnaire;
import org.uva.sea.ql.encoders.service.QuestionnaireParsingService;
import org.uva.sea.ql.encoders.service.QuestionnaireParsingServiceImpl;

public class QLUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;

	public static void main(String[] args) {
		QLUI qlui = new QLUI();
		qlui.setUpUI();
	}

	public QLUI() {
		super("Questionnaire");
	}

	private void setUpUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(550, 400));
		setLocationRelativeTo(null);

		contentPanel = new JPanel(new GridBagLayout());
		JScrollPane scrollPane = new JScrollPane(contentPanel);
		add(scrollPane);

		QuestionnaireParsingService questionnaireParsingService = new QuestionnaireParsingServiceImpl();
		try {
			Questionnaire questionnaire = questionnaireParsingService
					.parse("src/main/resources/example.ql2");
			Collection<Question> questions = questionnaire.getQuestions()
					.values();
			int y = 0;
			for (Question question : questions) {
				// add(new JLabel(question.getName()), 0, y);
				DataType dataType = question.getDataType();
				switch (dataType) {
				case BOOLEAN:
					add(new JCheckBox(question.getQuestionText()), 0, y);
					break;
				case MONEY:
					add(new JLabel(question.getQuestionText()), 0, y);
					JTextField textField = new JTextField();
					textField.setPreferredSize(new Dimension(200, 15));
					add(textField, 1, y);
					break;
				default:
					throw new IllegalStateException("Unsupported type: " + dataType);
				}

				y++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		pack();
		setVisible(true);
	}

	private void add(Component comp, int x, int y) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = x;
		c.gridy = y;
		contentPanel.add(comp, c);
	}
}
