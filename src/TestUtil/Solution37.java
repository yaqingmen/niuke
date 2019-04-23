package TestUtil;


import java.util.ArrayList;
import java.util.LinkedList;

public class Solution37 {

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  private static TreeNode root = null;
  public static void main(String[] args) {
//    String s = "6 2 # # 3 # #";
//    int idx = s.indexOf(" ");
//    System.out.println(idx);
//    String t = s.substring(1,3);
    //s = t;
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(7);
    root.left.right = new TreeNode(8);
    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(5);
    Solution37 t37 = new Solution37();

    String s = t37.Serialize(root);
    System.out.println("serialize :"+s);
    TreeNode node = t37.Deserialize(s);
    //System.out.println(node.val);
    ArrayList<Integer> list = new ArrayList<>();
    t37.preorder(node,list);
    System.out.println(list);
  }
  void preorder(TreeNode node, ArrayList<Integer> list) {
    if(node == null)
      return;
    list.add(node.val);
    preorder(node.left,list);
    preorder(node.right,list);
  }

  String Serialize(TreeNode root) {
    StringBuffer sb = new StringBuffer();
    if(root == null) {
      sb.append("# ");
      return sb.toString();
    }
    sb.append(root.val + " ");
    sb.append(Serialize(root.left));
    sb.append(Serialize(root.right));
    return sb.toString();
  }
   int index = -1;
  TreeNode Deserialize(String str) {
    if(str.length() == 0 ||str==null)
      return null;
    String[] info =str.split(" ");
    return DeserializeStr(info);

  }
  TreeNode DeserializeStr(String[] info) {
    index++;
    TreeNode node = null;
    if(!info[index].equals("#")) {
      node = new TreeNode(Integer.parseInt(info[index]));
      node.left = DeserializeStr(info);
      node.right = DeserializeStr(info);
    }
    return node;
  }

}
