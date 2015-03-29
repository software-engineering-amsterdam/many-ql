package nl.uva.sc.encoders.testrig;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.runtime.misc.TestRig;

/**
 * GUI for {@link TestRig}
 * 
 * @author Pim Tegelaar
 */
public class TestRigGui extends JFrame implements ActionListener {

	private static final String TMPFILE_TXT = "tmpfile.txt";

	private static final long serialVersionUID = 1L;

	private TextField grammarNameText = new TextField();
	private TextField startNameText = new TextField();
	private TextArea inputArea = new TextArea();

	private TextField encodingText = new TextField("");
	private TextField psFileText = new TextField("");

	private Button button = new Button("Rig her up!");

	private JCheckBox treeCb = new JCheckBox("tree");
	private JCheckBox guiCb = new JCheckBox("gui");
	private JCheckBox tokensCb = new JCheckBox("tokens");
	private JCheckBox traceCb = new JCheckBox("trace");
	private JCheckBox sllCb = new JCheckBox("SLL");
	private JCheckBox diagnosticsCb = new JCheckBox("diagnostics");

	private final String grammarName;
	private final String startName;
	private final String inputLocation;

	public static void main(String[] args) throws Exception {
		String grammarName = "nl.uva.sc.encoders.qls.EncodersQLS";
		String startName = "stylesheet";
		String inputLocation = "qls/stylesheet.qls";
		if (args.length == 3) {
			grammarName = args[0];
			startName = args[1];
			inputLocation = args[2];
		}
		TestRigGui testRigGui = new TestRigGui(grammarName, startName, inputLocation);
		testRigGui.setUpGui();
	}

	public TestRigGui(String grammarName, String startName, String inputLocation) throws HeadlessException {
		super("TestRigGui");
		this.grammarName = grammarName;
		this.startName = startName;
		this.inputLocation = inputLocation;
	}

	private void setUpGui() throws IOException, URISyntaxException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(550, 400));
		setLocationRelativeTo(null);

		GridBagLayout gridLayout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		setLayout(gridLayout);

		grammarNameText.setText(grammarName);
		startNameText.setText(startName);

		add(new Label("Lexer"), 0, 0);
		add(grammarNameText, 1, 0);

		add(new Label("Startname"), 0, 1);
		add(startNameText, 1, 1);

		add(new Label("Input"), 0, 2);
		add(inputArea, 1, 2);

		add(new Label("Encoding"), 0, 3);
		add(encodingText, 1, 3);

		add(new Label("PS file"), 0, 4);
		add(psFileText, 1, 4);

		JPanel panel = new JPanel();
		panel.add(treeCb);
		panel.add(guiCb);
		panel.add(tokensCb);
		panel.add(traceCb);
		panel.add(sllCb);
		panel.add(diagnosticsCb);
		add(panel, 1, 5);

		add(button, 1, 6);

		guiCb.setSelected(true);

		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(inputLocation);
		byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
		inputArea.setText(new String(bytes));

		button.addActionListener(this);

		pack();
		setVisible(true);
	}

	public void add(Component comp, int x, int y) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = x;
		c.gridy = y;
		add(comp, c);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String text = inputArea.getText();

		File tmpFile = new File(TMPFILE_TXT);
		FileWriter writer;
		try {
			writer = new FileWriter(tmpFile);
			writer.write(text);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			TestRig testRig = new TestRig(getArguments().toArray(new String[] {}));
			testRig.process();
			tmpFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<String> getArguments() {
		List<String> argList = new ArrayList<String>(Arrays.asList(grammarNameText.getText(), startNameText.getText(), TMPFILE_TXT));

		if (treeCb.isSelected()) {
			argList.add("-tree");
		}
		if (guiCb.isSelected()) {
			argList.add("-gui");
		}
		if (tokensCb.isSelected()) {
			argList.add("-tokens");
		}
		if (traceCb.isSelected()) {
			argList.add("-trace");
		}
		if (sllCb.isSelected()) {
			argList.add("-SLL");
		}
		if (diagnosticsCb.isSelected()) {
			argList.add("-(diagnostics");
		}
		String encoding = encodingText.getText();
		if (!encoding.isEmpty()) {
			argList.add("-encoding");
			argList.add(encoding);
		}
		String psFile = psFileText.getText();
		if (!psFile.isEmpty()) {
			argList.add("-ps");
			argList.add(psFile);
		}
		return argList;
	}
}
