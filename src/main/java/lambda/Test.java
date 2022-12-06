package lambda;
import entity.University;
import entity.person.staff.cleaner.Gardener;
import entity.person.staff.enforcement.PoliceOfficer;
import java.util.function.ToIntFunction;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.function.DoubleConsumer;

public class Test {
    public static void print(Object o){
        System.out.println(o);
    }

    public static void main(String[] args){
        ToIntFunction<University> uniPersonMultiplier = (uni) -> uni.getPersonList().size() * 100;
        University uni = new University();
        uni.getPersonList().add(new PoliceOfficer());
        uni.getPersonList().add(new Gardener());
        print("TESTING PERSON SCORE MULTIPLIER");
        print(uniPersonMultiplier.applyAsInt(uni));

        DoubleSupplier maxGpa = () -> 4.0;
        print("GETTING MAX GPA");
        print(maxGpa.getAsDouble());

        IntSupplier generateStudentId = () -> (int)(Math.random() * 10000);
        print("RANDOM STUDENT ID");
        print(generateStudentId.getAsInt());

        Supplier<String> writingDevice = () -> "pencil";
        print("WRITING DEVICE");
        print(writingDevice.get());

        DoubleConsumer a = (b) -> print("balance123: " + b);
        a.andThen((b) -> print("balance: " + (b * 100))).accept(5);;



    }
}
