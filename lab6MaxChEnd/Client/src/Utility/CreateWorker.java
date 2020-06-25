package Utility;


import Stuff.*;

import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * The type Create worker.
 */
public class CreateWorker {
    /**
     * The constant isFromScript.
     */
    public static boolean isFromScript;
    /**
     * The Scanner.
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * The Why failed.
     */
    String whyFailed = "";
    /**
     * The constant workerFromScript.
     */
    public static Worker workerFromScript;


    /**
     * Create from execute.
     *
     * @param o the o
     */
    public void createFromExecute(String o){
        Map.Entry entry = Decoder.decodeIntoCollectionFromExecute(o).entrySet().iterator().next();
        Worker worker = (Worker) entry.getValue();
        worker.setCreationDate(Date.from(Instant.now()));

        workerFromScript = worker;

    }

    /**
     * Create person worker.
     *
     * @return the worker
     */
    public Worker createPerson(){
        Worker worker = new Worker();
        Person person =new Person();
        this.setBitrhday(person,worker);
        this.setEyeColor(person);
        this.setHairColor(person);
        this.setNationality(person);
        worker.setPerson(person);
        return worker;
    }

    /**
     * Create worker.
     *
     * @return the worker
     */
    public Worker create() {
            Worker Worker = new Worker();
            Worker.setCreationDate(Date.from(Instant.now()));
            Coordinates coords = new Coordinates();
            Person person =new Person();
            this.setNameForWorker(Worker);
            if (Worker.getName().equals("test")) return Worker;
            this.setCoordinateXForCoordinates(coords);
            this.setCoordinateYForCoordinates(coords);
            this.setSalary(Worker);
            this.setStartDate(Worker);
            this.setEndDate(Worker);
            this.setWorkerPosition(Worker);
            this.setBitrhday(person,Worker);
            this.setEyeColor(person);
            this.setHairColor(person);
            this.setNationality(person);
            Worker.setCoordinates(coords);
            Worker.setPerson(person);
            return Worker;
        }


