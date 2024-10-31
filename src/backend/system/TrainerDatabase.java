package backend.system;

import backend.general.Database;

public class TrainerDatabase extends Database {

    public TrainerDatabase(String filename){
        super(filename);
    }

    @Override
    public Trainer createRecordFrom(String line) {
        String[] trainerData = line.split(",");
        String trainerId = trainerData[0];
        String name = trainerData[1];
        String email = trainerData[2];
        String speciality = trainerData[3];
        String phoneNumber = trainerData[4];
        return new Trainer(trainerId, name, email, speciality, phoneNumber);
    }
    @Override
    public Trainer getRecord(String key) {
        return (Trainer) super.getRecord(key);
    }

}
