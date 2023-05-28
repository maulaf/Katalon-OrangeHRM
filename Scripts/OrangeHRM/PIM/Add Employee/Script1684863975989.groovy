import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.nio.file.Paths as Paths
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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
import java.nio.file.Path as Path


WebUI.callTestCase(findTestCase('OrangeHRM/login/01 - login admin'), [:], FailureHandling.STOP_ON_FAILURE)

TestData data = findTestData('Data Files/employee')

WebUI.click(findTestObject('OrangeHRM/PIM/span_PIM'))

WebUI.click(findTestObject('OrangeHRM/PIM/button_Add'))

WebUI.setText(findTestObject('OrangeHRM/PIM/input_Employee Full Name_firstName'), data.getValue('firstName', 1))

WebUI.setText(findTestObject('OrangeHRM/PIM/input_Employee Full Name_middleName'), data.getValue('middleName', 1))

WebUI.setText(findTestObject('OrangeHRM/PIM/input_Employee Full Name_lastName'), data.getValue('lastName', 1))

WebUI.sendKeys(findTestObject('OrangeHRM/PIM/input_Employee Id'), Keys.chord(Keys.CONTROL, 'a', Keys.BACK_SPACE))

def randomId = RandomStringUtils.randomNumeric(5)

WebUI.setText(findTestObject('OrangeHRM/PIM/input_Employee Id'), randomId)

String projectDir = RunConfiguration.getProjectDir()

println('Project Directory: ' + projectDir)

WebUI.uploadFile(findTestObject('OrangeHRM/PIM/uploadFoto'), projectDir + '/Data/foto.png')

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/button_Save'))

WebUI.verifyTextPresent('Success', true)

WebUI.takeFullPageScreenshot()

