

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

class PalindromeService {

    public boolean isPalindrome(String text) {
        String reversedText = new StringBuilder(text).reverse().toString();
        return text.equals(reversedText);
    }
}

@RunWith(Parameterized.class)// добавь аннотацию с раннером
public class PalindromeServiceTest {

	private final String checkedText;
    private final boolean expected;// добавь два поля класса: для проверяемой строки и ожидаемого результата

	public PalindromeServiceTest(String checkedText, boolean expected){
        this.checkedText = checkedText;
        this.expected = expected;
       	// напиши конструктор с двумя параметрами
    }
	@Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"anna", true},
                {"anka", false},
                {"q", true}, 
        };
    }// напиши метод для получения тестовых данных

	@Test
    public void shouldCheckPalindrome() {
        PalindromeService palindrome = new PalindromeService();
        
        boolean actual = palindrome.isPalindrome(checkedText);
        assertEquals(expected, actual);
    }	// напиши тест

}
