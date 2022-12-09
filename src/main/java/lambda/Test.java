package lambda;

import entity.University;
import entity.person.staff.cleaner.Gardener;
import entity.person.staff.enforcement.PoliceOfficer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.*;

public class Test {
    private static Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public static void main(String[] args) {
        ToIntFunction<University> uniPersonMultiplier = (uni) -> uni.getPersonList().size() * 100;
        University uni = new University();
        uni.getPersonList().add(new PoliceOfficer());
        uni.getPersonList().add(new Gardener());
        LOGGER.info("TESTING PERSON SCORE MULTIPLIER");
        LOGGER.info(uniPersonMultiplier.applyAsInt(uni));

        DoubleSupplier maxGpa = () -> 4.0;
        LOGGER.info("GETTING MAX GPA");
        LOGGER.info(maxGpa.getAsDouble());

        IntSupplier generateStudentId = () -> (int) (Math.random() * 10000);
        LOGGER.info("RANDOM STUDENT ID");
        LOGGER.info(generateStudentId.getAsInt());

        Supplier<String> writingDevice = () -> "pencil";
        LOGGER.info("WRITING DEVICE");
        LOGGER.info(writingDevice.get());

        DoubleConsumer a = (b) -> LOGGER.info("balance123: " + b);
        a.andThen((b) -> LOGGER.info("balance: " + (b * 100))).accept(5);
        ;

    }
}
