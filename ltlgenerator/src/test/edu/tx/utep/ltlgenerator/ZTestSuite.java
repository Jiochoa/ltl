package test.edu.tx.utep.ltlgenerator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CPGeneratorTest.class,
	AndRGeneratorTest.class,
	AndLGeneratorTest.class,
	AndMinusLGeneratorTest.class,
	GlobalTemplateTest.class,
	BeforeRTemplateTest.class,
	AfterLTemplateTest.class,
})

public class ZTestSuite {

}
