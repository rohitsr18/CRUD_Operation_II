    package com.rohitsr18;

    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.Transaction;
    import org.hibernate.cfg.Configuration;

    import java.util.List;
    import java.util.Scanner;

    public class Main {
        private static final SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClasses(Student.class)
                .buildSessionFactory();

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.println("Student Details");
                System.out.println("1. Create Student");
                System.out.println("2. Read Student by Roll No.");
                System.out.println("3. Update Student Details");
                System.out.println("4. Delete Student");
                System.out.println("5. Show All Students");
                System.out.println("0. Exit");
                System.out.println("Choose an option:");
                int choice= sc.nextInt();

                switch (choice) {
                    case 1 -> create(sc);
                    case 2 -> read(sc);
                    case 3 -> update(sc);
                    case 4 -> delete(sc);
                    case 5 -> readAll(sc);
                    case 0 -> {
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    }
                    default -> {
                        System.out.println("Invalid Choice");
                    }
                    }
                }
            }

        private static void create(Scanner sc) {
            Student s = new Student();
            System.out.println("Enter Student Roll No: ");
            s.setsRollNo(sc.nextInt());
            sc.nextLine(); // consume newline
            System.out.println("Enter Student Name: ");
            s.setsName(sc.nextLine());
            System.out.println("Enter Student Age: ");
            s.setsAge(sc.nextInt());
            try(Session session = sf.openSession()) {
                Transaction tx = session.beginTransaction();
                session.persist(s);
                tx.commit();
                System.out.println("Student Saved.");
            }
        }
        private static void read(Scanner sc) {
            System.out.println("Enter Roll No to retrieve:");
            int rollNo = sc.nextInt();
            try(Session session = sf.openSession()){
                Student s = session.find(Student.class, rollNo);
                System.out.println(s!=null?s:"Student not found.");
            }
        }
        private static void update(Scanner sc) {
            System.out.println("Enter Roll No to update:");
            int rollNo = sc.nextInt();
            try(Session session = sf.openSession()){
                Transaction tx = session.beginTransaction();
                Student s = session.find(Student.class, rollNo);
                if(s!=null){
                    System.out.println("Enter new Name:");
                    sc.nextLine();
                    s.setsName(sc.nextLine());
                    System.out.println("Enter new Age:");
                    s.setsAge(sc.nextInt());
                    tx.commit();
                    System.out.println("Student Updated.");
                }
                else {
                    System.out.println("Student not found.");
                    tx.rollback();
                }
            }
        }
        private static void delete(Scanner sc) {
            System.out.println("Enter Roll No to delete:");
            int rollNo = sc.nextInt();
            try(Session session = sf.openSession()){
                Transaction tx = session.beginTransaction();
                Student s = session.find(Student.class,rollNo);
                if(s!=null){
                    session.detach(s);
                    System.out.println("Student Deleted.");
                }
                else {
                    System.out.println("Student not found.");
                    tx.rollback();
                }
            }
        }
        private static void readAll(Scanner sc) {
            try(Session session = sf.openSession()){
                List<Student> students = session.createQuery("from Student", Student.class).getResultList();
                students.forEach(System.out::println);
            }
        }
    }