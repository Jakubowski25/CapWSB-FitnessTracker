package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsTO;
import org.springframework.stereotype.Component;

@Component
class StatisticsMapper {
    Statistics toEntity(StatisticsTO statisticsTO) {
        return new Statistics(statisticsTO.getId(),
                statisticsTO.getTotalTrainings(),
                statisticsTO.getTotalDistance(),
                statisticsTO.getTotalCalories());
    }

    StatisticsTO toTO(Statistics statistics) {
        return new StatisticsTO(statistics.getId(),
                statistics.getUser().getId(),
                statistics.getTotalTrainings(),
                statistics.getTotalDistance(),
                statistics.getTotalCaloriesBurned());
    }
}
