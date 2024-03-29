package com.Kareclouds.TestPages;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.DisabledPatientPage;
import com.Kareclouds.Pages.PatientPage;

public class PatientPageTest extends BaseTest{
	public DashboardPage dashboard_page;
	public PatientPage patient_page;
	public DisabledPatientPage disabledPatient_pg;
	
   @Test()
   public void verifyFormDetails() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.enterFormDetails("kumar", "moses","Male","March 1994","12","O+","Single","C:\\Users\\prasannakumar\\Pictures\\t.jpg","9123456795","kumar@gmail.com","Hno:12 hyderbad","nothing","No allergies");
		Assert.assertEquals(result,"Record Saved Successfully");
   }
   
   @Test()
   public void VerifySearchOption() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.searchOperation("1002");
		Assert.assertEquals(result, "1002");
   }
   
   @Test()
   public void verifyDisabledPatientLink() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		disabledPatient_pg=patient_page.gotoDisabledPatientPage();
		String title=disabledPatient_pg.checkPageTitle();
		Assert.assertEquals(title, "Disabled Patient List");
   }
  
   @Test()
   public void verifyPatientIdAscendingOrder() throws InterruptedException {
	   		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
	 		patient_page=dashboard_page.selectPatientLink();
	 		String result=patient_page.patientIdAscendingSorting("1077");
	 		System.out.println("order changed  to :"+result);
	 		Assert.assertEquals(result, "Ascending order");
   }
   
   @Test()
   public void verifTableColumnSorting() throws InterruptedException {
  		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.checkTableColumnSorting("phone","7444654641");
		Assert.assertEquals(result, "Descending order");
   }
   
   @Test()
   public void verifyActionColumnInTable() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.checkActionColumn();
		Assert.assertEquals(result, "Abhijeet Sharma");
   }
   
   @Test()
   public void verifyActionCol_ListOPDLink() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.checklistBtnOPD();
		Assert.assertEquals(result, "Abhijeet Sharma");
   }
   
   @Test()
   public void verifyActionCol_ListPharamacyLink() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.checklistBtnPharamacy();
		Assert.assertEquals(result, "Pharmacy Bill");
   }
   
   @Test()
   public void verifyActionCol_ListOpeartionTheater() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.checklistBtnOT();
		Assert.assertEquals(result, "Operation Theatre Patient");
   }
   
   
   
   //--------experiment-----------
//   @Test()
//   public void verifyPatientIdOrder_1stWay() throws InterruptedException {
//	   		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
//	 		patient_page=dashboard_page.selectPatientLink();
//	 		boolean result=patient_page.sortingPatientID_1stway();
//	 		Assert.assertTrue(result);
//   }
//   
//   @Test()
//   public void verifyPatientIdOrder_2ndWay() throws InterruptedException {
//	   		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
//	 		patient_page=dashboard_page.selectPatientLink();
//	 	List<List<String>> data=patient_page.sortingPatientID_2ndway();
//	 	Assert.assertEquals(data.get(0), data.get(1));	
//	 	
//	 	Assert.assertEquals(data.get(0), data.get(1));
//   }
//   
//   @Test()
//   public void verifyPatientnameOrder_1stWay() throws InterruptedException {
//	   		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
//	 		patient_page=dashboard_page.selectPatientLink();
//	 		boolean result=patient_page.sortingPatientname_1stway();
//	 		Assert.assertTrue(result);
//   }
   
   @Test()
 public void verifyPatientnameOrder_1stWay() throws InterruptedException {
	   		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
	 		patient_page=dashboard_page.selectPatientLink();
	 		List<List<String>> result=patient_page.sortingEachColumn("patientname",2);
	 		Assert.assertEquals(result.get(0), result.get(1));
 }
   
   
   /*---------------------------------------Question--------------------------------------*/
   
   @Test()
   public void verifyPatientnameOrder() throws InterruptedException {
  	   		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
  	 		patient_page=dashboard_page.selectPatientLink();
  	 		List<List<String>> result=patient_page.sortingPatientNameColumn();
  	 		Assert.assertEquals(result.get(0), result.get(1));
   }
}
   
   
   
   
   
   