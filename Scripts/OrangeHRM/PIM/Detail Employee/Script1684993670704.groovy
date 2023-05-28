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
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar

WebUI.callTestCase(findTestCase('OrangeHRM/login/01 - login admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OrangeHRM/PIM/Add Employee'), [:], FailureHandling.STOP_ON_FAILURE)

// Get the current date
Calendar calendar = Calendar.getInstance()

// Add one year to the current date
calendar.add(Calendar.YEAR, 1)

// Get the date one year after the current date
Date oneYearAfter = calendar.time

// Define the date format
SimpleDateFormat dateFormat = new SimpleDateFormat('yyyy-MM-dd')

// Format the date
String formattedDate = dateFormat.format(oneYearAfter)

WebUI.setText(findTestObject('Object Repository/OrangeHRM/PIM/input_License Expiry Date'), formattedDate)

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/div_-- Select --Nationality'))

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/option_Nationality'))



