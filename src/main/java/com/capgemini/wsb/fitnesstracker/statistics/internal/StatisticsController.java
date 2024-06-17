package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/statistics")
@RequiredArgsConstructor
class StatisticsController {
    private final StatisticsServiceImpl statisticsService;

    @PostMapping
    public ResponseEntity<StatisticsTO> createNewStatistic(@RequestBody StatisticsTO statisticsTO) {
        statisticsService.saveNewStatistics(statisticsTO);
        return ResponseEntity.ok(statisticsTO);
    }

    @PutMapping
    public ResponseEntity<StatisticsTO> updateStatistic(@RequestBody StatisticsTO statisticsTO) {
        statisticsService.saveNewStatistics(statisticsTO);
        return ResponseEntity.ok(statisticsTO);
    }

    @GetMapping
    public ResponseEntity<List<StatisticsTO>> getStatisticsForUser(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(statisticsService.getStatisticsForUser(userId));
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteStatistic(@RequestParam("statisticId") Long statisticId) {
        statisticsService.deleteById(statisticId);
        return ResponseEntity.ok(statisticId);
    }

    @GetMapping("/{calories}")
    public ResponseEntity<List<StatisticsTO>> findStatisticByCalories(@PathVariable int calories) {
        return ResponseEntity.ok(statisticsService.getStatisticsByCaloriesBurned(calories));
    }
}
