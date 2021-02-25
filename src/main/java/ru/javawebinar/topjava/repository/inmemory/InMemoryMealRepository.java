package ru.javawebinar.topjava.repository.inmemory;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryMealRepository implements MealRepository {
    private final Map<String, Meal> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        //MealsUtil.meals.forEach(this::save);
    }

    {
        for (Meal meal : MealsUtil.meals) {
            this.save(meal, 1);
        }
    }

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()) {
            meal.setUserId(userId);
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getUserId() + "-" + meal.getId(), meal);
            return meal;
        }
        // handle case: update, but not present in storage
        return repository.computeIfPresent(meal.getUserId() + "-" + meal.getId(), (id, oldMeal) -> meal);
    }

    @Override
    public boolean delete(int id, int userId) {
        boolean hasUserId = false;
        for (Map.Entry<String, Meal> pair : repository.entrySet()) {
            try {
                if (Integer.parseInt(pair.getKey().split("-")[0])  == userId) {
                    hasUserId = true;
                }
            } catch (Exception e) {

            }
        }

        return hasUserId && repository.remove(userId + "-" + id) != null;

        //return repository.remove(userId + "-" + id) != null;
    }

    @Override
    public Meal get(int id, int userId) {
        boolean hasUserId = false;
        for (Map.Entry<String, Meal> pair : repository.entrySet()) {
            try {
                if (Integer.parseInt(pair.getKey().split("-")[0])  == userId) {
                    hasUserId = true;
                }
            } catch (Exception e) {

            }
        }
        if (hasUserId) {
            return repository.get(userId + "-" + id);
        } else return null;
        //return repository.get(id);
    }

    @Override
    public Collection<Meal> getAll() {
        List<Meal> list = new ArrayList<>(repository.values());
        //list = list.stream().
        List<Meal> reverseList = new ArrayList<>();
        for (int i = list.size() - 1; i == 0; i--) {

        }
        return list.stream().collect(Collectors.toList());
    }
}

