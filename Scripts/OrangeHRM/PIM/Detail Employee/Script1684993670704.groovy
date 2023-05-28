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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar

WebUI.callTestCase(findTestCase('OrangeHRM/login/01 - login admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('OrangeHRM/PIM/Add Employee'), [:], FailureHandling.STOP_ON_FAILURE)

def nickName = WebUI.getAttribute(findTestObject('OrangeHRM/PIM/input_Employee Full Name_firstName'), 'value')

WebUI.setText(findTestObject('Object Repository/OrangeHRM/PIM/input_Nickname'), nickName)

def otherId = RandomStringUtils.randomNumeric(5)

WebUI.setText(findTestObject('Object Repository/OrangeHRM/PIM/input_Other Id'), otherId)

def prefix = RandomStringUtils.randomAlphabetic(2)

def suffix = RandomStringUtils.randomNumeric(10)

def driverLicenseNumber = prefix + suffix

WebUI.setText(findTestObject('Object Repository/OrangeHRM/PIM/input_Driver License Number'), driverLicenseNumber)

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

def SSN = RandomStringUtils.randomNumeric(3)

WebUI.setText(findTestObject('Object Repository/OrangeHRM/PIM/input_SSN Number'), SSN)

def SIN = RandomStringUtils.randomNumeric(3)

WebUI.setText(findTestObject('Object Repository/OrangeHRM/PIM/input_SIN Number'), SIN)

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/div_-- Select --Nationality'))

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/option_Nationality', [('nationality') : 'Indonesian']))

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/div_-- Select -- Martial Status'))

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/option_Martial Status', [('martial') : 'Single']))

WebUI.setText(findTestObject('Object Repository/OrangeHRM/PIM/select_DOB'), '1990-09-09')

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/rb_Gender', [('gender') : 'Female']))

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/cb_Smoker'))

WebUI.setText(findTestObject('Object Repository/OrangeHRM/PIM/input_Military Service'), 'Angkatan Laut')

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/button_Save'))

WebUI.takeFullPageScreenshot()

WebUI.scrollToElement(findTestObject('OrangeHRM/PIM/button_Add'), 0)

//add attachment
WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/button_Add'))

WebUI.uploadFile(findTestObject('OrangeHRM/PIM/uploadFile'), 'C:\\Users\\fetty\\git\\OrangeHRM\\orangeHRM\\Data\\orangeHRM.xlsx')

