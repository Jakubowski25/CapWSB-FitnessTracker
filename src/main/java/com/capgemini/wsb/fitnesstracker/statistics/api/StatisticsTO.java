package com.capgemini.wsb.fitnesstracker.statistics.api;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsTO {
    @Nullable
    private Long id;
    private Long userId;
    private int totalTrainings;
    private double totalDistance;
    private int totalCalories;
}
