package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingProvider;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// TODO: Provide Impl
@Component
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingProvider {
    private final TrainingRepository trainingRepository;
    @Override
    public Optional<User> getTraining(final Long trainingId) {
        throw new UnsupportedOperationException("Not finished yet");
    }
    @Override
    public List<Training> findTrainingsForUser(User user) {
        return trainingRepository.findAllByUser(user);
    }
}
