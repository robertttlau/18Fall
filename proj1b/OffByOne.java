public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        System.out.println(diff);
        return diff == 1 || diff == -1;
    }
}
