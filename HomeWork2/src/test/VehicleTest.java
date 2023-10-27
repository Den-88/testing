import main.Car;
import main.Motorcycle;
import main.Vehicle;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class VehicleTest {

    //проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
    @Test
    void carInstance() {
        Car car = new Car("Tesla", "model 3", 2020);
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    //проверка того, объект Car создается с 4-мя колесами
    @Test
    void carNumWheels() {
        Car car = new Car("Tesla", "model 3", 2020);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    //проверка того, объект Car создается с 4-мя колесами
    @Test
    void motorcycleNumWheels() {
        Motorcycle motorcycle = new Motorcycle("Zero", "DS", 2022);
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    //проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void carTestDrive() {
        Car car = new Car("Tesla", "model 3", 2020);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    //проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void motorcycleTestDrive() {
        Motorcycle motorcycle = new Motorcycle("Zero", "DS", 2022);
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    //проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    void carTestPark() {
        Car car = new Car("Tesla", "model 3", 2020);
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    //проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    void motorcycleTestPark() {
        Motorcycle motorcycle = new Motorcycle("Zero", "DS", 2022);
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}
