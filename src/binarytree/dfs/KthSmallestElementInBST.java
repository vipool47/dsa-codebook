package binarytree.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import binarytree.TreeNode;

public class KthSmallestElementInBST {
    // ---------- Better Approach -----------
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;

        // store the elements in the list
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        // sort the list and return the kth smallest element
        Collections.sort(list);
        // return k-1 because the list is 0-indexed
        return list.get(k - 1);
    }

    // ---------- Optimal Approach -----------

    // Initialize result and count variables to keep track of the kth smallest element and the number of nodes visited
    int result = 0;
    int count = 0;

    public int kthSmallestOptimal(TreeNode root, int k){
        inOrder(root, k);
        return result;
    }

    public void inOrder(TreeNode root, int k){
        // Base case: if the current node is null or we have already found the kth smallest element
        if (root == null || count >= k) {
            return;
        }

        // Traverse the left subtree first (in-order traversal)
        inOrder(root.left, k);

        // Increment the count of nodes visited
        // If the count matches k, we have found the kth smallest element
        count++;
        if(count == k){
            result = root.val;
            return;
        }

        // Traverse the right subtree 
        inOrder(root.right, k);
    }
}
