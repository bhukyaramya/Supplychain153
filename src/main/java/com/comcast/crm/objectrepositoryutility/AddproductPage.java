package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddproductPage {
	private WebDriver driver;

	//WebDriver driver;
	 public AddproductPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	 	@FindBy(xpath="//a[@href='../admin/view_products.php']")
	 	private WebElement productLink;
	 	
	    @FindBy(xpath = "//a[@href='../admin/add_product.php']")
	    private WebElement addProductLink;
	    
	    @FindBy(xpath="//tr[td[contains(text(), ' Pizza3817 ')]]//a[contains(@href, 'edit_product.php')]")
	    private WebElement editButton;
	    
	    @FindBy(id= "product:name")
	    private WebElement productName;

	    @FindBy(id = "product:price")
	    private WebElement productPrice;

	    @FindBy(id = "product:unit")
	    private WebElement productUnit;

	    
	    @FindBy(id="product:category")
	    private WebElement productCategory;

	    @FindBy(xpath="//input[@value='1']")
	    private WebElement rdbStock;

	    @FindBy(id="product:description")
	    private WebElement productDescription;

	    @FindBy(xpath="//input[@value='Add Product']")
	    private WebElement addProductButton;

	    public WebElement getProductName() {
	        return productName;
	    }

	    public WebElement getAddProductLink() {
	        return addProductLink;
	    }

	    public WebElement getAddProductButton() {
	        return addProductButton;
	    }

	    public WebElement getProductPrice() {
	        return productPrice;
	    }

	    public WebElement getProductUnit() {
	        return productUnit;
	    }

	    public WebElement getProductCategory() {
	        return productCategory;
	    }

	    public WebElement getRdbStock() {
	        return rdbStock;
	    }

	    public WebElement getProductDescription() {
	        return productDescription;
	    }

	    public WebDriver getDriver() {
	        return driver;
	    }
	    

	    /**
		 * @return the productLink
		 */
		public WebElement getProductLink() {
			return productLink;
		}

		/**
		 * @return the editButton
		 */
		public WebElement getEditButton() {
			return editButton;
		}

		// Method to add a product by filling out the form
		public void addProduct(String productname, String price, String unit, String category, String inStock, String description) {
	        addProductLink.click();
	        productName.sendKeys(productname);
	        productPrice.sendKeys(price);
	        productUnit.sendKeys(unit);
	        productCategory.sendKeys(category);
	        if (inStock != null) {
	            rdbStock.click();
	        }
	        productDescription.sendKeys(description);
	        addProductButton.click();
	    }

	    // Method to edit the product name
	    public void editProductName(String newProductName) {
	        productLink.click(); 
	        editButton.click();  
	        productName.clear(); 
	        productName.sendKeys(newProductName); 
	        addProductButton.click(); 
	    }
	    
	    // Method to get the product name text
	    public String getProductMsgInProductPage() {
	        return productName.getAttribute("value"); 
	    }

		public boolean isProductInList(String productname2) {
			// TODO Auto-generated method stub
			return false;
		}

		public String getErrorMessage() {
			
			WebElement errorMessageElement = driver.findElement(By.xpath("//span[@class='error-message']")); 
		   
		    return errorMessageElement.getText();
		}

		public void addProduct(String productname) {
			 productName.sendKeys(productname);
			
		}
	}


