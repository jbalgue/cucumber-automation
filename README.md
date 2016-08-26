# Browser Automation Using Cucumber, Selenium, Java, and JUnit


Simple template project for starting automated testings with different browsers.

### Tutorials
* [Cucumber](https://cucumber.io/docs/reference/browser-automation)
* [Selenium](http://www.seleniumhq.org/)


### Prerequisites

* Java Development Kit (JDK) SE8

### How to Install
* Download `Eclipse` and run `git clone git@github.com:jbalgue/cucumber-automation.git` to the Eclipse workspace on the terminal. Import project into Eclipse.
* Go to `cucumber-automation` directory on the Eclipse workspace and run `./gradlew eclipse`. This will fix the classpath.
* Create a directory named `project-automation-conf` same hierarchy as the `cucumber-automation`. Then copy the `testdata.properties` from config directory to the `project-automation-conf`.
* Using the [Cucumber Plugin](https://github.com/samueltbrown/gradle-cucumber-plugin)

### Essential plugins for automation in Eclipse

Copy link and install plugin in Eclipse: (Help > Install New Software...)

* Cucumber feature editor: `http://cucumber.github.com/cucumber-eclipse/update-site`
* Gradle editor: `http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1640500`