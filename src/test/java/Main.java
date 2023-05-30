import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        ReplaceTest.class,
        InsertTest.class,
        ModifyTest.class,
        RemoveTest.class,
        FindTest.class,
        CountTest.class
})
public class Main {
}
