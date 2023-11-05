package seminars.second.life_cycle_JUnit5;

import org.junit.jupiter.api.*;
import seminars.second.hw.Car;
import seminars.second.hw.Motorcycle;
import seminars.second.hw.Vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLC {
    private static Car car;
    private static Motorcycle motorcycle;

    @BeforeAll
    static void setup() {
        car = new Car("Toyota", "Camry", 2023);
        motorcycle = new Motorcycle("Yamaha", "SpeedUp", 2021);
    }

    //   @BeforeEach
    //   void setupThis() {
    //      System.out.println("@BeforeEach");
    //   }

    //   @Test
    //  void testOne() {
    //      System.out.println("testOne");
    //  }

    @Test
    // - Проверить, что экземпляр объекта Car также является экземпляром
    // транспортного средства (используя оператор instanceof).
    public void testCarIsInstanceOfVehicle() {
        //Car car = new Car("Toyota", "Camry", 2023);
        assertTrue(car instanceof Vehicle);
    }

    @Test
    // - Проверить, что объект Car создается с 4-мя колесами.
    public void testCarNumWheelsToCount() {
        //Car car = new Car("Toyota", "Camry", 2023);
        assertEquals(4, car.getNumWheels());
    }

    @Test
    // - Проверить, что объект Motorcycle создается с 2-мя колесами.
    public void testMotorcycleNumWheelsToCount() {
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    //- Проверить, что объект Car развивает скорость 60 в режиме
    // тестового вождения (используя метод testDrive()).
    public void testDriveSpeedToCheckCar(){
        car.testDrive(); // тестовая поездка
        assertEquals(60, car.getSpeed()); // проверка скорости
    }

    @Test
    // - Проверить, что объект Motorcycle развивает скорость 75
    // в режиме тестового вождения (используя метод testDrive()).
    public void testDriveSpeedToCheckMotorcycle(){
        motorcycle.testDrive(); // тестовая поездка
        assertEquals(75, motorcycle.getSpeed()); // проверка скорости
    }

    @Test
    // - Проверить, что в режиме парковки (сначала testDrive, потом park,
    // т.е. эмуляция движения транспорта)
    // машина останавливается (speed = 0).
    public void testParkingSpeedZeroCar(){
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    // - Проверить, что в режиме парковки (сначала testDrive,
    // потом park, т.е. эмуляция движения транспорта)
    // мотоцикл останавливается (speed = 0).
    public void testParkingSpeedZeroMotorcycle(){
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }




//    @Test
    //   void testTwo() {
    //       System.out.println("testTwo");
    //   }

    //   @AfterEach
//    void tearThis() {
    //       System.out.println("@AfterEach");
    //  }

 //   @AfterAll
 //   static void tear() {
  //      System.out.println("@AfterAll");
  //  }
}
