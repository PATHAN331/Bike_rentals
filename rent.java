import java.util.Scanner;
import java.util.regex.Pattern;
interface Color
{
	static String RESET = "\u001B[0m";
	static String RED = "\u001B[31m";
	static String GREEN = "\u001B[32m";
	static String YELLOW = "\u001B[33m";
	static String BLUE = "\u001B[34m";
	static String PURPLE = "\u001B[35m";
	static String CYAN = "\u001B[36m";
	static String BRIGHT_WHITE_BG = "\u001B[47m";
	static String BLACK = "\u001B[30m";
	static String by = "\u001B[43m\u001B[30m";
	static String BLUE_BACKGROUND = "\u001B[44m";
	static String CYAN_BACKGROUND = "\u001B[46m";
	static String BLACK_TEXT = "\u001B[30m";
    static String WHITE	="\u001B[37m";

}

class Login implements Color{
    static Scanner sc = new Scanner(System.in);
    private String[] user_id = {"shannu", null, null, null, null};
    private String[] password = {"Shanmukha@123", null, null, null, null};
    private long[] phone = {7286960853l, 0, 0, 0, 0};
    private boolean[] isApproved = {true, false, false, false, false}; // Tracks approval status

    // Getter methods
    String getPassword(int i) {
        return password[i];
    }

    String getUserId(int i) {
        return user_id[i];
    }
    long getPhone(int i)
    {
        return phone[i];
    }

    boolean getApprovalStatus(int i) {
        return isApproved[i];
    }

    // Setter methods
    void setPassword(String password, int i) {
        this.password[i] = password;
    }
    void setPassword(String password, int i,long phone) {
        if(this.phone[i]==phone)
            this.password[i] = password;
    }
    boolean getUserId(String id)
    {
        for(int i=0;i<5;i++){
            if(id.equals(user_id[i]))
                return true;
        }
        return false;
    }

    boolean getUserPhone(String p)
    {
        long ph=Long.parseLong(p);
        for(int i=0;i<5;i++){
            if(ph==phone[i])
                return true;
        }
        return false;
    }

    void setUserId(String userid, int i) {
        this.user_id[i] = userid;
    }
    void setPhone(long phone, int i) {
        this.phone[i] = phone;
    }

    void setApprovalStatus(boolean status, int i) {
        this.isApproved[i] = status;
    }

    // Method to find the next available index in the user array
    int getNextAvailableIndex() {
        for (int i = 0; i < user_id.length; i++) {
            if (user_id[i] == null) {
                return i;
            }
        }
        return -1; // Array is full
    }

    


    int phoneIndex(long phone)
    {
        for(int i=0;i<user_id.length;i++)
        {
            if(this.phone[i]==phone){
                return i;
            }
        }
        return -1;
    }

    int Index(String id)
    {
        for(int i=0;i<user_id.length;i++)
        {
            if(id.equals(user_id[i]))
                return i;
        }
        return -1;
    }
    static boolean isValidPassword(String password) {
        final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(PASSWORD_REGEX, password);
    }

    static boolean isValidPhoneNumber(String phoneNumber) {
        final String PHONE_NUMBER_REGEX = "^[9876][0-9]{9}$";
        return Pattern.matches(PHONE_NUMBER_REGEX, phoneNumber);
    }

    static boolean isValidDays(String id) {
        final String D_REGEX = "^[1-9]{1}$";
        return Pattern.matches(D_REGEX, id);
    }

    static boolean isValidID(String id) {
        final String ID_REGEX = "^[A-Za-z][A-Za-z0-9]{5,11}$";
        return Pattern.matches(ID_REGEX, id);
    }

    static boolean isValidDrivingLicense(String license) {
        String LICENSE_REGEX = "^[A-Z]{2}[0-9]{2,3}[0-9]{4}[0-9]{7}$";
        return Pattern.matches(LICENSE_REGEX, license);
    }

    static boolean isValidName(String name) {
        final String NAME_REGEX = "^[A-Za-z][A-Za-z'\\-\\s]{4,49}$";
        return Pattern.matches(NAME_REGEX, name);
    }

}


