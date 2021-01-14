# CH3 스프링 부트에서 JPA로 데이터 베이스 다루기


** Posts_등록 테스트 **![](https://images.velog.io/images/donglee99/post/4378ebda-4e46-4a04-8838-553fe778f54d/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-14%20%EC%98%A4%ED%9B%84%207.22.58.png)

* 위 코드는 PostsSaveRequestDto 에 선언한 값들을 빌드 한후
값들이 정상적으로 저장이 되었는지 확인하는 테스트이다.
* 이전의 HelloController와 달리 @WebMvcTest를 사용하지 않고 @SpringBootTest와 TestRestTemplate 를 사용하였다. 이는 @WebMvcTest가 JPA 기능이 작동하지 않기 때문이다.

### 수정 및 조회 기능 만들기 
** PostsApiController **
![](https://images.velog.io/images/donglee99/post/5d7a55c8-bf19-4cac-843b-775519caaa25/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-14%20%EC%98%A4%ED%9B%84%207.30.16.png)

* 위의 메서드는 Update 즉 수정을 위한 메서드 이고 아래의 메서드는 조회를 위한 메서드이다 두 함수는 요청하는 주소가 같지만 방식이 다르다.

** PostsService **
![](https://images.velog.io/images/donglee99/post/11416f3e-84f6-4f46-93af-73b52f113f28/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-14%20%EC%98%A4%ED%9B%84%207.38.58.png)

* /api/v1/posts/{id}가 Put 방식으로 요청된경우 PostsApiController로 들어가서 return이 postsService.update(id, requestDtO)이다 이때 service의 update 가 호출되어 처리를 하는데 코드를 보면 id 의 게시물을 찾고 있다면 Posts.update를 진행하게 된다.

** PostsApiControllerTest **

* 이제 위의 수정기능을 만들었으면 테스트를 해보자

![](https://images.velog.io/images/donglee99/post/3740bfbd-6328-47e2-873f-03777e0c64a4/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-01-14%20%EC%98%A4%ED%9B%84%207.43.12.png)

* given = 먼저 수정을 확인 하려면 수정을 하기위해 저장된 값을 만들어 주어야 된다. 따라서 PostsRespository의 save를 이용해 값을 지정해준다.
* 이후 savePosts 즉 저장한 값의 id 값을 따로 변수에 저장하고 변경할 값들을 저장해둔뒤 requestDto에 담는다.
* when = 위에서 변경할 변수를 저장한 값들을 /api/v1/posts/id로 요청을 보낸다.
* then = 이후 변경된 값들을 비교 하면서 성공적으로 update가 됐는지 확인 해본다.

## 3.5 JPA Auditing으로 생성시간/수정시간 자동화 
* 이 부분은 기능면에서는 딱히 중요하지 않다고 생각하여 따로 필기는 하지 않겠다.