package uva.qls.interpreter.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import uva.qls.ast.ASTNode;
import uva.qls.ast.Prog;
import uva.qls.interpreter.gui.elements.Size;
import uva.qls.interpreter.gui.elements.UIContainer;
import uva.qls.interpreter.gui.elements.UIFrame;
import uva.qls.interpreter.gui.elements.UIScrollView;
import uva.qls.interpreter.gui.elements.UITabController;
import uva.qls.interpreter.gui.table.DefaultTable;
import uva.qls.interpreter.gui.table.DefaultTableValue;
import uva.qls.interpreter.gui.table.QuestionValueTable;
import uva.qls.interpreter.gui.visitor.QuestionValueVisitor;
import uva.qls.interpreter.gui.visitor.Renderer;
import uva.qls.interpreter.typecheck.TypeCheckQLS;
import uva.qls.ast.statements.*;
import uva.qls.ast.style.*;

public class GUI {

	private TypeCheckQLS typeCheck;
	private QuestionValueVisitor visitor;
	private QuestionValueTable questionValueTable;
	private Renderer renderer;
	public DefaultTable table;
	
	private UITabController tabController;
	private UIFrame frame;
	
	public GUI(ASTNode _ast){
		this.questionValueTable = new QuestionValueTable();
		this.table = new DefaultTable();
		
		this.typeCheck = new TypeCheckQLS(_ast);
		this.visitor = new QuestionValueVisitor(this);
		this.visitor.visitProg((Prog)_ast);
		
		this.initializeFrame();
		this.renderer = new Renderer(this.questionValueTable, this, _ast);
	}
	
	public QuestionValueTable getQuestionValueTable(){
		return this.questionValueTable;
	}
	
	public DefaultTable getTable(){
		return this.table;
	}
	
	public TypeCheckQLS getTypeCheck(){
		return this.typeCheck;
	}
	
	public Renderer getRenderer(){
		return this.renderer;
	}
	
	public UITabController getTabController(){
		return this.tabController;
	}
	
	public void initializeFrame(){
		Size size = new Size(this.getLargestWidth() + 350, 400);
		
		this.tabController = new UITabController(size);
		this.frame = new UIFrame(size, this.tabController);
		this.frame.randerFrame();
	}
	
	public void addFrameComponent(UIContainer _container){
		UIScrollView scrollView = this.tabController.getLastAddedComponent();
		
		scrollView.addComponent(_container);
		scrollView.getPanel().revalidate();
	}
	
	public int getLargestWidth(){
		List<Integer> widthList = new ArrayList<Integer>();
		widthList.add(250);	
		
		for (Question question : this.questionValueTable.getTable().keySet()){
			DefaultTableValue value = this.questionValueTable.retrieveValue(question);
			
			Width width = (Width)value.getStyle().retrieveValue("Width");
			widthList.add(width.evaluatedValue());
		}
		return Collections.max(widthList);
	}
}