class vehicle extends Login
{
    static Scanner sc=new Scanner(System.in);
    //Vehicle price
    static final int splendor=400, glamour=500,raider=500,ns=800,duke=1000,rtr=1000,ninja=2500,ducati=3000,triumph=2500;
    static final int swift=1000,baleno=1200,glanza=1200,thor=2000,creta=1500,innova=3000,vrena=2000,city=2000,slavia=2000;
    //Security Deposite
    static final int normal_deposite=2000,sport_deposite=3000,super_deposite=10000;
    static final int suv_deposite=7000,hatchback_deposite=5000,sedan_deposite=8000;

    String user_name[]={null,null,null,null,null,null,null,null,null,null};
    long user_phone[]={0,0,0,0,0,0,0,0,0,0};
    String user_id[]={null,null,null,null,null,null,null,null,null,null};
    String vehicle[]=new String[10];
    int day_rent[]=new int[10];
    int days[]=new int[10];
    int bike_rent[]=new int[10];
    int security_deposite[]=new int[10];
    double bill[]={0,0,0,0,0,0,0,0,0,0};
    
    static double cash=0;

    String return_user[]=new String[10];
    long return_phone[]=new long[10];
    String return_id[]=new String[10];
    String return_vehicle[]=new String[10];
    int return_day_rent[]=new int[10];
    int return_days[]=new int[10];
    int return_bike_rent[]=new int[10];
    double return_totalamount[]=new double[10];
    double return_amount[]=new double[10];

    

    static int available;
    double total=-1;
    double return_total=-1;
    boolean a=false;
    static
    {
        System.out.println("               "+CYAN_BACKGROUND+"Welcome to KVS Rental"+RESET);
    }
    int phoneIndex(long phone)
    {
        for(int i=0;i<user_phone.length;i++)
        {
            if(this.user_phone[i]==phone){
                return i;
            }
        }
        return -1;
    }
    int LicenseIndex(String license)
    {
        for(int i=0;i<user_id.length;i++)
        {
            if(license.equals(user_id[i])){
                return i;
            }
        }
        return -1;
    }
    void bikeDisplay(char v)
    {
        if(v=='1')
            System.out.println("Security Deposite          "+normal_deposite);
        else if(v=='2')
            System.out.println("Security Deposite          "+sport_deposite);
        else if(v=='3')
            System.out.println("Security Deposite          "+super_deposite);
        if(v=='1'||v=='2'||v=='3'){
            System.out.println("----------------------------------");
            System.out.println("Bikes              Cost per Day");
            System.out.println("----------------------------------");
        }
        if(v=='1')
        {
            System.out.println("Splendor                    "+splendor);
            System.out.println("Glamour                     "+glamour);
            System.out.println("Raider                      "+raider);
        }
        if(v=='2')
        {
            System.out.println("NS                          "+ns);
            System.out.println("Duke                        "+duke);
            System.out.println("RTR                         "+rtr);
        }
        if(v=='3')
        {
            System.out.println("Ninja                       "+ninja);
            System.out.println("Ducati                      "+ducati);
            System.out.println("Triumph                     "+triumph);
        }
    }
    void carDisplay(char v)
    {
        if(v=='1')
            System.out.println("Security Deposite          "+suv_deposite);
        else if(v=='2')
            System.out.println("Security Deposite          "+hatchback_deposite);
        else if(v=='3')
            System.out.println("Security Deposite          "+sedan_deposite);
        if(v=='1'||v=='2'||v=='3'){
            System.out.println("----------------------------------");
            System.out.println("Cars                Cost per Day");
            System.out.println("----------------------------------");
        }
        if(v=='1')
        {
            System.out.println("Thor                        "+thor);
            System.out.println("Creta                       "+creta);
            System.out.println("Innova                      "+innova);  
        }
        if(v=='2')
        {
            System.out.println("Swift                       "+swift);
            System.out.println("Baleno                      "+baleno);
            System.out.println("Glanza                      "+glanza);
        }
        if(v=='3')
        {
            System.out.println("Verna                       "+vrena);
            System.out.println("City                        "+city);
            System.out.println("Slavia                      "+slavia);
        }
    }
    int getNextAvailableIndex() 
    {
        for (int i = 0; i < user_id.length; i++)
        {
            if (user_id[i] == null) 
            {
                return i;
            }
        }
        return -1; // Array is full
    }

