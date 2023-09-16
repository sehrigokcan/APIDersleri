package Booking_smoketest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        A1Post.class,
        B2Put.class,
        C3Delete.class,
        D4Get.class
})
public class Runner {

}
