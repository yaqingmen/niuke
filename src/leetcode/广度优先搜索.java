package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 广度优先搜索 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
        System.out.println(maxDepth(root));
        System.out.println(minDepth(root));
        System.out.println(maxDepthBfs(root));
    }

    /**
     * 给定一个二叉树，层次遍历输出
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        //保存结果的list
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        //特殊情况
        if (root == null) return res;
        //用双端队列模拟bfs
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //先把根节点加入
        queue.offer(root);
        //出队进队模拟bfs
        while (queue.size() > 0) {
            //先保存size后面会变化
            int qsize = queue.size();
            //对每层都有一个list
            List<Integer> l = new LinkedList<>();
            //处理每一层的节点
            for (int i = 0; i < qsize; i++) {
                //处理的当前节点
                TreeNode curNode = queue.poll();
                //将当前节点的值加入list
                l.add(curNode.val);
                //如果有子节点，加入队列中，做下一次处理。
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            res.add(l);
        }
        return res;
    }

    /**
     * 二叉树的最小深度
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
//        if(root.left == null) return 1 + minDepth(root.right);
//        if(root.right == null) return 1 + minDepth(root.left);
//        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (root.left == null || root.right == null) ? (1 + right + left) : 1 + Math.min(right, left);

    }

    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left) ,maxDepth(root.right));

    }
    public  static int maxDepthBfs(TreeNode root) {
        if(root == null) return 0;
        //双端队列模拟bfs
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int max = 0;
        //出队入队
        while(queue.size() > 0) {
            //先保存队列大小，因为后面会变化
            int qsize = queue.size();
            //处理每一层节点
            for(int i = 0; i < qsize; i++) {
                //处理的当前节点
                TreeNode curNode = queue.poll();
                //如果有左右子树
                if(curNode.left != null) queue.offer(curNode.left);
                if(curNode.right != null) queue.offer(curNode.right);
            }
            max++;
        }
        return max;
    }
}