    int getNextAvailableReturnIndex() 
    {
        for (int i = 0; i < user_id.length; i++)
        {
            if (return_id[i] == null) 
            {
                return i;
            }
        }
        return -1; // Array is full
    }
    void customerDetails(String name,long phone,String id){
        int index=getNextAvailableIndex();
        if(index==-1){
            System.out.println("Customers registration limit reached. Cannot add more customers.");
        }
        else{
            if(paymentStatus()){
                user_name[index]=name;
                user_phone[index]=phone;
                user_id[index]=id;
                System.out.println(user_name[index]+" received "+vehicle[index]);
            }else
            System.out.println("Please, try again");
        }
    }
    void car()
    {
        System.out.println("1. SUV\n2. Hatchback \n3. Sedan\n4. Return to Back");
        System.out.print("Enter your Option :");
        char c=sc.next().charAt(0);
        carDisplay(c);
        if(c=='1')
        {
            System.out.print("Enetr 1 for Thor | Enter 2 for Creta | Enter 3 for Innova | Enter 4 to Back :");
            char n=sc.next().charAt(0);
            int car_price=0;
            String car="";
            if(n=='1')
            {
                car_price=thor;
                car="Thor";
            }
            else if(n=='2')
            {
                car_price=creta;
                car="Creta";
            }
            else if(n=='3')
            {
                car_price=innova;
                car="Innova";
            }
            else if(n=='4')
            {
                car();
            }
            else
            {
                car();
            }
            if(car_price!=0){
                billing(car_price,suv_deposite,car);
            }
        }
        else if(c=='2')
        {
            System.out.print("Enetr 1 for Swift | Enter 2 for Baleno| Enter 3 for Glanza | Enter 4 to Back :");
            char n=sc.next().charAt(0);
            int car_price=0;
            String car="";
            if(n=='1')
            {
                car_price=swift;
                car="Swift";
            }
            else if(n=='2')
            {
                car_price=baleno;
                car="baleno";
            }
            else if(n=='3')
            {
                car_price=glanza;
                car="Glanza";
            }
            else if(n=='4')
            {
                car();
            }
            else
            {
                car();
            }
            if(car_price!=0){
                billing(car_price,hatchback_deposite,car);
            }
        }
        else if(c=='3')
        {
            System.out.print("Enetr 1 for Verna | Enter 2 for City | Enter 3 for Slavia | Enter 4 to Back :");
            char n=sc.next().charAt(0);
            int car_price=0;
            String car="";
            if(n=='1')
            {
                car_price=vrena;
                car="Verna";
            }
            else if(n=='2')
            {
                car_price=city;
                car="City";
            }
            else if(n=='3')
            {
                car_price=slavia;
                car="Slavia";
            }
            else if(n=='4')
            {
                car();
            }
            else
            {
                car();
            }
            if(car_price!=0){
                billing(car_price,sedan_deposite,car);
            }
        }
        else if(c=='4'){
            rentVehicle();
        }
        else
        {
            System.out.println("Invalid Input, Please try again ");
            car();
        }
        if(a){
            a=false;
            car();
        }
    }
        
