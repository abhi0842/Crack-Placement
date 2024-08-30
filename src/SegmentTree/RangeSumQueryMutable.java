package SegmentTree;

public class RangeSumQueryMutable {
    int n;
    int[] tree;

    public void buildtree(int i, int left, int right, int[] nums) {
        if (left == right) {
            tree[i] = nums[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildtree(2 * i + 1, left, mid, nums);
        buildtree(2 * i + 2, mid + 1, right, nums);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public void updatetree(int index, int val, int i, int left, int right) {
        if (left == right) {
            tree[i] = val;
            return;
        }
        int mid = left + (right - left) / 2;
        if (index <= mid) {
            updatetree(index, val, 2 * i + 1, left, mid);
        } else {
            updatetree(index, val, 2 * i + 2, mid + 1, right);
        }
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public int querytree(int left, int right, int i, int l, int r) {
        if (l > right || r < left) {
            return 0;
        }
        if (l >= left && r <= right) {
            return tree[i];
        }
        int mid = l + (r - l) / 2;
        return querytree(left, right, 2 * i + 1, l, mid) + querytree(left, right, 2 * i + 2, mid + 1, r);
    }

    public RangeSumQueryMutable(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        buildtree(0, 0, n - 1, nums);
    }

    public void update(int index, int val) {
        updatetree(index, val, 0, 0, n - 1);
    }

    public int sumRange(int left, int right) {
        return querytree(left, right, 0, 0, n - 1);
    }

}
