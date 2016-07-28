package testngExamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotations {

	/*
	 * @Test public void testcase1() {
	 * 
	 * System.out.println("This is testcase1"); }
	 * 
	 * @Test public void testcase2() {
	 * 
	 * System.out.println("This is testcase2");
	 * 
	 * }
	 * 
	 * @BeforeMethod public void beforeMethod() {
	 * 
	 * System.out.println("I am before method"); }
	 * 
	 * @AfterMethod public void afterMethod() {
	 * System.out.println("I am after method"); }
	 * 
	 * @BeforeClass public void beforeClass() {
	 * System.out.println("I am before class"); }
	 * 
	 * @AfterClass public void afterClass() {
	 * System.out.println(" I am after class"); }
	 */

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am before test");
	}

	@AfterTest
	public void afterTest()

	{
		System.out.println(" I am after test");
	}

	@BeforeSuite
	public void beforeSuite() {

		System.out.println("I am Before Suite");
	}

	@AfterSuite
	public void afterSuite()

	{
		System.out.println("I am after Suite");
	}

}