    void billing(int price,int deposite,String vehicle){
        
        String day="";
        while(true){
            System.out.print("For what duration did the user rent this vehicle? Days: ");
            day=sc.next();
            if(isValidDays(day))
            {
                    break;
            }
            else
                System.out.println("Must be lessthan 10 days...");
        }
        int days=Integer.parseInt(day);
        System.out.println("Cost for vehicle               = "+price);
        System.out.println("Number of Days                 = "+days);
        System.out.println("Total rent                     = "+(days*price));
        System.out.println("Security Deposite for vehicle  = "+deposite);
        double total=(price*days)+deposite;
        System.out.println("Tota Amouunt                   = "+total);
        
        while(true){
            System.err.println("Do you want to continue payment 'Yes /No: '");
            String s=sc.next();
            if(s.equalsIgnoreCase("yes")){
                payment(total,vehicle,price,(price*days),deposite,days);
                a=false;
                break;
            }
            else if(s.equalsIgnoreCase("no")){
                a=true;
                return;
            }
            else{
            System.out.println("Enter valid Input");
            a=false;
            }
        }
    }
    void payment(double total,String vehicle,int price,int rent,int deposite,int days)
    {   
        System.out.println("Did you receive payment of "+total+" from user Yes/No");
        String s=sc.next();
        if(s.equalsIgnoreCase("yes"))
        {
            cash+=total;
            bill[available]=total;
            this.total=total;
            if(paymentStatus()){
                this.vehicle[available]=vehicle;
                security_deposite[available]=deposite;
                bike_rent[available]=rent;
                day_rent[available]=price;
                this.days[available]=days;
            }
        }
        else if(s.equalsIgnoreCase("no"))
        {
            while(true){
                
                System.out.println("Do you want to cancel payment 1. Cancle | 2. Continue payment");
                char i=sc.next().charAt(0);
                if(i=='1'){break;}
                else if(i=='2'){
                    payment(total , vehicle , price , rent , deposite , days);
                    break;
                }
                else{
                    System.err.println("Please Choose correct Option ");
                }
            }
        }
        else payment(total, vehicle, price , rent, deposite, days);
    }
    boolean paymentStatus(){
        return this.total==bill[available];
    }
    void bike()
    {
        System.out.println("1. Normal Bike\n2. Sports Bike\n3. Super Bike\n4. Return to Back");
        System.out.print("Enter your Option: ");
        char b=sc.next().charAt(0);
        bikeDisplay(b);
        if(b=='1')
        {   
            System.out.print("Enetr 1 for Splendor | Enter 2 for Glamour | Enter 3 for Raider | Enter 4 to Back :");
            char n=sc.next().charAt(0);
            int bike_price=0;
            String bike="";
            if(n=='1')
            {
                bike_price=splendor;
                bike="Splendor";
            }
            else if(n=='2')
            {
                bike_price=glamour;
                bike="Glamour";
            }
            else if(n=='3')
            {
                bike_price=raider;
                bike="Raider";
            }
            else if(n=='4')
            {
                bike();
            }
            else
            {
                bike();
            }
            if(bike_price!=0){
                billing(bike_price,normal_deposite,bike);
            }
            
        }
        else if(b=='2')
        {
            System.out.print("Enetr 1 for NS | Enter 2 for Duke| Enter 3 for RTR | Enter 4 to Back :");
            char n=sc.next().charAt(0);
            int bike_price=0;
            String bike="";
            if(n=='1')
            {
                bike_price=ns;
                bike="NS";
            }
            else if(n=='2')
            {
                bike_price=duke;
                bike="Duke";
            }
            else if(n=='3')
            {
                bike_price=rtr;
                bike="RTR";
            }
            else if(n=='4')
            {
                bike();
            }
            else
            {
                bike();
            }
            if(bike_price!=0){
                billing(bike_price,sport_deposite,bike);
            }
        }
        else if(b=='3')
        {
            System.out.print("Enetr 1 for Ninja | Enter 2 for Ducati | Enter 3 for Triumph | Enter 4 to Back :");
            char n=sc.next().charAt(0);
            int bike_price=0;
            String bike="";
            if(n=='1')
            {
                bike_price=ninja;
                bike="Ninja";
            }
            else if(n=='2')
            {
                bike_price=ducati;
                bike="Ducati";
            }
            else if(n=='3')
            {
                bike_price=triumph;
                bike="Triumph";
            }
            else if(n=='4')
            {
                bike();
            }
            else
            {
                bike();
            }
            if(bike_price!=0){
                billing(bike_price,super_deposite,bike);
            }
        }
        else if(b=='4'){
            rentVehicle();
        }
        else
        {
            System.out.println("Invalid Input, Please try again ");
            // System.out.print("Invalid Input\nEnter 1 for booking or Enter Any Key to Exit :");
            // char n=sc.next().charAt(0);
            // if(n=='1')
            bike();
        }
        if(a){
            a=false;
            bike();
        }
        
    }
    void rentVehicle(){
        System.out.print("Enter 1 for Bike | Enter 2 for Car | Enter 3 to go Back :");
        char n=sc.next().charAt(0);
        if(n=='1')
        {
            bike();
        }
        else if(n=='2')
        {
            car();
        }
        else if(n=='3')
        {
            
        }
        else
        {
            System.out.println("Invalid input, Please choose correct option.");
            rentVehicle();
        }
    }
    void history(){
        System.out.println("1. Rent History\n2. Return History");
        System.out.print("Enter your Option :");
        char c=sc.next().charAt(0);
        if(c=='1'){
            for(int i=0;i<user_name.length;i++){
                if(user_id[i]!=null){
                    System.out.println("        Customer name           = "+user_name[i]);
                    System.out.println("        Customer Mobile No      = "+user_phone[i]);
                    System.out.println("        Customer Id             = "+user_id[i]);
                    System.out.println("        Renteded vehicle        = "+vehicle[i]);
                    System.out.println("        Rent per day            = "+day_rent[i]);
                    System.out.print("        Rent Duration           = "+days[i]);
                    if(days[i]>1)
                    System.out.print(" days\n");
                    else
                    System.out.print(" day\n");
                    System.out.println("        Total Rent              = "+bike_rent[i]);
                    System.out.println("        Security Deposite       = "+security_deposite[i]);
                    System.out.println("        Total Bill              = "+bill[i]);
                    System.out.println();
                    System.out.println("-------------------------------------------------------");

                }
            }
        }
        else if(c=='2'){
            for(int i=0;i<return_user.length;i++){
                if(return_id[i]!=null){
                    System.out.println("        Customer name           = "+return_user[i]);
                    System.out.println("        Customer Mobile No      = "+return_phone[i]);
                    System.out.println("        Customer Id             = "+return_id[i]);
                    System.out.println("        Renteded vehicle        = "+return_id[i]);
                    System.out.println("        Rent per day            = "+return_day_rent[i]);
                    System.out.print("        Rent Duration           = "+return_days[i]);
                    if(return_days[i]>1)
                    System.out.print(" days\n");
                    else
                    System.out.print(" day\n");
                    System.out.println("        Total Rent              = "+return_totalamount[i]);
                    System.out.println("        Total                   = "+return_bike_rent[i]);
                    System.out.println("        Returned Amount         = "+return_amount[i]);
                    System.out.println();
                    System.out.println("-------------------------------------------------------");

                }
            }
        }
    }
    void returnVehicle(int index){
        int available=getNextAvailableReturnIndex();
        if(available!=-1){
            System.out.print("number of Days "+user_name[index]+" rented the Vehicle :");
            String day="";
            while(true){
                System.out.print("For what duration did the user rent this vehicle? Days: ");
                day=sc.next();
                if(isValidDays(day))
                {
                        break;
                }
                else
                    System.out.println("Must be lessthan 10 days...");
            }
            int days=Integer.parseInt(day);
            
            double total=bill[index]-(days*day_rent[index]);
            if(total>0){
                while(true){
                    System.out.println("Give "+total+" to "+user_name[index]);
                    System.out.print("Enter 'Yes' if you return the amount | Enter 'No' to Cancel :");
                    String s=sc.next();
                    if(s.equalsIgnoreCase("yes")){
                        return_user[available]=user_name[index];
                        return_phone[available]=user_phone[index];
                        return_id[available]=user_id[index];
                        return_vehicle[available]=vehicle[index];
                        return_day_rent[available]=day_rent[index];
                        return_days[available]=days;
                        return_totalamount[available]=bill[index];
                        return_bike_rent[available]=return_days[available]*return_day_rent[available];
                        return_amount[available]=total;

                        user_name[index]=null;
                        user_phone[index]=0;
                        user_id[index]=null;
                        vehicle[index]=null;
                        day_rent[index]=0;
                        this.days[index]=0;
                        bike_rent[index]=0;
                        security_deposite[index]=0;
                        bill[index]=0;
                        return_total=bill[index]-(days*day_rent[index]);
                        cash-=total;
                        break;
                    }
                    else if(s.equalsIgnoreCase("no")){
                        System.out.print("Do you want to cancle payment 'Yes/No' :");
                        String sh=sc.next();
                        if(sh.equalsIgnoreCase("yes")){
                            return;
                        }
                        else if(sh.equalsIgnoreCase("no")){

                        }else{
                            System.out.println("Invalid Input...");
                        }
                    }
                    else{
                        System.out.println("Invalid Input...");
                    }
                }
            }
            else
            {
                total=-total;
                while(true){
                    System.out.println("Ask "+total+" to "+user_name[index]);
                    System.out.print("Enter 'Yes' if "+user_name[index]+" return the amount | Enter 'No' to Cancel :");
                    String s=sc.next();
                    if(s.equalsIgnoreCase("yes")){
                        return_user[available]=user_name[index];
                        return_phone[available]=user_phone[index];
                        return_id[available]=user_id[index];
                        return_vehicle[available]=vehicle[index];
                        return_day_rent[available]=day_rent[index];
                        return_days[available]=days;
                        return_totalamount[available]=bill[index];
                        return_bike_rent[available]=return_days[available]*return_day_rent[available];
                        return_amount[available]=total;

                        user_name[index]=null;
                        user_phone[index]=0;
                        user_id[index]=null;
                        vehicle[index]=null;
                        day_rent[index]=0;
                        this.days[index]=0;
                        bike_rent[index]=0;
                        security_deposite[index]=0;
                        bill[index]=0;
                        return_total=bill[index]+total;
                        cash+=total;
                        break;
                    }
                    else if(s.equalsIgnoreCase("no")){
                        System.out.print("Do you want to cancle payment 'Yes/No' :");
                        String sh=sc.next();
                        if(sh.equalsIgnoreCase("yes")){
                            return;
                        }
                        else if(sh.equalsIgnoreCase("no")){

                        }else{
                            System.out.println("Invalid Input...");
                        }
                    }
                    else{
                        System.out.println("Invalid Input...");
                    }
                }
            }
            
        }

        
    }
    void allVehicle(){

    }
    
}


