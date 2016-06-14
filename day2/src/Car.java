/**
 * Created by jeff on 6/14/16.
 */
public class Car {
    private String make;
    private String model;
    private String color;
    private int year;
    private int miles;

    public Car(String make, String model, String color, int year){
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        miles = 0;
    }

    public Car(String make, String model, int year){
        this(make, model, null, year);
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    public String getColor(){
        return this.color;
    }

    public int getYear(){
        return this.year;
    }

    public int addMiles(int miles) throws Exception {

        if(miles < 0){
            throw new Exception("Cannot add negative miles.");
        }

        this.miles += miles;
        return this.miles;
    }

    public void honkHorn(){
        System.out.println("BEEP!!!!!!");
    }


}
