package ru.amir.dao;

import ru.amir.models.PersonRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonRecordDao {
    private Map<Long, PersonRecord> accountIndexMap;
    private Map<String, List<PersonRecord>> nameMap;
    private Map<Double, List<PersonRecord>> valueMap;

    public PersonRecordDao() {
        accountIndexMap = new HashMap<>();
        nameMap = new HashMap<>();
        valueMap = new HashMap<>();
    }

    public void addRecordPerson(PersonRecord record) {
        accountIndexMap.put(record.getAccount(), record);

        String name = record.getName();
        if (!nameMap.containsKey(name)) {
            nameMap.put(name, new ArrayList<>());
        }
        nameMap.get(name).add(record);

        double value = record.getValue();
        if (!valueMap.containsKey(value)) {
            valueMap.put(value, new ArrayList<>());
        }
        valueMap.get(value).add(record);
    }

    public void deleteRecordPerson(PersonRecord record) {
        accountIndexMap.remove(record.getAccount());
        nameMap.get(record.getName()).remove(record);
        valueMap.get(record.getValue()).remove(record);
    }

    public void updatePersonRecord(PersonRecord record) {
        deleteRecordPerson(record);
        addRecordPerson(record);
    }

    public List<PersonRecord> getPersonRecordByAccount(long account) {
        List<PersonRecord> arr = new ArrayList<>();
        PersonRecord personRecord = accountIndexMap.get(account);

        if (personRecord != null) {
            arr.add(personRecord);
        }

        return arr;
    }

    public List<PersonRecord> getPersonRecordByName(String name) {
        List<PersonRecord> arr = new ArrayList<>();
        List<PersonRecord> personRecord = nameMap.get(name);

        if (personRecord != null) {
            arr.addAll(personRecord);
        }

        return arr;
    }

    public List<PersonRecord> getPersonRecordByValue(double value) {
        List<PersonRecord> arr = new ArrayList<>();
        List<PersonRecord> personRecord = valueMap.get(value);

        if (personRecord != null) {
            arr.addAll(personRecord);
        }

        return arr;
    }

    public void printRecords() {
        for (Map.Entry<Long, PersonRecord> r :
                accountIndexMap.entrySet()) {
            System.out.println(r);
        }
    }


}
