package ua.konstantynov.test4.service;

import ua.konstantynov.test4.dao.RaceDao;
import ua.konstantynov.test4.entities.Horse;
import ua.konstantynov.test4.entities.Race;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacesService {
    private static final RaceDao RACE_DAO = new RaceDao();
    private static int horsePlace;

    public void save(Race race) {
        RACE_DAO.save(race);
    }

    public void deleteAll() {
        RACE_DAO.deleteAll();
    }

    public Race get(Long id) {
        return RACE_DAO.get(id);
    }

    public long getCount() {
        return RACE_DAO.getCount();
    }

    public List<Race> getAll() {
        return RACE_DAO.getAll();
    }

    synchronized public static int incrementAndGetHorsePlace() {
        return ++horsePlace;
    }

    public Race startRace(int horseCount, int horseNumber) throws IllegalArgumentException {
        List<Horse> horseList = new ArrayList<>();
        if (horseCount < 1) {
            throw new IllegalArgumentException("horseCount must be a natural number");
        }
        if (horseNumber < 1) {
            throw new IllegalArgumentException("horseNumber must be a natural number");
        }
        if (horseNumber > horseCount) {
            throw new IllegalArgumentException("The horseNumber must be greater or equals than the horseCount");
        }
        Race race = new Race();
        for (int i = 1; i <= horseCount; i++) {
            Horse horse = new Horse();
            horse.setNumber(i);
            horse.setRace(race);
            horseList.add(horse);
            horse.start();
        }
        for (Horse horse : horseList) {
            try {
                horse.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        race.setHorseNumber(horseNumber);
        race.setHorseCount(horseCount);
        race.setHorses(horseList.stream().sorted(Comparator.comparing(Horse::getPlace)).collect(Collectors.toList()));
        race.setDateTime(LocalDateTime.now());
        horsePlace = 0;
        return race;
    }
}
