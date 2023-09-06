import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.util.Random;

import java.util.Random;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Calendar now = Calendar.getInstance();
//int month = now.get(Calendar.MONTH) + 1;  // Ingat, nilai bulan dimulai dari 0
//
//SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
//String monthString = monthFormat.format(now.getTime());


LocalDate now = LocalDate.now();
int year = now.getYear();
int month = now.getMonthValue();
int day = now.getDayOfMonth();

String yearString = String.valueOf(year);

DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
String monthString = now.format(monthFormatter);

String dayString = String.valueOf(day);

System.out.println("Year: " + yearString);
System.out.println("Month: " + monthString);
System.out.println("Day: " + dayString);



Random random = new Random();
def randomNumber = random.nextInt(32768);
System.out.println(randomNumber);
