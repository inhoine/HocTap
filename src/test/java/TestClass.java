import org.testng.annotations.Test;

public class TestClass {
    @Test
    void test() throws InterruptedException {
        new CreateProduct().test();
    }
    @Test
    void test1() throws InterruptedException {
        new EdtiProduct().testEdit();
    }
}
