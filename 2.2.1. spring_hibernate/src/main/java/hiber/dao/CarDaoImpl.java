package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> listCars() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Car").getResultList();
    }

    @Override
    public Car getCar(User user) {
        return sessionFactory.getCurrentSession().get(Car.class, user.getId());

    }

    public Car getCarById (int id) {
        return sessionFactory.getCurrentSession().get(Car.class, (long) id);
    }

    public void deleteCar(int id) {
        Query q =  sessionFactory.getCurrentSession().createQuery("delete from Car c where c.id=:id");
        q.setParameter("id", (long)id);
        q.executeUpdate();
    }
}
