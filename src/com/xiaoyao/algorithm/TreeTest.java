package com.xiaoyao.algorithm;

import com.sun.istack.internal.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ljp
 * @version 1.0
 * @since 2020-07-15
 * 二叉树操作
 */
public class TreeTest {

    public static void main(String[] args) {


    }

    //==============================二叉搜索树操作↓=================================
    /*	1. 节点的左子树只包含小于当前节点的树
	    2. 节点的右子树只包含大于当前节点的树
        3. 节点的左子树和右子树本身也是二叉搜索树*/
    //===========插入二叉树操作，不保证平衡版本
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(val < root.val){
            root.left = insertIntoBST(root.left ,val);
        }else if(val > root.val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
    //===========验证是否是二叉树

    private long pre = Long.MIN_VALUE;
    /**
     * 验证是否是二叉搜索树： 利用二叉搜索树中序遍历后是一个升序数组进行验证
     * @param root
     * @return
     */
    public boolean validedBST(TreeNode root){
        if (root == null) {
            return true;
        }
        if(!validedBST(root.left)){
            return false;
        }
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
        return validedBST(root.right);
    }

    /**
     * 还是中序递归靠谱
     * 验证是否是二叉搜索树，递归边界验证方式
     * left 遍历: 上边界为父节点，下边界为上一次遍历的下边界 （节点A右节点B的左节点遍历，则下边界为A（结合right 遍历看），下边界为父节点。 ）
     * right 遍历: 下边界为父节点，上边界为上一次遍历的上边界
     * @param root
     * @param low
     * @param hight
     * @return
     */
    public boolean validedBST2(TreeNode root,Integer low,Integer hight){
        if (root == null) {
            return true;
        }
        if(low != null && root.val <= low) {
            return false;
        }
        if(hight != null && root.val >= hight) {
            return false;
        }
        if(!validedBST2(root.left,low,root.val)) {
            return  false;
        }
        return validedBST2(root.right, root.val, hight);
    }
    // ===========二叉搜索树删除节点==============

    /**
     * 删除值等于 val 的某一个节点
     * @param root
     * @param val
     * @return 删除后的根节点
     * 当找到被删除节点 A 时
     * A 没有左节点，则直接返回右节点
     * A 没有右节点，则直接返回左节点
     * A 即有左节点又有右节点，将左节点附值给后继节点左节点后返回右节点
     */
    public TreeNode deleteNode(TreeNode root,int val){
        if (root == null) {
            return  null;
        }
        if(root.val< val){
            root.right = deleteNode(root.right,val);
        }else if(root.val > val){
            root.left = deleteNode(root.right,val);
        }
        // 找到被删除节点
        else {
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return  root.left;
            }
            // 即有左节点又有右节点，将左节点附值给后继节点左节点后返回右节点
            else {
                // 获取后继节点
                TreeNode node = getNext(root);
                node.left = root.left;
                return root.right;
            }
        }
        return root;
    }
    // ===========二叉搜索树删除节点-获取前驱节点

    /**
     * 获取前驱节点
     * 前驱节点： 小于当前节点的最大节点。 即左节点中最右侧的节点。
     * @param node
     * @return
     */
    private TreeNode getLast(@NotNull TreeNode node ){
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    // ===========二叉搜索树删除节点-获取后继节点

    /**
     * 获取后继节点
     * 后继节点： 大于当前节点的最小节点。 即右节点中最左侧的节点。
     * @param node
     * @return
     */
    private TreeNode getNext(@NotNull TreeNode node){
        node = node.right;
        while (node.left != null){
            node = node.left;
        }
        return node;
    }


    //==========================二叉树遍历/深度查找操作↓===================================
    /**
     * 前序遍历
     * @param root
     * @param list
     */
    public void preorder(TreeNode root,List<Integer> list){
        if(root !=null){
            list.add(root.val);
            preorder(root.left,list);
            preorder(root.right,list);
        }
    }

    /**
     * 用栈实现前序，入栈的过程即是遍历的过程
     * // 将节点入栈,入栈的过程即使遍历的过程
     * @param root
     * @param list
     */
    public void preorderWithStack(TreeNode root,List<Integer> list){
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while (node != null || !s.isEmpty()){
            while (node != null){
                s.push(node);
                list.add(node.val);
                node = node.left;
            }
            if (!s.isEmpty()){
                node = s.pop();
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     * @param list
     */
    public void inorder(TreeNode root, List<Integer> list){
        if(root != null){
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
    }

    /**
     * 中序遍历：迭代模式利用栈实现
     * 节点出栈时进行list.add 操作
     * @param root
     * @param list
     */
    public void inorderWithStack(TreeNode root,List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!= null || !stack.isEmpty()){
            while (node!= null){
                stack.push(node);
                node = node.left;
            }
            // 重新给 node 赋值，并继续循环node 的子节点。
            if(!stack.isEmpty()){
                 node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }

    }
    /**
     * 后续遍历
     * @param root
     * @param list
     */
    public void backorder(TreeNode root,List<Integer> list){
        if(root != null){
            backorder(root.left,list);
            backorder(root.right,list);
            list.add(root.val);
        }
    }

    public void backorderWithStack(TreeNode root,List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastNode = null;
        while (node!= null || !stack.isEmpty()){
            // 所有左节点入栈
            while (node!= null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                // 弹出上一个没有左节点的node
                node = stack.pop();
                // 如果上一个没有左节点的node 同样没有右节点|| 右节点为上一次记录过的节点
                if(node.right == null || node.right == lastNode){
                    list.add(node.val);
                    lastNode = node;
                    node = null;
                }else {
                    stack.push(node);
                    node = node.right;
                }
            }
        }
    }

    /**
     * 层级遍历
     * @param root
     * @param list
     */
    public void levelOrder(TreeNode root,List<Integer> list){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (null != poll.left) {
                queue.add(poll.left);
            }
            if (null != poll.right) {
                queue.add(poll.right);
            }
        }
    }

    /**
     * 计算树的高度
     * @param node
     * @return
     */
    public int getHight(TreeNode node){
        if (node == null) {
            return 0;
        }
        return 1+ Math.max(getHight(node.left),getHight(node.right));
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
