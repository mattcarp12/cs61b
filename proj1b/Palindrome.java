public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> sol = new LinkedListDeque<Character>();
        for(char c: word.toCharArray()){
            sol.addLast(c);
        }
        return sol;
    }

    public boolean isPalindrome(String word){
        Deque<Character> dWord = wordToDeque(word);
        if(dWord.size() == 0 || dWord.size() == 1) {
            return true;
        }
        if (dWord.removeFirst() == dWord.removeLast()) {
             return isPalindrome(dequeToWord(dWord));
        } else{
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> dWord = wordToDeque(word);
        if(dWord.size() == 0 || dWord.size() == 1) {
            return true;
        }
        if (cc.equalChars(dWord.removeFirst(), dWord.removeLast())) {
            return isPalindrome(dequeToWord(dWord), cc);
        } else{
            return false;
        }
    }

    private String dequeToWord(Deque<Character> dWord) {
        String sol = "";
        int n = dWord.size();
        for (int i = 0; i < n; i++){
            sol += dWord.removeFirst();
        }
        return sol;
    }
}
