package org.example;

/**
 * 携程网搜索功能测试
 *
 * @version 2023/5/30 15:25
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CtripSearchTest {
    private static WebDriver driver;

    @BeforeClass
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public static void singleModuleTest1() {
        /*单模块测试1：扫码登录*/

        // 1. 打开携程网站
        driver.get("https://www.ctrip.com/");
        // 2. 点击“请登录”
        WebElement loinButton = driver.findElement(By.className("tl_nfes_home_header_login_IUsnp"));
        loinButton.click();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        // 3. 点击扫码登录
        WebElement scanLogin = driver.findElement(By.id("scanLogin"));
        scanLogin.click();
        //调用driver的getPageSource方法获取页面的源代码
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        String pageSourse=driver.getPageSource();
        //断言页面的源代码中是否包含“请登录”关键字，以此判断页面内容是否正确
        Assert.assertTrue(!pageSourse.contains("请登录"));
    }

    @Test
    public static void singleModuleTest2(){
        /*单模块测试2：输入关键字*/

        // 1. 打开携程网站
        driver.get("https://www.ctrip.com/");
        // 2. 在搜索框中输入关键字
        WebElement searchInput = driver.findElement(By.id("keyword"));
        searchInput.sendKeys("北京");
        String inputText = driver.findElement(By.id("keyword")).getAttribute("value");
        //断言搜索框当前内容是否为"北京"
        Assert.assertEquals("北京",inputText);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Test
    public static void singleModuleTest3(){
        /*单模块测试3：点击搜索按钮*/

        // 1. 打开携程网站
        driver.get("https://www.ctrip.com/");
        // 2. 在搜索框中输入关键字
        WebElement searchInput = driver.findElement(By.id("keyword"));
        searchInput.sendKeys("北京");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        WebElement searchButton = driver.findElement(By.className("hs_search-btn-container_R0HuJ"));
        searchButton.click();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Test
    public static void integrationTest1(){
        //1.打开携程网
        //2.点击登录
        //3.扫码登录
        singleModuleTest1();
        //4. 在搜索框中输入关键字
        WebElement searchInput = driver.findElement(By.id("keyword"));
        searchInput.sendKeys("北京");
        String inputText = driver.findElement(By.id("keyword")).getAttribute("value");
        //断言搜索框当前内容是否为"北京"
        Assert.assertEquals("北京",inputText);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Test
    public static void integrationTest2(){
        //1.打开携程网
        //2.点击登录
        //3.扫码登录
        //4. 在搜索框中输入关键字
        integrationTest1();
        //5.点击搜索
        WebElement searchButton = driver.findElement(By.className("hs_search-btn-container_R0HuJ"));
        searchButton.click();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //6.点击好评优先
        WebElement goodComment = driver.findElement(By.xpath("//*[@id=\"ibu_hotel_container\"]/div/section/div[2]/ul/li[3]/div[2]/div[2]/span"));
        goodComment.click();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //7.点击第一条搜索结果
        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"ibu_hotel_container\"]/div/section/div[2]/ul/li[5]/div/div/div/div[1]/div[2]"));
        firstResult.click();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //8.结束搜索
    }

    @DataProvider(name = "keywordCase")
    public Object[][] dataProvider(){
        return new Object[][]{
                {"北京"}, {"上海"},
                {"广州"}, {"深圳"},
                {"深圳"}, {"成都"},
                {"厦门"}, {"福州"},
                {"多伦多"}, {"南昌"},
                {"NewYork"}, {"巴黎"},
                {"休斯顿"}, {"西安"},
                {"哈尔滨"}, {"青岛"},


        };
    }

    @Test(dataProvider = "keywordCase")
    public static void dataTest(String keyword){
        // 1. 打开携程网站
        driver.get("https://www.ctrip.com/");
        // 2. 在搜索框中输入关键字
        WebElement searchInput = driver.findElement(By.id("keyword"));
        searchInput.sendKeys(keyword);
        String inputText = driver.findElement(By.id("keyword")).getAttribute("value");
        //断言搜索框当前内容是否为keyword
        Assert.assertEquals(keyword,inputText);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

