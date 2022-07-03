# Eclipse 에서 프로젝트 설정

**1. hw-be Repository의 Source를 Clone한다.**

![1](https://user-images.githubusercontent.com/12637306/176454526-51787e37-ac31-4068-a1c9-3d1b0ce8354f.PNG)

<br/>

**2. Eclipse 실행 후 Workspace 지정**

![2](https://user-images.githubusercontent.com/12637306/176454807-334ee6dd-9e53-4afa-9a1a-36f22a4ef09a.PNG)

<br/>

**3. 프로젝트를 오픈한 것이 아니기 때문에 아무것도 보이지 않을 것이다. 먼저 Eclipse에 Spring 관련 Plugin 을 설치하기 위해 Help → Eclipse Marketplace 선택**

![4](https://user-images.githubusercontent.com/12637306/176455327-5f33e032-3089-4578-9bb8-564defeb0160.png)

<br/>

**4. STS 검색 후 Spring Tools 3 (Standalone Edition) 을 Install 클릭 (아래 이미지는 이미 설치된 후기 때문에 Installed 가 표시되어 있음)**

![5](https://user-images.githubusercontent.com/12637306/176455624-3242ad95-9ebd-4123-831f-a66b8e3de2a2.png)

<br/>

**5. Licencse 동의 후 완료**

<br/>

**6. 오른쪽 아래에서 소프트웨어 설치 진행도를 볼 수 있다. 시간이 오래 걸리기 때문에 설치가 완료될 때까지 기다린다.**

<br/>

**7. Eclipse 를 재시작 할 것인지 묻는다. 재시작한다.**

<br/>

**8. 2번에서 지정했던 Workspace 그대로 Eclipse를 실행해준다.**

<br/>

**9. File → Open Projects from File System 선택**

![6](https://user-images.githubusercontent.com/12637306/176456378-cca95985-0ea0-4bdc-9336-6376cbed117b.png)

<br/>

**10. Directory 선택 후 camping 폴더를 선택 한 후 Finish**

![7](https://user-images.githubusercontent.com/12637306/176456672-f59e6b63-61bf-475d-a1ca-8d7f615755a0.png)

<br/>

**11. 프로젝트 우클릭, Configure → Convert to Maven Project 후 build가 완료될 때까지 기다린다.**

![8](https://user-images.githubusercontent.com/12637306/176456945-f9d65859-fb4b-4db2-ae8c-264b35e6ca4b.png)

<br/>

**12. 오른쪽 밑의 Servers 탭 → create a new server 클릭**

![9](https://user-images.githubusercontent.com/12637306/176457337-01912056-d92a-4701-8828-d1f5ad4885b0.png)

<br/>

**13. 개발 시 Tomcat v9.0.58에서 진행하였기 때문에 버전을 맞춰주기 위해 Tomcat v9.0 Server 선택 → Next**

![10](https://user-images.githubusercontent.com/12637306/176457762-1bb1ab8d-57f1-4626-8c48-18a1fe9ec940.png)

<br/>

**14. Browse 클릭 후 Apache Tomcat 홈페이지에서 직접 다운받아 압축을 푼 tomcat v9.0.58 라이브러리 폴더를 지정**

![11](https://user-images.githubusercontent.com/12637306/176458168-2e114f9e-ce2b-411c-a650-1a5485934b9c.png)

<br/>

**15. Servers 탭의 Tomcat v9.0 Server at localhost 더블클릭 → Modules 탭 → Add Web Module → camping 선택 → OK**

![12](https://user-images.githubusercontent.com/12637306/176458864-4b7643e8-7bc1-446e-bda3-2f718c58d300.png)

<br/>

**16. 추가된 모듈 선택 → Edit → Path를 / 로 변경 → OK**

![13](https://user-images.githubusercontent.com/12637306/176459065-7e9b2f06-90fe-41fc-9900-cca8936199b4.png)

<br/>

**17. 서버 우클릭 → Start**

![14](https://user-images.githubusercontent.com/12637306/176459463-cb733e8c-7b34-4589-95da-49b1273bf9da.png)

<br/>

**18. 알림창이 나오는데 Save 클릭하면 서버가 정상적으로 실행**

![15](https://user-images.githubusercontent.com/12637306/176459608-a34c1c88-49c4-400d-bb0d-b604fe014ba1.png)

<br/>

**19. 서버가 실행되고 나면 Postman 등으로 API 통신 테스트를 할 수 있다.**

![16](https://user-images.githubusercontent.com/12637306/176459761-1d058d29-1407-4dba-a58a-c83c63c6d8d2.png)

<br/>

**20. 404 에러가 발생한다면 Tomcat 서버의 Overview 탭 설정에서 설정되어 있는 포트번호로 요청을 정확하게 했는지 확인할 것**

![17](https://user-images.githubusercontent.com/12637306/176460202-423ebe88-787e-4ddd-a2f2-9e1189874e5d.PNG)

