import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test //Проверка на неверный пол
    public void doesHaveManeInvalidAnimal() {
        try {
            Feline feline = new Feline();
            Lion lion = new Lion("Нечто", feline);
            assertTrue(lion.doesHaveMane());
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

    @Test //Проверка вызова метода getKittens()
    public void getKittensMethodCall() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test //Проверка вызова метода getFood() один раз с любым аргументом типа String
    public void getFoodMethodCallWithAnyArgument() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
    }
}
