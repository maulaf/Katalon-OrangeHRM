package employeeManagement
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.Keys as Keys
import java.nio.file.Path as Path




class employeeManagementSteps {
	@Given('user login as admin')
	def loginAdmin() {
		WebUI.openBrowser(GlobalVariable.url)
		
		WebUI.maximizeWindow()
		
		WebUI.takeScreenshot()
		
		WebUI.setText(findTestObject('Object Repository/OrangeHRM/login/input_Username_username'), GlobalVariable.username)
		
		WebUI.setText(findTestObject('Object Repository/OrangeHRM/login/input_Password_password'), GlobalVariable.password)
		
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/OrangeHRM/login/button_Login'))
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/OrangeHRM/login/h6_Dashboard'), 10)
		
		WebUI.takeScreenshot()
		
	}
	
	@When('navigate to menu PIM')
	def navigateToPIM() {
		WebUI.click(findTestObject('OrangeHRM/PIM/span_PIM'))
	}
	
	@And('user click add button')
	def clickAdd() {
		WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/button_Add'))
	}
	
	@And('user fill add form')
	def fillAddForm() {
		
		TestData data = findTestData('Data Files/employee')
		
		WebUI.setText(findTestObject('OrangeHRM/PIM/input_Employee Full Name_firstName'), data.getValue('firstName', 1))
		
		WebUI.setText(findTestObject('OrangeHRM/PIM/input_Employee Full Name_middleName'), data.getValue('middleName', 1))
		
		WebUI.setText(findTestObject('OrangeHRM/PIM/input_Employee Full Name_lastName'), data.getValue('lastName', 1))
		
		WebUI.sendKeys(findTestObject('OrangeHRM/PIM/input_Employee Id'), Keys.chord(Keys.CONTROL, 'a', Keys.BACK_SPACE))
		
		def randomId = RandomStringUtils.randomNumeric(5)
		
		WebUI.setText(findTestObject('OrangeHRM/PIM/input_Employee Id'), randomId)
		
		String projectDir = RunConfiguration.getProjectDir()
		
		println('Project Directory: ' + projectDir)
		
		WebUI.uploadFile(findTestObject('OrangeHRM/PIM/uploadFile'), projectDir + '/Data/foto.png')
		WebUI.takeScreenshot()
		
	}
	
	@And('user click save button')
	def clickSave() {
		WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/button_Save'))
	}
	
	@Then('data employee should be successfully saved')
	def successAdd() {
		WebUI.verifyTextPresent('Successfully Saved', false)
		WebUI.takeScreenshot()
	}

}