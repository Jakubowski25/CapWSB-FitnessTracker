package com.capgemini.wsb.fitnesstracker.mail.internal;

import com.capgemini.wsb.fitnesstracker.mail.api.EmailDto;
import com.capgemini.wsb.fitnesstracker.mail.api.EmailSender;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingProvider;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class ReportScheduler {
    private final TrainingProvider trainingProvider;
    private final UserProvider userProvider;
    private final EmailSender emailSender;

    @Scheduled(cron = "0 0 2 3,18 * *")
    public void generateAndSendReports() {
        List<User> allUsers = userProvider.findAllUsers();
        Calendar sevenDaysAgo = Calendar.getInstance();
        sevenDaysAgo.add(Calendar.DAY_OF_WEEK, -7);
        for(User user : allUsers) {
            List<Training> userTrainings = trainingProvider.findTrainingsForUser(user);
            long lastWeekTrainings = userTrainings.stream().filter(training -> training.getEndTime().after(sevenDaysAgo.getTime())).count();
            emailSender.send(new EmailDto(user.getEmail(), "Training report", "Trainings total in the application %s, trainings this week %s".formatted(userTrainings.size(), lastWeekTrainings)));
        }
    }
}
