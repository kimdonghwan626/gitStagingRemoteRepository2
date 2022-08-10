* #### 고객 온라인 어플리케이션

  * BXCM 어플리케이션
  * REST API
    * /login : 로그인 처리(ID / PW 입력을 통해 고객 정보를 조회)
    * /customer : 고객정보 조회(고객 ID로 고객명을 조회)

* #### 어플리케이션 Build

  * sh gradlew build -x test

* #### Docker Build

  * docker build -t customer-app:latest --build-arg revision=$(git rev-parse HEAD | cut -c 2-7) .