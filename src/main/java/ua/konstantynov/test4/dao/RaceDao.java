package ua.konstantynov.test4.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.konstantynov.test4.entities.Race;
import ua.konstantynov.test4.utils.HibernateUtils;

import java.util.List;

public class RaceDao {
    public void save(Race race) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(race);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery("TRUNCATE race CASCADE").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Race get(Long id) {
        Transaction transaction = null;
        Race race = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            race = session.get(Race.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return race;
    }

    public long getCount() {
        Transaction transaction = null;
        long result = 0;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            result = (long) session.createQuery("SELECT COUNT(r.identifier) FROM Race r").uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return result;
    }

    public List<Race> getAll() {
        Transaction transaction = null;
        List<Race> races = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            races = session.createQuery(
                    "SELECT r FROM Race r", Race.class)
                    .list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return races;
    }
}
