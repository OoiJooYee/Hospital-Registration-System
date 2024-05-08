import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalRegistrationSystem {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<RegisterQueue> queues = new ArrayList<RegisterQueue>();
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
        
        // Initialize the administrators
        Administrator[] admin = { new Administrator("Wai Jia Wen", "011029010258", "29-10-2001", "Female", new Address("Jalan Delima 24", "Kluang", 86000, "Johor"), "0177026808", "waiwen@graduate.utm.my", "AM001", 4000),
                                  new Administrator("James Lee", "960213017875", "13-02-1996", "Male", new Address("Jalan Sri Putri 15", "Skudai", 81300, "Johor"), "01112344321", "leejames@gmail.com", "AM002", 5000)
                                };

        // Initialize some patients
        Patient[] p = { new Patient("Hannah Lim", "980920016778", "20-09-1998", "Female", new Address("Jalan Mewah 3", "Johor Bahru", 80300, "Johor"), "0167788563", "hannah@gmail.com", null, new EmergencyContact("Janice Lim", "Sister", "0127013738"), "University Student"),
                        new Patient("Wong Hui Min", "061223019788", "23-12-2006", "Female", new Address("Jalan Delima 24", "Kluang", 86000, "Johor"), "0198989011", "huimin@gmail.com", new Guardian("Wong Ming Hui", "Father"), new EmergencyContact("Wong Ming Hui", "Father", "0199798473"), "High School Student"),
                        new Patient("Lau Jun Min", "091011018931", "11-10-2009", "Male", new Address("Jalan Delima 24", "Kluang", 86000, "Johor"), "01111112222", "junmin@gmail.com", new Guardian("Lau Tung Ling", "Father"), new EmergencyContact("Lau Tung Ling", "Father", "01112345678"), "Medium School Student"),
                        new Patient("Chiew Jin Hong", "980815018999", "15-08-1998", "Male", new Address("Jalan Delima 24", "Kluang", 86000, "Johor"), "0145656788", "jinhong@gmail.com", null, new EmergencyContact("Chiew Hui Xian", "Sister", "0187878392"), "Accountant"),
                        new Patient("Rong Yi Hui", "990117014904", "11-01-1999", "Female", new Address("Jalan Delima 24", "Kluang", 86000, "Johor"), "0133334556", "yihui@gmail.com", null, new EmergencyContact("Rong Ming Hui", "Brother", "0133366738"), "Lawyer"),
                        new Patient("Yew Yu Wei", "871223018901", "23-12-1987", "Male", new Address("Jalan Delima 24", "Kluang", 86000, "Johor"), "0198899782", "yuwei@gmail.com", null, new EmergencyContact("Wong Mei Ling", "Wife", "01122234567"), "Mechanic")
                      };

        // Initialize the departments
        Department[] d = { new Department("ER", "Emergency Room. First point of contact for any critically ill patient, needing immediate medical attention."),
                           new Department("OPD", "Outpatient Department. Consultation is given to the ambulatory patients by specialists or super-specialists."),
                           new Department("IPD", "Inpatient Department. Take care of patients admitted in the hospital for at least a night.")
                         };
        
        // Services provided by hospital
        String[] services = {"Emergency Care", "Medical or Surgical Treatment", "Labor and Delivery Services", "Diagnosis of Disease", "Nutritional Counseling", "Laboratory Test"};

        // Initialize the doctors
        Doctor[] doc = { new Doctor("Dr. Lee Wei Kim", "890325017875", "23-03-1989", "Male", new Address("Jalan Putra 8", "Skudai", 81300, "Johor"), "0187799808", "weikim@yahoo.com", "DC001", 17500,  "Permanent Doctor", d[0]),
                         new Doctor("Dr. Yew Minnie", "880222015668", "22-02-1988", "Female", new Address("Jalan Sultan Ismail 2", "Skudai", 81300, "Johor"), "0139898055", "minnie@gmail.com", "DC002", 18000, "Permanent Doctor", d[1]),
                         new Doctor("Dr. Lim Yu Wei", "920413017007", "13-04-1992", "Male", new Address("Jalan Eco 5", "Skudai", 81300, "Johor"), "0157788939", "yuwei@gmail.com", "DC003", 23000, "Visiting Doctor", d[2]),
                         new Doctor("Dr. Vanessa Kim", "940721014862", "21-07-1994", "Female", new Address("Jalan Kurnia 10", "Johor Bahru", 80300, "Johor"), "01123456545", "vanessa@gmail.com", "DC004", 20000, "Permanent Doctor", d[2])
                       };

        // adding system users into User ArrayList
        for (int i=0; i<admin.length; i++){
            users.add(admin[i]);
        }
        for (int i=0; i<p.length; i++){
            users.add(p[i]);
        }
        for (int i=0; i<doc.length; i++){
            users.add(doc[i]);
        }

        clearConsole();
        int operation = 0;

        boolean loop = true; // continue looping until 3 (Quit) is chosen in userMenu

        operation = userMenu(input); // call the userMenu function

        while(loop){
            switch(operation){
                // user Login
                case 1: {
                    clearConsole();
                    User u = login(input, users);
                    int noOp = 0;
                    boolean loop2 = true;
                    if (u == null){
                        clearConsole();
                        operation = userMenu(input); // call the userMenu function
                        break;
                    }
                    else{
                        if(u instanceof Administrator){
                            clearConsole();
                            System.out.println("\nAdministrator (" + u.getName() + ") user session.");
                            noOp = administratorMenu(input); // call the administratorMenu function
                            while(loop2){
                                switch(noOp){
                                    case 1: {
                                        clearConsole(); viewUsers(users); 
                                        noOp = administratorMenu(input); // call the administratorMenu function
                                    }break;
                                    case 2: { 
                                        if (users.size() != 0){
                                        int num = manageUsers(input, users, d);
                                            if (num == 2){
                                                clearConsole();
                                            }
                                            else{
                                                clearConsole();
                                                System.out.println("\nUser is updated.");
                                            }
                                        }else{
                                            clearConsole();
                                            System.out.println("\nThere is no system user.");
                                        }
                                        noOp = administratorMenu(input); // call the administratorMenu function
                                    }break;
                                    case 3: clearConsole(); loop2 = false; break;
                                    default: {
                                        clearConsole();
                                        System.out.println("\nInvalid operation. Please try again.");
                                        noOp = administratorMenu(input); // call the administratorMenu function
                                    }break;
                                }
                            }
                        }
                        else if(u instanceof Doctor){
                            clearConsole();
                            System.out.println("\nDoctor (" + u.getName() + ") user session.");
                            noOp = doctorMenu(input); // call the doctorMenu function
                            while(loop2){
                                switch(noOp){
                                    case 1: {
                                        if (queues.size() == 0){
                                            clearConsole();
                                            System.out.println("\nThere is no patient waiting in the queue.");
                                        }
                                        else{
                                            clearConsole();
                                            int num = makeMedicalRecord(input, queues.get(0), (Doctor)u, medicalRecords);
                                            clearConsole();
                                            if (num == 1){
                                                queues.remove(0);
                                                RegisterQueue.diagnosedQueue += 1;
                                                System.out.println("\nMedical record is made.");
                                            }
                                        }
                                        noOp = doctorMenu(input); // call the doctorMenu function
                                    }break;
                                    case 2: {
                                        clearConsole(); viewMedicalRecords(medicalRecords);
                                        noOp = doctorMenu(input); // call the doctorMenu function
                                    }break;
                                    case 3: {
                                        clearConsole(); viewRegisteredQueue(queues); 
                                        noOp = doctorMenu(input); // call the doctorMenu function
                                    }break;
                                    case 4: {
                                        clearConsole(); viewAppointments(appointments); 
                                        noOp = doctorMenu(input); // call the doctorMenu function
                                    }break;
                                    case 5: loop2 = false; break;
                                    default: {
                                        clearConsole();
                                        System.out.println("\nInvalid operation. Please try again.");
                                        noOp = doctorMenu(input); // call the doctorMenu function
                                    }break;
                                }
                            }
                        }
                        else if(u instanceof Patient){ 
                            clearConsole();
                            System.out.println("\nPatient (" + u.getName() + ") user session.");
                            noOp = patientMenu(input);
                            while(loop2){
                                switch(noOp){
                                    case 1: {
                                        RegisterQueue q = takeQueueNumber(input, (Patient)u, services);
                                        clearConsole();
                                        if (q != null){
                                            queues.add(q);
                                            clearConsole();
                                            System.out.println("\nQueue number is taken.");
                                            System.out.println("Your queue number is: " + q.getQueueNo());
                                            System.out.println("Currently waiting in queue: " + q.getCurrentWaitingInQueue());
                                        }
                                        noOp = patientMenu(input); // call the patientMenu function
                                    }break;
                                    case 2: {
                                        clearConsole();
                                        int num = makeAppointment(input, (Patient)u, services, appointments); 
                                        clearConsole();
                                        if (num == 1){
                                            System.out.println("\nAppointment is done.");
                                        }
                                        noOp = patientMenu(input); // call the patientMenu function
                                    }break;
                                    case 3: {
                                        if (((Patient)u).getAppointment().size() != 0){
                                            clearConsole();
                                            int num = manageAppointment(input, (Patient)u, services, appointments);
                                            clearConsole();
                                            if (num == 1){
                                                System.out.println("\nAppointment is updated.");
                                            }
                                        }else{
                                            clearConsole();
                                            System.out.println("\nNo appointment is made.");
                                        }
                                        noOp = patientMenu(input); // call the patientMenu function
                                    }break;
                                    case 4: clearConsole(); loop2 = false; break;
                                    default: {
                                        clearConsole();
                                        System.out.println("\nInvalid operation. Please try again.");
                                        noOp = patientMenu(input); // call the patientMenu function
                                    }break;
                                }
                            }
                        }
                    }
                }break;
                
                // user Registration
                case 2:{
                    clearConsole();
                    User u = registerUser(input, d);
                    if (u == null){
                        clearConsole();
                        operation = userMenu(input); // call the userMenu function
                    }
                    else{
                        clearConsole();
                        if (u instanceof Patient)
                            System.out.println("\nPatient (" + u.getName() + ") registered sucessfully.");
                        else if (u instanceof Doctor)
                            System.out.println("\nDoctor (" + u.getName() + ") registered sucessfully.");
                        else if (u instanceof Administrator)
                            System.out.println("\nAdministrator (" + u.getName() + ") registered sucessfully.");
                        users.add(u);
                        operation = userMenu(input); // call the userMenu function
                    }
                }break;
                
                // user Quit
                case 3: loop = false; break;
                
                // invalid choice, call the userMenu function again
                default: {
                    clearConsole();
                    System.out.println("\nInvalid operation. Please try again.");
                    operation = userMenu(input); // call the userMenu function
                }break;
            }
        }

        System.exit(0);
    }

    //clear display screen
    public final static void clearConsole(){  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    // for all User
    public static int userMenu(Scanner sc){
        System.out.println("\nHOSPITAL REGISTRATION SYSTEM");
        System.out.println("----------------------------");
        System.out.println("1. Login\n2. Registration (First time user)\n3. Quit");
        System.out.printf("Choose your operation: ");
        int choice = 0;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Input format is wrong!");
            System.exit(0);
        }
        return choice;
    }

    public static User registerUser(Scanner sc, Department[] d){
        System.out.println("\nREGISTRATION");
        System.out.println("------------");
        System.out.println("Choose your role accordingly");
        System.out.println("1. Administrator\n2. Doctor\n3. Patient\n4. Return to Homepage");
        System.out.printf("Choose your operation: ");
        int choice = 0;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Input format is wrong!");
            System.exit(0);
        }

        String name, ic, DOB, gender, street, city, state, phone, email, staffid, role, department;
        User u = null; 
        int postcode = 0; double salary = 0;

        switch(choice){
            // Administrator registration
            case 1: {
                clearConsole();
                System.out.println("\nADMINISTRATOR REGISTRATION");
                System.out.println("--------------------------");
                System.out.println("Personal Details");
                System.out.print("Name: "); name = sc.nextLine();
                System.out.print("IC No.: "); ic = sc.nextLine();
                System.out.print("DOB: "); DOB = sc.nextLine();
                System.out.print("Gender: "); gender = sc.nextLine();
                System.out.println("\nAddress Information");
                System.out.print("Street: "); street = sc.nextLine();
                System.out.print("City: "); city = sc.nextLine();
                System.out.print("Postcode: ");
                try{
                    postcode = sc.nextInt();
                    sc.nextLine();
                }
                catch(InputMismatchException ex){
                    System.out.println("ERROR: Input format is wrong (Postcode is integer)!");
                    System.exit(0);
                }
                System.out.print("State: "); state = sc.nextLine();
                System.out.println("\nContact Information");
                System.out.print("Phone No.: "); phone = sc.nextLine();
                System.out.print("Email: "); email = sc.nextLine();
                System.out.println("\nJob Information");
                System.out.print("Staff ID: "); staffid = sc.nextLine();
                System.out.print("Salary: "); 
                try{
                    salary = sc.nextDouble();
                    sc.nextLine();
                }
                catch(InputMismatchException ex){
                    System.out.println("ERROR: Input format is wrong (Salary is double)!");
                    System.exit(0);
                }

                u = new Administrator(name, ic, DOB, gender, new Address(street, city, postcode, state), phone, email, staffid, salary);
            }break;

            // Doctor registration
            case 2: {
                Department dep = null; boolean depValid = false;
                clearConsole();
                System.out.println("\nDOCTOR REGISTRATION");
                System.out.println("-------------------");
                System.out.println("Personal Details");
                System.out.print("Name: "); name = sc.nextLine();
                System.out.print("IC No.: "); ic = sc.nextLine();
                System.out.print("DOB: "); DOB = sc.nextLine();
                System.out.print("Gender: "); gender = sc.nextLine();
                System.out.println("\nAddress Information");
                System.out.print("Street: "); street = sc.nextLine();
                System.out.print("City: "); city = sc.nextLine();
                System.out.print("Postcode: "); 
                try{
                    postcode = sc.nextInt();
                    sc.nextLine();
                }
                catch(InputMismatchException ex){
                    System.out.println("ERROR: Input format is wrong (Postcode is integer)!");
                    System.exit(0);
                }
                System.out.print("State: "); state = sc.nextLine();
                System.out.println("\nContact Information");
                System.out.print("Phone No.: "); phone = sc.nextLine();
                System.out.print("Email: "); email = sc.nextLine();
                System.out.println("\nJob Information");
                System.out.print("Staff ID: "); staffid = sc.nextLine();
                System.out.print("Department: "); department = sc.nextLine();
                do{
                    for (int i=0; i<d.length; i++){
                        if (d[i].getDepartmentName().equals(department)){
                            dep = d[i];
                            depValid = true;
                        }
                    }

                    if (!depValid){
                        System.out.println("Please enter a valid department.");
                        System.out.print("Department: "); department = sc.nextLine();
                    }
                }
                while(!depValid);
                System.out.print("Role: "); role = sc.nextLine();
                System.out.print("Salary: "); 
                try{
                    salary = sc.nextDouble();
                    sc.nextLine();
                }
                catch(InputMismatchException ex){
                    System.out.println("ERROR: Input format is wrong (Salary is double)!");
                    System.exit(0);
                }

                u = new Doctor(name, ic, DOB, gender, new Address(street, city, postcode, state), phone, email, staffid, salary, role, dep);
            }break;

            // Patient registration
            case 3: {
                String gName, gRel, eCName, eCRel, eCPhone, occ;
                clearConsole();
                System.out.println("\nPATIENT REGISTRATION");
                System.out.println("-------------------");
                System.out.println("Personal Details");
                System.out.print("Name: "); name = sc.nextLine();
                System.out.print("IC No.: "); ic = sc.nextLine();
                System.out.print("DOB: "); DOB = sc.nextLine();
                System.out.print("Gender: "); gender = sc.nextLine();
                System.out.print("Occupation: "); occ = sc.nextLine();
                System.out.println("\nAddress Information");
                System.out.print("Street: "); street = sc.nextLine();
                System.out.print("City: "); city = sc.nextLine();
                System.out.print("Postcode: ");
                try{
                    postcode = sc.nextInt();
                    sc.nextLine();
                }
                catch(InputMismatchException ex){
                    System.out.println("ERROR: Input format is wrong (Postcode is integer)!");
                    System.exit(0);
                }
                System.out.print("State: "); state = sc.nextLine();
                System.out.println("\nContact Information");
                System.out.print("Phone No.: "); phone = sc.nextLine();
                System.out.print("Email: "); email = sc.nextLine();
                System.out.println("\nGuardian Information");
                System.out.print("Guardian Name: "); gName = sc.nextLine();
                System.out.print("Guradian Relationship: "); gRel = sc.nextLine();
                System.out.println("\nEmergency Contact Information");
                System.out.print("Emergency Contact Name: "); eCName = sc.nextLine();
                System.out.print("Emergency Contact Relationship: "); eCRel = sc.nextLine();
                System.out.print("Emergency Contact Phone No.: "); eCPhone = sc.nextLine();

                u = new Patient(name, ic, DOB, gender, new Address(street, city, postcode, state), phone, email, new Guardian(gName, gRel), new EmergencyContact(eCName, eCRel, eCPhone), occ);
            }break;

            // Return to userMenu by returning null
            case 4: break;

            // invalid choice, call the registerUser function again
            default: {
                clearConsole();
                System.out.println("\nInvalid operation. Please try again.");
                u = registerUser(sc, d); break;
            }
        }

        return u;
    }

    public static User login(Scanner sc, ArrayList<User> users){
        System.out.println("\nLOGIN PAGE");
        System.out.println("----------");
        System.out.println("Choose your role accordingly");
        System.out.println("1. Administrator\n2. Doctor\n3. Patient\n4. Return to Homepage");
        System.out.printf("Choose your operation: ");
        int choice = 0;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Input format is wrong!");
            System.exit(0);
        }

        String ic, staffid, password;
        User u = null; 

        switch(choice){
            // Administrator login
            case 1: {
                clearConsole();
                System.out.println("\nADMINISTRATOR LOGIN");
                System.out.println("-------------------");
                System.out.print("Enter Staff ID: "); staffid = sc.nextLine();
                u = searchUsers(users, staffid);
                if (u!=null){
                    boolean tryAgain = true;
                    // Administrator need to provide password to access to the system
                    // Password checking process
                    do{
                        System.out.print("Enter Password: "); password = sc.nextLine();
                        if(((Administrator) u).checkPassword(password)){
                            System.out.println("\nAdministrator (" + ((Administrator) u).getName() + ") logged in successfully.");
                            tryAgain = false;
                        }
                        else{
                            String op;
                            boolean again = true;
                            do{
                                System.out.println("Invalid password. Enter \'y\' to re-enter password, or enter \'x\' to return to LOGIN PAGE.");
                                System.out.print("Choose your operation: ");
                                op = sc.nextLine();
                                if (op.equals("y") || op.equals("Y")){
                                    again = false;
                                }
                                else if (op.equals("x") || op.equals("X")){
                                    tryAgain = false;
                                    again = false;
                                    u = null;
                                }
                                else{
                                    System.out.println("Invalid operation. Please try again.");
                                }
                            }while(again);
                        }
                    }while(tryAgain);
                }
                else {
                    clearConsole();
                    System.out.println("\nAdministrator not found. Login failed. Please try again.");
                    u = login(sc, users); break;
                }
            }break;

            // Doctor login
            case 2: {
                clearConsole();
                System.out.println("\nDOCTOR LOGIN");
                System.out.println("------------");
                System.out.print("Enter Staff ID: "); staffid = sc.nextLine();
                u = searchUsers(users, staffid);
                if (u!=null){
                    System.out.println("\nDoctor (" + ((Doctor)u).getName() + ") logged in successfully.");
                }
                else {
                    clearConsole();
                    System.out.println("\nDoctor not found. Login failed. Please try again.");
                    u = login(sc, users); break;
                }
            }
            break;

            // Patient login
            case 3: {
                clearConsole();
                System.out.println("\nPATIENT LOGIN");
                System.out.println("-------------");
                System.out.print("Enter IC No.: "); ic = sc.nextLine();
                u = searchUsers(users, ic);
                if (u!=null){
                    System.out.println("\nPatient (" + ((Patient)u).getName() + ") logged in successfully.");
                }
                else {
                    clearConsole();
                    System.out.println("\nPatient not found. Login failed. Please try again.");
                    u = login(sc, users); break;
                }
            }break;

            // Return to userMenu by returning null
            case 4: break;

            // invalid choice, call the login function again
            default: {
                clearConsole();
                System.out.println("\nInvalid operation. Please try again.");
                u = login(sc, users); break;
            }
        }

        return u;
    }

    // for Patient
    public static int patientMenu(Scanner sc){
        System.out.println("\nPATIENT MENU");
        System.out.println("------------");
        System.out.println("1. Take Queue Number\n2. Make Appointment\n3. Manage Appointment\n4. Logout");
        System.out.printf("Choose your operation: ");
        int choice = 0;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Input format is wrong!");
            System.exit(0);
        }
        return choice;
    }

    public static RegisterQueue takeQueueNumber(Scanner sc, Patient p, String[] services){
        RegisterQueue q = null;
        int serviceNo = 0;
        System.out.println("\nTAKE QUEUE NUMBER");
        System.out.println("-----------------");
        System.out.println("Choose the service type");
        System.out.println("1. " + services[0] + "\n2. " + services[1] + "\n3. " + services[2] + "\n4. " + services[3] + "\n5. " + services[4] + "\n6. " + services[5] + "\n7. Return to PATIENT MENU");
        System.out.printf("Service type: ");
        try{
            serviceNo = sc.nextInt();
            sc.nextLine();
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Input format is wrong!");
            System.exit(0);
        }
        // Checking the input value for serviceNo, if invalid serviceNo is chosen, will calling takeQueueNumber function continuously
        while(serviceNo<1 || serviceNo>7){
            System.out.println("\nInvalid operation. Please try again.");
            q = takeQueueNumber(sc, p, services);
        }
        // Choosing 7 (Return to PATIENT MENU) will return null by not creating RegisterQueue object
        if (serviceNo != 7)
            q = new RegisterQueue(p, services[(serviceNo-1)]);
        return q;
    }

    public static int makeAppointment(Scanner sc, Patient p, String[] services, ArrayList<Appointment> app){
        System.out.println("\nMAKE APPOINTMENT");
        System.out.println("----------------");
        System.out.println("Do you want to make an appointment?");
        System.out.println("1. Yes" );
        System.out.println("2. No" );
        System.out.printf("Your choice: ");
        int choice = 0;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Input format is wrong!");
            System.exit(0);
        }
        while(choice<1 || choice>2){
            System.out.println("\nInvalid operation. Please try again.");
            makeAppointment(sc, p, services, app);
        }
        if (choice == 1){
            String date, time; int service = 0;
            Appointment a;
            System.out.println("\nENTER APPOINTMENT DETAILS");
            System.out.println("-------------------------");
            System.out.print("Date: "); date = sc.nextLine();
            System.out.print("Time: "); time = sc.nextLine();
            do{
                System.out.println("\nChoose the service type");
                System.out.println("1. " + services[0] + "\n2. " + services[1] + "\n3. " + services[2] + "\n4. " + services[3] + "\n5. " + services[4] + "\n6. " + services[5]);
                System.out.print("Service: "); 
                try{
                    service = sc.nextInt();
                    sc.nextLine();
                }
                catch(InputMismatchException ex){
                    System.out.println("ERROR: Input format is wrong!");
                    System.exit(0);
                }

                if (service<1 || service>6){
                    System.out.println("\nInvalid service chosen. Please try again");
                }
            } while(service<1 || service>6);

            a = new Appointment(p, date, time, services[(service-1)]);
            app.add(a);
        }

        return choice;
    }

    public static int manageAppointment(Scanner sc, Patient p, String[] services, ArrayList<Appointment> app){
        System.out.println("\nMANAGE APPOINTMENT");
        System.out.println("------------------");
        p.displayAppointmentInfo();
        System.out.println("\nDo you want to manage your appointment?");
        System.out.println("1. Yes" );
        System.out.println("2. No" );
        System.out.printf("Your choice: ");
        int choice = 0;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Input format is wrong!");
            System.exit(0);
        }
        while(choice<1 || choice>2){
            System.out.println("\nInvalid operation. Please try again.");
            manageAppointment(sc, p, services, app);
        }
        if (choice == 1){
            System.out.println("\nCHOOSE APPOINTMENT TO BE MANAGED");
            Appointment a = null;
            do{
                System.out.printf("\nEnter the Appointment ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                a = searchAppointment(p, id);
                if (a != null){
                    int c = 0;
                    do{
                        System.out.println("\nWhat appointment details to update?");
                        System.out.println("1. Date");
                        System.out.println("2. Time");
                        System.out.println("3. Type of Service");
                        System.out.println("4. All of the above");
                        System.out.println("5. Delete appointment");
                        System.out.printf("Your choice: ");
                        try{
                            c = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException ex){
                            System.out.println("ERROR: Input format is wrong!");
                            System.exit(0);
                        }
                        if (c<1 || c>5){
                            System.out.println("\nInvalid operation. Please try again.");
                        }
                    }while(c<1 || c>5);

                    String date, time; int service = 0;
                    switch(c){
                        case 1: {
                             System.out.println("\nUPDATE APPOINTMENT DETAILS");
                             System.out.println("-------------------------");
                             System.out.print("Date: "); date = sc.nextLine();
                             
                             a.setDate(date); 
                        }break;
                        case 2: {
                             System.out.println("\nUPDATE APPOINTMENT DETAILS");
                             System.out.println("-------------------------");
                             System.out.print("Time: "); time = sc.nextLine();

                             a.setTime(time); 
                        }break;
                        case 3: {
                             System.out.println("\nUPDATE APPOINTMENT DETAILS");
                             System.out.println("-------------------------");
                             do{
                                System.out.println("Choose the service type");
                                System.out.println("1. " + services[0] + "\n2. " + services[1] + "\n3. " + services[2] + "\n4. " + services[3] + "\n5. " + services[4] + "\n6. " + services[5]);
                                System.out.print("Service: "); 
                                try{
                                    service = sc.nextInt();
                                    sc.nextLine();
                                }
                                catch(InputMismatchException ex){
                                    System.out.println("ERROR: Input format is wrong!");
                                    System.exit(0);
                                }

                                if (service<1 || service>6){
                                    System.out.println("\nInvalid service chosen. Please try again");
                                }
                             } while(service<1 || service>6);

                             a.setService(services[(service-1)]);
                        }break;
                        case 4: {
                             System.out.println("\nUPDATE APPOINTMENT DETAILS");
                             System.out.println("-------------------------");
                             System.out.print("Date: "); date = sc.nextLine();
                             System.out.print("Time: "); time = sc.nextLine();
                             do{
                                System.out.println("\nChoose the service type");
                                System.out.println("1. " + services[0] + "\n2. " + services[1] + "\n3. " + services[2] + "\n4. " + services[3] + "\n5. " + services[4] + "\n6. " + services[5]);
                                System.out.print("Service: "); 
                                try{
                                    service = sc.nextInt();
                                    sc.nextLine();
                                }
                                catch(InputMismatchException ex){
                                    System.out.println("ERROR: Input format is wrong!");
                                    System.exit(0);
                                }

                                if (service<1 || service>6){
                                    System.out.println("\nInvalid service chosen. Please try again");
                                }
                             } while(service<1 || service>6);

                             a.setDate(date); a.setTime(time); a.setService(services[(service-1)]);
                        }break;
                        case 5: p.getAppointment().remove(a); app.remove(a); break;
                    }
                }
            }while(a==null);
        }

        return choice;
    }

    public static Appointment searchAppointment(Patient p, int id){
        Appointment a = null;
        if(p.getAppointment().size() != 0){
            for(Appointment app : p.getAppointment()){
                if (app.getAppointmentID() == id){
                    a = app;
                    break;
                }
            }
        }
        return a;
    }

    // for Doctor
    public static int doctorMenu(Scanner sc){
        System.out.println("\nDOCTOR MENU");
        System.out.println("-----------");
        System.out.println("1. Make Medical Record");
        System.out.println("2. View Medical Records");
        System.out.println("3. View Registered Queue");
        System.out.println("4. View Appointments");
        System.out.println("5. Logout");
        System.out.printf("Choose your operation: ");
        int choice = 0;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Input format is wrong!");
            System.exit(0);
        }
        return choice;
    }

    public static int makeMedicalRecord(Scanner sc, RegisterQueue p, Doctor d, ArrayList<MedicalRecord> records){
        System.out.println("\nMAKE MEDICAL RECORD");
        System.out.println("-------------------");
        System.out.println("Do you want to make medical record?");
        System.out.println("1. Yes" );
        System.out.println("2. No" );
        System.out.printf("Your choice: ");
        int choice = 0;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Input format is wrong!");
            System.exit(0);
        }
        while(choice<1 || choice>2){
            System.out.println("\nInvalid operation. Please try again.");
            makeMedicalRecord(sc, p, d, records);
        }
        if (choice == 1){
            String problem;
            MedicalRecord m;
            clearConsole();
            p.displayRegisterQueueInfo();
            System.out.println("\nENTER MEDICAL RECORD DETAILS");
            System.out.println("----------------------------");
            System.out.print("State diagnosis result: "); problem = sc.nextLine();

            m = new MedicalRecord(problem, p.getPatient(), d);
            records.add(m);
        }

        return choice;
    }

    public static void viewMedicalRecords(ArrayList<MedicalRecord> medicalRecords){
        if(medicalRecords.size() == 0){
            System.out.println("\nThere is no medical record made.");
        }
        else{
            for(MedicalRecord m:medicalRecords){
                System.out.println();
                m.displayMedicalRecord();
            }
        }
    }

    public static void viewRegisteredQueue(ArrayList<RegisterQueue> registerQueues){
        if(registerQueues.size() == 0){
            System.out.println("\nThere is no patient waiting in the queue.");
        }
        else{
            for(RegisterQueue r:registerQueues){
                System.out.println();
                r.displayRegisterQueueInfo();
            }
        }
    }

    public static void viewAppointments(ArrayList<Appointment> appointments){
        if(appointments.size() == 0){
            System.out.println("\nThere is no appointment made by patient.");
        }
        else{
            for(Appointment a:appointments){
                System.out.println();
                a.displayAppointmentInfo();
            }
        }
    }

    // for Administrator
    public static int administratorMenu(Scanner sc) throws InputMismatchException{
        System.out.println("\nADMINISTRATOR MENU");
        System.out.println("------------------");
        System.out.println("1. View Users");
        System.out.println("2. Manage Users");
        System.out.println("3. Logout");
        System.out.printf("Choose your operation: ");
        int choice = 0;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Input format is wrong!");
            System.exit(0);
        }
        return choice;
    }

    public static void viewUsers(ArrayList<User> users){
        ArrayList<Administrator> a = new ArrayList<Administrator>(); 
        ArrayList<Doctor> d = new ArrayList<Doctor>(); 
        ArrayList<Patient> p = new ArrayList<Patient>(); 
        if(users.size() == 0){
            System.out.println("\nThere is no system user.");
        }
        else{
            for(User u:users){
                if (u instanceof Administrator)
                    a.add((Administrator)u);
                else if(u instanceof Doctor)
                    d.add((Doctor)u);
                else
                    p.add((Patient)u);
            }

            System.out.println("\n<<< List of Administrators >>>");

            for(Administrator admin:a){
                admin.displayInfo();
                System.out.println();
            }

            System.out.println("\n<<< List of Doctors >>>");

            for(Doctor doctor:d){
                doctor.displayInfo();
                System.out.println();
            }

            System.out.println("\n<<< List of Patients >>>");

            for(Patient patient:p){
                patient.displayInfo();
                System.out.println();
            }
        }
    }

    public static int manageUsers(Scanner sc, ArrayList<User> users, Department[] dep){
        clearConsole();
        viewUsers(users);
        System.out.println("\nMANAGE USERS");
        System.out.println("------------");
        System.out.println("Do you want to manage system users?");
        System.out.println("1. Yes" );
        System.out.println("2. No" );
        System.out.printf("Your choice: ");
        int choice = 0;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Input format is wrong!");
            System.exit(0);
        }
        while(choice<1 || choice>2){
            System.out.println("\nInvalid operation. Please try again.");
            manageUsers(sc, users, dep);
        }
        if (choice == 1){
            System.out.println("\nCHOOSE USER TO BE MANAGED");
            System.out.println("-------------------------");
            User u = null;
            do{
                System.out.printf("Enter the User ID (Staff ID / Patient IC No.): ");
                String id = sc.nextLine();
                u = searchUsers(users, id);
                if (u != null){
                    int c = 0; clearConsole();
                    do{
                        System.out.println();
                        u.displayInfo();
                        System.out.println("\nWhat user details to update?");
                        System.out.println("1. Name");
                        System.out.println("2. IC No.");
                        System.out.println("3. DOB");
                        System.out.println("4. Gender");
                        System.out.println("5. Address");
                        System.out.println("6. Phone No.");
                        System.out.println("7. Email");
                        if(u instanceof Patient){
                            System.out.println("8. Occupation");
                            System.out.println("9. Guardian");
                            System.out.println("10. Emergency Contact");
                            System.out.println("11. Delete Patient");
                        }
                        if(u instanceof Doctor){
                            System.out.println("8. Staff ID");
                            System.out.println("9. Salary");
                            System.out.println("10. Role");
                            System.out.println("11. Department");
                            System.out.println("12. Delete Doctor");
                        }
                        if(u instanceof Administrator){
                            System.out.println("8. Staff ID");
                            System.out.println("9. Salary");
                            System.out.println("10. Delete Administrator");
                        }
                        System.out.printf("Your choice: ");
                        try{
                            c = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException ex){
                            System.out.println("ERROR: Input format is wrong!");
                            System.exit(0);
                        }
                        if ((c<1 || c>11) && u instanceof Patient){
                            clearConsole();
                            System.out.println("\nInvalid operation. Please try again.");
                        }
                        else if ((c<1 || c>12) && u instanceof Doctor){
                            clearConsole();
                            System.out.println("\nInvalid operation. Please try again.");
                        }
                        else if ((c<1 || c>10) && u instanceof Patient){
                            clearConsole();
                            System.out.println("\nInvalid operation. Please try again.");
                        }
                        else{
                            break;
                        }
                    }while(c<1 || c>12);

                    // for all User
                    String n, ic, dob, gender, street, city, state, phone, email; int postcode = 0; 
                    // for Patient
                    String occ, gN, gRel, eCN, eCRel, eCPhone;
                    // for Satff
                    String staffId; double salary = 0;
                    // for Doctor
                    String role, department;

                    switch(c){
                        case 1: {
                             System.out.println("\nUPDATE USER DETAILS");
                             System.out.println("-------------------");
                             System.out.print("Name: "); n = sc.nextLine();
                             u.setName(n);
                        }break;
                        case 2: {
                             System.out.println("\nUPDATE USER DETAILS");
                             System.out.println("-------------------");
                             System.out.print("IC No.: "); ic = sc.nextLine();
                             u.setIcNo(ic);
                        }break;
                        case 3: {
                             System.out.println("\nUPDATE USER DETAILS");
                             System.out.println("-------------------");
                             System.out.print("DOB: "); dob = sc.nextLine();
                             u.setDOB(dob);
                        }break;
                        case 4: {
                             System.out.println("\nUPDATE USER DETAILS");
                             System.out.println("-------------------");
                             System.out.print("Gender: "); gender = sc.nextLine();
                             u.setGender(gender);
                        }break;
                        case 5: {
                             System.out.println("\nUPDATE USER DETAILS");
                             System.out.println("-------------------");
                             System.out.println("Address Information");
                             System.out.print("Street: "); street = sc.nextLine();
                             System.out.print("City: "); city = sc.nextLine();
                             System.out.print("Postcode: "); 
                             try{
                                postcode = sc.nextInt();
                                sc.nextLine();
                             }
                             catch(InputMismatchException ex){
                                 System.out.println("ERROR: Input format is wrong (Postcode is integer)!");
                                 System.exit(0);
                             }
                             System.out.print("State: "); state = sc.nextLine();
                             u.setAddress(new Address(street, city, postcode, state));
                        }break;
                        case 6: {
                             System.out.println("\nUPDATE USER DETAILS");
                             System.out.println("-------------------");
                             System.out.print("Phone No.: "); phone = sc.nextLine();
                             u.setPhone(phone);
                        }break;
                        case 7: {
                             System.out.println("\nUPDATE USER DETAILS");
                             System.out.println("-------------------");
                             System.out.print("Email: "); email = sc.nextLine();
                             u.setPhone(email);
                        }break;
                        case 8: {
                             System.out.println("\nUPDATE USER DETAILS");
                             System.out.println("-------------------");
                             if (u instanceof Patient){
                                System.out.print("Occupation: "); occ = sc.nextLine();
                                ((Patient)u).setOccupation(occ);
                             }
                             else{
                                System.out.print("Staff ID: "); staffId = sc.nextLine();
                                ((Staff)u).setStaffID(staffId);
                             }     
                        }break;
                        case 9: {
                             System.out.println("\nUPDATE USER DETAILS");
                             System.out.println("-------------------");
                             if (u instanceof Patient){
                                System.out.println("Guardian Information");
                                System.out.print("Guardian Name: "); gN = sc.nextLine();
                                System.out.print("Guradian Relationship: "); gRel = sc.nextLine();
                                ((Patient)u).setGuardian(new Guardian(gN, gRel));
                             }
                             else{
                                System.out.print("Salary: "); 
                                try{
                                    salary = sc.nextDouble();
                                    sc.nextLine();
                                }
                                catch(InputMismatchException ex){
                                    System.out.println("ERROR: Input format is wrong (Salary is double)!");
                                    System.exit(0);
                                }
                                ((Staff)u).setSalary(salary);
                             }   
                        }break;
                        case 10: {
                             if (u instanceof Patient){
                                System.out.println("\nUPDATE USER DETAILS");
                                System.out.println("-------------------");
                                System.out.println("Emergency Contact Information");
                                System.out.print("Emergency Contact Name: "); eCN = sc.nextLine();
                                System.out.print("Emergency Contact Relationship: "); eCRel = sc.nextLine();
                                System.out.print("Emergency Contact Phone No.: "); eCPhone = sc.nextLine();
                                ((Patient)u).setEmergencyContact(new EmergencyContact(eCN, eCRel, eCPhone));
                             }
                             else if (u instanceof Doctor){
                                System.out.println("\nUPDATE USER DETAILS");
                                System.out.println("-------------------");
                                System.out.print("Role: "); role = sc.nextLine();
                                ((Doctor)u).setRole(role);
                             }
                             else{
                                users.remove(u); // remove administrator
                             }
                        }break;
                        case 11: {
                             if (u instanceof Patient){
                                users.remove(u); // remove patient
                             }
                             else if (u instanceof Doctor){
                                System.out.println("\nUPDATE USER DETAILS");
                                System.out.println("-------------------");
                                System.out.print("Department: "); department = sc.nextLine(); 
                                boolean depValid = false;
                                Department d = null;
                                do{
                                    for (int i=0; i<dep.length; i++){
                                        if (dep[i].getDepartmentName().equals(department)){
                                            d = dep[i];
                                            depValid = true;
                                        }
                                    }
                                    if (!depValid){
                                        System.out.println("Please enter a valid department.");
                                        System.out.print("Department: "); department = sc.nextLine();
                                    }
                                }while(!depValid);
                                ((Doctor)u).setDepartment(d);
                             }
                        }break;
                        case 12: users.remove(u); break; // remove doctor
                    }
                }
                else{
                    System.out.println("\nUser not found, please try again.\n");
                }
            }while(u==null);
        }

        return choice;
    }

    public static User searchUsers(ArrayList<User> users, String id){
        User u = null;
        if(users.size() != 0){
            for(User user : users){
                if (user instanceof Patient){
                    if(((Patient)user).getIcNo().equals(id)){
                        u = user;
                        break;
                    }
                }
                else{
                    if(((Staff)user).getStaffID().equals(id)){
                        u = user;
                        break;
                    }
                }
            }
        }
        return u;
    }
}
