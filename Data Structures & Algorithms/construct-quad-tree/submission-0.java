/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int r, int c, int size) {
        if(isSquare(grid, r, c, size)) {
            Node node = new Node();
            node.val = grid[r][c] == 1;
            node.isLeaf = true;
            return node;
        }

        Node node = new Node();
        node.isLeaf = false;

        int half = size / 2;
        node.topLeft = build(grid, r, c, half);
        node.topRight = build(grid, r, c+half, half);
        node.bottomLeft = build(grid, r+half, c, half);
        node.bottomRight = build(grid, r+half, c+half, half);

        return node;
    }

    private boolean isSquare(int[][]grid, int r, int c, int size) {
        int n = grid[r][c];
        boolean res = true;
        for(int i=r; i<r+size; i++) {
            for(int j=c; j<c+size; j++) {
                res = res & (n == grid[i][j]);
            }
        }
        return res;
    }
}