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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'buzz.buzzKeyword.createPost'()

WebUI.callTestCase(findTestCase('buzz/BUZZ_TC.032 - Comment Post'), [:], FailureHandling.STOP_ON_FAILURE)

xpath = "//div[@class='orangehrm-post-comment-action-area']/p[text()='Delete']"

deleteComment = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath)

WebUI.click(deleteComment)

WebUI.verifyTextPresent("The selected item will be permanently deleted. Are you sure you want to continue?", false)

WebUI.click(findTestObject('Object Repository/general/btn_No Cancel'))

WebUI.verifyElementNotPresent(findTestObject('Object Repository/general/toast'), 0)

WebUI.verifyTextNotPresent("The selected item will be permanently deleted. Are you sure you want to continue?", false)