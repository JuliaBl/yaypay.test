package core.utils.prop;
import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath("config.properties")
public interface Config {
    @Property("app_url")
    String getAppUrl();
    @Property("user_name")
    String getUserName();
    @Property("user_password")
    String getUserPassword();
    @Property("browser")
    String getBrowser();
    @Property("remote_url")
    String getRemoteUrl();
    @Property("is_remote")
    String isRemote();
 }
