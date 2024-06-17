package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsTO;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl {
    private final StatisticsMapper statisticsMapper;
    private final StatisticsRepository statisticsRepository;
    private final UserProvider userProvider;

    public void saveNewStatistics(StatisticsTO statisticsTO) {
        User user = userProvider.getUser(statisticsTO.getUserId()).get();
        Statistics statistics = statisticsMapper.toEntity(statisticsTO);
        statistics.setUser(user);
        Statistics savedEntity = statisticsRepository.save(statistics);
        statisticsTO.setId(savedEntity.getId());
    }

    public List<StatisticsTO> getStatisticsForUser(Long userId) {
        User user = userProvider.getUser(userId).get();
        return statisticsRepository.findAllByUser(user).stream().map(statisticsMapper::toTO).collect(Collectors.toList());
    }

    public void deleteById(Long statisticId) {
        statisticsRepository.deleteById(statisticId);
    }

    public List<StatisticsTO> getStatisticsByCaloriesBurned(int calories) {
        return statisticsRepository.findAllByTotalCaloriesBurnedGreaterThan(calories).stream().map(statisticsMapper::toTO).collect(Collectors.toList());
    }
}
