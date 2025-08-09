import java.util.Stack;

class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sort(s);
            insertSort(s, x);
        }
        return s;
    }
    
    public void insertSort(Stack<Integer> s, int temp) {
        if (s.isEmpty() || temp > s.peek()) {
            s.push(temp);
            return; // ✅ semicolon fixed
        }
        int x = s.pop();
        insertSort(s, temp); // ✅ should be 'temp', not 'x'
        s.push(x);
    }
}
