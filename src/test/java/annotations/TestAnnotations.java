package annotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestAnnotations {

    @BeforeTest
    public void BT() {
        System.out.println("i am before Test -------------------");
    }

    @AfterTest
    public void AT() {
        System.out.println("i am after Test ----------------------");
    }
}

