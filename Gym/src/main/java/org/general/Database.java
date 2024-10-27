package org.general;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Database {
    private String filename;
    private ArrayList<Record> records;

    public Database(String filename){
        this.filename = filename;
        this.records = new ArrayList<>();
    }

    public void readFromFile() throws IOException {
        File file = new File(this.filename);
        if (!file.exists() || file.length() == 0) {
            return;
        }
        FileReader fr = new FileReader(this.filename);
        BufferedReader bf = new BufferedReader(fr);
        String line;
        Record record;
        while ((line = bf.readLine()) != null) {
            record = createRecordFrom(line);
            this.returnAllRecords().add(record);
        }
        bf.close();
    }

    public ArrayList<Record> returnAllRecords() {
        return this.records;
    }

    public boolean contains(String key) {
        for (Record record: this.returnAllRecords())
            if (Objects.equals(record.getSearchKey(), key)) return true;
        return false;
    }

    public Record getRecord(String key) {
        for (Record record: this.returnAllRecords())
            if (Objects.equals(record.getSearchKey(), key))
                return record;
        return null;
    }

    public void insertRecord(Record record) {
        // Implement the logic to add a trainer to the list of records
        records.add(record);
    }

    public void deleteRecord(String key) {
        this.records.remove(this.getRecord(key));
    }

    public void saveToFile() throws IOException {
        FileWriter fw = new FileWriter(this.filename);
        BufferedWriter bw = new BufferedWriter(fw);
        String line;
        for (Record record: this.returnAllRecords()) {
            line = record.LineRepresentation();
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }

    public abstract Record createRecordFrom(String line);

}
