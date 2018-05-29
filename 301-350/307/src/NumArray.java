// https://leetcode-cn.com/problems/range-sum-query-mutable/description/
public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if(nums.length!=0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree= new SegmentTree<>(data,(a,b)->a+b);
        }
    }

    public void update(int i, int val) {
        segmentTree.set(i,val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i,j);
    }


    private interface Merge<E> {
        E merge(E e1, E e2);
    }



    private class SegmentTree<E> {
        private E[] tree;
        private E[] data;
        private Merge<E> merge;
        public SegmentTree(E[] arr, Merge<E> merge) {
            this.data = data;
            this.merge = merge;
            data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            tree = (E[]) new Object[4 * arr.length];
            buildSegmentTree(0, 0, arr.length - 1);
        }
        private void buildSegmentTree(int treeIndex, int l, int r) {
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }
            int mid = l + (r - l) / 2;
            int leftChild = leftChild(treeIndex);
            int rightChild = rightChild(treeIndex);
            buildSegmentTree(leftChild, l, mid);
            buildSegmentTree(rightChild, mid + 1, r);
            tree[treeIndex] = merge.merge(tree[leftChild], tree[rightChild]);
        }

        public E query(int dataL, int dataR) {
            if (dataL < 0 || dataL >= data.length || dataR < 0 || dataR >= data.length || dataL > dataR) {
                throw new IllegalArgumentException("Index is illegal.");
            }
            return query(0, 0, data.length - 1, dataL, dataR);
        }

        private E query(int treeIndex, int l, int r, int dataL, int dataR) {
            if (l == dataL && r == dataR) {
                return tree[treeIndex];
            }
            int mid = l + (r - l) / 2;
            int leftChildIndex = leftChild(treeIndex);
            int rightChildIndex = rightChild(treeIndex);
            if (dataR <= mid) {
                return query(leftChildIndex, l, mid, dataL, dataR);
            }
            if (dataL >= mid + 1) {
                return query(rightChildIndex, mid + 1, r, dataL, dataR);
            }
            E leftResult = query(leftChildIndex, l, mid, dataL, mid);
            E rightResult = query(rightChildIndex, mid + 1, r, mid + 1, dataR);
            return merge.merge(leftResult, rightResult);
        }


        public void set(int dataIndex, E val) {
            if (dataIndex < 0 || dataIndex >= data.length) {
                throw new IllegalArgumentException("Index is illegal.");
            }
            data[dataIndex] = val;
            set(0, 0, data.length - 1, dataIndex, val);
        }


        private void set(int treeIndex, int l, int r, int dataIndex, E val) {
            if (l == r) {
                tree[treeIndex] = val;
                return;
            }
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            int mid = l + (r - l) / 2;
            if (dataIndex >= mid + 1) {
                set(rightTreeIndex, mid + 1, r, dataIndex, val);
            }
            if (dataIndex <= mid) {
                set(leftTreeIndex, l, mid, dataIndex, val);
            }
            tree[treeIndex] = merge.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        public int getSize() {
            return data.length;
        }

        public E get(int index) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("Index is illegal.");
            }
            return data[index];
        }

        public int leftChild(int index) {
            return 2 * index + 1;
        }

        public int rightChild(int index) {
            return 2 * index + 2;
        }
    }



}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */