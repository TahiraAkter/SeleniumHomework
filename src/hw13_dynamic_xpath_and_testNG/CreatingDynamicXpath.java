package hw13_dynamic_xpath_and_testNG;

public class CreatingDynamicXpath {

	/*
	 * 1) Tag with single attribute:
	 * 
	 * Source: https://www.pfizer.com
	 * 
	 * Example: 
	 * i) Product---> //a[@class='section-blue'] 
	 * ii)About---> //a [@
	 * role='menuitem'] 
	 * iii)Explore RxPathways--->//a[@class='btn btn--primary']
	 * iv)Hope Changes Lives---> //h1[@class='banner-tile__headline'] 
	 * v) ACCUPRIL®---> //a [@title='ACCUPRIL® ']
	 */

	/*
	 * 2)Tag with multiple attribute with 'or' logic:
	 * 
	 * Source: https//www.bestbuy.com
	 * 
	 * Example: 
	 * i) Deal of the day---> //a[@class='bottom-left-links ' or @
	 * data-lid='hdr_dotd'] 
	 * ii) Brands----> //h3[@class='sideCarHeader'
	 * or @tabindex='_1'] 
	 * iii)Menu---> //button[@class ='c-button-link
	 * visibility-hidden visibility-hidden-focusable' or @aria-label='Menu']
	 * iv) Featured---> //button[@class ='c-button-unstyled top-four v-fw-medium' or @data-id='node-31']
	 * v) Cart---> //span[@class='cart-label' or text()='Cart']
	 */
	/*
	 * 3) Tag with multiple attribute with 'and' logic:
	 * 
	 * Source: https//www.target.com
	 * 
	 * Example:
	 * i)Search Field---> //input[@type='search' and @id='search']
	 * ii)Deal of the Day---> //img[@ class='styles__MobileImgTop-sc-1ealqwt-16 kkJIAM' and @ alt='Deal of the Day']
	 * iii)Sign in---> //span[@ class='styles__LinkText-sc-u2k6h-3 gQYCDY h-margin-r-x3' and text()='Sign in']
	 * iv) Serach button---> //button[@class='styles__SearchButton-sc-srf2ow-7 gPjSve' and @type='submit']
	 * v) Search field---> //input[@type='search' and @ id='search']
	 */
	/*
	 * 4) Tag with inner text (complete):
	 * 
	 * Source: https//www.target.com
	 * 
	 * Example:
	 * i) Womens shoes---> //span[text()='womens shoes']
	 * ii)Ready for school---> //h1[text()='Ready for School']
	 * iii) School supplies---> //span[text()='School supplies']
	 * iv)Dressed their best---> //span[text()='Dressed their best']
	 * v)fMake it yummy with these easy favorites---> //span[text()='fMake it yummy with these easy favorites.']
	 * 
	 */
	/*
	 * 5) Tag with inner text (not complete):
	 * 
	 * Source: https//www.cvs.com
	 * 
	 * Example:
	 * i) Let’s make healthier happen together---> //h1[contains(text(), 'Let’s make healthier')]
	 * ii)Our MinuteClinic providers (Paragraph)---> //p[contains(text(), 'Our MinuteClinic providers specialize in family health care')]
	 * iii) Screenings, monitoring, counseling and treatment (paragraph)---> //p[ contains(text(), 'Screenings, monitoring, counseling and treatment options are all offered')]
	 */
	/*
	 * 6) Tag with attributes and use of contains:
	 * 
	 * Source: https//www.pfizer.com
	 * 
	 * Example:
	 * i) Complete-- Explore our science--->//corporate-button[contains(@class, 'hydrated')]
	 * ii) Complete-- Science---> //a[contains(@class, 'section-orange is-active')]
	 * iii)Partial--Science---> //div[contains(@class, 'cat')]
	 * iv) Partial-- Diseases & conditions index---> //p[contains(@class, 'link')]
	 */
	/*
	 * 7) Normalize space:
	 * 
	 * Source: https//www.pfizer.com
	 * 
	 * Example:
	 * i) Guide to Clinical Trials---> //a[normalize-space(text())='Guide to Clinical Trials']
	 * ii) Partnerships ---> //p[normalize-space(text())='Partnerships' and @ class='link-l']
	 */
	/*
	 * 8) Starts with text:
	 *  
	 *  Source: https//www.pfizer.com
	 *  
	 *  Example:
	 *  i) Fellow organizations (paragraph)--->//h4[starts-with(text(), 'Fellow organizations actively researching bold scientific ideas, capabilities, and technologies')]
	 *  ii) Fellow organizations (paragraph)----> //h4[starts-with(text(), 'Fellow organizations actively ')]
	 */
	/*
	 * 9) Starts with attributes:
	 * 
	 * Source: https//www.pfizer.com
	 * 
	 * Example:
	 * i) Products--->//a[starts-with(@class, 'section')]
	 * ii) Distributors---> //li[starts-with(@class, 'main-menu')]
	 */
	

}
