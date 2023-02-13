package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarDao {
    void add(Car car);
    List<Car> listCars();

    Car getCar(User user);
    public Car getCarById (int id);
    public void deleteCar(int id);

}
