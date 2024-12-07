import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private final String sex;
    private final boolean hasMane;
    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    public LionParametrizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test //Проверка наличия гривы
    public void doesHaveManeTest() throws Exception {
        lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(hasMane, actual);
    }
}
