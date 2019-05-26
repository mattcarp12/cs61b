import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("hannah"));
        assertTrue(palindrome.isPalindrome("7"));
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testIsPalindromeCC() {
        CharacterComparator obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertFalse(palindrome.isPalindrome("boob", obo));
    }

    /*
    @Test
    public void testDequeToWord() {
        Deque d = palindrome.wordToDeque("persiflage");
        assertEquals("persiflage", palindrome.dequeToWord(d));
    }
    */

}
