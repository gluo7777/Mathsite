# Mathsite
Convert MathProblemGenerator to Web Serivce

Current Tasks

- Adding Controller for handing requests to load site, generate a list of math problems, and to solve problems
- Adding Services to handle business logic such as problem generation, transforming viewmodels to model, and so on
- Adding Repositories to persist data such as user settings (will be correlated to a cookie id)
- Add testing frameworks
  - JUnit 4
  - Mockito
  - Integration testing with Spring MVC, Spring Runner, and @ContextConfiguration
- Need to create a template for letting user set settings and display a list of math problems
  - Considering using JSP or Thymeleaf
    - JSP - higher performance, more configuration
    - Thymeleaf - slower performance, but native to HTML, offers static templating
    
Deployment
- Need to host on Marcus' server

Future functionalities

- Use Spring Security and Spring Session to centralize Session management
- Set up continuous integration with Jenkins and create pipelines to automatically build and generate useful reports such as CheckStyle, 
  PIT mutation, etc. Set up critera that builds need to meet in order to pass (e.g. statement/branch coverage, mutation coverage). The
  coverage should not go down.
- Add ability to mix fraction and number problems
- Front end
  - Use Bootstrap to mitigate necessity to learn CSS
  - Javascript frameworks
    - Angular or React
    - AJAX for making calls to back-end services
      - Look into Promises
     