class User extends vehicle{
    static Login loginSystem = new Login();
    static vehicle veh=new vehicle();
    boolean login()
    {
        System.out.print("User Id: ");
        String user_id = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        // Check credentials
        for (int i = 0; i < 5; i++) {
            if (user_id.equals(loginSystem.getUserId(i)) &&
                password.equals(loginSystem.getPassword(i)) &&
                loginSystem.getApprovalStatus(i)) {
                return true;
            }
        }
        return false;
    }
    void forgotpass(){
        while(true){
            System.out.print("Enter User Id: ");
            String id=sc.next(); 
            int index=loginSystem.Index(id);
            if(index==-1){
                System.out.println("Invalid User Id");
                System.out.println("Enter 1 for Reattempt\nEnter 2 to return Back");
                System.out.print("Choose an option: ");
                char i=sc.next().charAt(0);
                if(i=='1')
                {
                    continue;
                }
                else if(i=='2'){
                    break;
                }
                else{
                    System.out.println("Invalid Input, choose the correct option");
                }
            }
            else
            {
                while(true){
                    System.out.print("Enter phone Number: ");
                    long phone=sc.nextLong();
                    if(phone==loginSystem.getPhone(index))
                    {
                        String new_password="";
                        while(true){
                            System.out.print("Enter New Password: ");
                            new_password=sc.next();
                            if(isValidPassword(new_password))
                                break;
                            else
                                System.out.println("Use at least 8 characters one uppercase letter one lowercase letter one special character and one number in your password");
                        }
                        loginSystem.setPassword(new_password, index);
                        break;
                    }
                    else{
                        System.out.println("Wrong Moble Number");
                        System.out.println("Enter 1 for Reattempt\nEnter 2 to return Back");
                        System.out.print("Choose an option: ");
                        char i=sc.next().charAt(0);
                        if(i=='1')
                        {
                            continue;
                        }
                        else if(i=='2'){
                            break;
                        }
                        else{
                            System.out.println("Invalid Input, choose the correct option");
                        } 
                    }
                }
                break;
            }
            
  
        }
    }
    void forgotId()
    {
        while (true) {
            System.out.print("Enter phone Number: ");
            long phone=sc.nextLong();
            int index=loginSystem.phoneIndex(phone);
            if(index==-1){
                System.out.println("Invalid Mobile Number");
                System.out.println("Enter 1 for Reattempt\nEnter 2 to return Back");
                System.out.print("Choose an option: ");
                char i=sc.next().charAt(0);
                if(i=='1')
                {
                    continue;
                }
                else if(i=='2'){
                    break;
                }
                else{
                    System.out.println("Invalid Input, choose the correct option");
                }
            }
            else{
                System.out.println(loginSystem.getUserId(index));
                break;
            }
        }
    }
    void signUp(){
        int index = loginSystem.getNextAvailableIndex();
        if (index == -1) {
            System.out.println("User registration limit reached. Cannot add more users.");
        } else {
            String new_user_id="";
            while(true){
                System.out.print("Enter User Id: ");
                new_user_id = sc.next();
                
                if(isValidID(new_user_id))
                {
                    if(getUserId(new_user_id)){
                        System.err.println("UserId must be Unique");
                    }
                    else{
                        break;
                    }
                }
                else
                System.out.println("Starts with a letter, followed by alphanumeric characters, 6-12 characters long.");
            }
            String new_password ="";
            while(true){
                System.out.print("Enter Password: ");
                new_password = sc.next();
                if(isValidPassword(new_password))
                    break;
                else
                    System.out.println("Use at least 8 characters one uppercase letter one lowercase letter one special character and one number in your password");
            }
            String phone="";
            while(true){
                System.out.print("Enter Phone Number: ");
                phone=sc.next();
                if(isValidPhoneNumber(phone))
                {
                    if(getUserPhone(phone)){
                        System.err.println("The mobile number you entered already exists with another account. Please try with another number.");
                    }
                    else{
                        break;
                    }
                }
                    
                else
                    System.out.println("Please enter a valid 10 digit mobile number");
            }
            loginSystem.setUserId(new_user_id, index);
            loginSystem.setPassword(new_password, index);
            loginSystem.setPhone(Long.parseLong(phone), index);
            loginSystem.setApprovalStatus(false, index); // Mark as not approved
            System.out.println("Sign-up successful! Awaiting admin approval.");
        }
    }
    void approvalUser(){
        System.out.print("Enter admin User Id: ");
        String admin_id = sc.next();
        System.out.print("Enter admin Password: ");
        String admin_password = sc.next();

        // Check if admin credentials match
        if (admin_id.equals(loginSystem.getUserId(0)) && admin_password.equals(loginSystem.getPassword(0))) {
            System.out.println("Approval Dashboard:");
            for (int i = 1; i < 5; i++) {
                if (loginSystem.getUserId(i) != null && !loginSystem.getApprovalStatus(i)) {
                    System.out.println((i) + ". " + loginSystem.getUserId(i) + " (Pending Approval)");
                }
            }
            System.out.print("Enter the index of the user to approve: ");
            int approveIndex = sc.nextInt();
            if (approveIndex > 0 && approveIndex < 5 && loginSystem.getUserId(approveIndex) != null) {
                loginSystem.setApprovalStatus(true, approveIndex);
                System.out.println("User " + loginSystem.getUserId(approveIndex) + " approved!");
            } else {
                System.out.println("Invalid index.");
            }
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }
    void invalidCred(){
        
        System.out.println("Enetr 1, if you Forgot Password\nEnter 2, if you Forgot UserId\nEnter 3 to go Back");
        System.out.print("Choose an option: ");
        char f=sc.next().charAt(0);
        if(f=='1')
        {
            forgotpass();
        }
        else if(f=='2')
        {
            forgotId();
        }

        else if(f=='3')
        {
            return;
        }
        else
        {
            System.out.println("Invlaid Input, please try again.");
            invalidCred();

        }
        
    }
    public static void main(String[] args) {
        User user=new User();
        while (true) { // Run the application until the user chooses to exit
            System.out.println("1. Login\n2. Sign Up\n3. Approve Requests (Admin)\n4. Forgot Password\n5. Exit");
            System.out.print("Choose an option: ");
            char c = sc.next().charAt(0);
            
            if (c == '1') 
            { // Login
                boolean success = user.login();
                if(success)
                {
                    System.out.println("Login successful!");
                    while(true){
                        {
                            System.out.println("Available Cash in Counter ="+CYAN+cash+RESET);
                        }
                        System.out.print("Enter 1 for rent a vehicle | Enter 2 to Return the vehicle | Enter 3 for History | Enter 4 for LogOff :");
                        char r=sc.next().charAt(0);
                        if(r=='1')
                        {
                            available=veh.getNextAvailableIndex();
                            if(available!=-1){
                                
                                String phone1="";
                                while(true){
                                    System.out.print("Enetr Customer Mobile Number :");
                                    phone1=sc.next();
                                    if(isValidPhoneNumber(phone1))
                                        break;
                                    else
                                        System.out.println("Please enter a valid 10 digit mobile number");
                                }
                                long phone=Long.parseLong(phone1);
                                int phoneIndex=veh.phoneIndex(phone); 
                                if(phoneIndex!=-1)
                                {
                                    System.out.println("user found");
                                }
                                else
                                {
                                    String name="";
                                    while(true){
                                        System.out.print("Enter Name of the Customer: ");
                                        name=sc.next();
                                        if(isValidName(name))
                                            break;
                                        else
                                            System.out.println("Name must Starts with a letter, allows letters,  hyphens, and apostrophes, 5-50 characters long.");
                                    }
                                    
                                    String id="";
                                    while(true){
                                        System.out.print("Enter Customer- Driving License Number: ");
                                        id=sc.next();
                                        if(isValidDrivingLicense(id))
                                            break;
                                        else
                                            System.out.println("State code (2 uppercase letters), RTO code (2 or 3 digits), year (4 digits), and license number (7 digits).");
                                    }
                                    int idIndex=veh.LicenseIndex(id);
                                    if(idIndex!=-1)
                                    {
                                        System.out.println("user found");
                                    }
                                    else
                                    {
                                        veh.rentVehicle();
                                        veh.customerDetails(name,phone,id);  
                                    }
                                }
                            }
                            else System.out.println("Filled");
                        }
                        else if(r=='2')
                        {
                            String phone1="";
                            while(true){
                                System.out.print("Enter Customer Phone Number: ");
                                phone1=sc.next();
                                if(isValidPhoneNumber(phone1))
                                {
                                    break;
                                }
                                    
                                else
                                    System.out.println("Please enter a valid 10 digit mobile number");
                            }
                            long phone=Long.parseLong(phone1);
                            int phoneIndex=veh.phoneIndex(phone); 
                            if(phoneIndex!=-1)
                            {
                                veh.returnVehicle(phoneIndex);
                            }
                            else
                            System.out.println("No user ....");
                            
                        }
                        else if(r=='3'){
                            veh.history();
                        }
                        else if(r=='4')
                        {
                            System.out.println("Do you want to Logout");
                            System.out.println("");
                            System.out.println(" Yes             No");
                            String s=sc.next();
                            if(s.equalsIgnoreCase("yes"))
                            break;
                        }
                        else
                        {
                            System.out.println("Invalid Input, Please try again ");
                        }
                    }
                    

                }
                else {
                    System.out.println("Invalid credentials or account not approved. Please try again.");
                }

            } else if (c == '2') { // Sign Up
                user.signUp();

            } else if (c == '3') { // Approve Requests (Admin)
                user.approvalUser();
            }
            else if(c=='4'){
                user.invalidCred();
            } 
            else if (c == '5') { // Exit
                System.out.println("Do you want to Exit");
                System.out.println("");
                System.out.println(" Yes             No");
                String exit=sc.next();
                if(exit.equalsIgnoreCase("yes"))
                {
                    System.out.println(RED +"Exiting the system. Goodbye!"+ RESET);
                    break;
                }
                else if(exit.equalsIgnoreCase("no"))
                    continue;
                else System.out.println("Invalid Input");

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
