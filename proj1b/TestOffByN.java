import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByN {

    static CharacterComparator offBy5 = new OffByN(5);

    // Your tests go here.
    @Test
    public void testequalChars() {
        assertTrue(offBy5.equalChars('a', 'f'));
        assertFalse(offBy5.equalChars('a', 'c'));
    }
}
