public class OffByN implements CharacterComparator {
    int num;

    public OffByN(int N) {
        this.num = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        System.out.println(diff);
        return diff == num || diff == -num;
    }
}