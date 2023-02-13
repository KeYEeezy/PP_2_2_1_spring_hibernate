package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.CarDaoImpl;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Component
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    @Transactional
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    @Transactional
    public List<Car> listCars() {
        return carDao.listCars();
    }

    @Override
    @Transactional
    public Car getCar(User user) {
        return carDao.getCar(user);
    }

    public Car getCarById (int id) {
        return carDao.getCarById(id);
    }
    public void deleteCar(int id) {
        carDao.deleteCar(id);
    }
}
