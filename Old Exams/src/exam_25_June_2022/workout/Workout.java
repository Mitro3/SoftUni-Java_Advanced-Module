package exam_25_June_2022.workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise (Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        Exercise exercise = null;
        exercise = exercises.stream().filter(e -> e.getName().equals(name))
                .filter(e -> e.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);

        if (exercise != null) {
            exercises.remove(exercise);
            return true;
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        return exercises.stream().filter(e -> e.getName().equals(name))
                .filter(e -> e.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories))
                .orElse(null);
    }

    public int getExerciseCount() {
        return this.exerciseCount;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("Workout type: ");
        sb.append(type);

        exercises.forEach(e -> sb.append("Exercise: ").append(e.toString()).append(String.format("%n")));


        return sb.toString().trim();
    }

}
