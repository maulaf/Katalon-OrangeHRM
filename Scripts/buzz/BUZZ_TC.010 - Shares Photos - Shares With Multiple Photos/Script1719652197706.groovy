import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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

WebUI.click(findTestObject('Object Repository/buzz/menu_Buzz'))

WebUI.click(findTestObject('Object Repository/buzz/btn_Shares Photos'))

WebUI.setText(findTestObject('Object Repository/buzz/dialog_textareaPost'), '')

def dirProject = RunConfiguration.getProjectDir()

def file = dirProject + '/Test Data/wallpaper.jpg'

def file2 = dirProject + '/Test Data/wallpaper2.jpg'

WebUI.uploadFile(findTestObject('Object Repository/buzz/addPhotos'), file)

WebUI.uploadFile(findTestObject('Object Repository/buzz/addPhotos'), file2)

WebUI.click(findTestObject('Object Repository/buzz/btn_Share'))

WebUI.verifyElementText(findTestObject('general/toast'), 'Successfully Saved')
