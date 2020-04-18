package hometask27;

public class Lesson27 {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        tiger.eat("meat");
        try{
            tiger.drink("water");
            try{
                tiger.drink("beer");
            } catch (NotWaterException e2){
                System.out.println(e2.getMessage());
            } catch (Exception e){
                System.out.println(e.getMessage());
            } finally {
                System.out.println("It is inner finally initializer.");
            }
        } catch (RuntimeException e2){
            System.out.println(e2.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class NotMeatException extends RuntimeException{
    NotMeatException (String message){
        super(message);
    }
}
class NotWaterException extends Exception{
    NotWaterException (String message){
        super(message);
    }
}
class Tiger{
    void eat(String food){
        if (!food.equals("meat")){
            throw new NotMeatException("Tiger doesn't eat " + food);
        }
        else {
            System.out.println("Tiger eats meat.");
        }
    }
    void drink(String name) throws NotWaterException{
        if (!name.equals("water")){
            throw new NotWaterException("Tiger doesn't drink " + name);
        }
        else {
            System.out.println("Tiger drinks water.");
        }
    }
}