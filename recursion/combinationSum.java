class Solution {
    public List<List<Integer>> combinationSum(int[] c, int t) {
        List<List<Integer>> l = new ArrayList<>();
        cs(0, c, t, l, new ArrayList<>());
        return l;
    }

    public void cs(int i, int[] arr, int t, List<List<Integer>> l, List<Integer> ds) {
        if (i == arr.length) {
            if (t == 0) {
                l.add(new ArrayList<>(ds));

            }
            return;
        }
        if (arr[i] <= t) {
            ds.add(arr[i]);
            cs(i, arr, t - arr[i], l, ds);
            ds.remove(ds.size() - 1);
        }
        cs(i + 1, arr, t, l, ds);

    }
}