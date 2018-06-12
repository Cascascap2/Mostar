//import javax.annotation.PostConstruct;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.swing.tree.TreeModel;
//
//
//import org.primefaces.model.DefaultTreeNode;
//import org.primefaces.model.TreeNode;
//
//import net.bootsfaces.component.tree.event.TreeNodeCheckedEvent;
//import net.bootsfaces.component.tree.event.TreeNodeEventListener;
//import net.bootsfaces.component.tree.event.TreeNodeExpandedEvent;
//import net.bootsfaces.component.tree.event.TreeNodeSelectionEvent;
//
//@ViewScoped
//@ManagedBean(name = "test")
//public class TestBean implements TreeNodeEventListener {
//	private TreeNode root;
// @PostConstruct
//    public void init() {
//        root = new DefaultTreeNode("Root", null);
//	    TreeNode node0 = new DefaultTreeNode("Node 0", root);
//	    TreeNode node1 = new DefaultTreeNode("Node 1", root);
//	     
//	    TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
//	    TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);
//	     
//	    TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);
//	     
//	    node1.getChildren().add(new DefaultTreeNode("Node 1.1"));
//	    node00.getChildren().add(new DefaultTreeNode("Node 0.0.0"));
//	    node00.getChildren().add(new DefaultTreeNode("Node 0.0.1"));
//	    node01.getChildren().add(new DefaultTreeNode("Node 0.1.0"));
//	    node10.getChildren().add(new DefaultTreeNode("Node 1.0.0"));
//	    root.getChildren().add(new DefaultTreeNode("Node 2"));
//	    }
// 
//	    public TreeNode getRoot() {
//	        return root;
//	    }
//  @Override
//  public void processValueSelected(TreeNodeSelectionEvent event) {
//    if (event.isSelected())
//    messages.add("Node selected: '" + event.getNode().getText() + "'");
//    else
//    messages.add("Node unselected: '" + event.getNode().getText() + "'");
//  }
// 
//  @Override
//  public void processValueChecked(TreeNodeCheckedEvent event) {
//    if (event.isChecked())
//    messages.add("Node checked: '" + event.getNode().getText() + "'");
//    else
//    messages.add("Node unchecked: '" + event.getNode().getText() + "'");
//  }
// 
//  @Override
//  public void processValueExpanded(TreeNodeExpandedEvent event) {
//    if (event.isExpanded())
//    messages.add("Node expanded: '" + event.getNode().getText() + "'");
//    else
//    messages.add("Node collapsed: '" + event.getNode().getText() + "'");
//  }
 