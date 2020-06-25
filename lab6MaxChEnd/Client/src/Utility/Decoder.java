package Utility;

import Stuff.*;

import java.io.*;
import java.lang.invoke.WrongMethodTypeException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * The type Decoder.
 */
public class Decoder{
    /**
     * Decode into collection hashtable.
     *
     * @param s the s
     * @return the hashtable
     */
    public static Hashtable<Long, Worker> decodeIntoCollection(String s) {
        Hashtable<Long, Worker> collection = new Hashtable<>();
        String errorMessage="В ходе заполнения коллекции возникли следующие ошибки:\n";
        if (s.length()>0){
            String a[] = s.split("\n");
            for(int i=0;i<a.length;i++) {
                String b[] = a[i].split(",");
                Worker Worker = new Worker();
                Coordinates coordinates = new Coordinates();
                Person person = new Person();

                try {
                    if (b[0].equals("") || b[0] == null) {
                        throw new Exception();
                    } else Worker.setId(Long.parseLong(b[0]));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указано айди у работника №" + Worker.getId() + ",изменено на другое уникальное значение,можете исправить с помощью команды update.");
                    Worker.setId(WorkerCollection.generateId());
                }


                try {

                    if (b[1].equals("") || b[1] == null) {
                        throw new Exception();
                    } else Worker.setName(b[1]);
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указано имя у работника №" + Worker.getId() + ",изменено на Name,можете исправить с помощью команды update.");
                    Worker.setName("Name");
                }




                try {
                    if (b[2].equals("") || b[2] == null ) {
                        throw new Exception();
                    } else coordinates.setX(Float.parseFloat(b[2]));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана координата Х у работника №" + Worker.getId() + ",изменено на 0,можете исправить с помощью команды update.");
                    coordinates.setX(0);
                }



                try {
                    if (b[3].equals("") || b[3] == null || Double.parseDouble(b[3])>289D) {
                        throw new Exception();
                    } else coordinates.setY(Double.parseDouble(b[3]));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана координата Y у работника №" + Worker.getId() + ",изменено на 0,можете исправить с помощью команды update.");
                    coordinates.setY((double) 0);
                }

                Worker.setCoordinates(coordinates);


                try {
                    if (b[4].equals("") || b[4] == null) {
                        throw new Exception();
                    } else {
                        String stringDateFormat = "EEE MMM dd HH:mm:ss z yyyy";
                        SimpleDateFormat format = new SimpleDateFormat(stringDateFormat, Locale.US);
                        Worker.setCreationDate(format.parse(b[4]));
                    }
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана дата создания элемента у работника №" + Worker.getId() + ",изменено на нынешнее время,можете исправить с помощью команды update.");
                    Worker.setCreationDate(Date.from(Instant.now()));
                }

                try {
                    if (Double.parseDouble(b[5]) <= 0) {
                        throw new Exception();
                    } else Worker.setSalary(Double.parseDouble(b[5]));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана зарплата у работника №" + Worker.getId() + ",изменено на 1,можете исправить с помощью команды update.");
                    Worker.setSalary(1);
                }

                try {
                    Worker.setStartDate(ZonedDateTime.parse(b[6]));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана дата начала работы у работника №" + Worker.getId() + ",изменено на время сейчас,можете исправить с помощью команды update.");
                    Worker.setStartDate(ZonedDateTime.now());
                }

                try {
                    if (LocalDateTime.parse(b[7]).isBefore((Worker.getStartDate().toLocalDate()).atStartOfDay())) throw new Exception();
                    else Worker.setEndDate(LocalDateTime.parse(b[7]));
                }
                catch (Exception e){
                    e.printStackTrace();
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана дата конца работы у работника №\" + Worker.getId() + \",изменено на время сейчас,можете исправить с помощью команды update.");
                    Worker.setEndDate(LocalDateTime.now());
                }
                try {
                    if (b[8].equals("")) Worker.setPosition(null);
                    else Worker.setPosition(Position.valueOf((b[8]).toUpperCase()));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана Должность у человека билетом №" + Worker.getId() + ",изменено на RUSSIA,можете исправить с помощью команды update.");
                    Worker.setPosition((Position.MANAGER));
                }

                try {
                    if (b[9].equals("") || b[9] == null) {
                        throw new Exception();
                    } else {
                        String stringDateFormat = "EEE MMM dd HH:mm:ss z yyyy";
                        SimpleDateFormat format = new SimpleDateFormat(stringDateFormat, Locale.US);
                        person.setBirthday(format.parse(b[9]));
                    }
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана дата рождения у работника №" + Worker.getId() + ",изменено на нынешнее время,можете исправить с помощью команды update.");
                    person.setBirthday(Date.from(Instant.now()));
                }

                try {
                    if (b[10].equals("")) person.setEyeColor(null);
                    else person.setEyeColor(Color.valueOf((b[10]).toUpperCase()));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указан цвет глаз у работника №" + Worker.getId() + ",изменено на BLACK,можете исправить с помощью команды update.");
                    person.setEyeColor(Color.BLACK);
                }

                try {
                    person.setHairColor(Color.valueOf((b[11]).toUpperCase()));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указан цвет волос у работника №" + Worker.getId() + ",изменено на BLACK,можете исправить с помощью команды update.");
                    person.setHairColor(Color.BLACK);
                }

                try {
                    person.setNationality(Country.valueOf((b[12]).toUpperCase()));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана национальность у работника №" + Worker.getId() + ",изменено на RUSSIA,можете исправить с помощью команды update.");
                    person.setNationality(Country.RUSSIA);
                }
                Worker.setPerson(person);
                collection.put(Worker.getId(), Worker);
            }
        }
        return collection;
    }

    /**
     * Decode into collection from execute hashtable.
     *
     * @param s the s
     * @return the hashtable
     */
    public static Hashtable<Long, Worker> decodeIntoCollectionFromExecute(String s) {
        Hashtable<Long, Worker> collection = new Hashtable<>();
        String errorMessage="В ходе заполнения коллекции возникли следующие ошибки:\n";
        if (s.length()>0){
            String a[] = s.split("\n");
            for(int i=0;i<a.length;i++) {
                String b[] = a[i].split(";");
                Worker Worker = new Worker();
                Coordinates coordinates = new Coordinates();
                Person person = new Person();
                Worker.setId(WorkerCollection.generateId());


                try {

                    if (b[0].equals("") || b[0] == null) {
                        throw new Exception();
                    } else Worker.setName(b[0]);
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указано имя у работника №" + Worker.getId() + ",изменено на Name,можете исправить с помощью команды update.");
                    Worker.setName("Name");
                }


                try {
                    if (b[1].equals("") || b[1] == null ) {
                        throw new Exception();
                    } else coordinates.setX(Float.parseFloat(b[1]));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана координата Х у работника №" + Worker.getId() + ",изменено на 0,можете исправить с помощью команды update.");
                    coordinates.setX(0);
                }



                try {
                    if (b[2].equals("") || b[2] == null || Double.parseDouble(b[2])>289D) {
                        throw new Exception();
                    } else coordinates.setY(Double.parseDouble(b[2]));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана координата Y у работника №" + Worker.getId() + ",изменено на 0,можете исправить с помощью команды update.");
                    coordinates.setY((double) 0);
                }

                Worker.setCoordinates(coordinates);



                try {
                    if (Double.parseDouble(b[3]) <= 0) {
                        throw new Exception();
                    } else Worker.setSalary(Double.parseDouble(b[3]));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана зарплата у работника №" + Worker.getId() + ",изменено на 1,можете исправить с помощью команды update.");
                    Worker.setSalary(1);
                }

                try {
                    Worker.setStartDate(ZonedDateTime.parse(b[4]));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана дата начала работы у работника №" + Worker.getId() + ",изменено на время сейчас,можете исправить с помощью команды update.");
                    Worker.setStartDate(ZonedDateTime.now());
                }

                try {
                    Worker.setEndDate(LocalDateTime.parse(b[5]));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана дата конца работы у работника №" + Worker.getId() + ",изменено на время сейчас,можете исправить с помощью команды update.");
                    Worker.setEndDate(LocalDateTime.now());
                }
                try {
                    Worker.setPosition(Position.valueOf((b[7]).toUpperCase()));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана Должность у человека билетом №" + Worker.getId() + ",изменено на MANAGER,можете исправить с помощью команды update.");
                    Worker.setPosition((Position.MANAGER));
                }

                try {
                    if (b[8].equals("") || b[8] == null) {
                        throw new Exception();
                    } else {
                        String stringDateFormat = "EEE MMM dd HH:mm:ss z yyyy";
                        SimpleDateFormat format = new SimpleDateFormat(stringDateFormat, Locale.US);
                        person.setBirthday(format.parse(b[8]));
                    }
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана дата дня рождения у работника №" + Worker.getId() + ",изменено на нынешнее время,можете исправить с помощью команды update.");
                    person.setBirthday(Date.from(Instant.now()));
                }

                try {
                    person.setEyeColor(Color.valueOf((b[9]).toUpperCase()));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указан цвет глаз у работника №" + Worker.getId() + ",изменено на BLACK,можете исправить с помощью команды update.");
                    person.setEyeColor(Color.BLACK);
                }

                try {
                    person.setHairColor(Color.valueOf((b[10]).toUpperCase()));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указан цвет волос у работника №" + Worker.getId() + ",изменено на BLACK,можете исправить с помощью команды update.");
                    person.setHairColor(Color.BLACK);
                }

                try {
                    person.setNationality(Country.valueOf((b[11]).toUpperCase()));
                }
                catch (Exception e){
                    System.out.print(errorMessage);
                    errorMessage = "";
                    System.out.println("Некорректно указана национальность у работника №" + Worker.getId() + ",изменено на RUSSIA,можете исправить с помощью команды update.");
                    person.setNationality(Country.RUSSIA);
                }
                Worker.setPerson(person);
                collection.put(Worker.getId(), Worker);
            }
        }
        return collection;
    }


}
