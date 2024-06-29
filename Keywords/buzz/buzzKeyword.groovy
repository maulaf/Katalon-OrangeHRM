package buzz

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class buzzKeyword {

	@Keyword
	def createPost() {
		WebUI.click(findTestObject('Object Repository/buzz/menu_Buzz'))

		WebUI.click(findTestObject('Object Repository/buzz/btn_Shares Photos'))

		WebUI.setText(findTestObject('Object Repository/buzz/dialog_textareaPost'), 'test')

		def dirProject = RunConfiguration.getProjectDir()

		def file = dirProject + '/Test Data/wallpaper.jpg'

		WebUI.uploadFile(findTestObject('Object Repository/buzz/addPhotos'), file)

		WebUI.click(findTestObject('Object Repository/buzz/btn_Share'))

		WebUI.verifyElementText(findTestObject('general/toast'), 'Successfully Saved')
	}

	@Keyword
	def createPostVideo() {
		WebUI.click(findTestObject('Object Repository/buzz/menu_Buzz'))

		WebUI.click(findTestObject('Object Repository/buzz/btn_Shares Video'))

		WebUI.setText(findTestObject('Object Repository/buzz/dialog_textareaPost'), 'test')

		def url = "https://www.youtube.com/watch?v=PVUCnmnHI8s"

		WebUI.setText(findTestObject('Object Repository/buzz/input_URL'), url)

		WebUI.click(findTestObject('Object Repository/buzz/btn_Share'))

		WebUI.verifyElementText(findTestObject('general/toast'), 'Successfully Saved')
	}
}
