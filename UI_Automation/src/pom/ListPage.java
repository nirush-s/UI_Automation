package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;
import generic.DynamicWait;

public  class ListPage extends BasePage
{
	
	public ListPage(WebDriver driver,ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

			DynamicWait dynamicwait = new DynamicWait(driver, test);
		
		
			@FindBy(id="ctl00_FT_PH_cmdAdd_cmdButtonControl")
			private WebElement addButton;
			
			@FindBy(id="ctl00_ctl04_lnkSignOut")
			private WebElement pageTitle;
			
			@FindBy(id="ctl00_FC_PH_schSearchControl_bshBasicSearch_OneStringctl00_FC_PH_schSearchControlrRrrRrrRr0rRr1")
			private WebElement assetAlias;
			
			@FindBy(id="igtxtctl00_FC_PH_schSearchControl_bshBasicSearch_OneInt32ctl00_FC_PH_schSearchControlrRrrRrrRr1rRr0")
			private WebElement unitnumber;
		
			@FindBy(id="ctl00_FC_PH_schSearchControl_cmdSearch_cmdButtonControl")
			private WebElement searchButton;
			
			@FindBy(id="ctl00_FC_PH_grdList_lnkAllCP")
			private WebElement currentpage;
			
			@FindBy(id="ctl00_FT_PH_cmdSelect_cmdButtonControl")
			private WebElement selectButton;
			
			@FindBy(id="ctl00_FT_PH_cmdSelectClient_cmdExportButton")
			private WebElement selectExportButton;
			
			//newly added to aid Asset value change list page
			@FindBy(xpath="//input[@class='igtbl_checkBox']")
			private WebElement gridCheckBox;
		
			@FindBy(id="ctl00_FC_PH_grdList_lnkAllCP")
			private WebElement selectAll;
			
			@FindBy(id="ctl00_FT_PH_cmdSelectClient_cmdExportButton")
			private WebElement select;
			
			@FindBy(xpath="//*[@id='ctl00xFCxPHxgrdListxgrdList_rc_0_5']/nobr")      //tr[@id='ctl00xFxPHxgrdListxgrdList_r_0']/td[4]/nobr
			private WebElement jobStatus;
			
			
		
		
			
			public void searchByAlias(String alias)
			{
				dynamicwait.webDriverWait(assetAlias);
				assetAlias.clear();
				assetAlias.sendKeys(alias);
			}
			
			public void searchByUnitNumber(String unNumber) throws InterruptedException
			{
				dynamicwait.webDriverWait(unitnumber);
				unitnumber.clear();
				unitnumber.sendKeys(unNumber);
			}
			

			public void clickOnSelectExportButton(String beforewindow) 
			{
				dynamicwait.webDriverWait(selectExportButton);
				selectExportButton.click();
				driver.switchTo().window(beforewindow);	
			}
			
			public void selectGridCheckBox()
			{
				dynamicwait.webDriverWait(gridCheckBox);
				gridCheckBox.click();
			}
			
			public void handleAlert()
			{
				
					try
					{
						
						WebDriverWait wt=new WebDriverWait(driver, 1);
						wt.until(ExpectedConditions.alertIsPresent());
						Alert alert = driver.switchTo().alert();
						alert.accept();
						
					}
					catch (Exception e)
					{
						
					}
				
			}
			
			public String validateJobStatus()
			{
				
				WebDriverWait wt= new WebDriverWait(driver, 100);
				wt.until(ExpectedConditions.visibilityOf(searchButton));
			
				while("Not Started".equalsIgnoreCase(jobStatus.getText()) || "Started".equalsIgnoreCase(jobStatus.getText()))
				{
					searchButton.click();	
					//driver.navigate().refresh();		
				}	
				String jobResult = jobStatus.getText();	

				return jobResult;
			}
			
			
			
}
