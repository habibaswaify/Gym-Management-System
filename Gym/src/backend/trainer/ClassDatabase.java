package Gym.src.backend.trainer;

import Gym.src.backend.general.Database;

public class ClassDatabase extends Database {
    public ClassDatabase(String filename) {
        super(filename);
    }

    @Override
    public Class createRecordFrom(String line) {
        String[] classData = line.split(",");
        String classId = classData[0];
        String className = classData[1];
        String trainerId = classData[2];
        int duration = Integer.parseInt(classData[3]);
        int availableSeats = Integer.parseInt(classData[4]);
        return new Class(classId, className, trainerId, duration, availableSeats);
    }
    @Override
    public Class getRecord(String key) {
        return (Class) super.getRecord(key);
    }
}