    /**
     * Sets name for worker.
     *
     * @param Worker the worker
     */
    public void setNameForWorker(Worker Worker) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите имя работника.");
                System.out.print("~ ");
                String name = scanner.nextLine();
                if (name.equals("") || name.equals("null")) {
                    System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                    this.setNameForWorker(Worker);
                } else Worker.setName(name);
            } catch (InputMismatchException e) {
                System.out.println("Значение должно быть типа:\"String\". Введите значение заново");
                System.out.print("~ ");
                this.setNameForWorker(Worker);
            }
        }

    /**
     * Sets coordinate x for coordinates.
     *
     * @param coords the coords
     */
    public void setCoordinateXForCoordinates(Coordinates coords) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите координату x");
                System.out.print("~ ");
                String x = scanner.nextLine();
                float xn = Float.parseFloat(x);
                if (x.equals("") || x.equals(null)) {
                    System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                    this.setCoordinateXForCoordinates(coords);
                } else coords.setX(xn);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Значение должно быть типа:\"float\". Введите значение заново");
                this.setCoordinateXForCoordinates(coords);
            }
        }

    /**
     * Sets coordinate y for coordinates.
     *
     * @param coords the coords
     */
    public void setCoordinateYForCoordinates(Coordinates coords) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите координату y");
                System.out.print("~ ");
                String y = scanner.nextLine();
                if (y.equals("") || y.equals(null)||Double.parseDouble(y)>289) {
                    System.out.println("Значение не может быть нулевым или больше 289, попробуйте ещё раз.");
                    this.setCoordinateYForCoordinates(coords);
                } else {
                    Double yn = Double.parseDouble(y);
                    coords.setY(yn);
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Значение должно быть типа:\"Double\". Введите значение заново.");
                this.setCoordinateYForCoordinates(coords);
            }
        }

    /**
     * Sets salary.
     *
     * @param Worker the worker
     */
    public void setSalary(Worker Worker) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите зарплату работника");
                System.out.print("~ ");
                String price = scanner.nextLine();
                double pricen = Double.parseDouble(price);
                if (price.equals("") || price.equals(null) || pricen<=0) {
                    System.out.println("Значение не может быть меньше нуля или равно нулю, попробуйте ещё раз.");
                    this.setSalary(Worker);
                } else Worker.setSalary(pricen);
            } catch (InputMismatchException|NumberFormatException e) {
                System.out.println("Значение должно быть типа:\"double\". Введите значение заново.");
                this.setSalary(Worker);
            }
        }

    /**
     * Sets start date.
     *
     * @param Worker the worker
     */
    public void setStartDate(Worker Worker) {
            try {
                    boolean get = true;
                    LocalTime time = LocalTime.parse("09:00:00");
                    Scanner scanner = new Scanner(System.in);
                    while (get) {
                        System.out.println("Введите дату начала работы в формате \"yyyy-mm-dd\"");
                        System.out.print("~ ");
                        String comment = scanner.nextLine();
                        if (comment.equals("") || comment.equals(null)) {
                            System.out.println("Значение не может быть нулевым.");
                            this.setStartDate(Worker);
                        }
                        else {
                            LocalDate date = LocalDate.parse(comment);
                            Worker.setStartDate(ZonedDateTime.of(date, time, ZoneId.systemDefault()));
                            get = false;
                        }
                    }
                }catch (Exception e) {
                    System.out.println("Неверный формат даты,попробуйте ещё раз.");
                    this.setStartDate(Worker);
            }

        }

    /**
     * Sets end date.
     *
     * @param Worker the worker
     */
    public void setEndDate(Worker Worker) {
        try {

            LocalTime time = LocalTime.parse("19:00:00");
            Scanner scanner = new Scanner(System.in);
                System.out.println("Введите дату окончания работы в формате \"yyyy-mm-dd\"");
                System.out.print("~ ");
                String comment = scanner.nextLine();
                if (comment.equals("") || comment.equals(null)) {
                    System.out.println("Значение не может быть нулевым.");
                    this.setEndDate(Worker);
                }
                else {
                    LocalDate date = LocalDate.parse(comment);
                    if (date.isBefore(Worker.getStartDate().toLocalDate())) {
                        System.out.println("Дата окончания работы не может быть позже даты начала.Укажите дату позже данной: " + Worker.getStartDate().toLocalDate());
                        this.setEndDate(Worker);
                    } else {
                        Worker.setEndDate(LocalDateTime.of(date, time));

                    }
                }
        }catch (Exception e) {
            System.out.println("Неверный формат даты,попробуйте ещё раз.");
            this.setEndDate(Worker);
        }

    }

    /**
     * Set worker position.
     *
     * @param Worker the worker
     */
    public void setWorkerPosition(Worker Worker){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите должность работника регистр не важен.( MANAGER,HEAD_OF_DEPARTMENT,LEAD_DEVELOPER,BAKER)");
                System.out.print("~ ");
                String WorkerType = scanner.nextLine();
                if (WorkerType.equals("")||WorkerType.equals(null)){
                    Worker.setPosition(null);

                } else Worker.setPosition(Position.valueOf(WorkerType.toUpperCase()));

            }
            catch (InputMismatchException|IllegalArgumentException e){
                e.printStackTrace();
                System.out.println("Значение не подходит, введите значение заново.");
                this.setWorkerPosition(Worker);
            }
        }

    /**
     * Set hair color.
     *
     * @param person the person
     */
    public void setHairColor(Person person){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите цвет волос человека(GREEN,YELLOW,ORANGE,WHITE,BROWN)");
                System.out.print("~ ");
                String hairColor = scanner.nextLine();
                if (hairColor.equals("") || hairColor.equals(null)) {
                    System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                    this.setHairColor(person);
                } else {
                    person.setHairColor(Color.valueOf(hairColor.toUpperCase()));
                }
            }
            catch (InputMismatchException|IllegalArgumentException e){
                e.printStackTrace();
                System.out.println("Значение не подходит, введите значение заново.");
                this.setHairColor(person);
            }
        }

    /**
     * Set eye color.
     *
     * @param person the person
     */
    public void setEyeColor(Person person){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите цвет глаз человека(BLACK,ORANGE,BROWN)");
            System.out.print("~ ");
            String hairColor = scanner.nextLine();
            if (hairColor.equals("")||hairColor.equals(null)){
                person.setEyeColor(null);
            }
            else {
                person.setEyeColor(Color.valueOf(hairColor.toUpperCase()));
            }
        }
        catch (InputMismatchException|IllegalArgumentException e){
            System.out.println("Значение не подходит, введите значение заново.");
            this.setEyeColor(person);
        }
    }

    /**
     * Set nationality.
     *
     * @param person the person
     */
    public void setNationality(Person person){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите национальность человека(RUSSIA,USA,FRANCE,VATICAN,THAILAND)");
                System.out.print("~ ");
                String country = scanner.nextLine();
                if (country.equals("")||country.equals(null)) {
                    System.out.println("Значение не может быть нулевым, попробуйте ещё раз.");
                    this.setNationality(person);
                }
                else person.setNationality(Country.valueOf(country.toUpperCase()));
            }
            catch (InputMismatchException|IllegalArgumentException e){
                System.out.println("Значение не подходит, введите значение заново.");
                this.setNationality(person);
            }
        }

    /**
     * Sets bitrhday.
     *
     * @param person the person
     * @param worker the worker
     */
    public void setBitrhday(Person person,Worker worker) {
            try {
                Scanner scanner = new Scanner(System.in);
                    System.out.println("Введите день рождения работника в формате \"yyyy-mm-dd\"");
                    System.out.print("~ ");
                    String comment = scanner.nextLine();
                    if (comment.equals("") || comment.equals(null)) {
                        System.out.println("Значение не может быть нулевым.");
                        this.setBitrhday(person,worker);
                    }
                    else {
                        LocalDate date1 = LocalDate.parse(comment);
                        if (date1.isAfter(worker.getStartDate().toLocalDate())) {
                            System.out.println("У работника не может быть день рождения после начала работы,а очень жаль,мог бы налогов больше заплатить.\nВведите дату раньше данной:" + worker.getStartDate().toLocalDate());
                            this.setBitrhday(person, worker);
                        } else {
                            Date date = Date.from(date1.atStartOfDay(ZoneId.systemDefault()).toInstant());
                            person.setBirthday(date);
                        }
                    }

            }catch (Exception e) {
                System.out.println("Неверный формат даты,попробуйте ещё раз.");
                this.setBitrhday(person,worker);
            }
        }



    }