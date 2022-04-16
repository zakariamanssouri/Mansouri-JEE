<div id="top"></div>

<br />
<div align="center">
<h3 align="center">Gestion des Patients</h3>

  <p align="center">
    Application Web JEE basée sur Spring MVC, Thylemeaf et Spring Data JPA qui permet de gérer les patients.
    <br />
    <br />
    <br />
 
  </p>
</div>








## Built With
* [Spring](https://spring.io/)
* [Thymeleaf](https://www.thymeleaf.org/)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

We will create a web application based on spring and thymleaf template engine , also we will use spring security in order to secure our app 🤙   .


### Creation of Patient Entity
 [Patient.java](https://github.com/zakariamanssouri/Mansouri-JEE/blob/master/Spring-MVC/src/main/java/ma/enset/springmvc/entites/Patient.java)
 <br>
 ![image](https://user-images.githubusercontent.com/80859231/163098843-bc1f3450-7343-4951-8380-2cf419dbcfb3.png)

### Creation of Patient Repository
 [PatientRepository.java](https://github.com/zakariamanssouri/Mansouri-JEE/blob/master/Spring-MVC/src/main/java/ma/enset/springmvc/repositories/PatientRepository.java)
 <br>
 ![image](https://user-images.githubusercontent.com/80859231/163099328-e851078f-7fe6-4234-87b7-3196aee46833.png)


### Creation of Patient Controller

this controller will handle all app requests , it has a lot of functions but here i will mention only one <br>
 [PatientController.java](https://github.com/zakariamanssouri/Mansouri-JEE/blob/master/Spring-MVC/src/main/java/ma/enset/springmvc/web/PatientController.java)
 <br>
![image](https://user-images.githubusercontent.com/80859231/163398203-0326468c-9c8d-4e7f-a2c1-840b0d40b85e.png)


### Security 
in this section we will secure our app by adding users with roles , so we will create two entities one for users and one for roles.
<br>
#### User entity
* [AppUser.java](https://github.com/zakariamanssouri/Mansouri-JEE/blob/master/Spring-MVC/src/main/java/ma/enset/springmvc/security/entities/AppUser.java)

![image](https://user-images.githubusercontent.com/80859231/163400259-666d35cc-6dee-4693-acf9-6cd5ca78d1ca.png)

#### Role entity
* [AppRole.java](https://github.com/zakariamanssouri/Mansouri-JEE/blob/master/Spring-MVC/src/main/java/ma/enset/springmvc/security/entities/AppRole.java)

![image](https://user-images.githubusercontent.com/80859231/163400872-d5b19b0c-beab-46d5-9777-f9d9a1a98407.png)

Now we should create repositories for both entities
####  User Repository
* [AppUserRepository.java](https://github.com/zakariamanssouri/Mansouri-JEE/blob/master/Spring-MVC/src/main/java/ma/enset/springmvc/security/repositories/AppUserRepository.java)

![image](https://user-images.githubusercontent.com/80859231/163401598-a5a1ea0f-f1ea-474a-b2c9-226b977dccf0.png)

####  Role Repository
* [AppRoleRepository.java](https://github.com/zakariamanssouri/Mansouri-JEE/blob/master/Spring-MVC/src/main/java/ma/enset/springmvc/security/repositories/AppUserRepository.java)

![image](https://user-images.githubusercontent.com/80859231/163402055-50fc5e93-41cc-4004-bd07-92e5f55c42fe.png)

Now we should add an interface that contains all methods we will use to handle users with their roles

### SecurityService
* [SecurityService.java](https://github.com/zakariamanssouri/Mansouri-JEE/blob/master/Spring-MVC/src/main/java/ma/enset/springmvc/security/service/SecurityService.java)

![image](https://user-images.githubusercontent.com/80859231/163402966-80f58831-8ab6-4192-ada6-dd721e64b18b.png)

### Implementation of SecurityService 

* [SecurityServiceImpl.java](https://github.com/zakariamanssouri/Mansouri-JEE/blob/master/Spring-MVC/src/main/java/ma/enset/springmvc/security/service/SecurityService.java)

![image](https://user-images.githubusercontent.com/80859231/163403482-b345e4e8-4dc5-442c-939a-2f8da123ac40.png)

the image above dosen't contains all implemented methods .

### UserDetailsService 

* [UserDetailsServiceImpl.java](https://github.com/zakariamanssouri/Mansouri-JEE/blob/master/Spring-MVC/src/main/java/ma/enset/springmvc/security/service/UserDetailsServiceImpl.java)


![image](https://user-images.githubusercontent.com/80859231/163404494-68ded470-8ea0-4160-a860-7ef95f59cb39.png)

### SecurityConfig
* [SecurityConfig.java]()

![image](https://user-images.githubusercontent.com/80859231/163414585-ffb6693c-caeb-4f98-a931-b619627a2c58.png)


### Pages
#### Home
![image](https://user-images.githubusercontent.com/80859231/163399525-64151d2e-b0ca-4431-8e4a-21b470a04acb.png)

#### Login
![image](https://user-images.githubusercontent.com/80859231/163418733-f209ab75-3f39-4dde-b9ec-d9b60019a7ba.png)

### form Patient
![image](https://user-images.githubusercontent.com/80859231/163418830-bf911085-8e26-4401-b629-b5b4e2bf131e.png)



<!-- CONTACT -->
## Contact

Zakaria Mansouri -- zakariyamanssouri01@gmail.com

Project Link: [https://github.com/zakariamanssouri/Mansouri-JEE/tree/master/Spring-MVC](https://github.com/zakariamanssouri/Mansouri-JEE/tree/master/Spring-MVC)

<p align="right">(<a href="#top">back to top</a>)</p>

