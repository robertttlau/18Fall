import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Palindrome<T> extends LinkedListDeque<T> {
    public static Deque<Character> wordToDeque(String word) {
        Palindrome<Character> a = new Palindrome<Character>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            a.addLast(c);
        }
        return a;
    }

    public boolean isPalindrome(String word) {
        return isPalindromeHelper(word, 0, word.length() - 1);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeHelper2(word, 0, word.length() - 1, cc);
    }


    private boolean isPalindromeHelper(String word, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }
        return isPalindromeHelper(word, start + 1, end - 1);
    }

    private boolean isPalindromeHelper2(String word, int start, int end, CharacterComparator cc) {
        CharacterComparator offByOne = new OffByOne();
        if (start >= end) {
            return true;
        }
        if (offByOne.equalChars(word.charAt(start), word.charAt(end)) != true) {
            return false;
        }
        return isPalindromeHelper2(word, start + 1, end - 1, cc);
    }
}
