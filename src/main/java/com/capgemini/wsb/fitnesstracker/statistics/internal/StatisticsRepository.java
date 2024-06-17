package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    List<Statistics> findAllByUser(User user);
    List<Statistics> findAllByTotalCaloriesBurnedGreaterThan(int caloriesBurned);
}
