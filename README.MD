Test project for UI test.

Used: Selenide(framework powered by Selenium), TestNG(test running), Allure(for reporting), Gradle(as build), Log4J(for logging)

For running test on local environment - gradle test --info -Dbrowser=firefox -Duser_name="" -Duser_password="".
-Dbrowser can be set to 'chrome'.
Also there is possibility to run added task to gradle - gradle chrome or gradle firefox.

In framework was added possibility to run test with remote driver.
Before running test open cmd and go to project folder and then run command to start docker-compose -
docker-compose up -d. After selenium-hub with two node(chrome, firefox) should be up.
For this purpose - gradle test --info -Dis_remote=true -Dremote_url=http://localhost:4444/wd/hub -Dbrowser=firefox -Duser_name="" -Duser_password="".
To observe how test is running in container, open VNC viewer and specify port for chrome(5901) or firefox(5902) node.

In order to observe allure report - gradle allureServe.

