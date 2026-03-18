class Solution {
    public List<List<Integer>> combinationSum2(int[] c, int t) {
        List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(c); /
        cs(0, c, t, l, new ArrayList<>());
        return l;
    }

    public void cs(int i, int[] arr, int t, List<List<Integer>> l, List<Integer> ds) {
        if (t == 0) {
            l.add(new ArrayList<>(ds));
            return;
        }
        for (int ind = i; ind < arr.length; ind++) {
            if (ind > i && arr[ind] == arr[ind - 1])
                continue;
            if (arr[ind] > t)
                break;
            ds.add(arr[ind]);
            cs(ind + 1, arr, t - arr[ind], l, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
