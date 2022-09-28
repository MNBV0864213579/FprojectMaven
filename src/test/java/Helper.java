import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {
    public static final String WIKI = "https://en.wikipedia.org/wiki/Astrology";
    public static final String SERCH="searchInput";
    public static final String BTSER="searchButton";
    public static final String FOLDER="C:\\Users\\user\\.android\\screenshot\\";

    public static final String AUTO="http://automationpractice.com/index.php";
    public static final String SINGIN="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a";
    public static final String EMAIL="email_create";
    public static final String CREAT="//*[@id=\"SubmitCreate\"]/span";
    public static final String EVENING="//*[@id=\"categories_block_left\"]/div/ul/li[2]/a";
    public static final String DRESS="//*[@id=\"block_top_menu\"]/ul/li[2]/a";
    public static final String CASUAL="//*[@id=\"categories_block_left\"]/div/ul/li[1]/a";



    public static ChromeDriver setupdraiver() {
        System.setProperty("webdriver.chrome.driver", "res\\chromedriver.exe");
        return new ChromeDriver();
    }
}
