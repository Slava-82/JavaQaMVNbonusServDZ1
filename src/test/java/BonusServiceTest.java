import Slava82.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1000_000;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredMaxBorderBonus() {
        BonusService service = new BonusService();

        long amount = 16666;
        boolean registered = true;
        long expected = 499;

        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredMaxBorderBonus() {
        BonusService service = new BonusService();

        long amount = 49999;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredBorderMaxBonus() {
        BonusService service = new BonusService();

        long amount = 16667;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredBorderMaxBonus() {
        BonusService service = new BonusService();

        long amount = 49999;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredBorderMinBonus() {
        BonusService service = new BonusService();

        long amount = 33;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredBorderMinBonus() {
        BonusService service = new BonusService();

        long amount = 99;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredMinBorderBonus() {
        BonusService service = new BonusService();

        long amount = 34;
        boolean registered = true;
        long expected = 1;

        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredMinBorderBonus() {
        BonusService service = new BonusService();

        long amount = 100;
        boolean registered = false;
        long expected = 1;

        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }
}