package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    // @Test
    // @BeforeMethod
    // @AfterMethod
    // (enabled=false)
    // (dependsOnMethods = {""})
    // (priority = )


    @Test(enabled = false)
    public void ATestCase() {
        System.out.println("A test case");
    }

    @Test
    public void BTestCase() {
        System.out.println("B test case");
    }

    @Test(dependsOnMethods = {"BTestCase"})
    public void CTestCase() {
        System.out.println("C test case");
    }

    @Test(priority = 2)
    public void DTestCase() {
        System.out.println("D test case");
    }

    @Test(priority = 1)
    public void ETestCase() {
        System.out.println("E test case");
    }

    @BeforeMethod(enabled = false)
    public void beforeMethod() {
        System.out.println(" == before method == ");
    }

    @AfterMethod(enabled = false)
    public void afterMethod() {
        System.out.println(" == after method == ");
    }
}
