package ru.amir;

import ru.amir.dao.PersonRecordDao;
import ru.amir.models.PersonRecord;

public class Main {
    public static void main(String[] args) {
        PersonRecordDao personRecordDao = new PersonRecordDao();

        PersonRecord personRecord1= new PersonRecord(1L, "Test1", 200.35);
        PersonRecord personRecord2 = new PersonRecord(2L, "Test2", 300.15);
        PersonRecord personRecord3 = new PersonRecord(3L, "Test3", 400.85);

        System.out.println("Записи: ");
        personRecordDao.addRecordPerson(personRecord1);
        personRecordDao.addRecordPerson(personRecord2);
        personRecordDao.addRecordPerson(personRecord3);

        personRecordDao.printRecords();

        System.out.println("-----------------------------------------------------");

        System.out.println("Поиск по аккаунта с id 2: ");
        System.out.println(personRecordDao.getPersonRecordByAccount(2L));
        System.out.println("Поиск по имени Test3: ");
        System.out.println(personRecordDao.getPersonRecordByName("Test3"));
        System.out.println("Поиск по цене 200.35: ");
        System.out.println(personRecordDao.getPersonRecordByValue(200.35));
        System.out.println("Удаление 3 записи...");
        personRecordDao.deleteRecordPerson(personRecord3);
        System.out.println("Записи: ");
        personRecordDao.printRecords();
    }
}