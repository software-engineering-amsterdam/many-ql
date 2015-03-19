package qls.gui.structure;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

import ql.Value;
import ql.gui.UIComponent;
import qls.ast.visitor.domaincreator.ConditionalDomain;

public class TabbedPanel implements UIComponent {
	private JTabbedPane tabbedPanel;
	private List<ConditionalDomain> domains;
	private List<UIComponent> pages;
	
	public TabbedPanel(List<ConditionalDomain> domains) {
		tabbedPanel = new JTabbedPane();
		
		this.domains = domains;
		pages = new ArrayList<UIComponent>();
	}
	
	public void setPages(List<UIComponent> pages) {
		this.pages = pages;
		this.pages.stream().forEach(page -> tabbedPanel.addTab(page.toString(),
				page.getComponent()));
		this.pages.stream().forEach(page -> page.setHandler(this));
		updateComponent();
	}

	@Override
	public void setHandler(UIComponent handler) {}

	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		updateComponent();
	}

	@Override
	public void updateComponent() {
		domains.stream().forEach(domain -> domain.updateDomain());
		pages.stream().forEach(page -> page.updateComponent());
	}

	@Override
	public JComponent getComponent() {
		return tabbedPanel;
	}
}
